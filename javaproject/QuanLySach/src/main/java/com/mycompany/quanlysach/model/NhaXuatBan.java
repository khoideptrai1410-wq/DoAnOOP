/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.*;
public class NhaXuatBan {
    private String maNXB;
    private String tenNXB;
    private String diaChi;
    private String sdt; 
    private String email;


    public NhaXuatBan(){maNXB="";tenNXB="";diaChi="";sdt="";email="";}

    public NhaXuatBan(String maNhaXuatBan,String tenNhaXuatBan,String diachi,String sdt,String email){
        this.maNXB=maNhaXuatBan;
        this.tenNXB=tenNhaXuatBan;
        this.diaChi=diachi;
        this.sdt=sdt; 
        this.email=email;
    }

    public NhaXuatBan(NhaXuatBan nxb){
        this.maNXB=nxb.maNXB;
        this.tenNXB=nxb.tenNXB;
        this.diaChi=nxb.diaChi;
        this.sdt=nxb.sdt;
        this.email=nxb.email;
    }

    public String getMaNhaXuatBan(){return maNXB;}
    public void setMaNhaXuatBan(String ma){maNXB=ma;}
    public String getTenNhaXuatBan(){return tenNXB;}
    public void setTenNhaXuatBan(String t){tenNXB=t;}
    public String getDiaChi(){return diaChi;}
    public void setDiaChi(String dc){diaChi=dc;}
    public String getSDT(){return sdt;}
    public void setSDT(String dt){sdt=dt;}
    public String getEmail(){return email;}
    public void setEmail(String em){email=em;}

    private Scanner sc=new Scanner(System.in);

    public void nhap(){
        
        System.out.print("nhap ma NXB:: ");
        maNXB=sc.nextLine();
        System.out.print("nhap ten NXB: ");
        tenNXB=sc.nextLine();
        System.out.print("Nhap dia chi: ");
        diaChi=sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        sdt=sc.nextLine();
        System.out.print("Nhap email: ");
        email=sc.nextLine();
      
        
    }

    public void xuat(){
        System.out.printf("%-10s | %-25s | %-40s | %-12s | %-25s%n", maNXB, tenNXB, diaChi, sdt, email);

    }

    
}

