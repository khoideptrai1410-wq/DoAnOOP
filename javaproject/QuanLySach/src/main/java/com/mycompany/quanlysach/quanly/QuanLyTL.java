/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;


import com.mycompany.quanlysach.model.TheLoai;
import java.util.Scanner;

public class QuanLyTL extends QuanLy{
    private Scanner sc=new Scanner(System.in);
    // === MENU TÁC GIẢ ===
    @Override
    public void menuChinh() {
      
        int chon;
        
        do {
            System.out.println("\n==== QUAN LY THE LOAI====");
            System.out.println("1. Xuat danh sach the loai");
            System.out.println("2. Them the loai");
            System.out.println("3. Sua the loai");
            System.out.println("4. Xoa the loai");
            System.out.println("5. Tim kiem the loai theo ten");
            System.out.println("6.Thong ke the loai la: tu dien");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1: dstl.xuatDS(); break;
                case 2: themTheLoai(); break;
                case 3: 
                    dstl.suaTheLoai(); break;
                case 4: 
                    System.out.print("Nhap ma the loai can xoa: ");
                    String ma2 = sc.nextLine();
                    dstl.xoaTheoMa(ma2); break;
                case 5: 
                    System.out.print("Nhap ma the loai can tim");
                    String ten1=sc.nextLine();
                    dstl.timTheoTen(ten1);
                    break;
                case 6:
                    dstl.thongKeTLTuDien();
                    break;
                case 0: 
                   
                    break;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
        
    }

    public void themTheLoai() {
        System.out.println("=== Nhap the loai moi ===");
        
        // Nhập thông tin the loai
        TheLoai tg = new TheLoai();
        tg.nhap();

        // Kiểm tra mã the loai trùng
        if (dstl.timTheoMa(tg.getMaTL()) != null) {
            System.out.println("Loi : ma the loai nay da ton tai!");
            return;
        }

        // Thêm vào danh sách
        dstl.them(tg);
        System.out.println("da them the loai thanh cong...");
    }

}
