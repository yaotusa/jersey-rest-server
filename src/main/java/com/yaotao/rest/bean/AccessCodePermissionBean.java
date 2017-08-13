package com.yaotao.rest.bean;

/**
*
* @author 
* @website 
*/
public class AccessCodePermissionBean {

	private String resourceId;
	private String accessCodeID;
	private String tenantId;
	private boolean readPermission;
	private boolean updatePermission;
	/**
	 * @return the resourceId
	 */
	public String getResourceId() {
		return resourceId;
	}
	/**
	 * @param resourceId the resourceId to set
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
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
	 * @return the readPermission
	 */
	public boolean isReadPermission() {
		return readPermission;
	}
	/**
	 * @param readPermission the readPermission to set
	 */
	public void setReadPermission(boolean readPermission) {
		this.readPermission = readPermission;
	}
	/**
	 * @return the updatePermission
	 */
	public boolean isUpdatePermission() {
		return updatePermission;
	}
	/**
	 * @param updatePermission the updatePermission to set
	 */
	public void setUpdatePermission(boolean updatePermission) {
		this.updatePermission = updatePermission;
	}

}