package com.yaotao.rest.resource.business;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.yaotao.rest.bean.AccessCodeJsonBean;
import com.yaotao.rest.bean.AccessCodeOutputRootJsonBean;
import com.yaotao.rest.bean.AccessCodePermissionBean;
import com.yaotao.rest.bean.ResourceOperationsJsonBean;
import com.yaotao.rest.commons.AccessCodeRequestType;
import com.yaotao.rest.commons.RestConst;
import com.yaotao.rest.logic.AccessCodeLogic;
import com.yaotao.rest.logic.ResourceLogic;
import com.yaotao.rest.param.AccessCodeSearchParam;

public class AccessCodeCommon {

	protected static Logger log = Logger.getLogger("com.yaotao.rest.resource");

	public static Response getAccessCode(AccessCodeRequestType type, String tenantId, String filter, String accessCodeId, Integer top,
			Integer skip) throws Exception {
		log.info("get begin:");

		log.info("parameter infomation begin:");
		log.info("get type = " + type);
		log.info("tenantId=" + tenantId);
		log.info("filter=" + filter);

		AccessCodeSearchParam param = new AccessCodeSearchParam();
		param.setTenantId(tenantId);
		if (type.getCodeExist() == RestConst.REQUEST_WITH_ACCESSCODE) {
			param.setAccessCodeId(accessCodeId);
			log.info("accessCodeId=" + accessCodeId);
		}
		param.setFilter(filter);
		if (type.getRequestType() == RestConst.REQUEST_ACCESSCODES_SEARCH) {
			param.setRequestCount(top);
			param.setStartNumber(skip);
			log.info("top=" + top);
			log.info("skip=" + skip);
		}

		log.info("parameter infomation end:");

		AccessCodeLogic logic = new AccessCodeLogic();
		if (type.getRequestType() == RestConst.REQUEST_ACCESSCODES_SEARCH) {
			AccessCodeOutputRootJsonBean acorJsonBean = logic.search(param);
			return Response.ok(acorJsonBean, MediaType.APPLICATION_JSON).build();
		} else if (type.getRequestType() == RestConst.REQUEST_ACCESSCODES_COUNT) {
			String count = logic.count(param);
			return Response.ok(count, MediaType.APPLICATION_JSON).build();
		}

		return null;
	}

	public static List<AccessCodePermissionBean> makeAcpBeanList(AccessCodeJsonBean accessCodeBean, String tenantId,
			String accessCodeId) throws Exception {
		List<AccessCodePermissionBean> acpBeanList = new ArrayList<AccessCodePermissionBean>();

		AccessCodePermissionBean acpBean = null;
		List<ResourceOperationsJsonBean> roJsonBeanList = accessCodeBean.getPermissions().getResourceOperations();
		for (ResourceOperationsJsonBean roJsonBean : roJsonBeanList) {

			acpBean = new AccessCodePermissionBean();
			acpBean.setTenantId(tenantId);
			acpBean.setAccessCodeID(accessCodeId);

			ResourceLogic rsLogic = new ResourceLogic();
			String rsId = rsLogic.getResourceIdByPath(tenantId, roJsonBean.getResourcePath());
			log.info("resourcePath=" + roJsonBean.getResourcePath());
			log.info("resourceId=" + rsId);

			acpBean.setResourceId(rsId);

			List<String> opeList = roJsonBean.getOperations();
			for (String ope : opeList) {
				if (ope.compareToIgnoreCase(RestConst.RESOURCE_PERMISSION_UPDATE) == 0) {
					acpBean.setUpdatePermission(true);
				} else if (ope.compareToIgnoreCase(RestConst.RESOURCE_PERMISSION_READ) == 0) {
					acpBean.setReadPermission(true);
				}
				log.info("ope=" + ope);
			}

			acpBeanList.add(acpBean);
		}

		return acpBeanList;
	}

}
