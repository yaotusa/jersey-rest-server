/**
 * FUJITSU CONFIDENTIAL
 * Copyright 2010 FUJITSU LIMITED All rights reserved.
 */
package com.yaotao.rest.servlet;

import javax.servlet.ServletException;

import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Const初期化
 *
 * @author FUJITSU BROAD SOLUTION & CONSULTING Inc.
 * @version 1.0
 */
public class CommonInitialServlet extends ServletContainer {

	/**	 */
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
		try {
			Class.forName("com.yaotao.rest.commons.RestConst");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 */
	public void destroy() {
	}

}
