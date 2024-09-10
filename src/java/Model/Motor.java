/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Motor {
    private int id;
    private String motorname;
    private double motorprice;
    private String motorimageurl;

    public Motor() {
    }

    public Motor(int id, String motorname, double motorprice, String motorimageurl) {
        this.id = id;
        this.motorname = motorname;
        this.motorprice = motorprice;
        this.motorimageurl = motorimageurl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotorname() {
        return motorname;
    }

    public void setMotorname(String motorname) {
        this.motorname = motorname;
    }

    public double getMotorprice() {
        return motorprice;
    }

    public void setMotorprice(double motorprice) {
        this.motorprice = motorprice;
    }

    public String getMotorimageurl() {
        return motorimageurl;
    }

    public void setMotorimageurl(String motorimageurl) {
        this.motorimageurl = motorimageurl;
    }

    @Override
    public String toString() {
        return "Motor{" + "id=" + id + ", motorname=" + motorname + ", motorprice=" + motorprice + ", motorimageurl=" + motorimageurl + '}';
    }
    
    
}
