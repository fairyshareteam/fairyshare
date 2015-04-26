package com.fairyshareteam.fairyshare.domain;

import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.ApiResourceProperty;
import com.google.appengine.api.datastore.Text;
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
	private Long id;
	
	@Parent
	@ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
	Key<Profile> ownerKey;
	
	String name;
	
	@Index
	long created;
	
	@Index
	int rating;
	
	String description;
	
	Text text;
	
	String websafeKey;
	
	public Story(final Long id, Key<Profile> ownerKey, long created, int rating) {
		
		this.id = id;
		this.ownerKey = ownerKey;
		this.name = "";
		this.created = created;
		this.rating = rating;
		this.description = "";
		this.text = new Text("");
		this.websafeKey = "";
	}
	
	public Story(){}
	
	Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id == null ? 0 : id;
	}
	
	public Key<Profile> getOwnerKey() {
		return ownerKey;
	}
	
	public void setOwnerKey(Key<Profile> ownerKey) {
		this.ownerKey = ownerKey == null ? Key.create(Profile.class, "0") : ownerKey;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name == null ? "" : name;
	}
	
	public long getCreated() {
		return created;
	}
	
	public void setCreated(long created) {
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
		this.description = description == null ? "" : description;
	}
	
	public Text getText() {
		return text;
	}
	
	public void setText(Text text) {
		this.text = text == null ? new Text("") : text;
	}
	
	public String getWebsafeKey() {
		return websafeKey;
	}
	
	public void setWebsafeKey(String websafeKey) {
		this.websafeKey = websafeKey == null ? "" : websafeKey;
	}
	
	public int like(){
		return ++rating;
	}
	public int dislike(){
		return --rating;
	}
}
