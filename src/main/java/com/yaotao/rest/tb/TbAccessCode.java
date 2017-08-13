package com.yaotao.rest.tb;
// Generated 2016-1-2 22:34:23 by Hibernate Tools 3.6.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbAccessCode generated by hbm2java
 */
public class TbAccessCode implements java.io.Serializable {

	private TbAccessCodeId id;
	private TbTenant tbTenant;
	private String accessCodeName;
	private Date expirationDate;
	private String comment;
	private boolean createPermission;
	private boolean deletePermission;
	private boolean listPermission;
	private String reserved01;
	private String reserved02;
	private String reserved03;
	private Date addedDate;
	private Date modifiedDate;
	private Set tbIpfilterAccesscodeRelations = new HashSet(0);
	private Set tbTargetResources = new HashSet(0);
	private Set tbRecommends = new HashSet(0);
	private Set tbDispersionPolces = new HashSet(0);
	private Set tbAccessCodePermissions = new HashSet(0);

	public TbAccessCode() {
	}

	public TbAccessCode(TbAccessCodeId id, TbTenant tbTenant, boolean createPermission, boolean deletePermission,
			boolean listPermission, Date addedDate) {
		this.id = id;
		this.tbTenant = tbTenant;
		this.createPermission = createPermission;
		this.deletePermission = deletePermission;
		this.listPermission = listPermission;
		this.addedDate = addedDate;
	}

	public TbAccessCode(TbAccessCodeId id, TbTenant tbTenant, String accessCodeName, Date expirationDate,
			String comment, boolean createPermission, boolean deletePermission, boolean listPermission,
			String reserved01, String reserved02, String reserved03, Date addedDate, Date modifiedDate,
			Set tbIpfilterAccesscodeRelations, Set tbTargetResources, Set tbRecommends, Set tbDispersionPolces,
			Set tbAccessCodePermissions) {
		this.id = id;
		this.tbTenant = tbTenant;
		this.accessCodeName = accessCodeName;
		this.expirationDate = expirationDate;
		this.comment = comment;
		this.createPermission = createPermission;
		this.deletePermission = deletePermission;
		this.listPermission = listPermission;
		this.reserved01 = reserved01;
		this.reserved02 = reserved02;
		this.reserved03 = reserved03;
		this.addedDate = addedDate;
		this.modifiedDate = modifiedDate;
		this.tbIpfilterAccesscodeRelations = tbIpfilterAccesscodeRelations;
		this.tbTargetResources = tbTargetResources;
		this.tbRecommends = tbRecommends;
		this.tbDispersionPolces = tbDispersionPolces;
		this.tbAccessCodePermissions = tbAccessCodePermissions;
	}

	public TbAccessCodeId getId() {
		return this.id;
	}

	public void setId(TbAccessCodeId id) {
		this.id = id;
	}

	public TbTenant getTbTenant() {
		return this.tbTenant;
	}

	public void setTbTenant(TbTenant tbTenant) {
		this.tbTenant = tbTenant;
	}

	public String getAccessCodeName() {
		return this.accessCodeName;
	}

	public void setAccessCodeName(String accessCodeName) {
		this.accessCodeName = accessCodeName;
	}

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isCreatePermission() {
		return this.createPermission;
	}

	public void setCreatePermission(boolean createPermission) {
		this.createPermission = createPermission;
	}

	public boolean isDeletePermission() {
		return this.deletePermission;
	}

	public void setDeletePermission(boolean deletePermission) {
		this.deletePermission = deletePermission;
	}

	public boolean isListPermission() {
		return this.listPermission;
	}

	public void setListPermission(boolean listPermission) {
		this.listPermission = listPermission;
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

	public Date getAddedDate() {
		return this.addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Set getTbIpfilterAccesscodeRelations() {
		return this.tbIpfilterAccesscodeRelations;
	}

	public void setTbIpfilterAccesscodeRelations(Set tbIpfilterAccesscodeRelations) {
		this.tbIpfilterAccesscodeRelations = tbIpfilterAccesscodeRelations;
	}

	public Set getTbTargetResources() {
		return this.tbTargetResources;
	}

	public void setTbTargetResources(Set tbTargetResources) {
		this.tbTargetResources = tbTargetResources;
	}

	public Set getTbRecommends() {
		return this.tbRecommends;
	}

	public void setTbRecommends(Set tbRecommends) {
		this.tbRecommends = tbRecommends;
	}

	public Set getTbDispersionPolces() {
		return this.tbDispersionPolces;
	}

	public void setTbDispersionPolces(Set tbDispersionPolces) {
		this.tbDispersionPolces = tbDispersionPolces;
	}

	public Set getTbAccessCodePermissions() {
		return this.tbAccessCodePermissions;
	}

	public void setTbAccessCodePermissions(Set tbAccessCodePermissions) {
		this.tbAccessCodePermissions = tbAccessCodePermissions;
	}

}
