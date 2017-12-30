package org.thoth.jdbc.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;

public class PostgreSQLRemoteJdbcIT {

    @Test
    public void connect() throws Exception {
        Class.forName("org.postgresql.Driver");

        String connectionUrl
            = "jdbc:postgresql://localhost/5432/widget";

        String user = "widgetapp";
        String pass = "widgetapp";

        Connection conn
            = DriverManager.getConnection(connectionUrl, user, pass);
    }

}
