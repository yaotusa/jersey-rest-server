package com.yaotao.rest.tb;
// Generated 2016-1-2 22:34:23 by Hibernate Tools 3.6.0.Final

import java.util.Date;

/**
 * TbTenantCommon generated by hbm2java
 */
public class TbTenantCommon implements java.io.Serializable {

	private String tenantId;
	private TbResourceDataDbServer tbResourceDataDbServer;
	private TbTenant tbTenant;
	private String mqttUser;
	private String mqttPasswd;
	private String databaseName;
	private String collectionName;
	private String reserved01;
	private String reserved02;
	private String reserved03;
	private String reserved04;
	private String reserved05;
	private String reserved06;
	private String reserved07;
	private Date addedDate;
	private Date modifiedDate;

	public TbTenantCommon() {
	}

	public TbTenantCommon(TbResourceDataDbServer tbResourceDataDbServer, TbTenant tbTenant, String mqttUser,
			String mqttPasswd, String databaseName, String collectionName, Date addedDate) {
		this.tbResourceDataDbServer = tbResourceDataDbServer;
		this.tbTenant = tbTenant;
		this.mqttUser = mqttUser;
		this.mqttPasswd = mqttPasswd;
		this.databaseName = databaseName;
		this.collectionName = collectionName;
		this.addedDate = addedDate;
	}

	public TbTenantCommon(TbResourceDataDbServer tbResourceDataDbServer, TbTenant tbTenant, String mqttUser,
			String mqttPasswd, String databaseName, String collectionName, String reserved01, String reserved02,
			String reserved03, String reserved04, String reserved05, String reserved06, String reserved07,
			Date addedDate, Date modifiedDate) {
		this.tbResourceDataDbServer = tbResourceDataDbServer;
		this.tbTenant = tbTenant;
		this.mqttUser = mqttUser;
		this.mqttPasswd = mqttPasswd;
		this.databaseName = databaseName;
		this.collectionName = collectionName;
		this.reserved01 = reserved01;
		this.reserved02 = reserved02;
		this.reserved03 = reserved03;
		this.reserved04 = reserved04;
		this.reserved05 = reserved05;
		this.reserved06 = reserved06;
		this.reserved07 = reserved07;
		this.addedDate = addedDate;
		this.modifiedDate = modifiedDate;
	}

	public String getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public TbResourceDataDbServer getTbResourceDataDbServer() {
		return this.tbResourceDataDbServer;
	}

	public void setTbResourceDataDbServer(TbResourceDataDbServer tbResourceDataDbServer) {
		this.tbResourceDataDbServer = tbResourceDataDbServer;
	}

	public TbTenant getTbTenant() {
		return this.tbTenant;
	}

	public void setTbTenant(TbTenant tbTenant) {
		this.tbTenant = tbTenant;
	}

	public String getMqttUser() {
		return this.mqttUser;
	}

	public void setMqttUser(String mqttUser) {
		this.mqttUser = mqttUser;
	}

	public String getMqttPasswd() {
		return this.mqttPasswd;
	}

	public void setMqttPasswd(String mqttPasswd) {
		this.mqttPasswd = mqttPasswd;
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

	public String getReserved04() {
		return this.reserved04;
	}

	public void setReserved04(String reserved04) {
		this.reserved04 = reserved04;
	}

	public String getReserved05() {
		return this.reserved05;
	}

	public void setReserved05(String reserved05) {
		this.reserved05 = reserved05;
	}

	public String getReserved06() {
		return this.reserved06;
	}

	public void setReserved06(String reserved06) {
		this.reserved06 = reserved06;
	}

	public String getReserved07() {
		return this.reserved07;
	}

	public void setReserved07(String reserved07) {
		this.reserved07 = reserved07;
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

}
