package com.project.bean;

import java.io.InputStream;

public class WidgetBean {

	private Integer widgetID;
	private String widgetName;
	
	private String widgetURL;
	private String widgetDescription;
	private InputStream widgetIcon=null;
	
	
	public Integer getWidgetID() {
		return widgetID;
	}
	public void setWidgetID(Integer widgetID) {
		this.widgetID = widgetID;
	}
	public String getWidgetName() {
		return widgetName;
	}
	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}
	public String getWidgetURL() {
		return widgetURL;
	}
	public void setWidgetURL(String widgetURL) {
		this.widgetURL = widgetURL;
	}
	public String getWidgetDescription() {
		return widgetDescription;
	}
	public void setWidgetDescription(String widgetDescription) {
		this.widgetDescription = widgetDescription;
	}
	public InputStream getWidgetIcon() {
		return widgetIcon;
	}
	public void setWidgetIcon(InputStream widgetIcon) {
		this.widgetIcon = widgetIcon;
	}
}
