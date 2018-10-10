package connection.szablon;

import java.sql.*;

public abstract class Query {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/tutorial";
    private static final String USER = "lukasz";
    private static final String PASSWORD = "password";
    private Connection connection;
    private PreparedStatement statement;
    protected ResultSet resultSet;
    private String empno;
    private String job;


    public Query(String empno, String job) {
        this.empno = empno;
        this.job = job;

    }

    public void execute() throws SQLException {
        connectToDatabase();
        executeSql();
        process();
        close();
    }

    private void connectToDatabase() throws SQLException {
        connection = DriverManager
                .getConnection(JDBC_URL, USER, PASSWORD);
    }

    private void executeSql() throws SQLException {
        statement = statement = connection.prepareStatement(
                "SELECT * FROM emp WHERE empno=? AND job=?");
        statement.setString(1, empno);
        statement.setString(2, job);
        resultSet = statement.executeQuery();
    }

    //bo będzie nadpisywana
    abstract protected void process() throws SQLException;

    private void close() throws SQLException {
        resultSet.close();
//        statement.execute("SHUTDOWN");
        statement.close();
        connection.close();
    }


}
