package com.pismirer.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ReportsController {
    
    public static Connection conectar() {
		Connection con = null;

		try {
			String url = "jdbc:mysql://localhost:3306/bds_pismirer2?user=root&password=admin123&useSSL=false";
			con = DriverManager.getConnection(url);
			if (con != null) {
				System.out.println("Conexion Satisfactoria");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
    
}
