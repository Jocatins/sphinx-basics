package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDoa1 {

    public static void main(String[] args) throws Exception {
        TitanDOA dao = new TitanDOA();

        Titan g2 = new Titan();
        g2.rollno = 32;
        g2.sname = "Titan";
        dao.connect();
        dao.addTitan(g2);

    }

}
class TitanDOA{
    Connection connect = null;
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection
                    ("jdbc:mysql://localhost/sphinx_schema","root","$phinx@007");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public Titan getGypsy(int rollno) {


        try {
            String query = "select sname from gypsy where rollno = " + rollno;
            Titan g = new Titan();
            g.rollno = rollno;

            Statement statement = connect.createStatement();
            ResultSet rSet = statement.executeQuery(query);
            rSet.next();
            String name = rSet.getString(1);
            g.sname = name;
            return g;

        } catch (Exception e) {
            System.out.println(e);
        }
        Titan g = null;
        return g;

    }

    public void addTitan(Titan g2)  {
        String query = "insert into gypsy values (?,?)";
        PreparedStatement pst;
        try {
            pst = connect.prepareStatement(query);
            pst.setInt(1, g2.rollno);
            pst.setString(2, g2.sname);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
class Titan {
    int rollno;
    String sname;
}
