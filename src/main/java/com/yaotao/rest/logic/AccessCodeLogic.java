/**
 * FUJITSU CONFIDENTIAL
 * Copyright 2010-2013 FUJITSU LIMITED All rights reserved.
 */
package com.yaotao.rest.logic;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yaotao.rest.bean.AccessCodeBean;
import com.yaotao.rest.bean.AccessCodeOutputRootJsonBean;
import com.yaotao.rest.bean.AccessCodePermissionBean;
import com.yaotao.rest.dao.AccessCodeDao;
import com.yaotao.rest.dao.TenantDao;
import com.yaotao.rest.param.AccessCodeSearchParam;

/**
 *
 *
 * @author FUJITSU BROAD SOLUTION & CONSULTING Inc.
 * @version 1.0
 */
public class AccessCodeLogic extends BaseLogic {
	/**
	 *
	 * @param param
	 *            検索条件パラメータ
	 * @return アクセスコード情報の検索結果
	 * @throws RestException
	 *             例外処理
	 */
	public AccessCodeOutputRootJsonBean search(AccessCodeSearchParam param) throws Exception {
		TenantDao tenantDao = new TenantDao();
		String tenantId = param.getTenantId();
		if(tenantDao.get(tenantId) == false){
			throw new Exception("The tenant whose id is [" + tenantId + "] is not exist.");			
		}
		
		AccessCodeDao dao = new AccessCodeDao();
		makeParamForDao(param);
		return dao.search(param);
	}

	private void makeParamForDao(AccessCodeSearchParam param) throws Exception {
		// handle the param accesscodeid
		String accessCode = param.getAccessCodeId();
		if (accessCode != null) {
			accessCode = accessCode.trim();
			if (accessCode.lastIndexOf('*') == accessCode.length() - 1) {
				accessCode = accessCode.substring(0, accessCode.length() - 1);
				param.setAccessCodeId(accessCode);
				param.setAccessCodeWildCard(true);
			}
			log.info("isAccessCodeWildCard=" + param.isAccessCodeWildCard());
		}

		// handle the param filter
		String filter = param.getFilter();
		if (filter == null) {
			return;
		}

		String[] filterArray = filter.split("and");

		Pattern patternStartWith = Pattern.compile("\\s*startswith\\s*\\((.*),\\s*'(.*)'");
		Pattern patternEq = Pattern.compile("\\s*(.*)\\s*eq\\s*'(.*)'");

		for (String filterStr : filterArray) {

			Matcher m = patternStartWith.matcher(filterStr);
			Matcher n = patternEq.matcher(filterStr);

			String name = "";
			String value = "";

			boolean bWildCard = false;
			if (m.find()) {
				name = m.group(1).trim();
				value = m.group(2).trim();
				bWildCard = true;
			} else if (n.find()) {
				name = n.group(1).trim();
				value = n.group(2).trim();
			} else {
				log.info("invalid filter parameter: " + filterStr);
				continue;
			}

			log.info("bWildCard=" + bWildCard);
			if (name.compareToIgnoreCase("_name") == 0) {
				param.setAccessCodeName(value);
				if (bWildCard)
					param.setAccessCodeNameWildCard(true);
				log.info("accessCodeName=" + value);
			} else if (name.compareToIgnoreCase("_resource_path") == 0) {
				param.setResourcePath(value);
				if (bWildCard)
					param.setResourcePathWildCard(true);
				log.info("resourcePath=" + value);
			} else if (name.compareToIgnoreCase("_resource_name") == 0) {
				param.setResourceName(value);
				if (bWildCard)
					param.setResourceNameWildCard(true);
				log.info("resourceName=" + value);
			}
		}

		return;
	}

	/**
	 * 条件に一致する件数を取得する。
	 *
	 * @param param
	 *            検索条件パラメータ
	 * @return 件数
	 * @throws Exception
	 *             例外処理
	 */
	public String count(AccessCodeSearchParam param) throws Exception {
		TenantDao tenantDao = new TenantDao();
		String tenantId = param.getTenantId();
		if(tenantDao.get(tenantId) == false){
			throw new Exception("The tenant whose id is [" + tenantId + "] is not exist.");			
		}
		
		AccessCodeDao dao = new AccessCodeDao();
		makeParamForDao(param);
		return dao.count(param);
	}

	public void add(AccessCodeBean acBean, List<AccessCodePermissionBean> acpBeanList) throws Exception {
		TenantDao tenantDao = new TenantDao();
		String tenantId = acBean.getTenantId();
		if(tenantDao.get(tenantId) == false){
			throw new Exception("The tenant whose id is [" + tenantId + "] is not exist.");			
		}
		
		// DBアクセス 登録済みのチェックはDB側で行う。
		AccessCodeDao dao = new AccessCodeDao();
		dao.insert(acBean, acpBeanList);
	}

	public void delete(AccessCodeBean acBean) throws Exception {
		TenantDao tenantDao = new TenantDao();
		String tenantId = acBean.getTenantId();
		if(tenantDao.get(tenantId) == false){
			throw new Exception("The tenant whose id is [" + tenantId + "] is not exist.");			
		}

		// DBアクセス 登録済みのチェックはDB側で行う。
		AccessCodeDao dao = new AccessCodeDao();
		dao.delete(acBean);
	}

	public void update(AccessCodeBean acBean, List<AccessCodePermissionBean> acpBeanList) throws Exception {
		TenantDao tenantDao = new TenantDao();
		String tenantId = acBean.getTenantId();
		if(tenantDao.get(tenantId) == false){
			throw new Exception("The tenant whose id is [" + tenantId + "] is not exist.");			
		}

		// DBアクセス 登録済みのチェックはDB側で行う。
		AccessCodeDao dao = new AccessCodeDao();
		dao.update(acBean, acpBeanList);
	}

}
