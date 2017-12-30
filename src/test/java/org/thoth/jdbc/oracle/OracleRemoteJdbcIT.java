package org.thoth.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Test;

public class OracleRemoteJdbcIT {

    @Test
    public void connect() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        String SID
            = "xe";

        String connectionUrl
            = "jdbc:oracle:thin:@localhost:1521:" + SID;

        String user = "hr";
        String pass = "hr";

        Connection conn
            = DriverManager.getConnection(connectionUrl, user, pass);

        Statement stmt
            = conn.createStatement();

        ResultSet rs
            = stmt.executeQuery("select employee_id from employees");

        while (rs.next()) {
            System.out.printf("EMPLOYEE_ID: %d%n", rs.getInt(1));
        }
    }

}
