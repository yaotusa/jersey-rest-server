package com.yaotao.rest.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author
 * @website
 */
public class PermissionsJsonBean {

	private String operations;

	private List<ResourceOperationsJsonBean> resourceOperations;

	public void setOperations(String operations) {
		this.operations = operations;
	}

	public String getOperations() {
		return operations;
	}

	public void setResourceOperations(List<ResourceOperationsJsonBean> resourceOperations) {
		this.resourceOperations = resourceOperations;
	}

	@XmlElement(name = "resource_operations")
	public List<ResourceOperationsJsonBean> getResourceOperations() {
		return resourceOperations;
	}

}