package com.yaotao.rest.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author
 * @website
 */
@XmlRootElement(name = "list")
public class AccessCodeOutputRootJsonBean {

	private List<AccessCodeJsonBean> accessCodes;

	public void setAccessCodes(List<AccessCodeJsonBean> accessCodes) {
		this.accessCodes = accessCodes;
	}

	@XmlElement(name = "access_codes")
	public List<AccessCodeJsonBean> getAccessCodes() {
		return accessCodes;
	}
}