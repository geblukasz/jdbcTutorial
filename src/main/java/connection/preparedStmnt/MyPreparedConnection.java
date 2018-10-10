package connection.preparedStmnt;

import java.sql.*;

//używamy jeśli często pojawia się jakiś parametr
public class MyPreparedConnection {

    public static void main(String[] args) throws SQLException {


        Connection conn = DriverManager
                .getConnection(
                        "jdbc:mysql://localhost:3306/tutorial",
                        "lukasz", "password"
                );

        PreparedStatement statement = conn.prepareStatement(
                "SELECT * FROM emp WHERE empno=? AND job=?");

        statement.setString(1,"7934");
        statement.setString(2,"clerk");
        ResultSet result = statement.executeQuery();

        String salary = "";
        while (result.next()){
            salary = result.getString("sal");
        }

        //Zawsze resultset powinnismy zamknąć - tak samo jak obiekt typu Statement i Connection
        result.close();
        System.out.println("Salary = " + salary);




    }
}
