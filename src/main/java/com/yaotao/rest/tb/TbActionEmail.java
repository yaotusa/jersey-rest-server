package com.yaotao.rest.tb;
// Generated 2016-1-2 22:34:23 by Hibernate Tools 3.6.0.Final

/**
 * TbActionEmail generated by hbm2java
 */
public class TbActionEmail implements java.io.Serializable {

	private String eventId;
	private TbEvent tbEvent;
	private String tenantId;
	private String emailAddress;
	private String emailSubject;
	private String emailBody;
	private String reserved01;
	private String reserved02;
	private String reserved03;

	public TbActionEmail() {
	}

	public TbActionEmail(TbEvent tbEvent, String emailAddress) {
		this.tbEvent = tbEvent;
		this.emailAddress = emailAddress;
	}

	public TbActionEmail(TbEvent tbEvent, String tenantId, String emailAddress, String emailSubject, String emailBody,
			String reserved01, String reserved02, String reserved03) {
		this.tbEvent = tbEvent;
		this.tenantId = tenantId;
		this.emailAddress = emailAddress;
		this.emailSubject = emailSubject;
		this.emailBody = emailBody;
		this.reserved01 = reserved01;
		this.reserved02 = reserved02;
		this.reserved03 = reserved03;
	}

	public String getEventId() {
		return this.eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public TbEvent getTbEvent() {
		return this.tbEvent;
	}

	public void setTbEvent(TbEvent tbEvent) {
		this.tbEvent = tbEvent;
	}

	public String getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailSubject() {
		return this.emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailBody() {
		return this.emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
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

}
