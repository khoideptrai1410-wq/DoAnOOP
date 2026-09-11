/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;



import com.mycompany.quanlysach.model.PhieuNhap;
import com.mycompany.quanlysach.model.ChiTietPhieuNhap;
import java.text.ParseException;
import java.util.Scanner;

public class QuanLyPN extends QuanLy{
    private Scanner sc=new Scanner(System.in);
      // === MENU PHIẾU NHẬP ===
    @Override
    public void menuChinh() {
      
       
        int chon;
        
        do {
            System.out.println("\n====QUAN LY PHIEU NHAP ====");
            System.out.println("1. Xuat danh sach phieu nhap");
            System.out.println("2. Them chi tiet phieu nhap _ctpn");
            System.out.println("3. Sua phieu nhap");
            System.out.println("4. Xoa phieu nhap");
            System.out.println("5. Xuat danh sach chi tiet phieu nhaop hang");
            System.out.println("6. Xuat chi tiet theo ma");
            System.out.println("7. Thong ke tong tien");
            System.out.println("8. Cap nhat lai ma chi tiet phieu nhap hang");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1: dspnh.xuat(); break;
                case 2: {
                    try {
                        menuThem();
                    } catch (ParseException ex) {
                        System.getLogger(QuanLyPN.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                }
                break;

                case 3: 
                    System.out.print("Nhap ma phieu nhap can sua: ");
                    String ma1 = sc.nextLine();
                {
                    try {
                        dspnh.suaTheoMa(ma1);
                    } catch (ParseException ex) {
                        System.getLogger(QuanLyPN.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                }
                break;

                case 4: 
                    System.out.print("Nhap ma phieu nhap hang can xoa: ");
                    String ma2 = sc.nextLine();
                    ChiTietPhieuNhap[] ct=dsct_pnh.timTheoMa(ma2);
                    for(int i=0;i<ct.length;i++){
                        dssach.capNhatSoLuong(ct[i].getMaSach(), -ct[i].getSoLuong());
                    }
                    dspnh.xoaTheoMa(ma2); 
                    dsct_pnh.xoaTheoMa(ma2);
                    break;
                case 5: dsct_pnh.xuat(); break;
                case 6: dsct_pnh.xuatCTTheoMa(); break;
                case 7: dspnh.thongKeTongTienTheoNam(); break;
                case 8:
                    System.out.println("Nhap ma phieu nhap da sua: ");
                    String macu=sc.nextLine();
                    System.out.println("Nhap ma phieu nhap moi");
                    String mamoi=sc.nextLine();
                    dsct_pnh.capNhatMaPNH(macu, mamoi);
                    break;
                case 0:  

                    break;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
        
    }

    public void menuThem() throws ParseException {
       
        int chon;

        do {
            System.out.println("\n===== MENU THEM =====");
            System.out.println("1. Them phieu nhap hang moi");
            System.out.println("2. Them chi tiet phieu nhap da co");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine(); // bỏ dòng thừa

            switch (chon) {
                case 1: themPhieuNhap(); break;
                case 2: 
                  themChiTietPNH(); break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai!");
            }
        } while (chon != 0);
    }

    public void themPhieuNhap() throws ParseException {
        PhieuNhap pnh = new PhieuNhap();
        pnh.nhap();

        // Kiểm tra phiếu trùng
        if (dspnh.timTheoMa(pnh.getMaPN()) != null) {
            System.out.println(" Ma phieu nhap da ton tai!");
            return;
        }

        // Kiểm tra nhân viên và nhà cung cấp
        if (dsnv.timTheoMa(pnh.getMaNV()) == null) {
            System.out.println("Nhan vien khong ton tai. vui long nhap them nhan vien o quan ly nhan vien.");
            return;
        }
        if (dsncc.timTheoMa(pnh.getMaNCC()) == null) {
            System.out.println("Nha cung cap khong ton tai . vui long nhap them nha cung cap o quan ly nha cung cap .");
            return;
        }

        // Nhập chi tiết phiếu nhập
        System.out.print("Nhap so luong chi tiet phieu: ");
        int soLuongCT = sc.nextInt();
        sc.nextLine();

        double tong = 0;
        for (int i = 0; i < soLuongCT; i++) {
            System.out.println("\n→ Nhap chi tiet phieu thu " + (i + 1) + ":");
            ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
            ct.setMaPN(pnh.getMaPN());
            ct.nhap();

            // Kiểm tra tồn tại sách
            if (dssach.timTheoMa(ct.getMaSach()) == null) {
                System.out.println("Ma sach khong ton tai . vui long nhap them sach moi. va bo qua chi tiet nay!");
                continue;
            }

            // Cập nhật tồn kho
            dssach.capNhatSoLuong(ct.getMaSach(), ct.getSoLuong());

            tong += ct.getThanhTien();
            dsct_pnh.them1(ct);
        }

        pnh.setTongTien(tong);
        dspnh.them(pnh);
        System.out.println(" Them phieu nhap thanh cong!");
    }

     public void themChiTietPNH() {
        System.out.print("Nhap ma phieu muon them chi tiet ");
        String maPNH = sc.nextLine();

        PhieuNhap pnh = dspnh.timTheoMa(maPNH);
        if (pnh == null) {
            System.out.println(" Phieu nhap khong ton tai!");
            return;
        }

        ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
        ct.setMaPN(maPNH);
        ct.nhap();

        if (dssach.timTheoMa(ct.getMaSach()) == null) {
            System.out.println(" Ma sach khong ton tai vui long them o quan ly sach.");
            return;
        }

        // Cập nhật tồn kho
        dssach.capNhatSoLuong(ct.getMaSach(), ct.getSoLuong());

        dsct_pnh.them1(ct);

        // Cập nhật tổng tiền phiếu nhập
        pnh.setTongTien(pnh.getTongTien() + ct.getThanhTien());

        System.out.println(" Them chi tiet phieu nhap thanh cong!");
    }



}


