/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2012 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package com.yaotao.rest.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.glassfish.jersey.process.internal.RequestScoped;

import com.yaotao.rest.bean.AccessCodeBean;
import com.yaotao.rest.bean.AccessCodeInputRootJsonBean;
import com.yaotao.rest.bean.AccessCodeJsonBean;
import com.yaotao.rest.bean.AccessCodePermissionBean;
import com.yaotao.rest.commons.AccessCodeRequestType;
import com.yaotao.rest.commons.RestConst;
import com.yaotao.rest.exception.RestException;
import com.yaotao.rest.logic.AccessCodeLogic;
import com.yaotao.rest.resource.business.AccessCodeCommon;

/**
 * @author Yao Tao
 */
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class AccessCodeSubResource {

	protected Logger log = Logger.getLogger(this.getClass());

	@GET
	public Response getAccessCodesWithAccessCodeParamater(@PathParam("tenantId") String tenantId,
			@PathParam("accessCodeId") String accessCodeId, @QueryParam("$filter") String filter,
			@DefaultValue(RestConst.QUERY_RESULT_MAX_COUNT) @QueryParam("$top") Integer top,
			@DefaultValue(RestConst.QUERY_RESULT_SKIP) @QueryParam("$skip") Integer skip) {

		try {
			Response res = AccessCodeCommon.getAccessCode(AccessCodeRequestType.REQUEST_ACCESSCODES_SEARCH_WITH_ACCESSCODE, tenantId, filter,
					accessCodeId, top, skip);
			return res;
		} catch (RestException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		} catch (Exception e) {
			e.printStackTrace();
			this.log.fatal(e.getMessage(), e);
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		} finally {
			// 終了ログ出力
			log.info("get end");
		}
	}

	@GET
	@Path("_count")
	public Response countAccessCodesWithAccessCodeParamater(@PathParam("tenantId") String tenantId,
			@PathParam("accessCodeId") String accessCodeId, @QueryParam("$filter") String filter) {

		try {
			Response res = AccessCodeCommon.getAccessCode(AccessCodeRequestType.REQUEST_ACCESSCODES_COUNT_WITH_ACCESSCODE, tenantId, filter,
					accessCodeId, null, null);
			return res;
		} catch (RestException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		} catch (Exception e) {
			e.printStackTrace();
			this.log.fatal(e.getMessage(), e);
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		} finally {
			// 終了ログ出力
			log.info("get end");
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postAccessCode(@PathParam("tenantId") String tenantId,
			@PathParam("accessCodeId") String accessCodeId, AccessCodeInputRootJsonBean acInputJsonBean) {

		try {
			log.info("post begin");

			AccessCodeJsonBean accessCodeBean = acInputJsonBean.getAccessCode();
			accessCodeBean.setAccessCodeId(accessCodeId);

			AccessCodeBean acBean = new AccessCodeBean();
			acBean.setTenantId(tenantId);
			log.info("json infomation begin:");
			log.info("tenantId=" + tenantId);
			acBean.setAccessCodeID(accessCodeBean.getAccessCodeId());
			log.info("accessCodeID=" + accessCodeBean.getAccessCodeId());
			acBean.setAccessCodeName(accessCodeBean.getName());
			log.info("accessCodeName=" + accessCodeBean.getName());
			acBean.setComment(accessCodeBean.getDescription());
			log.info("comment=" + accessCodeBean.getDescription());

			List<AccessCodePermissionBean> acpBeanList = AccessCodeCommon.makeAcpBeanList(accessCodeBean, tenantId, accessCodeId);
			log.info("json infomation end:");

			AccessCodeLogic acLogic = new AccessCodeLogic();
			acLogic.add(acBean, acpBeanList);
		} catch (RestException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		} catch (Exception e) {
			e.printStackTrace();
			this.log.fatal(e.getMessage(), e);
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		} finally {
			// 終了ログ出力
			log.info("post end");
		}

		return Response.ok("POST OK", MediaType.TEXT_PLAIN).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response putAccessCode(@PathParam("tenantId") String tenantId,
			@PathParam("accessCodeId") String accessCodeId, AccessCodeInputRootJsonBean acirJsonBean) {

		try {
			log.info("put begin");

			AccessCodeJsonBean accessCodeBean = acirJsonBean.getAccessCode();
			accessCodeBean.setAccessCodeId(accessCodeId);

			AccessCodeBean acBean = new AccessCodeBean();

			log.info("json infomation begin:");
			acBean.setTenantId(tenantId);
			log.info("tenantId=" + tenantId);
			acBean.setAccessCodeID(accessCodeBean.getAccessCodeId());
			log.info("accessCodeID=" + accessCodeBean.getAccessCodeId());
			acBean.setAccessCodeName(accessCodeBean.getName());
			log.info("accessCodeName=" + accessCodeBean.getName());
			acBean.setComment(accessCodeBean.getDescription());
			log.info("comment=" + accessCodeBean.getDescription());

			List<AccessCodePermissionBean> acpBeanList = AccessCodeCommon.makeAcpBeanList(accessCodeBean, tenantId, accessCodeId);
			log.info("json infomation end:");

			AccessCodeLogic acLogic = new AccessCodeLogic();
			acLogic.update(acBean, acpBeanList);

		} catch (RestException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		} catch (Exception e) {
			e.printStackTrace();
			this.log.fatal(e.getMessage(), e);
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		} finally {
			// 終了ログ出力
			log.info("put end");
		}

		return Response.ok("PUT OK", MediaType.TEXT_PLAIN).build();
	}

	@DELETE
	public Response deleteAccessCode(@PathParam("tenantId") String tenantId,
			@PathParam("accessCodeId") String accessCodeId) {

		try {
			log.info("delete begin");

			AccessCodeBean acBean = new AccessCodeBean();
			acBean.setTenantId(tenantId);
			log.info("json infomation begin:");
			log.info("tenantId=" + tenantId);
			acBean.setAccessCodeID(accessCodeId);
			log.info("accessCodeID=" + accessCodeId);
			AccessCodeLogic acLogic = new AccessCodeLogic();
			log.info("json infomation end:");
			acLogic.delete(acBean);
		} catch (RestException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		} catch (Exception e) {
			e.printStackTrace();
			this.log.fatal(e.getMessage(), e);
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		} finally {
			// 終了ログ出力
			log.info("delete end");
		}

		return Response.ok("DELETE OK", MediaType.TEXT_PLAIN).build();
	}

}
