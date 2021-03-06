package com.yaotao.rest.tb;
// Generated 2016-1-2 22:34:23 by Hibernate Tools 3.6.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbUser generated by hbm2java
 */
public class TbUser implements java.io.Serializable {

	private String userId;
	private String customerId;
	private String password;
	private String userName;
	private String comment;
	private int authority;
	private String reserved01;
	private String reserved02;
	private String reserved03;
	private Date addedDate;
	private Date modifiedDate;
	private Set tbIpfilterUserRelations = new HashSet(0);
	private Set tbTenants = new HashSet(0);

	public TbUser() {
	}

	public TbUser(String userId, String password, int authority, Date addedDate) {
		this.userId = userId;
		this.password = password;
		this.authority = authority;
		this.addedDate = addedDate;
	}

	public TbUser(String userId, String customerId, String password, String userName, String comment, int authority,
			String reserved01, String reserved02, String reserved03, Date addedDate, Date modifiedDate,
			Set tbIpfilterUserRelations, Set tbTenants) {
		this.userId = userId;
		this.customerId = customerId;
		this.password = password;
		this.userName = userName;
		this.comment = comment;
		this.authority = authority;
		this.reserved01 = reserved01;
		this.reserved02 = reserved02;
		this.reserved03 = reserved03;
		this.addedDate = addedDate;
		this.modifiedDate = modifiedDate;
		this.tbIpfilterUserRelations = tbIpfilterUserRelations;
		this.tbTenants = tbTenants;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getAuthority() {
		return this.authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
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

	public Set getTbIpfilterUserRelations() {
		return this.tbIpfilterUserRelations;
	}

	public void setTbIpfilterUserRelations(Set tbIpfilterUserRelations) {
		this.tbIpfilterUserRelations = tbIpfilterUserRelations;
	}

	public Set getTbTenants() {
		return this.tbTenants;
	}

	public void setTbTenants(Set tbTenants) {
		this.tbTenants = tbTenants;
	}

}
