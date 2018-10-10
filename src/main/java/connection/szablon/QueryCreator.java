package connection.szablon;

import java.sql.SQLException;

public class QueryCreator extends Query{


    public QueryCreator(String empno, String job) {
        super(empno, job);
    }

    protected void process() throws SQLException {

        String salary = "";
        while (resultSet.next()){
            salary = resultSet.getString("sal");
        }
        System.out.println("Salary = " + salary);
    }

    public static void main(String[] args) throws SQLException {
        QueryCreator queryCreator = new QueryCreator("7934","clerk");
        queryCreator.execute();
    }
}
