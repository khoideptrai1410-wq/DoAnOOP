/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.model;


import java.util.Scanner;

public class TheLoai  {
    private String maTL;
    private String ten;
    
   

    public TheLoai(){maTL="";ten="";}

    public TheLoai(String maTL,String ten){
        this.maTL=maTL;       
        this.ten=ten;
    }

    public TheLoai(TheLoai tl){
        this.maTL=tl.maTL;
        this.ten=tl.ten;
       
    }

    public String getMaTL(){return maTL;}

    public void setMaTL(String ma){maTL=ma;}


    public String getTen(){return ten;}

    public void setTen(String t){ten=t;}

   
    
    private Scanner sc=new Scanner(System.in);

    public void nhap(){
        System.out.print("Nhap ma the loai: ");
        maTL=sc.nextLine();
        System.out.print("Nhap ten the loai");
        ten=sc.nextLine();
       
    }

    public void xuat(){
        System.out.printf("%-10s | %-20s %n", maTL, ten);

    }    

   
}


