/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;



import java.text.ParseException;
import java.util.Scanner;

public class MainMenu {
    QuanLy ql;

    public MainMenu() throws ParseException{
        ql=new QuanLy();
        ql.docFile();
    }
    private Scanner sc=new Scanner(System.in);
    // === MENU CHÍNH ===
    public void menuChinh() {
        int chon;
      
        
        do {
            System.out.println("\n===== MENU CHINH =====");
            System.out.println("1. QUAN LY SACH");
            System.out.println("2. QUAN LY TAC GIA");
            System.out.println("3. QUAN LY NHA CUNG CAP");
            System.out.println("4. QUAN LY HOA DON VA CTHD");
            System.out.println("5. QUAN LY PHIEU NHAP VA CTPN");
            System.out.println("6. QUAN LY KHACH HANG");
            System.out.println("7. QUAN LY NHAN VIEN");
            System.out.println("8. QUAN LY NHA XUAT BAN");
            System.out.println("9. LUA CHON MENU THONG KE");
            System.out.println("0. Thoat");
            System.out.print("Chon : ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1: ql=new QuanLySP(); ql.menuChinh();break;
                case 2: ql=new QuanLyTG(); ql.menuChinh(); break;
                case 3: ql=new QuanLyNCC();ql.menuChinh(); break;
                case 4: ql=new QuanLyHD();ql.menuChinh(); break;
                case 5: ql=new QuanLyPN(); ql.menuChinh();break;
                case 6: ql=new QuanLyKH(); ql.menuChinh(); break;
                case 7: ql=new QuanLyNV(); ql.menuChinh(); break;
                case 8: ql=new QuanLyNXB(); ql.menuChinh(); break; 
                case 9: ql=new QuanLyThongKe(); ql.menuChinh(); break;
                case 0: 
               
                System.out.println("Thoat chuong trinh!"); break;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
        
    }

    
}
