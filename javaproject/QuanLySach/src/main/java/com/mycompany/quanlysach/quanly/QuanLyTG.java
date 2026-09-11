/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;

import com.mycompany.quanlysach.model.TacGia;
import java.util.Scanner;

public class QuanLyTG extends QuanLy{
    private Scanner sc=new Scanner(System.in);
    // === MENU TÁC GIẢ ===
    @Override
    public void menuChinh() {
      
        int chon;
        
        do {
            System.out.println("\n====QUAN LY TAC GIA====");
            System.out.println("1. Xuat danh sach tac gia");
            System.out.println("2. Them tac gia");
            System.out.println("3. Sua tac gia");
            System.out.println("4. Xoa tac gia");
            System.out.println("5. Tim kiem tac gia theo ten");
            System.out.println("6.Thong ke tac gia viet nam");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1: dstg.xuat(); break;
                case 2: themTacGia(); break;
                case 3: 
                    System.out.print("Nhap ma tac gia can sua: ");
                    String ma1 = sc.nextLine();
                    dstg.suaTheoMa(ma1); break;
                case 4: 
                    System.out.print("Nhap ma tac gia can xoa: ");
                    String ma2 = sc.nextLine();
                    dstg.xoaTheoMa(ma2); break;
                case 5: 
                    System.out.print("Nhap ten tac gia can tim:");
                    String ten1=sc.nextLine();
                    dstg.timTheoTen(ten1);
                    break;
                case 6:
                    dstg.thongKeTG_VN();
                    break;
                case 0: 
                   
                    break;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
        
    }

    public void themTacGia() {
        System.out.println("=== Nhap tac gia moi ===");
        
        // Nhập thông tin tác giả
        TacGia tg = new TacGia();
        tg.nhap();

        // Kiểm tra mã tác giả trùng
        if (dstg.timTheoMa(tg.getMaTG()) != null) {
            System.out.println("Loi: tac gia da ton tai!");
            return;
        }

        // Thêm vào danh sách
        dstg.them(tg);
        System.out.println("da them tac gia thanh cong!");
    }

}

