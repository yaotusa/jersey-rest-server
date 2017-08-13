/**
 * FUJITSU CONFIDENTIAL
 * Copyright 2011-2014 FUJITSU LIMITED All rights reserved.
 */
package com.yaotao.rest.param;

/**
 * アクセスコード情報検索条件パラメータ
 * 
 */
public class AccessCodeSearchParam {

	protected String tenantId;

	protected String accessCodeId;

	protected String accessCodeName;

	protected String resourcePath;

	protected String resourceName;

	protected String filter;

	protected boolean isAccessCodeWildCard;

	protected boolean isAccessCodeNameWildCard;

	protected boolean isResourcePathWildCard;

	protected boolean isResourceNameWildCard;

	/** 取得件数 */
	protected int requestCount;

	/** 開始番号 */
	protected int startNumber;

	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * @param tenantId
	 *            the tenantId to set
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	/**
	 * @return the accessCodeId
	 */
	public String getAccessCodeId() {
		return accessCodeId;
	}

	/**
	 * @param accessCodeId
	 *            the accessCodeId to set
	 */
	public void setAccessCodeId(String accessCodeId) {
		this.accessCodeId = accessCodeId;
	}

	/**
	 * @return the accessCodeName
	 */
	public String getAccessCodeName() {
		return accessCodeName;
	}

	/**
	 * @param accessCodeName
	 *            the accessCodeName to set
	 */
	public void setAccessCodeName(String accessCodeName) {
		this.accessCodeName = accessCodeName;
	}

	/**
	 * @return the resourcePath
	 */
	public String getResourcePath() {
		return resourcePath;
	}

	/**
	 * @param resourcePath
	 *            the resourcePath to set
	 */
	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	/**
	 * @return the resourceName
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * @param resourceName
	 *            the resourceName to set
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	/**
	 * @return the requestCount
	 */
	public int getRequestCount() {
		return requestCount;
	}

	/**
	 * @param requestCount
	 *            the requestCount to set
	 */
	public void setRequestCount(int requestCount) {
		this.requestCount = requestCount;
	}

	/**
	 * @return the startNumber
	 */
	public int getStartNumber() {
		return startNumber;
	}

	/**
	 * @param startNumber
	 *            the startNumber to set
	 */
	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public boolean isAccessCodeWildCard() {
		return isAccessCodeWildCard;
	}

	public void setAccessCodeWildCard(boolean isAccessCodeWildCard) {
		this.isAccessCodeWildCard = isAccessCodeWildCard;
	}

	public boolean isAccessCodeNameWildCard() {
		return isAccessCodeNameWildCard;
	}

	public void setAccessCodeNameWildCard(boolean isAccessCodeNameWildCard) {
		this.isAccessCodeNameWildCard = isAccessCodeNameWildCard;
	}

	public boolean isResourcePathWildCard() {
		return isResourcePathWildCard;
	}

	public void setResourcePathWildCard(boolean isResourcePathWildCard) {
		this.isResourcePathWildCard = isResourcePathWildCard;
	}

	public boolean isResourceNameWildCard() {
		return isResourceNameWildCard;
	}

	public void setResourceNameWildCard(boolean isResourceNameWildCard) {
		this.isResourceNameWildCard = isResourceNameWildCard;
	}
}
