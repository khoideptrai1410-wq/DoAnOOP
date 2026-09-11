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
public class SachThamKhao extends Sach {
    private String trinhDo;
    private String linhVuc;
    private static final Scanner sc = new Scanner(System.in);

  
    public SachThamKhao(){};
    public SachThamKhao(String maSach, String tenSach, double donGia, int soLuongTon, int namXB,
                        String tacGia, String nxb, String theLoai,
                        String trinhDo, String linhVuc) {
        super(maSach, tenSach, donGia, soLuongTon, namXB, tacGia, nxb, theLoai);
        this.trinhDo = trinhDo;
        this.linhVuc = linhVuc;
    }
    public String getTrinhDo() { return trinhDo; }
    public void setTrinhDo(String trinhDo) { this.trinhDo = trinhDo; }

    public String getLinhVuc() { return linhVuc; }
    public void setLinhVuc(String linhVuc) { this.linhVuc = linhVuc; }
    
     @Override public void nhapSach(){
     super.nhapSach();
     System.out.println("nhap trinh do:");
     trinhDo=sc.nextLine();
     System.out.println("nhap linh vuc:");
     linhVuc=sc.nextLine();
     
 }
    @Override
    public void xuat() {
        super.xuat();
        System.out.println(" | Trinh do: " + trinhDo + " | Linh vuc: " + linhVuc);
    }
}
