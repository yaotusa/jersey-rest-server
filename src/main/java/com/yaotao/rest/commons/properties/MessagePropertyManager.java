/**
 * FUJITSU CONFIDENTIAL
 * Copyright 2010 FUJITSU LIMITED All rights reserved.
 */
package com.yaotao.rest.commons.properties;

import com.yaotao.rest.exception.RestException;

/**
 * メッセージプロパティマネージャークラス
 *
 * @author FUJITSU BROAD SOLUTION & CONSULTING Inc.
 * @version 1.0
 */
public class MessagePropertyManager{

	/**
	 * プロパティファイル名
	 */
	private final static String PROPERTY_FILE_NAME = "rest_message.properties";

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
	public static synchronized PropertyAccessor getPropertyAccessor(){
		// 初回はインスタンスを生成する。
		if(propertyAccessor == null){
			try{
				// PropertyAccessorインスタンス化を生成する。
				propertyAccessor = new PropertyAccessor(PROPERTY_FILE_NAME);
			}catch(RestException e){
				// メッセージファイルを取得できない場合はログ出力のみ
			}
		}

		return propertyAccessor;
	}
}
