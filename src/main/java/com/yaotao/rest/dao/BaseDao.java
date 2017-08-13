/**
 * FUJITSU CONFIDENTIAL
 * Copyright 2010-2014 FUJITSU LIMITED All rights reserved.
 */
package com.yaotao.rest.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yaotao.rest.commons.RestConst;
import com.yaotao.rest.commons.properties.MessagePropertyManager;
import com.yaotao.rest.commons.properties.PropertyAccessor;
import com.yaotao.rest.exception.RestException;
import com.yaotao.rest.servlet.DBInitialServlet;


/**
 * DAOクラスのベース.
 *
 * @author FUJITSU BROAD SOLUTION & CONSULTING Inc.
 * @version 1.0
 */
public class BaseDao extends DBInitialServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** システムログ */
	protected Logger log = Logger.getLogger(this.getClass());

	/** APIインタフェースで使う日付フォーマット */
	public DateFormat idf = new SimpleDateFormat("yyyyMMdd");

	private static Hashtable<Integer, SessionFactory> tenantSessionTable = new Hashtable<Integer, SessionFactory>();

	/**
	 * DB接続を取得する
	 *
	 * @return DBセッション
	 * @throws RestException
	 *             DBエラー
	 */
	public Session getSession()  {
		try {
			return sessionFactory.openSession();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * DB接続を取得する (複数TenantDB対応)
	 * 
	 * @param tenantId
	 *            TenantのID
	 * @return DBセッション
	 * @throws RestException
	 *             DBエラー
	 */
	public Session getSession(String tenantId) {
		try {
			TenantDao tenantDao = new TenantDao();
			Object[] result = tenantDao.getTenantDBServerInfo(tenantId);
			int dbServerId = (int) result[0];
			String hostName = (String) result[1];
			
			if(dbServerId == 1){
				return getSession();
			}

			if (tenantSessionTable.get(dbServerId) != null) {
				return tenantSessionTable.get(dbServerId).openSession();
			}

			Configuration tenantConfig = new Configuration().configure();
			tenantConfig.setProperty("hibernate.connection.url",
					"jdbc:postgresql://" + hostName + ":5432/iotManagementDB");

			SessionFactory tenantSessionFactory = tenantConfig
					.buildSessionFactory();
			tenantSessionTable.put(dbServerId, tenantSessionFactory);
			return tenantSessionFactory.openSession();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * hibernate Sessionクローズ共通処理
	 * 外部からオブジェクトを渡している為、共通処理で行える。
	 * @param session
	 *            Hibernate Session
	 * @param transaction
	 *            Hibernate Transaction
	 */
	public void closeQuietly(Session session, Transaction transaction) {
		// ロールバック
		if (transaction != null) {
			try {
				transaction.rollback();
			} catch (HibernateException e) {
			}
		}
		if (session != null) {
			try {
				session.close();
			} catch (HibernateException e) {
				this.log.debug("HibernateException at session close.", e);
			}
		}
	}

	/**
	 * コミットを行う。
	 * 外部からTransactionオブジェクトを渡している為、共通処理で行える。
	 * @param transaction トランザクション
	 * @throws RestException 例外
	 */
	public void commit(Transaction transaction) {
		try {
			transaction.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * パラメータを元にRestExceptionを作成する。
	 *
	 * @param errorLevel
	 *            エラーレベル
	 * @param errorCode
	 *            エラーコード
	 * @param e
	 *            エラー起因
	 * @return RestException
	 */
	protected RestException convertE2R(int errorLevel, String errorCode,
			Exception e) {
		this.logException(errorLevel, errorCode, null, e);
		return new RestException(errorLevel, errorCode, e);
	}

	/**
	 * ログ出力
	 *
	 * @param errorLevel
	 *            エラーレベル
	 * @param errorCode
	 *            エラーコード
	 * @param options
	 *            オプション
	 * @param e
	 *            エラー起因
	 */
	private void logException(int errorLevel,
	                            String errorCode,
	                            Object[] options,
	                            Exception e) {
		final PropertyAccessor messageProperty = MessagePropertyManager.getPropertyAccessor();
		String msg = "";
		if (options == null) {
			msg = messageProperty.getString(errorCode);
		} else {
			msg = messageProperty.getString(errorCode, options);
		}
		
		if(msg == null) msg = "";
		this.outputLog(errorLevel, errorCode, e, msg);
	}

	/**
	 * ログに出力する
	 * @param errorLevel エラーレベル
	 * @param errorCode エラーコード
	 * @param e 例外オブジェクト
	 * @param msg メッセージ
	 */
	private void outputLog(int errorLevel, String errorCode, Exception e,
			String msg) {
		if (errorLevel == RestConst.LEVEL_ERROR) {
			this.log.error(errorCode + ":" + msg);
		} else if (errorLevel == RestConst.LEVEL_FATAL) {
			if (e != null) {
				this.log.fatal(errorCode + ":" + msg, e);
			} else {
				this.log.fatal(errorCode + ":" + msg);
			}
		}
	}


}
