package com.fairyshareteam.fairyshare.form;

public class ProfileForm {

	private String displayName, info;

	public ProfileForm(String displayName, String info) {
		this.displayName = displayName;
		this.info = info;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public String getInfo() {
		return info;
	}
}
