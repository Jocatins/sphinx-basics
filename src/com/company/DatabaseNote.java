package com.company;

import java.sql.*; //import the package

// Java Database Connectivity
//ddl - Data definition Language
//dml - data Manipulation Language
//dql - data query language
//drl - data retrieve language

//create table student (rollno int, username varchar(15));
//insert into student values (3, "Nico");
//delete from student where rollNumber <2 | =8;
//delete from student . to delete all the data in the student table --> DML
//truncate clears the data-table and rollback cannot retrieve it --> DDL
// drop database "name of database";
// select * from "name of table";
//select count(*) from student;
//select min(marks) from student;
//select avg/sum(marks) from student;
// select * from student order by marks desc;
//select username from student where rollno = 4;

public class DatabaseNote {

    public static void main(String[] args) throws Exception {
        String url = "";
        String username = "sphinx";
        String password = "";
        Class.forName("com.mysql.jdbc.Driver"); // register the driver
        Connection connect = DriverManager.getConnection(url, username, password);

    }

}

