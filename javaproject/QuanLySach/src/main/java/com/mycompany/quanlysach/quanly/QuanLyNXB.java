/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.mycompany.quanlysach.model.NhaXuatBan;
import java.util.Scanner;

public class QuanLyNXB extends QuanLy{
    private Scanner sc=new Scanner(System.in);
    @Override
     public void menuChinh(){
        
        int chon;
        
        do{
            System.out.println("\n====QUAN LY NHA XUAT BAN====");
            System.out.println("1. Xuat danh sach nha xuat ban");
            System.out.println("2. Them nha xuat ban");
            System.out.println("3. Sua nha xuat ban");
            System.out.println("4. Xoa nha xuat ban");
            System.out.println("5. Tim kiem nha xuat ban theo ten");
            System.out.println("6. Thong ke nha xuat ban o TP.HCM");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            chon=sc.nextInt();
            sc.nextLine();
        

            switch(chon){
                case 1: dsnxb.xuat(); break;
                case 2: themNXB(); break;
                case 3: 
                    System.out.print("Nhap ma nha xuat ban can sua: ");
                    String ma1 = sc.nextLine();
                    dsnxb.suaTheoMa(ma1); break;
                case 4: 
                    System.out.print("Nhap ma nha xuat ban can xoa : ");
                    String ma2 = sc.nextLine();
                    dsnxb.xoaTheoMa(ma2); break;
                case 5:
                    System.out.print("Nhap ten nha xuat ban can tim");
                    String ten1=sc.nextLine();
                    dsnxb.timTheoTen(ten1);
                    break;

                case 6: dsnxb.thongKeNXB_HCM();
                case 0: 
                   

                    break;
                default: System.out.println("Lua chon khong hop le");

            }
        } while(chon!=0);
        
    }
    public void themNXB() {
        System.out.println("=== NHAP NHA XUAT BAN MOI ===");

        // 1. Nhập thông tin NXB
        NhaXuatBan nxb = new NhaXuatBan();
        nxb.nhap();

        // 2. Kiểm tra mã NXB trùng
        if (dsnxb.timTheoMa(nxb.getMaNhaXuatBan()) != null) {
            System.out.println("Loi: nha xuat ban nay da toon tai!");
            return;
        }

        // 3. Thêm vào danh sách
        dsnxb.them(nxb);
        System.out.println("da them nha xuat ban thanh cong!");
    }

}
