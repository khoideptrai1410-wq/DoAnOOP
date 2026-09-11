/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;

import com.mycompany.quanlysach.model.NhanVien;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DSNhanVien {
    NhanVien[] dsnv;
    int n;

    public DSNhanVien() {
        dsnv = new NhanVien[0];
        n = 0;
    }

    public DSNhanVien(NhanVien[] dsnv, int n) {
        this.n = n;
        this.dsnv = Arrays.copyOf(dsnv, n);
    }

    public DSNhanVien(DSNhanVien d) {
        this.n = d.n;
        this.dsnv = Arrays.copyOf(d.dsnv, d.n);
    }

    private Scanner sc = new Scanner(System.in);

    public void nhap() {
        System.out.println("Nhap so luong nhan vien: ");
        n = sc.nextInt();
        dsnv = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap nhan vien thu " + (i + 1) + ":");
            dsnv[i] = new NhanVien();
            dsnv[i].nhap();
        }
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            dsnv[i].xuat();
        }
    }

    // them mot nhan vien
    public void them() {
        dsnv = Arrays.copyOf(dsnv, n + 1);
        dsnv[n] = new NhanVien();
        System.out.println("Nhap thong tin nhan vien moi:");
        dsnv[n].nhap();
        n++;
    }

    // them 1 nhan vien vao danh sach
    public void them(NhanVien nv) {
        if (dsnv == null) {
            dsnv = new NhanVien[0];
            n = 0;
        }
        dsnv = Arrays.copyOf(dsnv, n + 1);
        dsnv[n] = nv;
        n++;
    }

    // sua thong tin theo ma
    public void suaTheoMa(String ma) {
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (dsnv[i].getMaNV().equals(ma)) {
                found = true;
                int chon;
                do {
                    System.out.println("\n=== SUA THONG TIN NHAN VIEN ===");
                    System.out.println("1. Sua ma nhan vien");
                    System.out.println("2. Sua ho");
                    System.out.println("3. Sua ten");
                    System.out.println("4. Sua so dien thoai");
                    System.out.println("5. Sua dia chi");
                    System.out.println("6. Sua email");
                    System.out.println("7. Sua luong thang");
                    System.out.println("0. Thoat");
                    System.out.print("Chon: ");
                    chon = sc.nextInt();
                    sc.nextLine();

                    switch (chon) {
                        case 1:
                            System.out.print("Nhap ma nhan vien moi: ");
                            dsnv[i].setMaNV(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap ho moi: ");
                            dsnv[i].setHo(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhap ten moi: ");
                            dsnv[i].setTen(sc.nextLine());
                            break;
                        case 4:
                            System.out.print("Nhap so dien thoai moi: ");
                            dsnv[i].setSdt(sc.nextLine());
                            break;
                        case 5:
                            System.out.print("Nhap dia chi moi: ");
                            dsnv[i].setDiaChi(sc.nextLine());
                            break;
                        case 6:
                            System.out.print("Nhap email moi: ");
                            dsnv[i].setEmail(sc.nextLine());
                            break;
                        case 7:
                            System.out.print("Nhap luong thang moi: ");
                            dsnv[i].setLuong(sc.nextInt());
                            sc.nextLine();
                            break;
                        case 0:
                            System.out.println("Thoat sua thong tin nhan vien.");
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                    }
                } while (chon != 0);
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay nhan vien co ma: " + ma);
        }
    }

    // xoa nhan vien theo ma
    public void xoaTheoMa(String ma) {
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (dsnv[i].getMaNV().equals(ma)) {
                for (int j = i; j < n - 1; j++) {
                    dsnv[j] = dsnv[j + 1];
                }
                n--;
                dsnv = Arrays.copyOf(dsnv, n);

                System.out.println("Da xoa nhan vien co ma: " + ma);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay nhan vien co ma: " + ma);
        }
    }

    // tim nhan vien theo ma
    public NhanVien timTheoMa(String ma) {
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getMaNV().equals(ma)) {
                return dsnv[i];
            }
        }
        return null;
    }

    // ghi file
    public void ghiFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/nhanvien.txt"))) {
            for (int i = 0; i < n; i++) {
                bw.write(dsnv[i].getMaNV() + "/" +
                         dsnv[i].getHo() + "/" +
                         dsnv[i].getTen() + "/" +
                         dsnv[i].getSdt() + "/" +
                         dsnv[i].getDiaChi() + "/" +
                         dsnv[i].getEmail() + "/" +
                         dsnv[i].getLuong());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    // doc file
    public void docFile() {
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("data/nhanvien.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("/");
                if (parts.length < 7) continue;

                NhanVien nv = new NhanVien();
                nv.setMaNV(parts[0].trim());
                nv.setHo(parts[1].trim());
                nv.setTen(parts[2].trim());
                nv.setSdt(parts[3].trim());
                nv.setDiaChi(parts[4].trim());
                nv.setEmail(parts[5].trim());
                nv.setLuong(Integer.parseInt(parts[6].trim()));

                if (dsnv.length == i) dsnv = Arrays.copyOf(dsnv, i + 1);
                dsnv[i++] = nv;
            }
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        } finally {
            n = i;
            dsnv = Arrays.copyOf(dsnv, n);
        }
    }

    // tim theo ten
    public void timTheoTen(String ten) {
        if (n == 0) {
            System.out.println("Danh sach nhan vien trong!");
            return;
        }

        boolean found = false;
        System.out.println("\n=== KET QUA TIM KIEM NHAN VIEN THEO TEN ===");
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getTen().toLowerCase().contains(ten.toLowerCase())) {
                dsnv[i].xuat();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay nhan vien nao co ten chua: " + ten);
        }
    }

    // thong ke luong tren 30 trieu
    public void thongKeLuongTren30Trieu() {
        if (n == 0) {
            System.out.println("Danh sach nhan vien trong!");
            return;
        }

        int dem = 0;
        System.out.println("\n=== DANH SACH NHAN VIEN CO LUONG TREN 30 TRIEU ===");
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getLuong() > 30000000) {
                dsnv[i].xuat();
                dem++;
            }
        }

        if (dem == 0) {
            System.out.println("Khong co nhan vien nao co luong tren 30 trieu.");
        } else {
            System.out.println("=> Tong so nhan vien co luong tren 30 trieu: " + dem);
        }
    }
}
