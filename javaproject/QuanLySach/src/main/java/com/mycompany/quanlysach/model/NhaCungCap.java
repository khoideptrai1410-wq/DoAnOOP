/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.model;


import java.util.Scanner;

public class NhaCungCap {
    private String mancc;
    private String ten;
    private String sdt;
    private String email;
    private String diachi;

    
    // Constructor mặc định
    public NhaCungCap() {
        mancc = "";
        ten = "";
        sdt = "";
        email = "";
        diachi = "";
    }

    // Constructor đầy đủ
    public NhaCungCap(String mancc, String ten, String sdt, String email, String diachi) {
        this.mancc = mancc;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.diachi = diachi;
    } 

    // Constructor sao chép
    public NhaCungCap(NhaCungCap ncc) {
        this.mancc = ncc.mancc;
        this.ten = ncc.ten;
        this.sdt = ncc.sdt;
        this.email = ncc.email;
        this.diachi = ncc.diachi;
    }

    // Getter & Setter
    public String getMaNCC() { return mancc; }
    public void setMaNCC(String m) { mancc = m; }

    public String getTen() { return ten; }
    public void setTen(String t) { ten = t; }

    public String getSDT() { return sdt; }
    public void setSDT(String s) { sdt = s; }

    public String getEmail() { return email; }
    public void setEmail(String e) { email = e; }

    public String getDiaChi() { return diachi; }
    public void setDiaChi(String d) { diachi = d; }
    private Scanner sc=new Scanner(System.in);
    // Nhập thông tin nhà cung cấp
    public void nhap() {
       

        System.out.print("Nhap ma ncc:: ");
        mancc = sc.nextLine();
        System.out.print("Nhap ten ncc: ");
        ten = sc.nextLine();
        System.out.print("Nhap so dien thoai ncc: ");
        sdt = sc.nextLine();
        System.out.print("Nhap email: ");
        email = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        diachi = sc.nextLine();
        
    }

    // Xuất thông tin nhà cung cấp
    public void xuat() {
       System.out.printf("%-8s | %-60s| %-12s | %-20s | %-40s%n",mancc, ten, sdt, email, diachi);

    }
}
