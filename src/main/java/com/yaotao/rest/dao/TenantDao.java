/**
 * FUJITSU CONFIDENTIAL
 * Copyright 2010-2014 FUJITSU LIMITED All rights reserved.
 */
package com.yaotao.rest.dao;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.yaotao.rest.commons.RestConst;
import com.yaotao.rest.exception.RestException;

/**
 * FENICS ID情報、及び管理者情報を扱うDAOクラス.
 *
 * @author FUJITSU BROAD SOLUTION & CONSULTING Inc.
 * @version 1.0
 */
public class TenantDao extends BaseDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * テナントIDがあるかどうか
	 *
	 * @param tenantId
	 *            テナントID
	 * @return true ある
	 * 		　　  false ない
	 * @throws RestException
	 *             例外処理
	 */

	public Boolean get(String tenantId) throws RestException {

		Session session = null;

		try {
			log.info("get tenant begin");

			session = getSession();
			
			// ////////////////////////////////////////////////////////////
			// SQL構築
			StringBuffer sql = new StringBuffer();

			sql.append(" SELECT ");
			sql.append(" COUNT(*) AS count ");
			sql.append(" FROM iot.tb_tenant ");
			sql.append(" WHERE tenant_id=:tenantId ");			
			
			SQLQuery query = session.createSQLQuery(sql.toString());

			// ////////////////////////////////////////////////////////////
			// パラメータ設定
			log.info("sql sentence is: " + sql);
			query.setString("tenantId", tenantId);

			// ////////////////////////////////////////////////////////////
			// 戻り値型設定
			// (AdapterInfoBean)
			// 0 FENICS ID
			query.addScalar("count", new org.hibernate.type.IntegerType());

			// ////////////////////////////////////////////////////////////
			// SQL実行
			Integer count = (Integer) query.uniqueResult();
			if(count == 0){
				return false;
			}
			
			return true;
		} catch(HibernateException e){
			// DBエラー
			String errorCode = "RESTCM-F00013";
			int errorLevel = RestConst.LEVEL_FATAL;
			throw convertE2R(errorLevel, errorCode, e);
		} catch (Exception e) {
			String errorCode = "RESTCM-F00014";
			int errorLevel = RestConst.LEVEL_FATAL;
			throw convertE2R(errorLevel, errorCode, e);
		} finally {
			closeQuietly(session, null);
			log.info("get tenant end");
		}
	}

	/**
	 * 管理データDBサーバーIDを取得
	 *
	 * @param tenantId
	 *            テナントID
	 * @return Object(DBサーバーID & hostname)
	 * 		　　  
	 * @throws RestException
	 *             例外処理
	 */

	public Object[] getTenantDBServerInfo(String tenantId) throws RestException {

		Session session = null;

		try {
			log.info("get tenant's db server id begin");

			session = getSession();
			
			// ////////////////////////////////////////////////////////////
			// SQL構築
			StringBuffer sql = new StringBuffer();

			sql.append(" SELECT ");
			sql.append(" tbt.db_server_id AS serverId, tbm.hostname AS hostName");
			sql.append(" FROM iot.tb_tenant AS tbt ");
			sql.append(" INNER JOIN iot.tb_management_data_db_server AS tbm ");
			sql.append(" ON tbt.db_server_id=tbm.db_server_id ");
			sql.append(" WHERE tbt.tenant_id=:tenantId ");
			
			SQLQuery query = session.createSQLQuery(sql.toString());

			// ////////////////////////////////////////////////////////////
			// パラメータ設定
			log.info("sql sentence is: " + sql);
			query.setString("tenantId", tenantId);

			// ////////////////////////////////////////////////////////////
			// 戻り値型設定
			// (AdapterInfoBean)
			// 0 FENICS ID
			query.addScalar("serverId", new org.hibernate.type.IntegerType());
			query.addScalar("hostName", new org.hibernate.type.StringType());

			// ////////////////////////////////////////////////////////////
			// SQL実行
			Object[] result = (Object[]) query.uniqueResult();
			
			log.info("tenant db server id is: " + (int) result[0]);
			log.info("tenant db server hostname is: " + (String) result[1]);
			
			return result;
		} catch(HibernateException e){
			// DBエラー
			String errorCode = "RESTCM-F00015";
			int errorLevel = RestConst.LEVEL_FATAL;
			throw convertE2R(errorLevel, errorCode, e);
		} catch (Exception e) {
			String errorCode = "RESTCM-F00016";
			int errorLevel = RestConst.LEVEL_FATAL;
			throw convertE2R(errorLevel, errorCode, e);
		} finally {
			closeQuietly(session, null);
			log.info("get tenant's db server id end");
		}
	}	
	
}
