/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.model;





import java.text.*;
import java.util.Date;
import java.util.Scanner;
import java.time.*;

public class HoaDon {
    private String maHD;
    private Date ngayBan;
    private String maKH;
    private String maNV;
    private double tongTien;
   

    public HoaDon() {}
    public HoaDon(String mahd, String makh, String manv, Date ngay, double tong){
        this.maHD = mahd;
        this.maKH = makh;
        this.maNV = manv;
        this.ngayBan = ngay;
        this.tongTien = tong;
    }
    public HoaDon(HoaDon hd){
        this.maHD = hd.maHD;
        this.maKH = hd.maKH;
        this.maNV = hd.maNV;
        this.ngayBan = hd.ngayBan;
        this.tongTien = hd.tongTien;
    }
    public String getMaHD() { return maHD; }
    public void setMaHD(String maHD) { this.maHD = maHD; }

    public Date getNgayBan() { return ngayBan; }
    public void setNgayBan(String ngayBan) throws ParseException { 
        SimpleDateFormat std= new SimpleDateFormat("yyyy-MM-dd");
        
        this.ngayBan = std.parse(ngayBan); 
    }

    public String getMaKH() { return maKH; }
    public void setMaKH(String maKH) { this.maKH = maKH; }

    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }

    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }

   

   
    public void nhap() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma hoa don: ");
        maHD=sc.nextLine();
        System.out.println("nhap ngay lap hoa don (yyyy-MM-dd):");
        SimpleDateFormat sfd= new SimpleDateFormat("yyyy-MM-dd");
        String str=sc.nextLine();
        ngayBan=sfd.parse(str);
        System.out.println("Nhap ma nhan vien:");
        maNV=sc.nextLine();
        System.out.println("Nhap ma khach hang:");
        maKH=sc.nextLine();
        tongTien=0;
        
    }
    public void xuat() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.printf("thong tin hoa don :maHD: %-10s|maKH:  %-10s|maNV %-10s|ngay: %-15s|tong tien: %-10.2f\n",
                maHD, maKH, maNV, df.format(ngayBan), tongTien);
    }
    // Trả về ngày dạng chuỗi để ghi file
    public String getNgayBanString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(ngayBan);
    }
}
