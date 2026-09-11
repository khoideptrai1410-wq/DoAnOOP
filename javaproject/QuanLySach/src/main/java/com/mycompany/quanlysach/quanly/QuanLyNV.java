/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;



import com.mycompany.quanlysach.model.NhanVien;
import java.util.Scanner;

public class QuanLyNV extends QuanLy{
    private Scanner sc=new Scanner(System.in);
    @Override
    public void menuChinh(){
       
           
        int chon;
    
        do{
            System.out.println("\n====QUAN LY NHAN VIEN====");
            System.out.println("1. Xuat danh sach nhan vien");
            System.out.println("2. Them nhan vien");
            System.out.println("3. Sua nhan vien");
            System.out.println("4. Xoa nhan vien");
            System.out.println("5. Tim nhan vien theo ten");
            System.out.println("6. Thong ke nhan vien co luong tren 30tr");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            chon=sc.nextInt();
            sc.nextLine();
        

            switch(chon){
                case 1: dsnv.xuat(); break;
                case 2: themNhanVien(); break;
                case 3: 
                    System.out.print("Nhap ma nhan vien can sua: ");
                    String ma1 = sc.nextLine();
                    dsnv.suaTheoMa(ma1); break;
                case 4: 
                    System.out.print("Nhap ma nhan vien can xoa: ");
                    String ma2 = sc.nextLine();
                    dsnv.xoaTheoMa(ma2); break;
                case 5:
                    System.out.print("Nhap ma nhan vien can tim");
                    String ten1=sc.nextLine();
                    dsnv.timTheoTen(ten1);
                    break;

                case 6:
                    dsnv.thongKeLuongTren30Trieu();
                    break;
                case 0: 
                  

                    break;
                default: System.out.println("Lua chon khong hop le|");

            }
        } while(chon!=0);

    }

    public void themNhanVien() {
        System.out.println("=== Nhập nhân viên mới ===");

        // 1. Nhập thông tin nhân viên
        NhanVien nv = new NhanVien();
        nv.nhap();

        // 2. Kiểm tra mã nhân viên trùng
        if (dsnv.timTheoMa(nv.getMaNV()) != null) {
            System.out.println("Lỗi: Mã nhân viên này đã tồn tại!");
            return;
        }

        // 3. Thêm vào danh sách
        dsnv.them(nv);
        System.out.println("Đã thêm nhân viên thành công!");
    }

}

