package com.fairyshareteam.fairyshare.form;

public class StoryForm {
	
	private String name, description;
	
	private String text;
	
	public StoryForm(String name, String description, String text) {
		this.name = name;
		this.description = description;
		this.text = text;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getText() {
		return text;
	}
}
