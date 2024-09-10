/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.AccountRentMotorDTO;
import Model.AccountRentMotor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class AccountRentMotorDAO extends DBContext {
    //Khai bao cac thanh phan xu ly

    Connection cnn;//Ket noi db
    PreparedStatement stm; //Thuc hien cac cau lenh sql
    ResultSet rs;//Luu tru va xu ly du lieu duoc lay ve tu select

    public AccountRentMotorDAO() {
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

    public ArrayList<AccountRentMotorDTO> getAllAccountRentMotorByAccountId(int accountId) {
        ArrayList<AccountRentMotorDTO> result = new ArrayList<AccountRentMotorDTO>();
        String sql = "select * from AccountRentMotor join Motor on AccountRentMotor.motorId = Motor.id  where userId = ? ";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, accountId);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int userId = rs.getInt(2);
                int motorId = rs.getInt(3);
                String namerent = rs.getString(4);
                String email = rs.getString(5);
                String phonenumber = rs.getString(6);
                Date dobDate = rs.getDate(7);
                String dob = null;
                if (dobDate != null) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    dob = dateFormat.format(dobDate);
                }
                String url = rs.getString(11);
                result.add(new AccountRentMotorDTO(id, userId, motorId, namerent, email, phonenumber, dob, url));
            }
            return result;
        } catch (Exception e) {
            System.out.println("getListUser: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<AccountRentMotorDTO> getAllAccountRentMotor() {
        ArrayList<AccountRentMotorDTO> result = new ArrayList<AccountRentMotorDTO>();
        String sql = "select * from AccountRentMotor join Motor on AccountRentMotor.motorId = Motor.id";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int userId = rs.getInt(2);
                int motorId = rs.getInt(3);
                String namerent = rs.getString(4);
                String email = rs.getString(5);
                String phonenumber = rs.getString(6);
                Date dobDate = rs.getDate(7);
                String dob = null;
                if (dobDate != null) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    dob = dateFormat.format(dobDate);
                }
                String url = rs.getString(11);
                result.add(new AccountRentMotorDTO(id, userId, motorId, namerent, email, phonenumber, dob, url));
            }
            return result;
        } catch (Exception e) {
            System.out.println("getAllAccountRentMotor: " + e.getMessage());
        }
        return null;
    }

    public void UpdateAccountRentMotorDTOById(String id, String name, String email, String phone, String rentDate, int userID, int motorID) {
        String sql = "Update AccountRentMotor set motorId = ?, namerent=?, email=?,phonenumber=?,rentdate=?,userId=? where id = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, motorID);
            pstm.setString(2, name);
            pstm.setString(3, email);
            pstm.setString(4, phone);
            pstm.setString(5, rentDate);
            pstm.setInt(6, userID);
            pstm.setString(7, id);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("UpdateAccountRentMotorDTOById: " + e.getMessage());
        }
    }

    public AccountRentMotorDTO getAllAccountRentMotorById(String Aid) {
        ArrayList<AccountRentMotorDTO> result = new ArrayList<AccountRentMotorDTO>();
        AccountRentMotorDTO rentMoto = null;
        String sql = "select * from AccountRentMotor join Motor on AccountRentMotor.motorId = Motor.id  where AccountRentMotor.id = ?";
        try {
            stm = cnn.prepareStatement(sql);
            stm.setString(1, Aid);
            rs = stm.executeQuery();
            if (rs.next()) {
//                Date dobDate = rs.getDate(7);
//                String dob = null;
//                if (dobDate != null) {
//                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//                    dob = dateFormat.format(dobDate);
//                }
                rentMoto = new AccountRentMotorDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7) + "", rs.getString(11));
            }
        } catch (Exception e) {
            System.out.println("getListUser: " + e.getMessage());
        }
        return rentMoto;
    }

    public boolean createAccountRentMotor(AccountRentMotor accountRentMotor) {
        String sql = "insert into [AccountRentMotor] values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, accountRentMotor.getUserId());
            pstm.setInt(2, accountRentMotor.getMotorId());
            pstm.setString(3, accountRentMotor.getNamerent());
            pstm.setString(4, accountRentMotor.getEmail());
            pstm.setString(5, accountRentMotor.getPhonenumber());
            pstm.setString(6, accountRentMotor.getRentdate() + "");
            return pstm.executeUpdate() == 1;
        } catch (Exception e) {
            System.out.println("getListUser: " + e.getMessage());
        }
        return false;
    }

    public void delete(String id) {
        try {
            String strSQL = "delete from [AccountRentMotor] where id=?";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, id);

            stm.execute();
//            rs = stm.executeQuery();

        } catch (Exception e) {
            System.out.println("delete : " + e);
        }
    }

    public static void main(String[] args) {
        AccountRentMotorDAO m = new AccountRentMotorDAO();
//        ArrayList<AccountRentMotorDTO> result = m.getAllAccountRentMotorById("9");
        m.UpdateAccountRentMotorDTOById("2", "datne", "siuesao", "123123123", "03/12/2023", 2, 3);
//        for (AccountRentMotorDTO motor : result) {
//            System.out.println(motor);
//        }
        System.out.println("result :" + m);
    }

}
