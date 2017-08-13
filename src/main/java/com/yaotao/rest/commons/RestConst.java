/**
 * FUJITSU CONFIDENTIAL
 * Copyright 2010-2014 FUJITSU LIMITED All rights reserved.
 */
package com.yaotao.rest.commons;

import org.apache.log4j.Logger;

import com.yaotao.rest.commons.properties.CommonPropertyManager;
import com.yaotao.rest.commons.properties.PropertyAccessor;

/**
 * Rest共通 定数クラス
 *
 * @author FUJITSU BROAD SOLUTION & CONSULTING Inc.
 * @version 1.0
 */
public class RestConst {

	/** エラーレベル：INFO */
	public static final int LEVEL_INFO = 0;

	/** エラーレベル：WARN */
	public static final int LEVEL_WARN = 1;

	/** エラーレベル：ERROR */
	public static final int LEVEL_ERROR = 2;

	/** エラーレベル：FATAL */
	public static final int LEVEL_FATAL = 3;

	/** リソースREAD権限 */
	public static final String RESOURCE_PERMISSION_READ = "read";

	/** リソースUPDATE権限 */
	public static final String RESOURCE_PERMISSION_UPDATE = "update";

	protected static final Logger LOG = Logger.getLogger(RestConst.class);

	/** 検索結果として得られるデータをn個に限定する */
	public static final String QUERY_RESULT_MAX_COUNT = "1000";
	/** 検索結果として得られたデータをn個skipする */
	public static final String QUERY_RESULT_SKIP = "0";

	public static final int REQUEST_ACCESSCODES_SEARCH = 0;
	public static final int REQUEST_ACCESSCODES_COUNT = 1;

	public static final int REQUEST_WITH_ACCESSCODE = 0;
	public static final int REQUEST_WITHOUT_ACCESSCODE = 1;
	
	// static variable initial
	static {
		try {
			final PropertyAccessor prop = CommonPropertyManager.getPropertyAccessor();
			//Test Code
			if (prop.getString("yao").compareToIgnoreCase("tao") == 0) {
			}
			try {
			} catch (Exception e) {
			}
		} catch (Exception e) {
			setDefault();
		} finally {
			outputLog();
		}
	}

	/*
	 * 
	 * /** デフォルト値を設定する。
	 */
	private static void setDefault() {
		// プロパティがない場合はデフォルト値設定
	}

	/**
	 * 外部定義の内容をログに出力する。
	 */
	private static void outputLog() {

		LOG.debug("QUERY_RESULT_MAX_COUNT(query.result.max.count):" + QUERY_RESULT_MAX_COUNT);
		LOG.debug("QUERY_RESULT_SKIP(query.result.skip):" + QUERY_RESULT_SKIP);
	}
}