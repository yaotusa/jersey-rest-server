package com.yaotao.rest.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author
 * @website
 */
public class ResourceOperationsJsonBean {

	private String resourcePath;

	private List<String> operations;

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	@XmlElement(name = "resource_path")
	public String getResourcePath() {
		return resourcePath;
	}

	public void setOperations(List<String> operations) {
		this.operations = operations;
	}

	public List<String> getOperations() {
		return operations;
	}

}