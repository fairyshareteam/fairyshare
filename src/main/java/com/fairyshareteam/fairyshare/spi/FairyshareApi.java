package com.fairyshareteam.fairyshare.spi;

import static com.fairyshareteam.fairyshare.service.OfyService.ofy;

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
import com.google.appengine.api.users.User;
import com.google.appengine.repackaged.com.google.api.client.util.DateTime;
import com.googlecode.objectify.Key;

/**
 * Defines fairyshare APIs.
 */
@Api(name = "fairyshare", version = "indev_1", scopes = { Constants.EMAIL_SCOPE }, clientIds = {
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

		Key<Profile> key = Key.create(Profile.class, user.getUserId());
		return ofy().load().key(key).now();
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
			throws UnauthorizedException, IllegalArgumentException{

		String displayName = profileForm.getDisplayName();
		@Named("userUrl")String userUrl = profileForm.getUserUrl();
		String info = profileForm.getInfo();
		
		for(int i=0; i<displayName.length(); i++){
			if(!Character.isLetterOrDigit(displayName.charAt(i)) && !Character.isWhitespace(displayName.charAt(i)))
				throw new IllegalArgumentException("Display name can only contain letters, digits and spaces.");
		}
		for(int i=0; i<userUrl.length(); i++){
			if(!Character.isLetterOrDigit(userUrl.charAt(i)) && (userUrl.charAt(i))!='-' && (userUrl.charAt(i))!='_')
				throw new IllegalArgumentException("URL cannot contain puntuation marks other than '_' and '-'");
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

	@ApiMethod(name = "createStory", path = "story", httpMethod = HttpMethod.POST)
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

		ofy().save().entities(getProfile(user), story).now();

		return story;
	}

	@ApiMethod(name = "forkStory", path = "story", httpMethod = HttpMethod.POST)
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

		ofy().save().entities(getProfile(user), newStory);
		return newStory;
	}

	@ApiMethod(name = "likeStory", path = "story", httpMethod = HttpMethod.POST)
	public int likeStory(final User user,
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
		return story.getRating();
	}

	@ApiMethod(name = "dislikeStory", path = "story", httpMethod = HttpMethod.POST)
	public int dislikeStory(final User user,
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

		story.dislike();
		ofy().save().entity(story); // TODO This is not NOW!
		return story.getRating();
	}

	@ApiMethod(name = "saveStory", path = "story", httpMethod = HttpMethod.POST)
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

	@ApiMethod(name = "loadStory", path = "story", httpMethod = HttpMethod.POST)
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
}
