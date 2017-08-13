package com.yaotao.rest.tb;
// Generated 2016-1-2 22:34:23 by Hibernate Tools 3.6.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbCustomer generated by hbm2java
 */
public class TbCustomer implements java.io.Serializable {

	private String customerId;
	private String customerName;
	private String personInCharge;
	private String telephoneNumber;
	private String email;
	private String comment;
	private String reserved01;
	private String reserved02;
	private String reserved03;
	private Date addedDate;
	private Date modifiedDate;
	private Set tbTenants = new HashSet(0);

	public TbCustomer() {
	}

	public TbCustomer(String customerId, String customerName, Date addedDate) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.addedDate = addedDate;
	}

	public TbCustomer(String customerId, String customerName, String personInCharge, String telephoneNumber,
			String email, String comment, String reserved01, String reserved02, String reserved03, Date addedDate,
			Date modifiedDate, Set tbTenants) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.personInCharge = personInCharge;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
		this.comment = comment;
		this.reserved01 = reserved01;
		this.reserved02 = reserved02;
		this.reserved03 = reserved03;
		this.addedDate = addedDate;
		this.modifiedDate = modifiedDate;
		this.tbTenants = tbTenants;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPersonInCharge() {
		return this.personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}

	public String getTelephoneNumber() {
		return this.telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public Set getTbTenants() {
		return this.tbTenants;
	}

	public void setTbTenants(Set tbTenants) {
		this.tbTenants = tbTenants;
	}

}