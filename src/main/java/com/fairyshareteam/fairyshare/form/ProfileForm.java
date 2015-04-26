package com.fairyshareteam.fairyshare.form;

import javax.inject.Named;

public class ProfileForm {

	private String displayName, info;
	@Named("userUrl") String userUrl;
	
	public ProfileForm(String displayName, String info, String userUrl) {
		this.displayName = displayName;
		this.userUrl = userUrl;
		this.info = info;
	}
	
	public ProfileForm(){}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public String getUserUrl() {
		return userUrl;
	}
	
	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
}
