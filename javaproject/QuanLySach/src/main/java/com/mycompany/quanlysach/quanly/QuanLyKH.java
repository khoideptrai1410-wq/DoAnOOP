/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;



import com.mycompany.quanlysach.model.KhachHang;
import java.util.Scanner;

public class QuanLyKH extends QuanLy{
    private Scanner sc=new Scanner(System.in);
    @Override
     public void menuChinh(){     
        int chon;
        do{
            System.out.println("\n====QUAN LY KHACH HANG====");
            System.out.println("1. Xuat danh sach khach hang");
            System.out.println("2. Them khach hang");
            System.out.println("3. Sua khach hang");
            System.out.println("4. Xoa khach hang");
            System.out.println("5. Tim kiem khach hang theo ma");
            System.out.println("6. Thong ke khach hang cung ten");
            System.out.println("0. Quay lai");
            System.out.print("Chọn: ");
            chon=sc.nextInt();
            sc.nextLine();
        

            switch(chon){
                case 1: dskh.xuat(); break;
                case 2: themKhachHang(); break;
                case 3: 
                    System.out.print("Nhap ma khach hang can sua: ");
                    String ma = sc.nextLine();
                    dskh.suaTheoMa(ma); break;
                case 4: 
                    System.out.print("Nhap ma khach hang can xoa: ");
                    String ma1 = sc.nextLine();
                    dskh.xoaTheoMa(ma1); break;
                case 5:
                    System.out.print("Nhap ma khach hang can tim");
                    String ma3=sc.nextLine();
                    KhachHang kh=dskh.timTheoMa(ma3);
                    kh.xuatThongTin();
                    break;
                case 6:
                    dskh.thongKeCungTen();
                    break;
                case 0: 
                
                    break;
                default: System.out.println("Lua chon khong hop le");

            }
        } while(chon!=0);
        
    }

    public void themKhachHang() {
        System.out.println("=== Nhap khach hang moi ===");

        // 1. Nhập thông tin khách hàng
        KhachHang kh = new KhachHang();
        kh.nhap();

        // 2. Kiểm tra mã khách hàng trùng
        if (dskh.timTheoMa(kh.getMaKH()) != null) {
            System.out.println("Loi : khach hang nay da ton tai!");
            return;
        }

        // 3. Thêm vào danh sách
        dskh.them(kh);
        System.out.println("da them khach hang thanh cong!");
    }

}
