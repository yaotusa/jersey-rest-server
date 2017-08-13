package com.yaotao.rest.commons;

public enum AccessCodeRequestType {
	REQUEST_ACCESSCODES_SEARCH_WITH_ACCESSCODE(RestConst.REQUEST_ACCESSCODES_SEARCH,
			RestConst.REQUEST_WITH_ACCESSCODE), 
	REQUEST_ACCESSCODES_SEARCH_WITHOUT_ACCESSCODE(RestConst.REQUEST_ACCESSCODES_SEARCH,
			RestConst.REQUEST_WITHOUT_ACCESSCODE), 
	REQUEST_ACCESSCODES_COUNT_WITH_ACCESSCODE(RestConst.REQUEST_ACCESSCODES_COUNT,
			RestConst.REQUEST_WITH_ACCESSCODE), 
	REQUEST_ACCESSCODES_COUNT_WITHOUT_ACCESSCODE(RestConst.REQUEST_ACCESSCODES_COUNT, 
			RestConst.REQUEST_WITHOUT_ACCESSCODE);

	private int requestType;
	private int codeExist;

	/**
	 * コンストラクタ
	 *
	 * @param n
	 *            値
	 */
	private AccessCodeRequestType(int requestType, int codeExist) {
		this.requestType = requestType;
		this.codeExist = codeExist;
	}

	/**
	 * requestType取得
	 *
	 * @return 値
	 */
	public int getRequestType() {
		return this.requestType;
	}

	/**
	 * codeExist取得
	 *
	 * @return 値
	 */
	public int getCodeExist() {
		return this.codeExist;
	}

}
