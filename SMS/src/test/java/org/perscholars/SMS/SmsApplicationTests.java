package org.perscholars.SMS;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jpa.service.StudentService;


class SmsApplicationTests {

	@BeforeAll
	public static void setUp() throws SQLException{
		
//		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_sba", "root", "2002");
//		studentservice = new StudentService();
	}

}
