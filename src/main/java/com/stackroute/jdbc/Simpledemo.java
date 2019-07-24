package com.stackroute.jdbc;

import java.sql.*;

public class Simpledemo {
    private Connection connection = null;
    private Statement ps;
    private ResultSet rs;
    private PreparedStatement prepare;
    String name;
    String gender;

    public void getemployeedetails() {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery("select *from employee");
            while (rs.next()) {
                System.out.println("id:" + rs.getInt(1) + "name" + rs.getString(2) + "age" + rs.getInt(3));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {

        }
    }
        public void getdetailsreverse() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
                Statement ps = connection.createStatement();
                ResultSet rs = ps.executeQuery("select *from employee");
                rs.afterLast();
                while (rs.previous()) {
                    System.out.println("id:" + rs.getInt(1) + "name" + rs.getString(2) + "age" + rs.getInt(3));
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } catch (Exception ex) {

            }

            }


        /*Move ResultSet to second row and print in reverse order*/
        public void getEmployeeDetailsFromSecondRowInReverse()
    {

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
                    Statement ps = connection.createStatement();
                    ResultSet rs = ps.executeQuery("select *from employee");
                    //rs.afterLast();
                    rs.absolute(3);
                    while (rs.previous()) {
                        System.out.println("id:" + rs.getInt(1) + "name" + rs.getString(2) + "age" + rs.getInt(3));
                        //break;
                    }

                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                } catch (Exception ex) {

                }

                }




        //Use PreparedStatement to display by name and gender

        public void getEmployeeDetailsByNameAndGender(String name,String gender){
            try {
                String sql="select * from employee where name=? and gender=?";
                 prepare=connection.prepareStatement(sql);
                 prepare.setString(1,name);
                 prepare.setString(2,gender);
                rs = prepare.executeQuery();

                while (rs.next()) {
                    System.out.println("id:" + rs.getInt(1) + "name" + rs.getString(2) + "age" + rs.getInt(3));

                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

           finally {
                try {
                    connection.close();
                   // ps.close();
                    rs.close();
                    prepare.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }







