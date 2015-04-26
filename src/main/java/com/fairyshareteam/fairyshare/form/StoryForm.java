package com.fairyshareteam.fairyshare.form;

public class StoryForm {
	
	private String name, description;
	
	private String text;
	
	public StoryForm(String name, String description, String text) {
		this.name = name;
		this.description = description;
		this.text = text;
	}
	
	public StoryForm(){};
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
}
