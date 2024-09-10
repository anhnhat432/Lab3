/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.Account;
import java.sql.Connection;

/**
 *
 * @author Admin
 */
public class AccountDAO extends DBContext{
     //Khai bao cac thanh phan xu ly
    Connection cnn;//Ket noi db
    PreparedStatement stm; //Thuc hien cac cau lenh sql
    ResultSet rs;//Luu tru va xu ly du lieu duoc lay ve tu select

    public AccountDAO() {
        connect();
    }

    private void connect() {
        try {
            cnn = connection;
            if (cnn != null) {
                System.out.println("Connect success");
            } else {
                System.out.println("Connect fail");
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }
    public Account getUser(String account, String password) {
        String sql = "select * from Account where username = ? and password = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, account);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                return new Account(rs.getInt(1), account, password);
            }
        } catch (Exception e) {
            System.out.println("getListUser: "+e.getMessage());
        }
        return null;
    }
    public void insert(String username,String  password) {
        try {
            String strSQL = "Insert into Account values(?,?)";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.execute();
//            rs = stm.executeQuery();

        } catch (Exception e) {
            System.out.println("insert : " + e);
        }
    }
    
    public static void main(String[] args) {
        AccountDAO u = new AccountDAO();
        Account mu = u.getUser("customer", "customer");
        System.out.println(mu);
    }
    
}
