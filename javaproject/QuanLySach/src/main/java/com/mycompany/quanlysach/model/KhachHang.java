/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.model;




import java.util.Scanner;

public class KhachHang extends Nguoi{
    private String maKH;
    public KhachHang(){
        super();
    }

    public KhachHang(String makh, String ho,String ten, String sdt, String diaChi,String email) {
      super(ho,ten,sdt,diaChi,email);
      this.maKH=makh;
    }
    
    public KhachHang(KhachHang a){
        super((Nguoi)a);
        this.maKH=a.maKH;
    }
    
    public String getMaKH(){
        return this.maKH;
    }
    public void setMaKH(String makh){this.maKH=makh;}
    
    Scanner sc= new Scanner(System.in);
    @Override 
    public void nhap(){
        
        System.out.println("Nhap ma khach hang:");
        maKH=sc.nextLine();
        
        super.nhap();
    }
    @Override
    public void xuatThongTin() {
        System.out.print("KH: " + maKH);super.xuat();
    }

    
   
}
