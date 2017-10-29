package com.Jogmedia.Jogmedia.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class My_Connection {
    protected Connection con;
    public My_Connection(){}
    public My_Connection(Connection con){
        this.con=con;
    }
    public void makeConnection(){
        System.out.println("Openning database...");
        try{
            String db_password="password";
            String username="postgres";
            String url="jdbc:postgresql://localhost:5432/jogmedia";
            this.con= DriverManager.getConnection(url, username, db_password);
            System.out.println("Success openning db!");
        }
        catch (Exception e){
            System.out.println("Error while openning db");
            System.out.println(e);
        }
    }
    public void disconnect(){
        System.out.println("Open disconnect");
        try{
            this.con.close();
            System.out.println("Success disconnect");
        }
        catch (Exception e){
            System.out.println("Error while disconnect db");
            System.out.println(e);
        }
    }
}