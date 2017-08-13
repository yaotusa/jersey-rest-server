package com.yaotao.rest.tb;
// Generated 2016-1-2 22:34:23 by Hibernate Tools 3.6.0.Final

/**
 * TbResourceResultId generated by hbm2java
 */
public class TbResourceResultId implements java.io.Serializable {

	private String tenantId;
	private String userId;
	private int number;
	private String resourcePath;
	private String resourceName;
	private String status;
	private String errMessage;

	public TbResourceResultId() {
	}

	public TbResourceResultId(String tenantId, String userId, int number, String resourcePath, String status) {
		this.tenantId = tenantId;
		this.userId = userId;
		this.number = number;
		this.resourcePath = resourcePath;
		this.status = status;
	}

	public TbResourceResultId(String tenantId, String userId, int number, String resourcePath, String resourceName,
			String status, String errMessage) {
		this.tenantId = tenantId;
		this.userId = userId;
		this.number = number;
		this.resourcePath = resourcePath;
		this.resourceName = resourceName;
		this.status = status;
		this.errMessage = errMessage;
	}

	public String getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getResourcePath() {
		return this.resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrMessage() {
		return this.errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbResourceResultId))
			return false;
		TbResourceResultId castOther = (TbResourceResultId) other;

		return ((this.getTenantId() == castOther.getTenantId()) || (this.getTenantId() != null
				&& castOther.getTenantId() != null && this.getTenantId().equals(castOther.getTenantId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this.getUserId() != null
						&& castOther.getUserId() != null && this.getUserId().equals(castOther.getUserId())))
				&& (this.getNumber() == castOther.getNumber())
				&& ((this.getResourcePath() == castOther.getResourcePath())
						|| (this.getResourcePath() != null && castOther.getResourcePath() != null
								&& this.getResourcePath().equals(castOther.getResourcePath())))
				&& ((this.getResourceName() == castOther.getResourceName())
						|| (this.getResourceName() != null && castOther.getResourceName() != null
								&& this.getResourceName().equals(castOther.getResourceName())))
				&& ((this.getStatus() == castOther.getStatus()) || (this.getStatus() != null
						&& castOther.getStatus() != null && this.getStatus().equals(castOther.getStatus())))
				&& ((this.getErrMessage() == castOther.getErrMessage())
						|| (this.getErrMessage() != null && castOther.getErrMessage() != null
								&& this.getErrMessage().equals(castOther.getErrMessage())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTenantId() == null ? 0 : this.getTenantId().hashCode());
		result = 37 * result + (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result + this.getNumber();
		result = 37 * result + (getResourcePath() == null ? 0 : this.getResourcePath().hashCode());
		result = 37 * result + (getResourceName() == null ? 0 : this.getResourceName().hashCode());
		result = 37 * result + (getStatus() == null ? 0 : this.getStatus().hashCode());
		result = 37 * result + (getErrMessage() == null ? 0 : this.getErrMessage().hashCode());
		return result;
	}

}