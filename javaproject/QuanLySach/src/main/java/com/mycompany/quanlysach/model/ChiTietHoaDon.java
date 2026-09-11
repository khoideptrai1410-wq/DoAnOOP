/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.model;



import java.util.Scanner;

public class ChiTietHoaDon {
    private String maHD;
    private String maSach;
    private int soLuong;
    private double donGia;
    private double thanhTien;

    public ChiTietHoaDon() {
    maHD="";
    maSach="";
    soLuong=0;
    donGia=0;
    thanhTien=0;}

    public ChiTietHoaDon(String maHD, String maSach, int soLuong, double donGia) {
        this.maHD = maHD;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia;
    }

    public String getMaHD() { return maHD; }
    public void setMaHD(String maHD) { this.maHD = maHD; }

    public String getMaSach() { return maSach; }
    public void setMaSach(String maSach) { this.maSach = maSach; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        this.thanhTien = this.soLuong * this.donGia;
    }

    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
        this.thanhTien = this.soLuong * this.donGia;
    }
    public void tinhThanhTien(){
        thanhTien=soLuong*donGia;
    }

    public double getThanhTien() { return thanhTien; }
    public void setThanhTien( double tien) { this.thanhTien=tien; }

    public void nhap() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap ma Sach:");
        maSach=sc.nextLine();
        System.out.println("nhap so luong sach:");
        soLuong=sc.nextInt();
        sc.nextLine();
        tinhThanhTien();
     
    }

    // ================== XUẤT ==================
    public void xuat() {
        System.out.printf("Thong tin chi tiet: maHD:%-10s,maSach: %-10s,soluong: %-10d,Don Gia:  %-10.2f, Thanh Tien: %-10.2f\n",
                maHD, maSach, soLuong, donGia, thanhTien);
    }
}
