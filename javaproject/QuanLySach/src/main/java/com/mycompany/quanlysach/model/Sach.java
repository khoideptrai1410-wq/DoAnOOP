/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.model;



import java.util.Scanner;

/**
 *
 * @author Asus
 */
public abstract class Sach {
    protected String id_Sach;
    protected String tenSach;
    protected double donGia;
    protected int soLuongTon;
    protected int namXB;
    protected String maTacGia;
    protected String maTheLoai;
    protected String maNhaXB;
        
    public Sach(){};
    public Sach(String maSach, String tenSach, double donGia, int soLuongTon, 
                int namXuatBan, String tacGia, String nxb,String theLoai) 
    {
        this.id_Sach = maSach;
        this.tenSach = tenSach;
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
        this.namXB = namXuatBan;
        this.maTacGia = tacGia;
        this.maNhaXB = nxb;
        this.maTheLoai = theLoai;
    }
     public Sach(Sach s) {
        this.id_Sach=s.id_Sach;
        this.tenSach=s.tenSach;
        this.maTacGia=s.maTacGia;
        this.donGia=s.donGia;
        this.namXB=s.namXB;
        this.maNhaXB=s.maNhaXB;
        this.soLuongTon=s.soLuongTon;
        this.maTheLoai = s.maTheLoai;
    }
    public String getID_Sach() { return id_Sach; }
    public void setID_Sach(String id) { this.id_Sach = id; }
    
    public String getTenSach() { return tenSach; }
    public void setTenSach(String tensach) { this.tenSach = tensach; }
 
    public double getDonGia() { return donGia; }
    public void setDonGia(double dongia) { this.donGia = dongia; }
    
    public int getSoLuongTon() { return soLuongTon; }
    public void setSoLuongTon(int soLuongTon) { this.soLuongTon = soLuongTon; }
   
     public  int getNamXB(){return namXB;}
    public  void setetNamXB(int namxb){this.namXB=namxb;}
   
    public String getMaTacGia() { return maTacGia; }
    public void setMaTacGia(String tacgia){this.maTacGia=tacgia;}
    
    public String getMaTheLoai() { return maTheLoai; }
    public void setMaTheLoai(String theloai){this.maTheLoai=theloai;}
    
    public String getMaNhaXB() { return maNhaXB; }
    public void setMaNhaXB(String nxb){this.maNhaXB=nxb;}
    
    public void nhapSach() {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("\n=== Nhap thong tin sach ===");
    System.out.print("Nhap ma sach: ");
    this.id_Sach = sc.nextLine();
    
    System.out.print("Nhap ten sach: ");
     this.tenSach = sc.nextLine();
     
     
    System.out.print("Nhap ma tac gia: ");
       this.maTacGia = sc.nextLine();
       
    System.out.print("Nhap ma the loai: ");
       this.maTheLoai = sc.nextLine();
       
    System.out.print("Nhap ma nha xuat ban: ");
       this.maNhaXB = sc.nextLine();

     
    System.out.print("Nhap don gia: ");
    
     this.donGia = Double.parseDouble(sc.nextLine());
    System.out.print("Nhap so luong ton: ");
    
    this.soLuongTon = Integer.parseInt(sc.nextLine());
    System.out.print("Nhap nam xuat ban: ");
    this.namXB = sc.nextInt();
    sc.nextLine();
    }
    
    public void xuat() {
    System.out.printf(
        "| %-10s | %-30s | %-10s | %-10s | %-10s | %10s | %10d | %10.2f |\n",
        id_Sach, tenSach, maTacGia, maNhaXB, maTheLoai, namXB, soLuongTon, donGia
    );
}

}  
