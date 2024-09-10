/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class AccountRentMotorDTO {
    private int id;
    private int userId;
    private int motorId;
    private String namerent;
    private String email;
    private String phonenumber;
    private String rentdate;
    private String url;

    public AccountRentMotorDTO() {
    }

    public AccountRentMotorDTO(int id, int userId, int motorId, String namerent, String email, String phonenumber, String rentdate, String url) {
        this.id = id;
        this.userId = userId;
        this.motorId = motorId;
        this.namerent = namerent;
        this.email = email;
        this.phonenumber = phonenumber;
        this.rentdate = rentdate;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMotorId() {
        return motorId;
    }

    public void setMotorId(int motorId) {
        this.motorId = motorId;
    }

    public String getNamerent() {
        return namerent;
    }

    public void setNamerent(String namerent) {
        this.namerent = namerent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getRentdate() {
        return rentdate;
    }

    public void setRentdate(String rentdate) {
        this.rentdate = rentdate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "AccountRentMotorDTO{" + "id=" + id + ", userId=" + userId + ", motorId=" + motorId + ", namerent=" + namerent + ", email=" + email + ", phonenumber=" + phonenumber + ", rentdate=" + rentdate + ", url=" + url + '}';
    }
    
}
