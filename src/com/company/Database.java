package com.company;


import java.sql.*;

public class Database {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "$phinx@007";
        String query = "select * from student";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect = DriverManager.getConnection(url, username, password);
        Statement state = connect.createStatement();

        ResultSet rSet = state.executeQuery(query);

        String dataStored = "";
        while (rSet.next()) {

            dataStored = rSet.getInt(1) + " - " + rSet.getString(3);

            System.out.println(dataStored);
        }

        state.close();
        connect.close();

    }

}
