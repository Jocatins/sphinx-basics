package com.company;

import java.sql.*;

public class Database2 {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/student";
        String uname = "root";
        String password = "$phinx@007";
        int rollno = 6;
        int marks = 44;
        String username = "Elizabeth";
        String query = "insert into student values (?,?,?)";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect = DriverManager.getConnection(url, uname, password);
        // using prepared statement
        PreparedStatement state = connect.prepareStatement(query);
        state.setInt(1, rollno);
        state.setInt(2, marks);
        state.setString(3, username);

        int count = state.executeUpdate();

        System.out.println(count + " row/s affected");

        state.close();
        connect.close();

    }

}

