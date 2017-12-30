package org.thoth.jdbc.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Test;

public class PostgreSQLRemoteJdbcIT {

    @Test
    public void connect() throws Exception {
        Class.forName("org.postgresql.Driver");

        String connectionUrl
            = "jdbc:postgresql://localhost:5432/widget";

        String user = "widgetapp";
        String pass = "widgetapp";

        Connection conn
            = DriverManager.getConnection(connectionUrl, user, pass);

        Statement stmt
            = conn.createStatement();

        ResultSet rs
            = stmt.executeQuery("select id from widget");
        rs.next();

        System.out.printf("%s%n", rs.getString(1));
    }

}
