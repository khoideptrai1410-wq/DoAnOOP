/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.model;


import java.util.Scanner;

public class TacGia  {
    private String maTG;
    private String ten;
    private int namsinh;
    private String quoctich;


    public TacGia(){maTG="";ten="";namsinh=0;quoctich="";}

    public TacGia(String maTG,String ten,int namsinh,String quoctich){
        this.maTG=maTG;       
        this.ten=ten;
        this.namsinh=namsinh;
        this.quoctich=quoctich; 
    }

    public TacGia(TacGia tg){
        this.maTG=tg.maTG;
        this.ten=tg.ten;
        this.namsinh=tg.namsinh;
        this.quoctich=tg.quoctich;
    }

    public String getMaTG(){return maTG;}

    public void setMaTG(String ma){maTG=ma;}


    public String getTen(){return ten;}

    public void setTen(String t){ten=t;}

    public int getNamsinh(){return namsinh;}

    public void setNamsinh(int ns){namsinh=ns;}

    public String getQuoctich(){return quoctich;}

    public void setQuoctich(String qt){quoctich=qt;}
    
    private Scanner sc=new Scanner(System.in);

    public void nhap(){
        System.out.print("Nhap ma tac gia: ");
        maTG=sc.nextLine();
        System.out.print("Nhap ten tac gia: ");
        ten=sc.nextLine();
        System.out.print("Nhap nam sinh: ");
        namsinh=sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap quoc tich: ");
        quoctich=sc.nextLine();
        
    }

    public void xuat(){
        System.out.printf("%-10s | %-20s | %-10d | %-15s%n", maTG, ten, namsinh, quoctich);

    }    

   
}

