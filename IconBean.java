package com.project.bean;

import java.io.InputStream;

public class IconBean {

	private String iconName;
	private String iconCategory;
	private String iconDescription;
	private InputStream iconImage = null;	// input stream of the upload file
	public String getIconName() {
		return iconName;
	}
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}
	public String getIconCategory() {
		return iconCategory;
	}
	public void setIconCategory(String iconCategory) {
		this.iconCategory = iconCategory;
	}
	public String getIconDescription() {
		return iconDescription;
	}
	public void setIconDescription(String iconDescription) {
		this.iconDescription = iconDescription;
	}
	public InputStream getIconImage() {
		return iconImage;
	}
	public void setIconImage(InputStream iconImage) {
		this.iconImage = iconImage;
	}
	
}
