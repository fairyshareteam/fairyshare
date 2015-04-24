package com.fairyshareteam.fairyshare.domain;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Named;

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

	LinkedList<String> storiesKeys;

	public Profile(String id, String email) {

		this.id = id;
		this.email = email;
	}

	String getId() {
		return id;
	}

	String getEmail() {
		return email;
	}

	public String getDisplayName() {
		return (displayName == null || displayName == "") ? 
				getNameFromEmail(email) : displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUserUrl() {
		return (userUrl == null || userUrl == "") ? 
				getNameFromEmail(email).toLowerCase().replaceAll(".", "-") : userUrl;
	}
	
	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}

	public String getInfo() {
		return info == null ? "" : info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<String> getStoriesKeys() {
		return storiesKeys;
	}

	static private String getNameFromEmail(String email) {
		int atIndex = email.indexOf('@');
		if (atIndex != -1 && email.indexOf('.') > atIndex)
			return email.substring(0, atIndex);
		else
			return "Guest";
	}
}
