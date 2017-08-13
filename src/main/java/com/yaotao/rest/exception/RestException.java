/**
 * FUJITSU CONFIDENTIAL
 * Copyright 2010 FUJITSU LIMITED All rights reserved.
 */
package com.yaotao.rest.exception;

/**
 * REST共通Exception.
 *
 * @author FUJITSU BROAD SOLUTION & CONSULTING Inc.
 * @version 1.0
 */
public class RestException extends Exception{

	private static final long serialVersionUID = 1L;

	/** エラーレベル */
	private int level;

	/** エラーコード */
	private String code = null;

	/** オプション情報 */
	private Object[] options = null;

	/**
	 * コンストラクタ
	 *
	 * @param level
	 *            エラーレベル
	 * @param code
	 *            エラーコード
	 */
	public RestException(int level, String code){
		super();
		this.level = level;
		this.code = code;
	}

	/**
	 * コンストラクタ
	 *
	 * @param level
	 *            エラーレベル
	 * @param code
	 *            エラーコード
	 * @param options
	 *            オプション情報
	 */
	public RestException(int level, String code, Object[] options){
		super();
		this.level = level;
		this.code = code;
		this.options = options;
	}

	/**
	 * コンストラクタ
	 *
	 * @param level
	 *            エラーレベル
	 * @param code
	 *            エラーコード
	 * @param cause
	 *            エラー原因
	 */
	public RestException(int level, String code, Throwable cause){
		super(cause);
		this.level = level;
		this.code = code;
	}

	/**
	 * コンストラクタ
	 *
	 * @param level
	 *            エラーレベル
	 * @param code
	 *            エラーコード
	 * @param options
	 *            オプション情報
	 * @param cause
	 *            エラー原因
	 */
	public RestException(int level, String code, Object[] options,
			Throwable cause){
		super(cause);
		this.level = level;
		this.code = code;
		this.options = options;
	}

	/**
	 * エラーコードを取得する。
	 *
	 * @return エラーコード
	 */
	public String getCode(){
		return code;
	}

	/**
	 * エラーコードを設定する。
	 *
	 * @param code
	 *            エラーコード
	 */
	public void setCode(String code){
		this.code = code;
	}

	/**
	 * エラーレベルを取得する。
	 *
	 * @return エラーレベル
	 */
	public int getLevel(){
		return level;
	}

	/**
	 * エラーレベルを設定する。
	 *
	 * @param level
	 *            エラーレベル
	 */
	public void setLevel(int level){
		this.level = level;
	}

	/**
	 * オプション情報を取得する。
	 *
	 * @return オプション情報
	 */
	public Object[] getOptions(){
		return options;
	}

	/**
	 * オプション情報を設定する。
	 *
	 * @param options
	 *            オプション情報
	 */
	public void setOptions(Object[] options){
		this.options = options;
	}

}
