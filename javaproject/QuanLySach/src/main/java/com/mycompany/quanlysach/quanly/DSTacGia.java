/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;

import com.mycompany.quanlysach.model.TacGia;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DSTacGia {
    TacGia[] dstg;
    int n;

    public DSTacGia() {
        dstg = new TacGia[0];
        n = 0;
    }

    public DSTacGia(TacGia[] tg, int m) {
        if (m > 0 && tg != null) {
            this.dstg = Arrays.copyOf(tg, m);
            this.n = m;
        } else {
            this.dstg = new TacGia[0];
            this.n = 0;
        }
    }

    public DSTacGia(DSTacGia d) {
        this.dstg = Arrays.copyOf(d.dstg, d.n);
        this.n = d.n;
    }

    private Scanner sc = new Scanner(System.in);

    public void nhap() {
        System.out.print("Nhap so luong tac gia: ");
        n = sc.nextInt();
        sc.nextLine();
        dstg = new TacGia[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin tac gia thu " + (i + 1) + ":");
            dstg[i] = new TacGia();
            dstg[i].nhap();
        }
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            dstg[i].xuat();
        }
    }

    // Them mot tac gia
    public void them() {
        dstg = Arrays.copyOf(dstg, n + 1);
        dstg[n] = new TacGia();
        System.out.println("Nhap thong tin tac gia moi:");
        dstg[n].nhap();
        n++;
    }

    public void them(TacGia tg) {
        if (dstg == null) {
            dstg = new TacGia[0];
            n = 0;
        }
        dstg = Arrays.copyOf(dstg, n + 1);
        dstg[n] = tg;
        n++;
    }

    // Sua thong tin theo ma
    public void suaTheoMa(String ma) {
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (dstg[i].getMaTG().equals(ma)) {
                found = true;
                int chon;

                do {
                    System.out.println("\n=== MENU SUA THONG TIN TAC GIA ===");
                    System.out.println("1. Sua ma tac gia");
                    System.out.println("2. Sua ten tac gia");
                    System.out.println("0. Thoat");
                    System.out.print("Chon thuoc tinh muon sua: ");
                    chon = sc.nextInt();
                    sc.nextLine();

                    switch (chon) {
                        case 1:
                            System.out.print("Nhap ma tac gia moi: ");
                            dstg[i].setMaTG(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap ten tac gia moi: ");
                            dstg[i].setTen(sc.nextLine());
                            break;
                        case 0:
                            System.out.println("Thoat khoi che do sua.");
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                    }
                } while (chon != 0);

                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay tac gia co ma: " + ma);
        }
    }

    // Xoa tac gia theo ma
    public void xoaTheoMa(String ma) {
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (dstg[i].getMaTG().equals(ma)) {
                for (int j = i; j < n - 1; j++) {
                    dstg[j] = dstg[j + 1];
                }
                n--;
                dstg = Arrays.copyOf(dstg, n);
                System.out.println("Da xoa tac gia co ma: " + ma);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay tac gia co ma: " + ma);
        }
    }

    // Tim tac gia theo ma
    public TacGia timTheoMa(String ma) {
        for (int i = 0; i < n; i++) {
            if (dstg[i].getMaTG().equals(ma)) {
                return dstg[i];
            }
        }
        return null;
    }

    // Ghi file tacgia.txt theo dinh dang /
    public void ghiFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/tacgia.txt"))) {
            for (int i = 0; i < n; i++) {
                bw.write(dstg[i].getMaTG() + "/" + dstg[i].getTen());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    // Doc file tacgia.txt theo dinh dang /
    public void docFile() {
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("data/tacgia.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split("/");
                if (parts.length < 2) continue;

                TacGia tg = new TacGia();
                tg.setMaTG(parts[0].trim());
                tg.setTen(parts[1].trim());
                tg.setNamsinh(Integer.parseInt(parts[2].trim()));
                tg.setQuoctich(parts[3].trim());

                if (dstg.length == i) dstg = Arrays.copyOf(dstg, i + 1);
                dstg[i++] = tg;
            }
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        } finally {
            n = i;
            dstg = Arrays.copyOf(dstg, n);
        }
    }

    // Tim tac gia theo ten
    public void timTheoTen(String ten) {
        boolean found = false;
        System.out.println("\n=== KET QUA TIM KIEM TAC GIA THEO TEN: " + ten + " ===");
        for (int i = 0; i < n; i++) {
            if (dstg[i].getTen().toLowerCase().contains(ten.toLowerCase())) {
                dstg[i].xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay tac gia co ten: " + ten);
        }
    }

    public void thongKeTG_VN() {
        int dem = 0;
        for (int i = 0; i < n; i++) {
            if (dstg[i].getQuoctich().equals("Viet Nam")) {
                dstg[i].xuat();
                dem++;
            }
        }
        System.out.println("So tac gia Viet Nam: " + dem);
    }
}
