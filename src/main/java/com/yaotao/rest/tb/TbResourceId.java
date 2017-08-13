package com.yaotao.rest.tb;
// Generated 2016-1-2 22:34:23 by Hibernate Tools 3.6.0.Final

import java.util.HashSet;
import java.util.Set;

/**
 * TbResourceId generated by hbm2java
 */
public class TbResourceId implements java.io.Serializable {

	private String resourceId;
	private TbResource tbResource;
	private TbStorageAmount tbStorageAmount;
	private TbForwardAction tbForwardAction;
	private Set tbAccessCodePermissions = new HashSet(0);
	private Set tbTargetResources = new HashSet(0);
	private Set tbRecommends = new HashSet(0);
	private Set tbDispersionPolces = new HashSet(0);

	public TbResourceId() {
	}

	public TbResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public TbResourceId(String resourceId, TbResource tbResource, TbStorageAmount tbStorageAmount,
			TbForwardAction tbForwardAction, Set tbAccessCodePermissions, Set tbTargetResources, Set tbRecommends,
			Set tbDispersionPolces) {
		this.resourceId = resourceId;
		this.tbResource = tbResource;
		this.tbStorageAmount = tbStorageAmount;
		this.tbForwardAction = tbForwardAction;
		this.tbAccessCodePermissions = tbAccessCodePermissions;
		this.tbTargetResources = tbTargetResources;
		this.tbRecommends = tbRecommends;
		this.tbDispersionPolces = tbDispersionPolces;
	}

	public String getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public TbResource getTbResource() {
		return this.tbResource;
	}

	public void setTbResource(TbResource tbResource) {
		this.tbResource = tbResource;
	}

	public TbStorageAmount getTbStorageAmount() {
		return this.tbStorageAmount;
	}

	public void setTbStorageAmount(TbStorageAmount tbStorageAmount) {
		this.tbStorageAmount = tbStorageAmount;
	}

	public TbForwardAction getTbForwardAction() {
		return this.tbForwardAction;
	}

	public void setTbForwardAction(TbForwardAction tbForwardAction) {
		this.tbForwardAction = tbForwardAction;
	}

	public Set getTbAccessCodePermissions() {
		return this.tbAccessCodePermissions;
	}

	public void setTbAccessCodePermissions(Set tbAccessCodePermissions) {
		this.tbAccessCodePermissions = tbAccessCodePermissions;
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

}
