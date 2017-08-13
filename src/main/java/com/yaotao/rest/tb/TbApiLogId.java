package com.yaotao.rest.tb;
// Generated 2016-1-2 22:34:23 by Hibernate Tools 3.6.0.Final

import java.util.Date;

/**
 * TbApiLogId generated by hbm2java
 */
public class TbApiLogId implements java.io.Serializable {

	private Date date;
	private String tenantId;
	private String apiId;
	private String details;
	private String comment;

	public TbApiLogId() {
	}

	public TbApiLogId(String apiId, String details) {
		this.apiId = apiId;
		this.details = details;
	}

	public TbApiLogId(Date date, String tenantId, String apiId, String details, String comment) {
		this.date = date;
		this.tenantId = tenantId;
		this.apiId = apiId;
		this.details = details;
		this.comment = comment;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getApiId() {
		return this.apiId;
	}

	public void setApiId(String apiId) {
		this.apiId = apiId;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbApiLogId))
			return false;
		TbApiLogId castOther = (TbApiLogId) other;

		return ((this.getDate() == castOther.getDate()) || (this.getDate() != null && castOther.getDate() != null
				&& this.getDate().equals(castOther.getDate())))
				&& ((this.getTenantId() == castOther.getTenantId()) || (this.getTenantId() != null
						&& castOther.getTenantId() != null && this.getTenantId().equals(castOther.getTenantId())))
				&& ((this.getApiId() == castOther.getApiId()) || (this.getApiId() != null
						&& castOther.getApiId() != null && this.getApiId().equals(castOther.getApiId())))
				&& ((this.getDetails() == castOther.getDetails()) || (this.getDetails() != null
						&& castOther.getDetails() != null && this.getDetails().equals(castOther.getDetails())))
				&& ((this.getComment() == castOther.getComment()) || (this.getComment() != null
						&& castOther.getComment() != null && this.getComment().equals(castOther.getComment())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDate() == null ? 0 : this.getDate().hashCode());
		result = 37 * result + (getTenantId() == null ? 0 : this.getTenantId().hashCode());
		result = 37 * result + (getApiId() == null ? 0 : this.getApiId().hashCode());
		result = 37 * result + (getDetails() == null ? 0 : this.getDetails().hashCode());
		result = 37 * result + (getComment() == null ? 0 : this.getComment().hashCode());
		return result;
	}

}
