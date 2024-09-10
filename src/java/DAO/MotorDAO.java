/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Motor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class MotorDAO extends DBContext {
        //Khai bao cac thanh phan xu ly
    Connection cnn;//Ket noi db
    PreparedStatement stm; //Thuc hien cac cau lenh sql
    ResultSet rs;//Luu tru va xu ly du lieu duoc lay ve tu select

    public MotorDAO() {
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

    public ArrayList<Motor> getAllMotor() {
        ArrayList<Motor> result = new ArrayList<Motor>();
        String sql = "select * from Motor";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String motorname = rs.getString(2);
                double motorprice = rs.getDouble(3);
                String motorimageurl = rs.getString(4);
                result.add(new Motor(id, motorname, motorprice,motorimageurl));
            }
            return result;
        } catch (Exception e) {
            System.out.println("getAllMotor: "+e.getMessage());
        }
        return null;
    }
    
    public void UpdateMotorById(Motor motor) {
        String sql = "Update motor set motorname = ?, motorprice=?, motorimageurl=? where id = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, motor.getMotorname());
            pstm.setDouble(2, motor.getMotorprice());
            pstm.setString(3, motor.getMotorimageurl());
            pstm.setInt(4, motor.getId());
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("UpdateMotorById: "+e.getMessage());
        }
    }
    public Motor getMotorById(int id) {
        String sql = "select * from Motor where id = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                return new Motor(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("getMotorById: "+e.getMessage());
        }
        return null;
    }

        
            public void createAccountRentMotor(Motor motor) {
        try {
            String strSQL = "insert into Motor values (?, ?, ?)";
            stm = cnn.prepareStatement(strSQL);
             stm.setString(1, motor.getMotorname());
            stm.setDouble(2, motor.getMotorprice());
            stm.setString(3, motor.getMotorimageurl());

            stm.execute();
//            rs = stm.executeQuery();

        } catch (Exception e) {
            System.out.println("createAccountRentMotor : " + e);
        }
    }
    
    public static void main(String[] args) {
        MotorDAO m = new MotorDAO();
//        ArrayList<Motor> result = m.getAllMotor();
//        for (Motor motor : result) {
//            System.out.println(motor);
//        }
//m.UpdateMotorById(new Motor(0, "datuc", 44444, motorimageurl));
    }
}
