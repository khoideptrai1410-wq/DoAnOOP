/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;



import com.mycompany.quanlysach.model.NhaCungCap;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DSNhaCungCap {
    NhaCungCap[] dsncc;
    int n;
    
    // Constructor mặc định
    public DSNhaCungCap() {
        dsncc = new NhaCungCap[0];
        n = 0;
    }

    // Constructor từ mảng NhaCungCap
    public DSNhaCungCap(NhaCungCap[] ncc, int m) {
        if (m > 0 && ncc != null) {
            dsncc = Arrays.copyOf(ncc, m);
            n = m;
        } else {
            dsncc = new NhaCungCap[0];
            n = 0;
        }
    }

    // Constructor sao chép
    public DSNhaCungCap(DSNhaCungCap d) {
        dsncc = Arrays.copyOf(d.dsncc, d.n);
        n = d.n;
    }
    private Scanner sc = new Scanner(System.in);

    // Nhập danh sách nhà cung cấp
    public void nhap() {
        System.out.print("nhap so luong ncc: ");
        n = sc.nextInt();
        sc.nextLine();
        dsncc = new NhaCungCap[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap ncc thu: " + (i + 1) + ":");
            dsncc[i] = new NhaCungCap();
            dsncc[i].nhap();
        }
    }

    // Xuất danh sách nhà cung cấp
    public void xuat() {
        System.out.println("Danh sach ncc:");
        for (int i = 0; i < n; i++) {
            
            dsncc[i].xuat();
        }
    }

    // Thêm 1 nhà cung cấp
    public void them() {
        dsncc = Arrays.copyOf(dsncc, n + 1);
        dsncc[n] = new NhaCungCap();
        System.out.println("Nhap thong tin ncc :");
        dsncc[n].nhap();
        n++;
    }

    // Thêm 1 nhà cung cấp vào danh sách
    public void them(NhaCungCap ncc) {
        
        dsncc = Arrays.copyOf(dsncc, n + 1);
        dsncc[n] = ncc;
        n++;
    }


    // Sửa nhà cung cấp theo mã
   
    public void suaTheoMa(String ma) {
   
        boolean found = false;

        for (int i = 0; i < n; i++) {
             if (dsncc[i].getMaNCC().equals(ma)) {
                 found = true;
                int chon;
           
                 do {
                     System.out.println("\n=== SUA THONG TIN NHA CUNG CAP ===");
                      System.out.println("1. Sua ma nha cung cap");
                      System.out.println("2. Sua ten nha cung cap");
                      System.out.println("3. Sua so dien thoai");
                     System.out.println("4. Sua email");
                     System.out.println("5. Sua dia chi");
                      System.out.println("0. Thoat");
                     System.out.print("Chon: ");
                     chon = sc.nextInt();
                      sc.nextLine(); // bo dong trong

                     switch (chon) {
                     case 1:
                         System.out.print("Nhap ma moi: ");
                         dsncc[i].setMaNCC(sc.nextLine());
                         break;
                     case 2:
                         System.out.print("Nhap ten moi: ");
                          dsncc[i].setTen(sc.nextLine());
                         break;
                     case 3:
                         System.out.print("Nhap so dien thoai moi: ");
                         dsncc[i].setSDT(sc.nextLine());
                         break;
                     case 4:
                         System.out.print("Nhap email moi: ");
                         dsncc[i].setEmail(sc.nextLine());
                         break;
                     case 5:
                         System.out.print("Nhap dia chi moi: ");
                         dsncc[i].setDiaChi(sc.nextLine());
                         break;
                     case 0:
                        System.out.println("Thoat sua thong tin nha cung cap.");
                        break;
                   default:
                        System.out.println("Lua chon khong hop le!");
                    }
                } while (chon != 0);
                  break;

            }
    }

    if (!found) {
        System.out.println("Khong tim thay nha cung cap co ma: " + ma);
    }
}


    // Xóa nhà cung cấp theo mã
    public void xoaTheoMa(String ma) {
       
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (dsncc[i].getMaNCC().equals(ma)) {
                for (int j = i; j < n - 1; j++) {
                    dsncc[j] = dsncc[j + 1];
                }
                n--;
                dsncc = Arrays.copyOf(dsncc, n);
                System.out.println("da xoa nha cung cap co ma: " + ma);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay nha cung cap co ma: " + ma);
        }
    }

    // Tìm nhà cung cấp theo mã
    public NhaCungCap timTheoMa(String ma) {
        
        for (int i = 0; i < n; i++) {
            if (dsncc[i].getMaNCC().equals(ma)) {
                return dsncc[i];
            }
        }
        return null;
        
    }

    

 
    // Ghi file nhacungcap.txt theo định dạng / (mỗi NhaCungCap trên 1 dòng)
public void ghiFile() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/nhacungcap.txt"))) {
        for (int i = 0; i < n; i++) {
            // Ghi theo định dạng: maNCC/ten/SDT/email/diaChi
            bw.write(dsncc[i].getMaNCC() + "/" +
                     dsncc[i].getTen() + "/" +
                     dsncc[i].getSDT() + "/" +
                     dsncc[i].getEmail() + "/" +
                     dsncc[i].getDiaChi());
            bw.newLine(); // xuống dòng
        }
    } catch (IOException e) {
        System.out.println("Loi ghi file: " + e.getMessage());
    }
}

// Đọc file nhacungcap.txt theo định dạng / và lưu vào mảng dsncc
public void docFile() {
    int i = 0;
    try (BufferedReader br = new BufferedReader(new FileReader("data/nhacungcap.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue; // bỏ dòng trống

            String[] parts = line.split("/"); // tách theo dấu /
            if (parts.length < 5) continue;   // dòng sai định dạng

            NhaCungCap ncc = new NhaCungCap();
            ncc.setMaNCC(parts[0].trim());
            ncc.setTen(parts[1].trim());
            ncc.setSDT(parts[2].trim());
            ncc.setEmail(parts[3].trim());
            ncc.setDiaChi(parts[4].trim());

            if (dsncc.length == i) dsncc = Arrays.copyOf(dsncc, i + 1);
            dsncc[i++] = ncc;
        }
    } catch (IOException e) {
        System.out.println("Loi doc file: " + e.getMessage());
    } finally {
        n = i;
        dsncc = Arrays.copyOf(dsncc, n); // cắt mảng vừa khít
    }
}


    // 1. Tìm kiếm nhà cung cấp theo tên
public void timTheoTen(String ten) {
    if (n == 0) {
        System.out.println("Danh sach nha cung cap trong!");
        return;
    }

    boolean found = false;
    System.out.println("\n=== KET QUA TIM KIEM NCC THEO TEN ===");
    for (int i = 0; i < n; i++) {
        if (dsncc[i].getTen().toLowerCase().contains(ten.toLowerCase())) {
            dsncc[i].xuat();
            found = true;
        }
    }

    if (!found) {
        System.out.println("Khong tim thay nha cung cap co ten: " + ten);
    }
}

    
    public void thongKeNCC_HCM() {
    if (n == 0) {
        System.out.println("Danh sach trong!");
        return;
    }

    int dem = 0;
    System.out.println("\n**DANH SACH NXB O TP HO CHI MINH**");
    for (int i = 0; i < n; i++) {
       
        if (dsncc[i].getDiaChi().toLowerCase().contains("HCM".toLowerCase()) || dsncc[i].getDiaChi().toLowerCase().contains("Ho Chi Minh".toLowerCase())) {
            dsncc[i].xuat();
            dem++;
        }
    }

    if (dem == 0) {
        System.out.println("Khong co NXB nao o TP HO CHI MINH.");
    } else {
        System.out.println("Tong NXB: " + dem);
    }
    }


}
