package com.yaotao.rest.bean;

/**
 * 
 *
 * @author 
 * @website 
 */
public class AccessCodeBean {
	
	private String tenantId;
	private String accessCodeID;
	private String accessCodeName;
	private String comment;
	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return tenantId;
	}
	/**
	 * @param tenantId the tenantId to set
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	/**
	 * @return the accessCodeID
	 */
	public String getAccessCodeID() {
		return accessCodeID;
	}
	/**
	 * @param accessCodeID the accessCodeID to set
	 */
	public void setAccessCodeID(String accessCodeID) {
		this.accessCodeID = accessCodeID;
	}
	/**
	 * @return the accessCodeName
	 */
	public String getAccessCodeName() {
		return accessCodeName;
	}
	/**
	 * @param accessCodeName the accessCodeName to set
	 */
	public void setAccessCodeName(String accessCodeName) {
		this.accessCodeName = accessCodeName;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}