package connection.statement;

import java.sql.*;

public class MyConnection {

    public static void main(String[] args) throws SQLException {


        Connection conn = DriverManager
                .getConnection(
                        "jdbc:mysql://localhost:3306/tutorial", "lukasz", "password"
                );
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM emp");


        System.out.println(result.toString());

        ResultSetMetaData rsmd = result.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (result.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = result.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }

        statement.close();
        result.close();
        conn.close();
    }
}
