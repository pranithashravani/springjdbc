package com.stackroute.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transactiondemo {
    public void displaytransaction() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
            connection.setAutoCommit(false);

            PreparedStatement ps = connection.prepareStatement("insert into employee values(?,?,?,?)");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {

                System.out.println("enter id");
                String s1 = br.readLine();
                int id = Integer.parseInt(s1);

                System.out.println("enter name");
                String name = br.readLine();

                System.out.println("enter age");
                String s3 = br.readLine();
                int age = Integer.parseInt(s3);
                System.out.println("enter gender");
                String gender = br.readLine();



                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setInt(3, age);
                ps.setString(4,gender);
                ps.executeUpdate();
                System.out.println("commit/rollback");
                String answer=br.readLine();
                if(answer.equals("commit")){
                    connection.commit();
                }
                if(answer.equals("rollback")){
                    connection.rollback();
                }


                System.out.println("Want to add more records y/n");
                String ans=br.readLine();
                if(ans.equals("n")){
                    break;
                }

            }
            connection.commit();
            System.out.println("record successfully saved");




            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {

        }
    }

}
