/**
 * FUJITSU CONFIDENTIAL
 * Copyright 2010 FUJITSU LIMITED All rights reserved.
 */
package com.yaotao.rest.servlet;

import javax.servlet.ServletException;

import org.glassfish.jersey.servlet.ServletContainer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * DB初期化
 *
 * @author FUJITSU BROAD SOLUTION & CONSULTING Inc.
 * @version 1.0
 */
public class DBInitialServlet extends ServletContainer {

	/**	 */
	private static final long serialVersionUID = 1L;

	protected static Configuration config = new Configuration().configure();
	
	protected static SessionFactory sessionFactory = config.buildSessionFactory();
	
	public void init() throws ServletException {
	}

	/**
	 */
	public void destroy() {
	}

}
