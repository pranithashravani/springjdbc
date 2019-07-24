package com.stackroute.jdbc;

import java.sql.*;


public class DatabaseMetadataDemo {
    private Connection connection=null;

    private ResultSet rs;



    public void displaymetadata()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
            DatabaseMetaData metadata=connection.getMetaData();
            rs=metadata.getTables(null,null,null,new String[]{"SYSTEM TABLE"});
            while(rs.next())
            {
                System.out.println(rs.getString("TABLE_NAME"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {

        }
    }
}

