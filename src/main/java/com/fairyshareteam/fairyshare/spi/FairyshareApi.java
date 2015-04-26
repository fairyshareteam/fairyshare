package com.fairyshareteam.fairyshare.spi;

import static com.fairyshareteam.fairyshare.service.OfyService.ofy;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.fairyshareteam.fairyshare.Constants;
import com.fairyshareteam.fairyshare.domain.Profile;
import com.fairyshareteam.fairyshare.domain.Story;
import com.fairyshareteam.fairyshare.form.ProfileForm;
import com.fairyshareteam.fairyshare.form.StoryForm;
import com.fairyshareteam.fairyshare.service.OfyService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.response.NotFoundException;
import com.google.api.server.spi.response.UnauthorizedException;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;
import com.googlecode.objectify.cmd.QueryExecute;
import com.google.appengine.api.users.User;
import com.google.appengine.repackaged.com.google.api.client.util.DateTime;

/**
 * Defines fairyshare APIs.
 */
@Api(name = "fairyshare", version = "1.0", scopes = { Constants.EMAIL_SCOPE }, clientIds = {
		Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID }, description = "API for the Fairyshare Backend application.")
public class FairyshareApi {

	/*
	 * Profile related methods:
	 */

	/**
	 * Retrieves a Profile object associated with the given user object from
	 * Datastore.
	 * 
	 * @param user
	 *            A User object injected by the cloud endpoints.
	 * @return Profile object.
	 * @throws UnauthorizedException
	 *             when the User object is null.
	 */
	@ApiMethod(name = "getProfile", path = "profile", httpMethod = HttpMethod.GET)
	public Profile getProfile(final User user) throws UnauthorizedException {

		Key key =  Key.create(Profile.class, user.getUserId());
		return (Profile) ofy().load().key(key).now();
	}

	/**
	 * Creates or updates a Profile object associated with the given user
	 * object.
	 * 
	 * @param user
	 *            A Google Account User.
	 * @param profileForm
	 *            A ProfileForm object sent from the client form.
	 * @return Profile object just created/updated.
	 * @throws UnauthorizedException
	 *             when the User object is null.
	 */
	@ApiMethod(name = "saveProfile", path = "profile", httpMethod = HttpMethod.POST)
	public Profile saveProfile(User user, ProfileForm profileForm)
			throws UnauthorizedException, IllegalArgumentException {

		String displayName = profileForm.getDisplayName();
		@Named("userUrl")
		String userUrl = profileForm.getUserUrl();
		String info = profileForm.getInfo();

		for (int i = 0; i < displayName.length(); i++) {
			if (!Character.isLetterOrDigit(displayName.charAt(i))
					&& !Character.isWhitespace(displayName.charAt(i)))
				throw new IllegalArgumentException(
						"Display name can only contain letters, digits and spaces.");
		}
		for (int i = 0; i < userUrl.length(); i++) {
			if (!Character.isLetterOrDigit(userUrl.charAt(i))
					&& (userUrl.charAt(i)) != '-' && (userUrl.charAt(i)) != '_')
				throw new IllegalArgumentException(
						"URL cannot contain puntuation marks other than '_' and '-'");
		}

		Profile profile = getProfile(user);
		if (profile == null)
			profile = new Profile(user.getUserId(), user.getEmail());

		profile.setDisplayName(displayName);
		profile.setUserUrl(userUrl);
		profile.setInfo(info);

		ofy().save().entity(profile).now();
		return profile;
	}

	@ApiMethod(name = "createStory", path = "create", httpMethod = HttpMethod.POST)
	public Story createStory(final User user, final StoryForm storyForm)
			throws UnauthorizedException {
		if (user == null) {
			throw new UnauthorizedException("Authorization required");
		}

		final Key<Story> storyKey = OfyService.factory().allocateId(
				Key.create(Profile.class, user.getUserId()), Story.class);
		
		final long storyId = storyKey.getId();

		Story story = new Story(storyId, getProfile(user), new DateTime(
				System.currentTimeMillis()), 0, storyForm);

		Profile owner = getProfile(user);
		owner.addStoryKey(storyKey);
		
		ofy().save().entities(owner, story).now();

		return story;
	}

	@ApiMethod(name = "forkStory", path = "fork/{websafeStoryKey}", httpMethod = HttpMethod.POST)
	public Story forkStory(final User user,
			@Named("websafeStoryKey") final String websafeStoryKey)
			throws UnauthorizedException, NotFoundException {
		Key<Story> storyKey = Key.create(websafeStoryKey);
		Story story = ofy().load().key(storyKey).now();
		if (story == null) {
			throw new NotFoundException("No Story found with key: "
					+ websafeStoryKey);
		}
		if (user == null) {
			throw new UnauthorizedException("Authorization required");
		}

		final Key<Story> newStoryKey = OfyService.factory().allocateId(
				Key.create(Profile.class, user.getUserId()), Story.class);

		Story newStory = new Story(newStoryKey.getId(), getProfile(user),
				story.getName(), new DateTime(System.currentTimeMillis()), 0,
				story.getDescription(), story.getText());

		Profile owner = getProfile(user);
		owner.addStoryKey(newStoryKey);
		
		ofy().save().entities(owner, newStory).now();
		return newStory;
	}

	@ApiMethod(name = "likeStory", path = "like/{websafeStoryKey}", httpMethod = HttpMethod.POST)
	public Story likeStory(final User user,
			@Named("websafeConferenceKey") final String websafeStoryKey)
			throws UnauthorizedException, NotFoundException {

		Key<Story> storyKey = Key.create(websafeStoryKey);
		Story story = ofy().load().key(storyKey).now();
		if (story == null) {
			throw new NotFoundException("No Story found with key: "
					+ websafeStoryKey);
		}
		if (user == null) {
			throw new UnauthorizedException("Authorization required");
		}

		story.like();
		ofy().save().entity(story); // TODO This is not NOW!
		return story;
	}

	@ApiMethod(name = "dislikeStory", path = "dislike/{websafeStoryKey}", httpMethod = HttpMethod.POST)
	public Story dislikeStory(final User user,
			@Named("websafeConferenceKey") final String websafeStoryKey)
			throws UnauthorizedException, NotFoundException {

		Key<Story> storyKey = Key.create(websafeStoryKey);
		Story story = ofy().load().key(storyKey).now();
		if (story == null) {
			throw new NotFoundException("No Story found with key: "
					+ websafeStoryKey);
		}
		if (user == null) {
			throw new UnauthorizedException("Authorization required");
		}

		story.dislike();
		ofy().save().entity(story); // TODO This is not NOW!
		return story;
	}

	@ApiMethod(name = "saveStory", path = "edit/{websafeStoryKey}", httpMethod = HttpMethod.POST)
	public Story saveStory(final User user,
			@Named("websafeStoryKey") final String websafeStoryKey,
			StoryForm storyForm) throws UnauthorizedException,
			NotFoundException {
		Key<Story> storyKey = Key.create(websafeStoryKey);
		Story story = ofy().load().key(storyKey).now();
		if (story == null) {
			throw new NotFoundException("No Story found with key: "
					+ websafeStoryKey);
		}
		if (user == null) {
			throw new UnauthorizedException("Authorization required");
		}

		story.update(storyForm);
		ofy().save().entities(getProfile(user), story).now();
		return story;
	}

	@ApiMethod(name = "loadStory", path = "edit/{websafeStoryKey}", httpMethod = HttpMethod.GET)
	public Story loadStory(
			@Named("websafeStoryKey") final String websafeStoryKey)
			throws NotFoundException {
		Key<Story> storyKey = Key.create(websafeStoryKey);
		Story story = OfyService.ofy().load().key(storyKey).now();
		if (story == null) {
			throw new NotFoundException("No Story found with key: "
					+ websafeStoryKey);
		}
		return story;
	}

	@ApiMethod(name = "readStory", path = "read/{websafeStoryKey}", httpMethod = HttpMethod.GET)
	public Story readStory(
			@Named("websafeStoryKey") final String websafeStoryKey)
			throws NotFoundException {
		Key<Story> storyKey = Key.create(websafeStoryKey);
		Story story = OfyService.ofy().load().key(storyKey).now();
		if (story == null) {
			throw new NotFoundException("No Story found with key: "
					+ websafeStoryKey);
		}
		return story;
	}

	@ApiMethod(name = "allStories", path = "allStories", httpMethod = HttpMethod.GET)
	public List<Story> allStories() {
		Iterable<Story> stories = ofy().load().type(Story.class)
				.order("rating");
		List<Story> result = new ArrayList<>(0);
		List<Key<Profile>> ownersKeyList = new ArrayList<>(0);
		for (Story story : stories) {
			ownersKeyList.add(story.getOwnerKey());
			result.add(story);
		}
		// To avoid separate datastore gets for each story, pre-fetch the
		// Profiles.
		ofy().load().keys(ownersKeyList);
		return result;
	}

	@ApiMethod(name = "myStories", path = "myStories", httpMethod = HttpMethod.GET)
	public List<Story> myStories(final User user)
			throws UnauthorizedException {
		// If not signed in, throw a 401 error.
		if (user == null) {
			throw new UnauthorizedException("Authorization required");
		}
		List<Key<Story>> keyList = new ArrayList<>(0);
		for (Key key : getProfile(user).getStoriesKeys()) {
			keyList.add(key);
		}
		return ((QueryExecute<Story>) ofy().load().keys(keyList)).list();
	}
}
