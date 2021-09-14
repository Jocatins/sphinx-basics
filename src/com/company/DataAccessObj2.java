package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataAccessObj2 {

    public static void main(String[] args) {
        SphinxDAO dao = new SphinxDAO();
        Sphinx g1 = dao.getGypsy(30);
        System.out.println(g1.sname);

    }

}
class SphinxDAO{
    public Sphinx getGypsy(int rollno) {

        try {
            String query = "select sname from gypsy where rollno = " + rollno;
            Sphinx g = new Sphinx();
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
        Sphinx g = null;
        return g;

    }
}
class Sphinx {
    int rollno;
    String sname;
}
