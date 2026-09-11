/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.model;


import java.util.Scanner;

public class NhanVien extends Nguoi{
    private String maNV;
    private int luong;
    public NhanVien(){
        super();
    }

    public NhanVien(String manv, String ho,String ten, String sdt, String diaChi,String email,int luong) {
      super(ho,ten,sdt,diaChi,email);
      this.maNV=manv;
      this.luong=luong;
    }
    
    public NhanVien(NhanVien a){
        super((Nguoi)a);
        this.maNV=a.maNV;
        this.luong=a.luong;
    }
    
    public String getMaNV(){
        return this.maNV;
    }
    public void setMaNV(String manv){this.maNV=manv;}
    
    public int getLuong(){
        return this.luong;
    }
    public void setLuong(int luong){this.luong=luong;}
    
    Scanner sc= new Scanner(System.in);
    @Override 
    public void nhap(){
        
        System.out.println("Nhap ma nhan vien:");
        maNV=sc.nextLine();
        
        super.nhap();
        System.out.println("nhap luong thang:");
        luong=sc.nextInt();
    }
    @Override
    public void xuatThongTin() {
        System.out.print("KH: " + maNV+" Luong:"+luong);super.xuat();
        
    }

    
   
}
