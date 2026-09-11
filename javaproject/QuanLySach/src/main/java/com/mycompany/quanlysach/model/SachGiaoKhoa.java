/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.model;


import java.util.Scanner;
public class SachGiaoKhoa extends Sach {
    private String monHoc;
    private String capHoc;
     private static final Scanner sc = new Scanner(System.in);
    public  SachGiaoKhoa(){
    };
    public SachGiaoKhoa(String maSach, String tenSach, double donGia, int soLuongTon, int namXB,
                        String tacGia, String nxb, String theLoai,
                        String monHoc, String capHoc) {
        super(maSach, tenSach, donGia, soLuongTon, namXB, tacGia, nxb, theLoai);
        this.monHoc = monHoc;
        this.capHoc = capHoc;
    }
    public String getMonHoc(){return monHoc;}
    public String getCapHoc(){return capHoc;}
    public  void setMonHoc(String monHoc){this.monHoc=monHoc;}
    public  void setCapHoc(String capHoc){this.capHoc=capHoc;}
  
  
     @Override public void nhapSach(){
     
     super.nhapSach();
     System.out.println("nhap mon hoc:");
     monHoc=sc.nextLine();
     System.out.println("nhap cap hoc:");
     capHoc=sc.nextLine();
     
 }
 @Override
    public void xuat() {
        super.xuat();
        System.out.println(" | mon hoc: " + monHoc + " | cap hoc: " + capHoc);
    }

}

