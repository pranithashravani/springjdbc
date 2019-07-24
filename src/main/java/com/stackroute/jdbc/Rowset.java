package com.stackroute.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class Rowset {

    public void displayrowset()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();

            rowSet.setUrl("jdbc:mysql://localhost:3306/employee");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");
            rowSet.setCommand("select * from employee");
            rowSet.execute();
            while (rowSet.next()) {
                System.out.println("id" + rowSet.getString(1) + "name" + rowSet.getString(2) + "age" + rowSet.getString(3) + "gender" + rowSet.getString(4));
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {

        }

    }
}
