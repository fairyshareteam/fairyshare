package com.fairyshareteam.fairyshare.spi;

import static com.fairyshareteam.fairyshare.service.OfyService.ofy;

import com.fairyshareteam.fairyshare.Constants;
import com.fairyshareteam.fairyshare.domain.Profile;
import com.fairyshareteam.fairyshare.form.ProfileForm;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.response.UnauthorizedException;
import com.google.appengine.api.users.User;
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
	 * Retrieves a Profile object associated with the given user object from Datastore.
	 * 
	 * @param user
	 * 				A User object injected by the cloud endpoints.
	 * @return Profile object.
	 * @throws UnauthorizedException
	 * 				when the User object is null.
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
	 * 				A Google Account User.
	 * @param profileForm
	 * 				A ProfileForm object sent from the client form.
	 * @return Profile object just created/updated.
	 * @throws UnauthorizedException
	 * 				when the User object is null.
	 */
	@ApiMethod(name = "saveProfile", path = "profile", httpMethod = HttpMethod.POST)
	public Profile saveProfile(User user, ProfileForm profileForm)
			throws UnauthorizedException {
		
		Profile profile = getProfile(user);
		if(profile==null)
			profile = new Profile(user.getUserId(), user.getEmail());
		
		profile.setDisplayName(profileForm.getDisplayName());
		profile.setInfo(profileForm.getInfo());
		
		ofy().save().entity(profile).now();
		return profile;
	}
	
	
}
