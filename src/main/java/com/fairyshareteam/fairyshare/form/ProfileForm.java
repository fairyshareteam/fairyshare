package com.fairyshareteam.fairyshare.form;

import javax.inject.Named;

public class ProfileForm {

	private String displayName, info;
	@Named("userUrl") String userUrl;
	
	public ProfileForm(String displayName, String userUrl, String info) {
		this.displayName = displayName;
		this.userUrl = userUrl;
		this.info = info;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public String getUserUrl() {
		return userUrl;
	}
	
	public String getInfo() {
		return info;
	}
}
