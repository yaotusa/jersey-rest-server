/**
 * FUJITSU CONFIDENTIAL
 * Copyright 2010-2013 FUJITSU LIMITED All rights reserved.
 */
package com.yaotao.rest.logic;

import com.yaotao.rest.dao.ResourceDao;

/**
 *
 * @author FUJITSU BROAD SOLUTION & CONSULTING Inc.
 * @version 1.0
 */
public class ResourceLogic extends BaseLogic {


	/**
	 *
	 * @param path
	 *            リソースパス (完全一致)
	 * @return リソースID
	 * @throws Exception 例外処理
	 */

	public String getResourceIdByPath(String tenantId, String path) throws Exception {
		// DBアクセス 登録済みのチェックはDB側で行う。
		ResourceDao dao = new ResourceDao();
		return dao.get(tenantId, path);
	}
}
