package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataAccessObj {

    public static void main(String[] args) {
        GypsyDAO dao = new GypsyDAO();
        Gypsy g1 = dao.getGypsy(30);
        System.out.println(g1.sname);

    }

}
class GypsyDAO{
    public Gypsy getGypsy(int rollno) {

        try {
            String query = "select sname from gypsy where rollno = " + rollno;
            Gypsy g = new Gypsy();
            g.rollno = rollno;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection
                    ("jdbc:mysql://localhost/sphinx_schema","root","$phinx@007");
            Statement statement = connect.createStatement();
            ResultSet rSet = statement.executeQuery(query);
            rSet.next();
            String name = rSet.getString(1);
            g.sname = name;
            return g;

        } catch (Exception e) {
            System.out.println(e);
        }
        Gypsy g = null;
        return g;

    }
}
class Gypsy {
    int rollno;
    String sname;
}