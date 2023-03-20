import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3307/newdb", "root", "root00");
            statement = conn.createStatement();
            //statement.execute("CREATE TABLE IF NOT EXISTS students (student_id int NOT NULL PRIMARY KEY AUTO_INCREMENT, last_name varchar(30) ,firstname varchar(30))");
            resultSet = statement.executeQuery("SELECT first_name, last_name FROM newdb.students;");
        }catch (SQLException e){
            e.printStackTrace();
        }

        List<String> cognome = new ArrayList<>();

        while(resultSet.next()){
            System.out.println("Nome: " + resultSet.getString("first_name"));
            System.out.println("Cognome: " + resultSet.getString("last_name"));
            cognome.add(resultSet.getString("last_name"));
        }
        resultSet.close();

        System.out.println(cognome);
    }
}
