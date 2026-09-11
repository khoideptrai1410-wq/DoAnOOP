/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.model;

public abstract class Nguoi implements IHienThi {

    protected String ho;
    protected String ten;
    protected String sdt;
    protected String diaChi;
    protected String email;
    
    public Nguoi(){
    ho="";
    ten="";
    sdt="";
    email="";
    };

    public Nguoi( String ho,String ten, String sdt,String diaChi,String email) {
        
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi=diaChi;
        this.email=email;
    }
    public Nguoi(Nguoi a) {
        
        this.ho = a.ho;
        this.ten = a.ten;
        this.sdt = a.sdt;
        this.diaChi=a.diaChi;
        this.email=a.email;
    }


    public String getHo() { return ho; }
    public String getTen() { return ten; }
    public void setHo(String ho) { this.ho = ho; }
    public void setTen(String Ten) { this.ten = Ten; }

    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diachi) { this.diaChi = diachi; 
    }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public void nhap() {
    java.util.Scanner sc = new java.util.Scanner(System.in);


    System.out.print("Nhap ho: ");
    this.ho = sc.nextLine();

    System.out.print("Nhap ten: ");
    this.ten = sc.nextLine();

    System.out.print("Nhap so dien thoai: ");
    this.sdt = sc.nextLine();
    
    System.out.println("Nhap dia chi :");
    diaChi=sc.nextLine();

    System.out.print("Nhap email:");
    this.email= sc.nextLine();
        System.out.println("nhap thanh cong.");
}
    
    public void xuat() {
    System.out.println(
        "- Ho va ten : " + ho +" " + ten +" | SDT: " + sdt +"| Dia Chi:"+diaChi+" | email: " + email );
}


}
