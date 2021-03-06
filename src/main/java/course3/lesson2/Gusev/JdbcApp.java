package course3.lesson2.Gusev;

import java.sql.*;
import java.util.Random;

public class JdbcApp {

    private static Connection connection;
    private static Statement statement;
    private static Random random = new Random();

    public static void main(String[] args) {
        try {
            connect();
            createTable();
            long start = System.currentTimeMillis();
            insertStudents();
            System.out.println("insert smt " + (System.currentTimeMillis() - start) + " ms");
            start = System.currentTimeMillis();
            insertStudentsBatch();
            System.out.println("insert batch " + (System.currentTimeMillis() - start) + " ms");
            insertOneStudent("Charlie", "34a");
//            readData();
            selectByName("Bob1");
            dropTable();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:javadb.db");
//        connection.setAutoCommit(false);
// для транзакции если все в запросе выполнилось пишем connection.commit а в finally connection.rollback
        statement = connection.createStatement();
    }

    private static void disconnect(){
        try {
            if (statement != null){
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void selectByName(String name) throws SQLException {
        final String query = String.format("SELECT * FROM students WHERE name ='%s'", name);
        final ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            int id = rs.getInt("id");
            String nameDB = rs.getString("name");
            int score = rs.getInt("score");
            System.out.printf("%d - %s - %d\n", id, nameDB, score);
        }
    }

    private static void createTable() throws SQLException {
        statement.executeUpdate("create table if not exists students (\n" +
                "    id integer primary key autoincrement not null ,\n" +
                "    name text not null ,\n" +
                "    group_name text,\n" +
                "    score integer\n" +
                ");");
    }

    private static void insertStudents () throws SQLException {
        for (int i = 0; i < 10; i++) {
            statement.executeUpdate(
                    "insert into students (name, group_name, score)" +
                            " values ('Bob" + i + "', '22', 3);");
        }
    }

    private static void insertStudentsBatch(){
        try(PreparedStatement ps = connection.prepareStatement(
                "insert into students (name, group_name, score)" +
                " values (?, ?, ?);")){
            for (int i = 0; i < 10; i++) {
                ps.setString(1, "Jack " + i);
                ps.setString(2, "group " + (10 - i));
                ps.setInt(3, random.nextInt(6));
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

// name = ' drop database; '
    private static void insertOneStudent(String name, String group) {
        try(
        PreparedStatement ps = connection.prepareStatement("insert into students (name, group_name, score)" +
                " values (?, ?, 3);")) {
        ps.setString(1, name);
        ps.setString(2, group);
        ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        statement.executeUpdate(
//                "insert into students (name, group_name, score)" +
//                        " values ('" + name + "', '22', 3);");
    }

    private static void readData() {
        try(ResultSet rs = statement.executeQuery("select * from students")){ // 1 - based
            while (rs.next()){
                System.out.println(rs.getInt(1) +
                        " " + rs.getString("name") +
                        " " + rs.getString(3) + " " + rs.getInt("score"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void dropTable() throws SQLException {
        statement.executeUpdate("drop table students");
    }
}
