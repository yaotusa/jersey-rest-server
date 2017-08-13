/**
 * FUJITSU CONFIDENTIAL
 * Copyright 2010 FUJITSU LIMITED All rights reserved.
 */
package com.yaotao.rest.commons.properties;

import com.yaotao.rest.exception.RestException;

/**
 * 共通プロパティマネージャークラス
 *
 * @author FUJITSU BROAD SOLUTION & CONSULTING Inc.
 * @version 1.0
 */
public class CommonPropertyManager{

	/**
	 * プロパティファイル名
	 */
	private final static String PROPERTY_FILE_NAME = "rest_common.properties";

	/**
	 * プロパティアクセッサ
	 */
	private static PropertyAccessor propertyAccessor;

	/**
	 * プロパティアクセッサのインスタンスを取得する。
	 *
	 * @param propFileName
	 *            プロパティファイル名
	 * @return プロパティアクセッサのインスタンス
	 * @throws Exception
	 */
	public static synchronized PropertyAccessor getPropertyAccessor()
			throws RestException{
		// 初回はインスタンスを生成する。
		if(propertyAccessor == null){
			// PropertyAccessorインスタンス化を生成する。
			propertyAccessor = new PropertyAccessor(PROPERTY_FILE_NAME);
		}

		return propertyAccessor;
	}
}
