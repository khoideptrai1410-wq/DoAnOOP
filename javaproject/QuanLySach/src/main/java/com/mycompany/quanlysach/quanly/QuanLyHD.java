/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;



import java.util.Scanner;
import com.mycompany.quanlysach.model.HoaDon;
import com.mycompany.quanlysach.model.ChiTietHoaDon;
import java.text.ParseException;

public class QuanLyHD extends QuanLy {
    private Scanner sc=new Scanner(System.in);
    // === MENU HÓA ĐƠN ===
    @Override
    public void menuChinh() {
       
        int chon;
        
        do {
            System.out.println("\n==== QUAN LY HOA DON====");
            System.out.println("1. Xuat Danh Sach Hoa Don");
            System.out.println("2. Them Hoa Don-Chi Tiet Hoa Don");
            System.out.println("3. Sua hoa don");
            System.out.println("4. Xoa hoa don");
            System.out.println("5. Xuat danh sach chi tiet hoa don");
            System.out.println("6. Xuat chi tiet theo ma");
            System.out.println("7. Thong ke tong tien");
            System.out.println("8. Cap nhat lai ma o phan chi tiet hoa don");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1: dshd.xuat(); break;
                case 2: {
                    try {
                        menuThem();
                    } catch (ParseException ex) {
                        System.getLogger(QuanLyHD.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                }
                    break;

                case 3: 
                    System.out.print("nhap ma hoa don can sua: ");
                    String ma = sc.nextLine();
                {
                    try {
                        dshd.suaTheoMa(ma);
                    } catch (ParseException ex) {
                        System.getLogger(QuanLyHD.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                }
                    break;

                case 4: 
                    System.out.print("Nhap ma hoa don can xoa: ");
                    String ma2 = sc.nextLine();
                    ChiTietHoaDon[] ct=dsct_hd.timTheoMa(ma2);
                    for(int i=0;i<ct.length;i++){
                        dssach.capNhatSoLuong(ct[i].getMaSach(), ct[i].getSoLuong());
                    }
                    dshd.xoaTheoMa(ma2);
                    dsct_hd.xoaTheoMa(ma2);
                    break;
                case 5: dsct_hd.xuat(); break;
                case 6: 
                    
                    dsct_hd.xuatCacChiTiet();
                    ; break;
                case 7:  dshd.thongKeDoanhThu();break;
                case 8: 
                    System.out.println("Nhap ma hoa don da sua: ");
                    String macu=sc.nextLine();
                    System.out.println("Nhap ma hoa don moi");
                    String mamoi=sc.nextLine();
                    dsct_hd.capNhatMaHD(macu, mamoi);
                    break;
                case 0: 
                    break;
                default: System.out.println("Lua chon khong hop le !");
            }
        } while (chon != 0);
        
    }

    public void menuThem() throws ParseException {
       
        int chon;

        do {
            System.out.println("\n===== MENU THÊM =====");
            System.out.println("1. Them hoa don moi");
            System.out.println("2. Themc chi tiet hoa don da co");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            chon = sc.nextInt();
            sc.nextLine(); // bỏ dòng thừa

            switch (chon) {
                case 1: themHoaDon(); break;
                case 2: 
                   
                    themChiTietHD();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le vui long nhap lai!");
            }
        } while (chon != 0);
    }

     public void themHoaDon() throws ParseException {
        HoaDon hd = new HoaDon();
        hd.nhap(); 

        if (dshd.timTheoMa(hd.getMaHD()) != null) {
            System.out.println("ma hoa don da ton tai!");
            return;
        }
        // Kiểm tra ràng buộc
        if (dskh.timTheoMa(hd.getMaKH()) == null) {
            System.out.println("Khach hang khong ton tai. hay them khach hang o quan ly khach hang.");
            return;
        }
        if (dsnv.timTheoMa(hd.getMaNV()) == null) {
            System.out.println("Nhan vien khong ton tai. hay them nhan vien o quan ly khach hang..");
            return;
        }

        // Nhập chi tiết hóa đơn
        System.out.print("Nhap so luong chi tiet hoa don: ");
        int soLuongCT = sc.nextInt();
        sc.nextLine();

        double tong = 0;
        for (int i = 0; i < soLuongCT; i++) {
            System.out.println("\n→ Nhap chi tiet thu " + (i + 1) + ":");
            ChiTietHoaDon ct = new ChiTietHoaDon();
            ct.setMaHD(hd.getMaHD());
            ct.nhap();

            if (dssach.timTheoMa(ct.getMaSach()) == null) {
                System.out.println("Ma sach khong ton tai. nhap lai!");
                continue;
            }

            // Cập nhật giá + số lượng tồn
            ct.setDonGia(dssach.timTheoMa(ct.getMaSach()).getDonGia());
            dssach.capNhatSoLuong(ct.getMaSach(), -ct.getSoLuong());

            tong += ct.getThanhTien();
            dsct_hd.them(ct);
        }

        hd.setTongTien(tong);
        dshd.them(hd);
        System.out.println("Them hoa don thanh cong!");
    }

    public void themChiTietHD() {
        System.out.print("Nhap ma hoa don ma ban muon them : ");
        String maHD = sc.nextLine();

        if (dshd.timTheoMa(maHD) == null) {
            System.out.println("Hoa DOn khhong ton tai");
            return;
        }

        ChiTietHoaDon ct = new ChiTietHoaDon();
        ct.setMaHD(maHD);
        ct.nhap();

        if (dssach.timTheoMa(ct.getMaSach()) == null) {
            System.out.println(" ma sach khong ton tai..");
            return;
        }

        ct.setDonGia(dssach.timTheoMa(ct.getMaSach()).getDonGia());
        dssach.capNhatSoLuong(ct.getMaSach(), -ct.getSoLuong());
        dsct_hd.them(ct);

        // Cập nhật tổng tiền hóa đơn
        HoaDon hd = dshd.timTheoMa(maHD);
        if (hd != null) {
            hd.setTongTien(hd.getTongTien() + ct.getThanhTien());
        }

        System.out.println("Them chi tiet hoa don thanh cong!");
    }

   

  
}
