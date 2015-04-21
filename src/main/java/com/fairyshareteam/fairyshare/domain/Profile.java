package com.fairyshareteam.fairyshare.domain;

import java.util.LinkedList;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Profile {

	@Id
	private String id;

	String email, displayName, info;

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
