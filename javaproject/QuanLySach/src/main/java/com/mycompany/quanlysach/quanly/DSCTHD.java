/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import com.mycompany.quanlysach.model.ChiTietHoaDon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DSCTHD {
    ChiTietHoaDon[] dsct;
    int n;

    public DSCTHD() {
        dsct = new ChiTietHoaDon[0];
        n = 0;
    }

    public DSCTHD(ChiTietHoaDon[] ct, int m) {
        if (m > 0 && ct != null) {
            dsct = Arrays.copyOf(ct, m);
            n = m;
        } else {
            dsct = new ChiTietHoaDon[0];
            n = 0;
        }
    }

    // Constructor sao chep
    public DSCTHD(DSCTHD d) {
        dsct = Arrays.copyOf(d.dsct, d.n);
        n = d.n;
    }

    private Scanner sc = new Scanner(System.in);

    // Nhap danh sach chi tiet hoa don
    public void nhap() {
        System.out.print("Nhap so luong chi tiet hoa don: ");
        n = sc.nextInt();
        sc.nextLine();
        dsct = new ChiTietHoaDon[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap chi tiet hoa don thu " + (i + 1) + ":");
            dsct[i] = new ChiTietHoaDon();
            dsct[i].nhap();
        }
    }

    // Xuat danh sach chi tiet hoa don
    public void xuat() {
        System.out.println("Danh sach chi tiet hoa don:");
        for (int i = 0; i < n; i++) {
            dsct[i].xuat();
        }
    }

    public void xoaTheoMa(String mahd) {
        if (n == 0) return;

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (!dsct[i].getMaHD().equals(mahd)) {
                dsct[j++] = dsct[i];
            }
        }
        if (j < n) {
            System.out.println("Da xoa " + (n - j) + " chi tiet cua hoa don: " + mahd);
        } else {
            System.out.println("Khong tim thay chi tiet nao de xoa!");
        }
        n = j;
        dsct = Arrays.copyOf(dsct, n);
    }

    public void suaTheoMa(String ma) {
        int start = -1;
        int count = 0;
        System.out.println("Danh sach chi tiet hoa don co ma " + ma);
        for (int i = 0; i < n; i++) {
            if (dsct[i].getMaHD().equals(ma)) {
                if (start == -1) start = i;
                dsct[i].xuat();
                count++;
            }
        }

        if (start == -1) {
            System.out.println("Khong tim thay ma hoa don: " + ma);
            return;
        }

        System.out.println("Ban muon sua chi tiet thu may?");
        System.out.print("Nhap: ");
        int luachon = sc.nextInt();
        sc.nextLine();
        if (luachon < 1 || luachon > count) {
            System.out.println("Lua chon khong hop le!");
            return;
        }

        int index = start + luachon - 1;

        int chon;
        do {
            System.out.println("1. Sua ma sach");
            System.out.println("2. Sua so luong");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    System.out.print("Nhap ma sach moi: ");
                    String masachmoi = sc.nextLine();
                    dsct[index].setMaSach(masachmoi);
                    break;
                case 2:
                    System.out.print("Nhap so luong moi: ");
                    int slmoi = sc.nextInt();
                    sc.nextLine();
                    dsct[index].setSoLuong(slmoi);
                    double ttmoi1 = dsct[index].getDonGia() * slmoi;
                    dsct[index].setThanhTien(ttmoi1);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }

    public ChiTietHoaDon[] timTheoMa(String ma) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dsct[i].getMaHD().equals(ma)) count++;
        }

        if (count == 0) return null;

        ChiTietHoaDon[] kq = new ChiTietHoaDon[count];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (dsct[i].getMaHD().equals(ma)) {
                kq[j++] = dsct[i];
            }
        }
        return kq;
    }

    public void them(ChiTietHoaDon ct) {
        if (dsct == null) {
            dsct = new ChiTietHoaDon[0];
            n = 0;
        }
        dsct = Arrays.copyOf(dsct, n + 1);
        dsct[n] = ct;
        n++;
    }

    // Ghi file ct_hd.txt
    public void ghiFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/ct_hd.txt"))) {
            for (int i = 0; i < n; i++) {
                bw.write(dsct[i].getMaHD() + "/" +
                         dsct[i].getMaSach() + "/" +
                         dsct[i].getSoLuong() + "/" +
                         dsct[i].getDonGia() + "/" +
                         dsct[i].getThanhTien());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    // Doc file ct_hd.txt
    public void docFile() {
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("data/ct_hd.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("/");
                if (parts.length < 5) continue;

                ChiTietHoaDon ct = new ChiTietHoaDon();
                ct.setMaHD(parts[0].trim());
                ct.setMaSach(parts[1].trim());
                ct.setSoLuong(Integer.parseInt(parts[2].trim()));
                ct.setDonGia(Double.parseDouble(parts[3].trim()));
                ct.setThanhTien(Double.parseDouble(parts[4].trim()));

                if (dsct.length == i) dsct = Arrays.copyOf(dsct, i + 1);
                dsct[i++] = ct;
            }
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        } finally {
            n = i;
            dsct = Arrays.copyOf(dsct, n);
        }
    }

    public void xuatCacChiTiet() {
        System.out.print("Nhap ma hoa don can xem chi tiet: ");
        String mahd = sc.nextLine();

        System.out.println("=== Chi tiet hoa don: " + mahd + " ===");
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (dsct[i].getMaHD().equals(mahd)) {
                dsct[i].xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay chi tiet nao thuoc hoa don nay!");
        }
    }

    public void capNhatMaHD(String maCu, String maMoi) {
        for (int i = 0; i < n; i++) {
            if (dsct[i].getMaHD().equals(maCu)) {
                dsct[i].setMaHD(maMoi);
            }
        }
    }
}
