package com.fairyshareteam.fairyshare.domain;

import com.fairyshareteam.fairyshare.form.StoryForm;
import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.ApiResourceProperty;
import com.google.appengine.repackaged.com.google.api.client.util.DateTime;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

@Cache
@Entity
public class Story {

	@Id
	private long id;
	
	@Parent
	@ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
	Key ownerKey;
	
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
		this.rating = rating;
		this.description = description;
		this.text = text;/*
		this.text.replaceAll("<", "&lt;");
		this.text.replaceAll(">", "&gt;");*/
	}
	
	public Story(final long id, Profile owner, DateTime created, int rating, StoryForm storyForm) {
		
		new Story(id, owner, storyForm.getName(), created, rating, storyForm.getDescription(), storyForm.getText());
	}
	
	private Story(){}
	
	long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Key getOwnerKey() {
		return ownerKey;
	}
	
	public void setOwnerKey(Key ownerKey) {
		this.ownerKey = ownerKey;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public DateTime getCreated() {
		return created;
	}
	
	public void setCreated(DateTime created) {
		this.created = created;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public int like(){
		return ++rating;
	}
	public int dislike(){
		return --rating;
	}
	
	public void update(StoryForm sf) {
		if(sf.getName()!= null || sf.getName()!= "")
			name = sf.getName();
		if(sf.getDescription()!=null || sf.getDescription()!= "")
			description = sf.getDescription();
		if(sf.getText()!=null || sf.getText()!= "")
			text = sf.getText();
	}
}
