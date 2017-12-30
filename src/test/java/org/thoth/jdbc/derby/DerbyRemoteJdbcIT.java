package org.thoth.jdbc.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Test;

public class DerbyRemoteJdbcIT {

    @Test
    public void connect() throws Exception {
        Class.forName("org.apache.derby.jdbc.ClientDriver");

        String connectionUrl
            = "jdbc:derby://localhost:1110/widget";

        String user = "sa";
        String pass = "sa";

        Connection conn
            = DriverManager.getConnection(connectionUrl, user, pass);

        Statement stmt
            = conn.createStatement();

        ResultSet rs
            = stmt.executeQuery("select count(*) from sys.systables");
        rs.next();

        System.out.printf("%d%n", rs.getInt(1));
    }

}
