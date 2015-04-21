package com.fairyshareteam.fairyshare.domain;

import com.google.appengine.repackaged.com.google.api.client.util.DateTime;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

@Entity
public class Story {

	@Id
	private long id;
	
	@Parent
	Key<Profile> ownerKey;
	
	@Index
	String name, ownerName;
	
	@Index
	DateTime created;
	
	@Index
	int rating;
	
	String description;
	
	String text;
	
	public Story(final long id, Profile owner, String name, DateTime created, int rating, String description, String text) {
		
		this.id = id;
		ownerKey = Key.create(Profile.class, owner.getId());
		this.name = name;
		this.ownerName = owner.getDisplayName();
		this.created = created;
		this.rating = 0;
		this.description = description;
		this.text = text;
	}
	
	long getId() {
		return id;
	}
	
	public Key<Profile> getOwnerKey() {
		return ownerKey;
	}
	
	public String getName() {
		return name;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public DateTime getCreated() {
		return created;
	}
	
	public int getRating() {
		return rating;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getText() {
		return text;
	}
}
