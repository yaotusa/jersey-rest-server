package com.yaotao.rest.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 *
 * @author
 * @website
 */
@XmlRootElement
public class AccessCodeInputRootJsonBean {

	private AccessCodeJsonBean accessCode;

	public void setAccessCode(AccessCodeJsonBean accessCode) {
		this.accessCode = accessCode;
	}

	@XmlElement(name = "access_code")
	public AccessCodeJsonBean getAccessCode() {
		return accessCode;
	}

}