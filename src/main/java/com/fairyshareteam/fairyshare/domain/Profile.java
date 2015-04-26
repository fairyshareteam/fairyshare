package com.fairyshareteam.fairyshare.domain;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.ApiResourceProperty;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Cache
@Entity
public class Profile {

	@Id
	private String id;

	String email, displayName, info;
	@Named("userUrl") String userUrl;

	@ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
	ArrayList<Key<Story>> storiesKeys;

	public Profile(String id, String email) {

		this.id = id ==null ? "0" : id;
		this.email = email;
		displayName = "";
		info = "";
		userUrl = getNameFromEmail(email).toLowerCase().replaceAll(".", "-");
		storiesKeys = new ArrayList<Key<Story>>();
	}

	public Profile(){}
	
	String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDisplayName() {
		return (displayName == null || displayName == "") ? 
				displayName = getNameFromEmail(email) : displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUserUrl() {
		return (userUrl == null || userUrl == "") ? 
				userUrl = getNameFromEmail(email).toLowerCase().replaceAll(".", "-") : userUrl;
	}
	
	public void setUserUrl(String userUrl) {
		this.userUrl = (userUrl == null || userUrl == "") ? 
				getNameFromEmail(email).toLowerCase().replaceAll(".", "-") : userUrl;
	}

	public String getInfo() {
		return info == null ? "" : info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<Key<Story>> getStoriesKeys() {
		return storiesKeys;
	}
	
	public void setStoriesKeys(ArrayList<Key<Story>> storiesKeys) {
		this.storiesKeys = storiesKeys;
	}
	
	public void addStoryKey(Key<Story> storyKey){
		storiesKeys.add(storyKey);
	}

	static private String getNameFromEmail(String email) {
		int atIndex = email.indexOf('@');
		if (atIndex != -1 && email.indexOf('.') > atIndex)
			return email.substring(0, atIndex);
		else
			return "Guest";
	}
}
