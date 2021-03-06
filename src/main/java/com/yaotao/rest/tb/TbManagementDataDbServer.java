package com.yaotao.rest.tb;
// Generated 2016-1-2 22:34:23 by Hibernate Tools 3.6.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbManagementDataDbServer generated by hbm2java
 */
public class TbManagementDataDbServer implements java.io.Serializable {

	private int dbServerId;
	private Date addedDate;
	private String hostname;
	private Set tbTenants = new HashSet(0);

	public TbManagementDataDbServer() {
	}

	public TbManagementDataDbServer(int dbServerId) {
		this.dbServerId = dbServerId;
	}

	public TbManagementDataDbServer(int dbServerId, Date addedDate, String hostname, Set tbTenants) {
		this.dbServerId = dbServerId;
		this.addedDate = addedDate;
		this.hostname = hostname;
		this.tbTenants = tbTenants;
	}

	public int getDbServerId() {
		return this.dbServerId;
	}

	public void setDbServerId(int dbServerId) {
		this.dbServerId = dbServerId;
	}

	public Date getAddedDate() {
		return this.addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public String getHostname() {
		return this.hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public Set getTbTenants() {
		return this.tbTenants;
	}

	public void setTbTenants(Set tbTenants) {
		this.tbTenants = tbTenants;
	}

}
