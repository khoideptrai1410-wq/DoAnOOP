/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.model;



import java.util.Scanner;

public final class ChiTietPhieuNhap {
    private String maPN;
    private String maSach;
    private int soLuong;
    private double donGia;
    private double thanhTien;

    public ChiTietPhieuNhap() {
        maPN="";
        maSach="";
        soLuong=0;
        donGia=0;
        thanhTien=0;
    }

    public ChiTietPhieuNhap(String maPN, String maSach, int soLuong, double donGia) {
        this.maPN = maPN;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien=this.soLuong*this.donGia;
    }
    
    public ChiTietPhieuNhap(ChiTietPhieuNhap ct) {
        this.maPN = ct.maPN;
        this.maSach = ct.maSach;
        this.soLuong = ct.soLuong;
        this.donGia = ct.donGia;
        this.thanhTien=ct.thanhTien;
    }
    
    public String getMaPN() { return maPN; }
    public void setMaPN(String maPN) { this.maPN = maPN; }

    public String getMaSach() { return maSach; }
    public void setMaSach(String maSach) { this.maSach = maSach; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { 
        this.soLuong = soLuong; 
        tinhThanhTien();
    }

    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) { 
        this.donGia = donGia; 
        tinhThanhTien();
    }

    public double getThanhTien() { return thanhTien; }

    public void setThanhTien(double tien) { this.thanhTien=tien; }

    public void tinhThanhTien() {
        thanhTien = soLuong * donGia;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach: ");
        maSach=sc.nextLine();
        System.out.println("Nhap so luong: ");
        soLuong=sc.nextInt();
        System.out.println("Nhap don gia:");
        donGia=sc.nextDouble();
        tinhThanhTien();
    }

    public void xuat() {
        System.out.printf("Thong tin chi tiet phieu nhap: maPN: %-10s,maSach: %-10s,so luong: %-10d,don gia: %-10.2f,thanh tien: %-10.2f\n", maPN, maSach, soLuong, donGia, thanhTien);
    }
}
