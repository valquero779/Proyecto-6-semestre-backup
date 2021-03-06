package com.conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class Conexion {

	private static BasicDataSource dataSource = null;

	private static DataSource getDataSource() {

		if (dataSource == null) {

			dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("root");
			dataSource.setUrl("jdbc:mysql://localhost:3306/proyecto6dba?serverTimezone=UTC");

			dataSource.setInitialSize(500);
			dataSource.setMaxIdle(100);
			dataSource.setMaxTotal(150);
			dataSource.setMaxWaitMillis(30000);
			dataSource.setLogAbandoned(true);
			dataSource.setRemoveAbandonedOnBorrow(true);
			dataSource.setRemoveAbandonedOnMaintenance(true);
			dataSource.setRemoveAbandonedTimeout(1);

		}

		return dataSource;
	}

	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();

	}

}
