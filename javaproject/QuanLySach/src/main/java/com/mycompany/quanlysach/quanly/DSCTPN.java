/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;

import com.mycompany.quanlysach.model.ChiTietPhieuNhap;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DSCTPN {
    ChiTietPhieuNhap[] dsct;
    int n;

    public DSCTPN() {  
        dsct = new ChiTietPhieuNhap[0];
        n = 0;
    }

    public DSCTPN(ChiTietPhieuNhap[] ct, int m) {
        if (m > 0 && ct != null) {
            dsct = Arrays.copyOf(ct, m);
            n = m;
        } else {
            dsct = new ChiTietPhieuNhap[0];
            n = 0;
        }
    }

    public DSCTPN(DSCTPN d) {
        dsct = Arrays.copyOf(d.dsct, d.n);
        n = d.n;
    }

    private Scanner sc = new Scanner(System.in);

    public void nhap() {
        System.out.print("Nhap so luong chi tiet phieu nhap hang: ");
        n = sc.nextInt();
        sc.nextLine();
        dsct = new ChiTietPhieuNhap[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap chi tiet phieu nhap hang thu " + (i + 1) + ":");
            dsct[i] = new ChiTietPhieuNhap();
            dsct[i].nhap();
        }
    }

    public void xuat() {
        System.out.println("Danh sach chi tiet phieu nhap hang:");
        for (int i = 0; i < n; i++) {
            dsct[i].xuat();
        }
    }

    public void them1(ChiTietPhieuNhap ct) {
        if (dsct == null) {
            dsct = new ChiTietPhieuNhap[0];
            n = 0;
        }
        dsct = Arrays.copyOf(dsct, n + 1);
        dsct[n] = ct;
        n++;
    }

    public void xoaTheoMa(String mapnh) {
        if (n == 0) return;
        
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (!dsct[i].getMaPN().equals(mapnh)) {
                dsct[j++] = dsct[i];
            }
        }
        if (j < n) {
            System.out.println("Da xoa " + (n - j) + " chi tiet cua phieu nhap: " + mapnh);
        } else {
            System.out.println("Khong tim thay chi tiet nao de xoa!");
        }
        n = j;
        dsct = Arrays.copyOf(dsct, n);
    }

    public ChiTietPhieuNhap[] timTheoMa(String ma) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dsct[i].getMaPN().equals(ma)) count++;
        }

        if (count == 0) return null;

        ChiTietPhieuNhap[] kq = new ChiTietPhieuNhap[count];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (dsct[i].getMaPN().equals(ma)) {
                kq[j] = dsct[i];
                j++;
            }
        }
        return kq;
    }

    public void suaTheoMa(String ma) {
        int start = -1;
        int count = 0;
        System.out.println("Danh sach chi tiet phieu nhap hang co ma " + ma);
        for (int i = 0; i < n; i++) {
            if (dsct[i].getMaPN().equals(ma)) {
                if (start == -1) start = i;
                dsct[i].xuat();
                count++;
            }
        }

        if (start == -1) {
            System.out.println("Khong tim thay ma phieu nhap hang: " + ma);
            return;
        }

        System.out.println("Ban muon sua chi tiet thu may?");
        System.out.println("Nhap: ");
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
            System.out.println("3. Sua don gia");
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
                case 3:
                    System.out.print("Nhap don gia moi: ");
                    double dgmoi = sc.nextDouble();
                    sc.nextLine();
                    dsct[index].setDonGia(dgmoi);
                    double ttmoi2 = dgmoi * dsct[index].getSoLuong();
                    dsct[index].setThanhTien(ttmoi2);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }

    public void ghiFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/ct_pnh.txt"))) {
            for (int i = 0; i < n; i++) {
                bw.write(dsct[i].getMaPN() + "/" +
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

    public void docFile() {
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("data/ct_pnh.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("/");
                if (parts.length < 5) continue;

                ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
                ct.setMaPN(parts[0].trim());
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

    public void xuatCTTheoMa() {
        System.out.print("Nhap ma phieu nhap hang can xem chi tiet: ");
        String ma = sc.nextLine();

        System.out.println("=== Chi tiet phieu nhap hang: " + ma + " ===");
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (dsct[i].getMaPN().equals(ma)) {
                dsct[i].xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay chi tiet nao thuoc phieu nhap hang nay!");
        }
    }

    public void capNhatMaPNH(String maCu, String maMoi) {
        for (int i = 0; i < n; i++) {
            if (dsct[i].getMaPN().equals(maCu)) {
                dsct[i].setMaPN(maMoi);
            }
        }
    }
}
