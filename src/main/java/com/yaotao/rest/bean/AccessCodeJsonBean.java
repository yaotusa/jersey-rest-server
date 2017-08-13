package com.yaotao.rest.bean;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author
 * @website
 */
public class AccessCodeJsonBean {

	private String accessCodeId;

	private String name;
	private String description;
	private PermissionsJsonBean permissions;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setPermissions(PermissionsJsonBean permissions) {
		this.permissions = permissions;
	}

	public PermissionsJsonBean getPermissions() {
		return permissions;
	}

	@XmlElement(name = "access_code")
	public String getAccessCodeId() {
		return accessCodeId;
	}

	public void setAccessCodeId(String id) {
		this.accessCodeId = id;
	}

}