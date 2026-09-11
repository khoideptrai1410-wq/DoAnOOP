/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.model;


import java.time.*;
import java.text.*;
import java.util.Scanner;
import java.util.Date;

public class PhieuNhap {
    private String maPN;
    private Date ngayNhap;
    private String maNCC;
    private String maNV;
    private double tongTien;

    public PhieuNhap() {
        maPN = "";
        maNV = "";
        maNCC = "";
        ngayNhap = null;
        tongTien = 0;
    }
    public PhieuNhap(String mapnh, String manv, String mancc,Date ngaynhap,double tongtien) {
        this.maPN = mapnh;
        this.maNV = manv;
        this.maNCC = mancc;
        this.ngayNhap = ngaynhap;
        this.tongTien = tongtien;
    }

    // Constructor sao chép
    public PhieuNhap(PhieuNhap pnh) {
        this.maPN = pnh.maPN;
        this.maNV = pnh.maNV;
        this.maNCC = pnh.maNCC;
        this.ngayNhap = pnh.ngayNhap;
        this.tongTien = pnh.tongTien;
    }

    public String getMaPN() { return maPN; }
    public void setMaPN(String maPN) { this.maPN = maPN; }
    
    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }

    public Date getNgayNhap() { return ngayNhap; }
   public void setNgayNhap(String ngayNhap) throws ParseException { 
        SimpleDateFormat std= new SimpleDateFormat("yyyy-MM-dd");
        
        this.ngayNhap = std.parse(ngayNhap); 
    }

    public String getMaNCC() { return maNCC; }
    public void setMaNCC(String maNCC) { this.maNCC = maNCC; }

    public double getTongTien() { return tongTien; }
    public void setTongTien(double tong){this.tongTien=tong;};

 

    public void nhap() throws ParseException {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhap ma phieu nhap: ");
        maPN = sc.nextLine();
        
        
        System.out.print("Nhap ma Nhan Vien: ");
        maNV = sc.nextLine();
        
        System.out.print("Nhap ma NCC: ");
        maNCC = sc.nextLine();
        ngayNhap = new Date(); // mặc định ngày hiện tại
   
        SimpleDateFormat std=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("nhap ngay lap phieu (yyyy-MM-dd):");
        String str = sc.nextLine();
        ngayNhap=std.parse(str);
        
        tongTien=0;
    }

    public void xuat() {
        SimpleDateFormat sdt=new    SimpleDateFormat("yyyy-MM-dd");
        System.out.println("\nMa PN: " + maPN + ", NCC: " + maNCC +"maNV: "+maNV+ ", Ngay nhap: " + sdt.format(ngayNhap) + ", Tong tien: " + tongTien);
        
    }
    // Trả về ngày dạng chuỗi để ghi file
    public String getNgayNhapString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(ngayNhap);
    }
    
    
    
}
