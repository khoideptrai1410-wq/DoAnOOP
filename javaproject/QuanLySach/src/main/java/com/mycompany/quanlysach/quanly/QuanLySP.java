/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;



import com.mycompany.quanlysach.model.Sach;

import java.util.Scanner;

public class QuanLySP extends QuanLy{
    private Scanner sc=new Scanner(System.in);
    // === MENU SÁCH ===
    @Override
    public void menuChinh() {
            
        int chon;
        
        do {
            System.out.println("\n====QUAN LY SACH ");
            System.out.println("1. Xuat danh sach sach");
            System.out.println("2. Them sach");
            System.out.println("3. Sua sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Tim kiem sach theo ten");
            System.out.println("6. Thong ke so luong moi loai sach");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1: dssach.xuatDS(); break;
                case 2: themSach(); break;
                case 3: 
             
                    dssach.suaSach();
                    break;
                case 4: 
                    System.out.print("Nhap ma sach can xoa: ");
                    String ma2 = sc.nextLine();
                    dssach.xoaTheoMa(ma2); break;
                case 5:
                   
                    dssach.timKiemTheoTen();
                    break;
                case 6:
                    dssach.thongKeLoaiSach();  break;
                case 0: break;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
        
    }


    public void themSach() {
        System.out.println("=== NHAP SACH MOI ===");
        Sach s = dssach.nhap1Sach(); // gọi hàm nhập 1 sách từ DSSach

        // 1. Kiểm tra mã sách trùng
        if (dssach.timTheoMa(s.getID_Sach()) != null) {
            System.out.println("Ma sach da ton tai!");
            return;
        }

        // 2. Kiểm tra mã tác giả tồn tại
        if (dstg.timTheoMa(s.getMaTacGia()) == null) {
            System.out.println("Ma tac gia khong ton tai!");
            return;
        }

        // 3. Kiểm tra mã NXB tồn tại
        if (dsnxb.timTheoMa(s.getMaNhaXB()) == null) {
            System.out.println("Ma NXB khong ton tai!");
            return;
        }
        if (dstl.timTheoMa(s.getMaTheLoai()) == null) {
            System.out.println("Ma the loai khong ton tai!");
            return;
        }

        // Nếu hợp lệ, thêm sách
        dssach.them(s);
        System.out.println("da them sach thanh cong!");
    }

}
