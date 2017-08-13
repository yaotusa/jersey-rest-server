package com.yaotao.rest.tb;
// Generated 2016-1-2 22:34:23 by Hibernate Tools 3.6.0.Final

import java.util.Date;

/**
 * TbResourceModifyStatusId generated by hbm2java
 */
public class TbResourceModifyStatusId implements java.io.Serializable {

	private String resourceId;
	private String tenantId;
	private String resourceName;
	private String resourcePath;
	private Integer dataFormat;
	private String comment;
	private Integer dbServerId;
	private String databaseName;
	private String collectionName;
	private Date resourceDataUpdatedDate;
	private Integer resourceClass;
	private Integer retentionPeriod;
	private String reserved01;
	private String reserved02;
	private String reserved03;
	private Date modifiedDate;

	public TbResourceModifyStatusId() {
	}

	public TbResourceModifyStatusId(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public TbResourceModifyStatusId(String resourceId, String tenantId, String resourceName, String resourcePath,
			Integer dataFormat, String comment, Integer dbServerId, String databaseName, String collectionName,
			Date resourceDataUpdatedDate, Integer resourceClass, Integer retentionPeriod, String reserved01,
			String reserved02, String reserved03, Date modifiedDate) {
		this.resourceId = resourceId;
		this.tenantId = tenantId;
		this.resourceName = resourceName;
		this.resourcePath = resourcePath;
		this.dataFormat = dataFormat;
		this.comment = comment;
		this.dbServerId = dbServerId;
		this.databaseName = databaseName;
		this.collectionName = collectionName;
		this.resourceDataUpdatedDate = resourceDataUpdatedDate;
		this.resourceClass = resourceClass;
		this.retentionPeriod = retentionPeriod;
		this.reserved01 = reserved01;
		this.reserved02 = reserved02;
		this.reserved03 = reserved03;
		this.modifiedDate = modifiedDate;
	}

	public String getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourcePath() {
		return this.resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public Integer getDataFormat() {
		return this.dataFormat;
	}

	public void setDataFormat(Integer dataFormat) {
		this.dataFormat = dataFormat;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getDbServerId() {
		return this.dbServerId;
	}

	public void setDbServerId(Integer dbServerId) {
		this.dbServerId = dbServerId;
	}

	public String getDatabaseName() {
		return this.databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getCollectionName() {
		return this.collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public Date getResourceDataUpdatedDate() {
		return this.resourceDataUpdatedDate;
	}

	public void setResourceDataUpdatedDate(Date resourceDataUpdatedDate) {
		this.resourceDataUpdatedDate = resourceDataUpdatedDate;
	}

	public Integer getResourceClass() {
		return this.resourceClass;
	}

	public void setResourceClass(Integer resourceClass) {
		this.resourceClass = resourceClass;
	}

	public Integer getRetentionPeriod() {
		return this.retentionPeriod;
	}

	public void setRetentionPeriod(Integer retentionPeriod) {
		this.retentionPeriod = retentionPeriod;
	}

	public String getReserved01() {
		return this.reserved01;
	}

	public void setReserved01(String reserved01) {
		this.reserved01 = reserved01;
	}

	public String getReserved02() {
		return this.reserved02;
	}

	public void setReserved02(String reserved02) {
		this.reserved02 = reserved02;
	}

	public String getReserved03() {
		return this.reserved03;
	}

	public void setReserved03(String reserved03) {
		this.reserved03 = reserved03;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbResourceModifyStatusId))
			return false;
		TbResourceModifyStatusId castOther = (TbResourceModifyStatusId) other;

		return ((this.getResourceId() == castOther.getResourceId()) || (this.getResourceId() != null
				&& castOther.getResourceId() != null && this.getResourceId().equals(castOther.getResourceId())))
				&& ((this.getTenantId() == castOther.getTenantId()) || (this.getTenantId() != null
						&& castOther.getTenantId() != null && this.getTenantId().equals(castOther.getTenantId())))
				&& ((this.getResourceName() == castOther.getResourceName())
						|| (this.getResourceName() != null && castOther.getResourceName() != null
								&& this.getResourceName().equals(castOther.getResourceName())))
				&& ((this.getResourcePath() == castOther.getResourcePath())
						|| (this.getResourcePath() != null && castOther.getResourcePath() != null
								&& this.getResourcePath().equals(castOther.getResourcePath())))
				&& ((this.getDataFormat() == castOther.getDataFormat()) || (this.getDataFormat() != null
						&& castOther.getDataFormat() != null && this.getDataFormat().equals(castOther.getDataFormat())))
				&& ((this.getComment() == castOther.getComment()) || (this.getComment() != null
						&& castOther.getComment() != null && this.getComment().equals(castOther.getComment())))
				&& ((this.getDbServerId() == castOther.getDbServerId()) || (this.getDbServerId() != null
						&& castOther.getDbServerId() != null && this.getDbServerId().equals(castOther.getDbServerId())))
				&& ((this.getDatabaseName() == castOther.getDatabaseName())
						|| (this.getDatabaseName() != null && castOther.getDatabaseName() != null
								&& this.getDatabaseName().equals(castOther.getDatabaseName())))
				&& ((this.getCollectionName() == castOther.getCollectionName())
						|| (this.getCollectionName() != null && castOther.getCollectionName() != null
								&& this.getCollectionName().equals(castOther.getCollectionName())))
				&& ((this.getResourceDataUpdatedDate() == castOther.getResourceDataUpdatedDate())
						|| (this.getResourceDataUpdatedDate() != null && castOther.getResourceDataUpdatedDate() != null
								&& this.getResourceDataUpdatedDate().equals(castOther.getResourceDataUpdatedDate())))
				&& ((this.getResourceClass() == castOther.getResourceClass())
						|| (this.getResourceClass() != null && castOther.getResourceClass() != null
								&& this.getResourceClass().equals(castOther.getResourceClass())))
				&& ((this.getRetentionPeriod() == castOther.getRetentionPeriod())
						|| (this.getRetentionPeriod() != null && castOther.getRetentionPeriod() != null
								&& this.getRetentionPeriod().equals(castOther.getRetentionPeriod())))
				&& ((this.getReserved01() == castOther.getReserved01()) || (this.getReserved01() != null
						&& castOther.getReserved01() != null && this.getReserved01().equals(castOther.getReserved01())))
				&& ((this.getReserved02() == castOther.getReserved02()) || (this.getReserved02() != null
						&& castOther.getReserved02() != null && this.getReserved02().equals(castOther.getReserved02())))
				&& ((this.getReserved03() == castOther.getReserved03()) || (this.getReserved03() != null
						&& castOther.getReserved03() != null && this.getReserved03().equals(castOther.getReserved03())))
				&& ((this.getModifiedDate() == castOther.getModifiedDate())
						|| (this.getModifiedDate() != null && castOther.getModifiedDate() != null
								&& this.getModifiedDate().equals(castOther.getModifiedDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getResourceId() == null ? 0 : this.getResourceId().hashCode());
		result = 37 * result + (getTenantId() == null ? 0 : this.getTenantId().hashCode());
		result = 37 * result + (getResourceName() == null ? 0 : this.getResourceName().hashCode());
		result = 37 * result + (getResourcePath() == null ? 0 : this.getResourcePath().hashCode());
		result = 37 * result + (getDataFormat() == null ? 0 : this.getDataFormat().hashCode());
		result = 37 * result + (getComment() == null ? 0 : this.getComment().hashCode());
		result = 37 * result + (getDbServerId() == null ? 0 : this.getDbServerId().hashCode());
		result = 37 * result + (getDatabaseName() == null ? 0 : this.getDatabaseName().hashCode());
		result = 37 * result + (getCollectionName() == null ? 0 : this.getCollectionName().hashCode());
		result = 37 * result
				+ (getResourceDataUpdatedDate() == null ? 0 : this.getResourceDataUpdatedDate().hashCode());
		result = 37 * result + (getResourceClass() == null ? 0 : this.getResourceClass().hashCode());
		result = 37 * result + (getRetentionPeriod() == null ? 0 : this.getRetentionPeriod().hashCode());
		result = 37 * result + (getReserved01() == null ? 0 : this.getReserved01().hashCode());
		result = 37 * result + (getReserved02() == null ? 0 : this.getReserved02().hashCode());
		result = 37 * result + (getReserved03() == null ? 0 : this.getReserved03().hashCode());
		result = 37 * result + (getModifiedDate() == null ? 0 : this.getModifiedDate().hashCode());
		return result;
	}

}