/**
 * FUJITSU CONFIDENTIAL
 * Copyright 2010-2013 FUJITSU LIMITED All rights reserved.
 */
package com.yaotao.rest.commons.properties;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.yaotao.rest.commons.RestConst;
import com.yaotao.rest.exception.RestException;

/**
 * プロパティアクセッサクラス
 *
 * @author FUJITSU BROAD SOLUTION & CONSULTING Inc.
 * @version 1.0
 */
public class PropertyAccessor{

	/** プロパティ */
	private Properties properties;

	private static Logger log = Logger.getLogger(PropertyAccessor.class);

	/**
	 * コンストラクタ
	 *
	 * @param fileName
	 *            プロパティファイル名
	 */
	public PropertyAccessor(String fileName) throws RestException{
		// プロパティのインスタンスを生成する。
		properties = new Properties();
		InputStream is = getClass().getClassLoader().getResourceAsStream(
				fileName);

		// プロパティファイルを読み込む。
		try{
			// プロパティファイルからキーと値のリストを読み込む。
			properties.load(is);

		}catch(Exception e){
			log.error("", e);
			throw new RestException(RestConst.LEVEL_FATAL, "", e);
		}finally{
			IOUtils.closeQuietly(is);
		}
	}

	/**
	 * キーに対応する値をString型で取得する。
	 *
	 * @param key
	 *            キー
	 * @return キーの値
	 */
	public String getString(String key){
		// キーから値を取得する。
		String value = properties.getProperty(key);

		// 値をリターンする。
		return value;
	}

	/**
	 * キーに対応する値をint型で取得する。
	 *
	 * @param key
	 *            キー
	 * @return キーの値
	 */
	public int getInt(String key){
		// キーから値を取得する。
		String stringValue = properties.getProperty(key);
		int value = Integer.parseInt(stringValue);

		// 値をリターンする。
		return value;
	}

	/**
	 * キーに対応する値をString型で取得する。
	 *
	 * @param key
	 *            キー
	 * @param param
	 *            置き換え文字列の配列
	 * @return キーの値
	 */
	public String getString(String key, Object[] param) {
		String ret = null;
		try {
			ret = MessageFormat.format(this.getString(key), param);
		} catch (Exception e) {
			log.debug("getString() can't get message. key:" + key + "param:" + Arrays.toString(param));
			ret = "";
		}
		return ret;
	}
}
