/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;


import java.util.Scanner;

public class QuanLyThongKe extends QuanLy{
    private Scanner sc=new Scanner(System.in);
    @Override
     public void menuChinh(){
        int chon;
        do{
            System.out.println("====MENU THONG KE=====");
            System.out.println("1. Thong Ke Tong Tien Hoa Don Tu Ngay A--->NgayB");
            System.out.println("2. Thong Ke Thu Chi va Loi Nhuan Theo Quy");
            System.out.println("3. Thong Ke Tong Tien Hoa Don Cua Khach Hang Theo Quy");
            System.out.println("4. Thong Ke Nhan Vien Theo Hoa Don ");
            System.out.println( "0. Quay lai");
            System.out.println("Chon: ");
            chon=sc.nextInt();
            sc.nextLine();

            ThongKe tk=new ThongKe();

            switch (chon) {
                case 1: tk.thongKeHoaDonTheoNgay(); break;
                case 2: tk.thongKeThuChiTheoQuy(); break;
                case 3: tk.thongKeHoaDonTheoKhachHang(); break;
                case 4: tk.thongKeHoaDonTheoNhanVien(); break;
                case 0: break;
                default:
                  System.out.println("Lua chon khong hop le");
            }
        } while(chon!=0);
    }

   
}
