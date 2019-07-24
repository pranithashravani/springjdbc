package com.stackroute.jdbc;

import java.sql.*;

public class ResultsetMetaDataDemo {
    private Connection connection=null;
    private Statement statement=null;
    private ResultSet result;

    public void displayresultsetmetadata()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
             statement = connection.createStatement();
             String sql="select * from employee";
            result = statement.executeQuery(sql);

            ResultSetMetaData rsMeta = result.getMetaData();

            System.out.println(rsMeta.getColumnCount());

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {

        }
    }
}
