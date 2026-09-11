/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;



import com.mycompany.quanlysach.model.NhaCungCap;
import java.util.Scanner;

public class QuanLyNCC extends QuanLy{
    private Scanner sc=new Scanner(System.in);
     // === MENU NHÀ CUNG CẤP ===
     @Override
    public void menuChinh() {
          
        
        int chon;
        
        do {
            System.out.println("\n====QUAN LY NHA CUNG CAP====");
            System.out.println("1. Xuat danh sach nha cung cap");
            System.out.println("2  Them nha cung cap");
            System.out.println("3. Sua nha cung cap");
            System.out.println("4. Xoa nha cung cap");
            System.out.println("5 Tim kiem nha cung cap theo ten");
            System.out.println("6. Thong ke nha cung cap theo khu vuc");
            System.out.println("0. Quay lai");
            System.out.print("Chon chuc nang: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1: dsncc.xuat(); break;
                case 2: themNCC(); break;
                case 3: 
                    System.out.print("Nhap ma nha cung cap can sua: ");
                    String ma1 = sc.nextLine();
                    if (dsncc.timTheoMa(ma1) == null) {
                    System.out.println(" ncc nay khong ton tai!");
                    break;
                    }
                    dsncc.suaTheoMa(ma1); break;
                case 4: 
                    System.out.print("Nhap ma nha cung cap can xoa: ");
                    String ma2 = sc.nextLine();
                    dsncc.xoaTheoMa(ma2); break;
                case 5:
                    System.out.print("Nhap ten nha cung cap can tim:");
                    String ten1=sc.nextLine();
                    dsncc.timTheoTen(ten1);
                    break;
                case 6:
                    dsncc.thongKeNCC_HCM();
                    break;
                case 0: 
                   
                       
                    break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
        
    }

    public void themNCC() {
        System.out.println("=== Nhap nha cung cap moi ===");

        // 1. Nhập thông tin nhà cung cấp
        NhaCungCap ncc = new NhaCungCap();
        ncc.nhap();

        // 2. Kiểm tra mã NCC trùng
        if (dsncc.timTheoMa(ncc.getMaNCC()) != null) {
            System.out.println("Loi : nha cung cap nay da ton tai!");
            return;
        }

        // 3. Thêm vào danh sách
        dsncc.them(ncc);
        System.out.println("da them vao ds thanh cong!");
    }


}
