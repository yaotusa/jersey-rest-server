/**
 * FUJITSU CONFIDENTIAL
 * Copyright 2010-2014 FUJITSU LIMITED All rights reserved.
 */
package com.yaotao.rest.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yaotao.rest.bean.AccessCodeBean;
import com.yaotao.rest.bean.AccessCodeJsonBean;
import com.yaotao.rest.bean.AccessCodeOutputRootJsonBean;
import com.yaotao.rest.bean.AccessCodePermissionBean;
import com.yaotao.rest.bean.PermissionsJsonBean;
import com.yaotao.rest.bean.ResourceOperationsJsonBean;
import com.yaotao.rest.commons.RestConst;
import com.yaotao.rest.param.AccessCodeSearchParam;
import com.yaotao.rest.tb.TbAccessCode;
import com.yaotao.rest.tb.TbAccessCodeId;
import com.yaotao.rest.tb.TbAccessCodePermission;
import com.yaotao.rest.tb.TbAccessCodePermissionId;
import com.yaotao.rest.tb.TbTenant;

/**
 *
 * @author FUJITSU BROAD SOLUTION & CONSULTING Inc.
 * @version 1.0
 */
public class AccessCodeDao extends BaseDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * パラメータを指定してアクセスコード情報件数取得
	 *
	 * @param param
	 *            検索条件パラメータ
	 * @return 検索条件に該当する件数
	 * @throws Exception
	 *             例外処理
	 */

	public AccessCodeOutputRootJsonBean search(AccessCodeSearchParam param) throws Exception {

		Session session = null;
		Transaction transaction = null;

		AccessCodeOutputRootJsonBean accessCodeRoot = new AccessCodeOutputRootJsonBean();
		List<AccessCodeJsonBean> accessCodeList = new ArrayList<AccessCodeJsonBean>();
		accessCodeRoot.setAccessCodes(accessCodeList);

		try {
			log.info("search access code begin:");

			session = getSession(param.getTenantId());
			transaction = session.beginTransaction();

			// ////////////////////////////////////////////////////////////
			// SQL構築
			StringBuffer sql = makeSelectQuery(param);
			log.info("sql sentence is: " + sql);
			SQLQuery query = session.createSQLQuery(sql.toString());

			// ////////////////////////////////////////////////////////////
			// パラメータ設定
			makeParameterForQuery(query, param);
			query.setInteger("limit", param.getRequestCount());
			query.setInteger("offset", param.getStartNumber());
			log.info("limit=" + param.getRequestCount());
			log.info("offset=" + param.getStartNumber());

			// ////////////////////////////////////////////////////////////
			// 戻り値型設定
			// 0 アクセスコードID
			query.addScalar("accessCode", new org.hibernate.type.StringType());
			// 1 アクセスコード名
			query.addScalar("accessCodeName", new org.hibernate.type.StringType());
			// 2 アクセスコードコメント
			query.addScalar("comment", new org.hibernate.type.StringType());
			// 3 リソースパス
			query.addScalar("resourcePath", new org.hibernate.type.StringType());
			// 4 参照権限
			query.addScalar("readPermission", new org.hibernate.type.BooleanType());
			// 5 更新権限
			query.addScalar("updatePermission", new org.hibernate.type.BooleanType());

			// ////////////////////////////////////////////////////////////
			// SQL実行
			@SuppressWarnings("unchecked")
			List<Object[]> list = query.list();
			log.info("search result number = " + list.size());
			log.info("search result :");
			for (int i = 0; i < list.size(); i++) {
				log.info("row " + (i + 1) + ": " + " accessCode=" + list.get(i)[0] + "; accessCodeName="
						+ list.get(i)[1] + "; comment=" + list.get(i)[2] + "; resourcePath=" + list.get(i)[3]
						+ "; readPermission=" + list.get(i)[4] + "; updatePermission=" + list.get(i)[5]);
			}

			// ////////////////////////////////////////////////////////////
			// 戻り値取得
			Iterator<Object[]> ite = list.iterator();

			String tempAccessCodeId = null;
			List<ResourceOperationsJsonBean> roJsonBeanList = new ArrayList<ResourceOperationsJsonBean>();

			while (ite.hasNext()) {
				Object[] result = ite.next();
				if (tempAccessCodeId == null || ((String) result[0]).equalsIgnoreCase(tempAccessCodeId) == false) {

					ResourceOperationsJsonBean roJsonBean = new ResourceOperationsJsonBean();
					roJsonBean.setResourcePath((String) result[3]);

					List<String> opList = new ArrayList<String>();
					if ((boolean) result[4] == true) {
						opList.add(RestConst.RESOURCE_PERMISSION_READ);
					}

					if ((boolean) result[5] == true) {
						opList.add(RestConst.RESOURCE_PERMISSION_UPDATE);
					}
					roJsonBean.setOperations(opList);

					roJsonBeanList = new ArrayList<ResourceOperationsJsonBean>();
					roJsonBeanList.add(roJsonBean);

					PermissionsJsonBean perJsonBean = new PermissionsJsonBean();
					perJsonBean.setOperations(null);
					perJsonBean.setResourceOperations(roJsonBeanList);

					AccessCodeJsonBean acJsonBean = new AccessCodeJsonBean();
					acJsonBean.setAccessCodeId((String) result[0]);
					acJsonBean.setName((String) result[1]);
					acJsonBean.setDescription((String) result[2]);
					acJsonBean.setPermissions(perJsonBean);

					accessCodeList.add(acJsonBean);
				} else {
					ResourceOperationsJsonBean roJsonBean = new ResourceOperationsJsonBean();
					roJsonBean.setResourcePath((String) result[3]);

					List<String> opeList = new ArrayList<String>();
					if ((boolean) result[4] == true) {
						opeList.add(RestConst.RESOURCE_PERMISSION_READ);
					}

					if ((boolean) result[5] == true) {
						opeList.add(RestConst.RESOURCE_PERMISSION_UPDATE);
					}
					roJsonBean.setOperations(opeList);

					roJsonBeanList.add(roJsonBean);
				}

				tempAccessCodeId = (String) result[0];
			}

			transaction.commit();
			transaction = null;

			return accessCodeRoot;

		} catch (HibernateException e) {
			// DBエラー
			String errorCode = "RESTCM-F00003";
			int errorLevel = RestConst.LEVEL_FATAL;
			throw convertE2R(errorLevel, errorCode, e);
		} catch (Exception e) {
			String errorCode = "RESTCM-F00004";
			int errorLevel = RestConst.LEVEL_FATAL;
			throw convertE2R(errorLevel, errorCode, e);
		} finally {
			closeQuietly(session, transaction);
			log.info("search access code end:");
		}
	}

	private void makeParameterForQuery(SQLQuery query, AccessCodeSearchParam param) {

		query.setString("tenantId", param.getTenantId());

		if (param.getAccessCodeId() != null && !param.getAccessCodeId().trim().isEmpty()) {
			String accessCodeId = param.getAccessCodeId();
			if (param.isAccessCodeWildCard())
				accessCodeId = accessCodeId.concat("%");
			query.setString("accessCodeId", accessCodeId);
			log.info("accessCodeId=" + accessCodeId);
		}
		if (param.getAccessCodeName() != null && !param.getAccessCodeName().trim().isEmpty()) {
			String accessCodeName = param.getAccessCodeName();
			if (param.isAccessCodeNameWildCard())
				accessCodeName = accessCodeName.concat("%");
			query.setString("accessCodeName", accessCodeName);
			log.info("accessCodeName=" + accessCodeName);
		}
		if (param.getResourcePath() != null && !param.getResourcePath().trim().isEmpty()) {
			String resourcePath = param.getResourcePath();
			if (param.isResourcePathWildCard())
				resourcePath = resourcePath.concat("%");
			query.setString("resourcePath", resourcePath);
			log.info("resourcePath=" + resourcePath);
		}
		if (param.getResourceName() != null && !param.getResourceName().trim().isEmpty()) {
			String resourceName = param.getResourceName();
			if (param.isResourceNameWildCard())
				resourceName = resourceName.concat("%");
			query.setString("resourceName", resourceName);
			log.info("resourceName=" + resourceName);
		}

	}

	public String count(AccessCodeSearchParam param) throws Exception {

		Session session = null;
		Transaction transaction = null;

		try {
			log.info("count access code begin:");

			session = getSession(param.getTenantId());
			transaction = session.beginTransaction();

			// ////////////////////////////////////////////////////////////
			StringBuffer sql = makeCountQuery(param);
			log.info("sql sentence is: " + sql);
			SQLQuery query = session.createSQLQuery(sql.toString());

			// ////////////////////////////////////////////////////////////
			// パラメータ設定
			makeParameterForQuery(query, param);

			// ////////////////////////////////////////////////////////////
			// 戻り値型設定
			query.addScalar("count", new org.hibernate.type.LongType());

			// ////////////////////////////////////////////////////////////
			// SQL実行
			long count = (long) query.uniqueResult();

			// ////////////////////////////////////////////////////////////
			// 戻り値取得
			log.info("count result = " + count);

			transaction.commit();
			transaction = null;

			return String.valueOf(count);

		} catch (HibernateException e) {
			// DBエラー
			String errorCode = "RESTCM-F00005";
			int errorLevel = RestConst.LEVEL_FATAL;
			throw convertE2R(errorLevel, errorCode, e);
		} catch (Exception e) {
			String errorCode = "RESTCM-F00006";
			int errorLevel = RestConst.LEVEL_FATAL;
			throw convertE2R(errorLevel, errorCode, e);
		} finally {
			closeQuietly(session, transaction);
			log.info("count access code end:");
		}
	}

	private StringBuffer makeSelectQuery(AccessCodeSearchParam param) {
		StringBuffer sql = new StringBuffer();

		sql.append(" SELECT ");
		sql.append(" ac.access_code AS accessCode, ");
		sql.append(" ac.access_code_name AS accessCodeName, ");
		sql.append(" ac.comment AS comment, ");
		sql.append(" acp.read_permission AS readPermission, ");
		sql.append(" acp.update_permission AS updatePermission, ");
		sql.append(" rs.resource_path AS resourcePath, ");
		sql.append(" rs.resource_name AS resourceName");

		makeSelectCondQuery(param, sql);

		sql.append(" ORDER BY ac.access_code, rs.resource_path ");

		return sql;
	}

	private StringBuffer makeCountQuery(AccessCodeSearchParam param) {
		StringBuffer sql = new StringBuffer();

		sql.append(" SELECT ");
		sql.append(" COUNT(DISTINCT ac.access_code) AS count ");

		makeCountCondQuery(param, sql);

		return sql;
	}

	private void makeSelectCondQuery(AccessCodeSearchParam param, StringBuffer sql) {

		sql.append(" FROM (");
		sql.append(
				" (iot.tb_access_code AS ac LEFT OUTER JOIN iot.tb_access_code_permission AS acp ON acp.tenant_id = ac.tenant_id AND acp.access_code = ac.access_code) ");
		sql.append(" INNER JOIN iot.tb_resource AS rs ON acp.resource_id = rs.resource_id) ");
		sql.append(" WHERE 1=1 ");
		sql.append(" AND ac.tenant_id = :tenantId ");

		sql.append(" AND ac.access_code IN (SELECT  DISTINCT ac.access_code AS accessCode ");
		sql.append(
				" FROM((iot.tb_access_code AS ac LEFT OUTER JOIN iot.tb_access_code_permission AS acp ON acp.tenant_id = ac.tenant_id AND acp.access_code = ac.access_code) INNER JOIN iot.tb_resource AS rs ON acp.resource_id = rs.resource_id) ");
		sql.append(" WHERE 1=1 ");
		sql.append(" AND ac.tenant_id = :tenantId ");

		makeFilterCondQuery(param, sql);

		sql.append(" ORDER BY ac.access_code ");
		sql.append(" LIMIT :limit ");
		sql.append(" OFFSET :offset ) ");
	}

	private void makeCountCondQuery(AccessCodeSearchParam param, StringBuffer sql) {

		sql.append(" FROM (");
		sql.append(
				" (iot.tb_access_code AS ac LEFT OUTER JOIN iot.tb_access_code_permission AS acp ON acp.tenant_id = ac.tenant_id AND acp.access_code = ac.access_code) ");
		sql.append(" INNER JOIN iot.tb_resource AS rs ON acp.resource_id = rs.resource_id) ");
		sql.append(" WHERE 1=1 ");
		sql.append(" AND ac.tenant_id = :tenantId ");
		
		makeFilterCondQuery(param, sql);
	}
	
	private void makeFilterCondQuery(AccessCodeSearchParam param, StringBuffer sql) {
		if (param.getAccessCodeId() != null && !param.getAccessCodeId().trim().isEmpty()) {
			sql.append(" AND ac.access_code LIKE :accessCodeId ");
		}

		if (param.getAccessCodeName() != null && !param.getAccessCodeName().trim().isEmpty()) {
			sql.append(" AND ac.access_code_name LIKE :accessCodeName ");
		}

		if (param.getResourcePath() != null && !param.getResourcePath().trim().isEmpty()) {
			sql.append(" AND rs.resource_path LIKE :resourcePath ");
		}

		if (param.getResourceName() != null && !param.getResourceName().trim().isEmpty()) {
			sql.append(" AND rs.resource_name LIKE :resourceName ");
		}
		
		return;
	}

	public void insert(AccessCodeBean aBean, List<AccessCodePermissionBean> acpBeanList) throws Exception {

		Session session = null;
		Transaction transaction = null;

		try {
			log.info("insert begin:");

			session = getSession(aBean.getTenantId());
			transaction = session.beginTransaction();

			log.info("insert tb_access_code begin:");

			TbAccessCode tbAccessCode = (TbAccessCode) session.get(TbAccessCode.class,
					new TbAccessCodeId(aBean.getTenantId(), aBean.getAccessCodeID()));
			if (tbAccessCode != null) {
				throw new Exception("The accesscode whose id is [" + aBean.getAccessCodeID()
						+ "] already exist in the tenant [" + aBean.getTenantId() + "].");
			}

			tbAccessCode = new TbAccessCode();
			tbAccessCode.setId(new TbAccessCodeId(aBean.getTenantId(), aBean.getAccessCodeID()));
			tbAccessCode.setAccessCodeName(aBean.getAccessCodeName());
			tbAccessCode.setAddedDate(new Date());
			tbAccessCode.setModifiedDate(new Date());
			tbAccessCode.setComment(aBean.getComment());

			log.info("tenant id:" + aBean.getTenantId());
			log.info("accesscode id:" + aBean.getAccessCodeID());
			log.info("accesscode name:" + aBean.getAccessCodeName());
			log.info("comment:" + aBean.getComment());
			session.save(tbAccessCode);

			log.info("insert tb_access_code end:");

			log.info("insert tb_access_code_permissions begin:");
			for (AccessCodePermissionBean acpBean : acpBeanList) {
				log.info("insert tb_access_code_permission begin:");
				TbAccessCodePermission tbAccessCodePermission = new TbAccessCodePermission();
				tbAccessCodePermission.setAddedDate(new Date());
				tbAccessCodePermission.setModifiedDate(new Date());
				tbAccessCodePermission.setReadPermission(acpBean.isReadPermission());
				tbAccessCodePermission.setUpdatePermission(acpBean.isUpdatePermission());
				tbAccessCodePermission.setTbTenant((TbTenant) session.load(TbTenant.class, acpBean.getTenantId()));
				tbAccessCodePermission
						.setId(new TbAccessCodePermissionId(acpBean.getResourceId(), acpBean.getAccessCodeID()));
				//tbAccessCodePermission.setTbAccessCode(tbAccessCode);
				//tbAccessCode.getTbAccessCodePermissions().add(tbAccessCodePermission);

				log.info("resource id:" + acpBean.getResourceId());
				log.info("accesscode id:" + acpBean.getAccessCodeID());
				log.info("tenant id:" + acpBean.getTenantId());
				log.info("read permission:" + acpBean.isReadPermission());
				log.info("update permission:" + acpBean.isUpdatePermission());

				log.info("insert tb_access_code_permission end:");
				session.save(tbAccessCodePermission);
			}
			log.info("insert tb_access_code_permissions end:");

			transaction.commit();
			transaction = null;
		} catch (HibernateException e) {
			// DBエラー
			String errorCode = "RESTCM-F00007";
			int errorLevel = RestConst.LEVEL_FATAL;
			throw convertE2R(errorLevel, errorCode, e);
		} catch (Exception e) {
			String errorCode = "RESTCM-F00008";
			int errorLevel = RestConst.LEVEL_FATAL;
			throw convertE2R(errorLevel, errorCode, e);
		} finally {
			closeQuietly(session, transaction);
			log.info("insert end:");
		}
	}

	public void update(AccessCodeBean aBean, List<AccessCodePermissionBean> acpBeanList) throws Exception {

		Session session = null;
		Transaction transaction = null;

		try {
			log.info("update begin:");

			log.info("update tb_access_code begin:");
			session = getSession(aBean.getTenantId());
			transaction = session.beginTransaction();

			TbAccessCode tbAccessCode = (TbAccessCode) session.get(TbAccessCode.class,
					new TbAccessCodeId(aBean.getTenantId(), aBean.getAccessCodeID()));
			if (tbAccessCode == null) {
				throw new Exception("The accesscode whose id is [" + aBean.getAccessCodeID()
						+ "] doesn't exist in the tenant [" + aBean.getTenantId() + "].");
			}
			tbAccessCode.setAccessCodeName(aBean.getAccessCodeName());
			tbAccessCode.setComment(aBean.getComment());
			tbAccessCode.setModifiedDate(new Date());

			log.info("tenant id:" + aBean.getTenantId());
			log.info("accesscode id:" + aBean.getAccessCodeID());
			log.info("accesscode name:" + aBean.getAccessCodeName());
			log.info("comment:" + aBean.getComment());
			session.saveOrUpdate(tbAccessCode);
			log.info("update tb_access_code end:");

			log.info("delete tb_access_code_permission begin:");
			StringBuffer sql = new StringBuffer();
			sql.append(" DELETE FROM iot.tb_access_code_permission ");
			sql.append(" WHERE tenant_id = :tenantId ");
			sql.append(" AND access_code = :accessCode ");

			log.info("sql sentence is: " + sql);
			SQLQuery query = session.createSQLQuery(sql.toString());

			// パラメータセット
			query.setString("tenantId", aBean.getTenantId());
			query.setString("accessCode", aBean.getAccessCodeID());

			// クエリ実行
			query.executeUpdate();
			log.info("delete tb_access_code_permission end:");

			log.info("insert tb_access_code_permissions begin:");
			for (AccessCodePermissionBean acpBean : acpBeanList) {
				log.info("insert tb_access_code_permission begin:");

				TbAccessCodePermission tbAccessCodePermission = new TbAccessCodePermission();
				tbAccessCodePermission.setAddedDate(new Date());
				tbAccessCodePermission.setModifiedDate(new Date());
				tbAccessCodePermission.setReadPermission(acpBean.isReadPermission());
				tbAccessCodePermission.setUpdatePermission(acpBean.isUpdatePermission());
				tbAccessCodePermission.setTbTenant((TbTenant) session.load(TbTenant.class, acpBean.getTenantId()));
				tbAccessCodePermission
						.setId(new TbAccessCodePermissionId(acpBean.getResourceId(), acpBean.getAccessCodeID()));

				log.info("resource id:" + acpBean.getResourceId());
				log.info("accesscode id:" + acpBean.getAccessCodeID());
				log.info("tenant id:" + acpBean.getTenantId());
				log.info("read permission:" + acpBean.isReadPermission());
				log.info("update permission:" + acpBean.isUpdatePermission());

				session.save(tbAccessCodePermission);
				log.info("insert tb_access_code_permission end:");
			}
			log.info("insert tb_access_code_permissions end:");

			session.flush();
			transaction.commit();
			transaction = null;
		} catch (HibernateException e) {
			// DBエラー
			String errorCode = "RESTCM-F00009";
			int errorLevel = RestConst.LEVEL_FATAL;
			throw convertE2R(errorLevel, errorCode, e);
		} catch (Exception e) {
			String errorCode = "RESTCM-F00010";
			int errorLevel = RestConst.LEVEL_FATAL;
			throw convertE2R(errorLevel, errorCode, e);
		} finally {
			closeQuietly(session, transaction);
			log.info("update end:");
		}
	}

	public void delete(AccessCodeBean acBean) throws Exception {

		Session session = null;
		Transaction transaction = null;

		try {
			log.info("delete begin:");

			session = getSession(acBean.getTenantId());
			transaction = session.beginTransaction();

			log.info("delete tb_access_code_permission begin:");
			StringBuffer sql = new StringBuffer();
			sql.append(" DELETE FROM iot.tb_access_code_permission ");
			sql.append(" WHERE tenant_id = :tenantId ");
			sql.append(" AND access_code = :accessCode ");

			log.info("sql sentence is: " + sql);
			SQLQuery query = session.createSQLQuery(sql.toString());

			// パラメータセット
			query.setString("tenantId", acBean.getTenantId());
			query.setString("accessCode", acBean.getAccessCodeID());

			// クエリ実行
			query.executeUpdate();
			log.info("delete tb_access_code_permission end:");

			log.info("delete tb_access_code begin:");
			sql = new StringBuffer();
			sql.append(" DELETE FROM iot.tb_access_code ");
			sql.append(" WHERE tenant_id = :tenantId ");
			sql.append(" AND access_code = :accessCode ");

			log.info("sql sentence is: " + sql);
			query = session.createSQLQuery(sql.toString());

			// パラメータセット
			query.setString("tenantId", acBean.getTenantId());
			query.setString("accessCode", acBean.getAccessCodeID());

			// クエリ実行
			query.executeUpdate();
			log.info("delete tb_access_code end:");

			session.flush();
			transaction.commit();
			transaction = null;
		} catch (HibernateException e) {
			// DBエラー
			String errorCode = "RESTCM-F00011";
			int errorLevel = RestConst.LEVEL_FATAL;
			throw convertE2R(errorLevel, errorCode, e);
		} catch (Exception e) {
			String errorCode = "RESTCM-F00012";
			int errorLevel = RestConst.LEVEL_FATAL;
			throw convertE2R(errorLevel, errorCode, e);
		} finally {
			closeQuietly(session, transaction);
		}
	}

}
