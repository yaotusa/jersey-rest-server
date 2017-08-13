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
public class ResourceDao extends BaseDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * リソースID取得
	 *
	 * @param param
	 *            検索条件パラメータ
	 * @return 検索条件に該当する件数
	 * @throws RestException
	 *             例外処理
	 */

	public String get(String tenantId, String path) throws RestException {

		Session session = null;

		try {
			log.info("get resourcd id begin:");

			session = getSession(tenantId);
			
			// ////////////////////////////////////////////////////////////
			// SQL構築
			StringBuffer sql = new StringBuffer();

			sql.append(" SELECT ");
			sql.append(" resource_id AS resourceId ");
			sql.append(" FROM iot.tb_resource ");
			sql.append(" WHERE resource_path=:resourcePath ");			
			sql.append(" AND tenant_id=:tenantId ");			
			
			
			SQLQuery query = session.createSQLQuery(sql.toString());

			// ////////////////////////////////////////////////////////////
			// パラメータ設定
			log.info("sql sentence is: " + sql);
			query.setString("resourcePath", path);
			query.setString("tenantId", tenantId);

			// ////////////////////////////////////////////////////////////
			// 戻り値型設定
			// (AdapterInfoBean)
			// 0 FENICS ID
			query.addScalar("resourceId", new org.hibernate.type.StringType());

			// ////////////////////////////////////////////////////////////
			// SQL実行
			String id = (String) query.uniqueResult();
			if(id == null){
				throw new Exception("The resource whose path is [" + path + "] is not exist in the tenant [" + tenantId + "].");
			}

			log.info("resource id is: " + id);
			return id;
		} catch(HibernateException e){
			// DBエラー
			String errorCode = "RESTCM-F00001";
			int errorLevel = RestConst.LEVEL_FATAL;
			throw convertE2R(errorLevel, errorCode, e);
		} catch (Exception e) {
			String errorCode = "RESTCM-F00002";
			int errorLevel = RestConst.LEVEL_FATAL;
			throw convertE2R(errorLevel, errorCode, e);
		} finally {
			closeQuietly(session, null);
			log.info("get resourcd id  end:");
		}
	}

}
