/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;



import com.mycompany.quanlysach.model.TheLoai;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DSTheLoai {
    private TheLoai[] dstl;
    private int soLuong;

    public DSTheLoai() {
        dstl = new TheLoai[0];
        soLuong = 0;
    }

   
    public void nhapTheLoai() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong the loai muon nhap: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nThe loai thu " + (i + 1) + ":");

            String maTL;
            while (true) {
                System.out.print("Nhap ma the loai: ");
                maTL = sc.nextLine();
                if (timTheoMa(maTL) != null) {
                    System.out.println("Ma the loai da ton tai! Vui long nhap lai.");
                } else break;
            }

            TheLoai tl = new TheLoai();
            tl.nhap(); 
            tl.setMaTL(maTL);
            them(tl);

            System.out.println("✅ Da them the loai thanh cong!");
        }
    }

    public void them(TheLoai tl) {
        dstl = Arrays.copyOf(dstl, soLuong + 1);
        dstl[soLuong] = tl;
        soLuong++;
    }

 
    public TheLoai timTheoMa(String ma) {
        for (int i=0;i<soLuong;i++)
            if (dstl[i].getMaTL().equalsIgnoreCase(ma))
                return dstl[i];
        return null;
    }

  
    
    public void timTheoTen(String ten) {
        boolean found = false;
        for (int i=0;i<soLuong;i++) {
            if (dstl[i].getTen().toLowerCase().contains(ten.toLowerCase())) {
                System.out.println("Ma: " + dstl[i].getMaTL() + " | Ten: " + dstl[i].getTen());
                found = true;
            }
        }
        if (!found) System.out.println("Khong tim thay the loai co ten " + ten);
    }
    
    public void xoaTheoMa(String ma) {
       
        boolean found = false;

        for (int i = 0; i < soLuong; i++) {
            if (dstl[i].getMaTL().equals(ma)) {
               
                for (int j = i; j < soLuong - 1; j++) {
                    dstl[j] = dstl[j + 1];
                }
                soLuong--;
               
                dstl = Arrays.copyOf(dstl, soLuong);

                System.out.println("Da xoa the loai co ma: " + ma);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay the loai co ma: " + ma);
        }
       
    }
    
    public void suaTheLoai() {
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhap ma the loai can sua: ");
        String ma =sc.nextLine();
        TheLoai tl= timTheoMa(ma);
        if (tl == null) {
            System.out.println("Khong tim thay the loai!");
            return;
        }

        int chon;
        do {
            System.out.println("\n--- MENU SUA THE LOAI ---");
            System.out.println("1. Sua ma the loai");
            System.out.println("2. Sua ten the loai");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> {
                    System.out.print("Nhap ma moi: ");
                    String maMoi = sc.nextLine();
                    if (!maMoi.isEmpty() && timTheoMa(maMoi) == null) tl.setMaTL(maMoi);
                }
                case 2 -> {
                    System.out.print("Nhap ten moi: ");
                    String tenMoi = sc.nextLine();
                    if (!tenMoi.isEmpty()) tl.setTen(tenMoi);
                }
                case 0 -> System.out.println("Thoat menu sua.");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }

    // ================= XUAT DANH SACH =================
    public void xuatDS() {
        if (soLuong == 0) System.out.println("Danh sach the loai rong!");
        for (int i=0;i<soLuong;i++){
            dstl[i].xuat();
        }
           
    }

    public int getSoLuong() { return soLuong; }
    
    
    
    // Ghi file theloai.txt theo định dạng / (mỗi thể loại trên 1 dòng)
public void ghiFile() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/theloai.txt"))) {
        for (int i = 0; i < soLuong; i++) {
            // Ghi theo định dạng: maTL/ten
            bw.write(dstl[i].getMaTL() + "/" + dstl[i].getTen());
            bw.newLine(); // xuống dòng
        }
    } catch (IOException e) {
        System.out.println("Lỗi khi ghi file: " + e.getMessage());
    }
}

// Đọc file theloai.txt theo định dạng / và lưu vào mảng dstl
public void docFile() {
    int i = 0;
    try (BufferedReader br = new BufferedReader(new FileReader("data/theloai.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue; // bỏ dòng trống

            String[] parts = line.split("/"); // tách theo dấu /
            if (parts.length < 2) continue;   // dòng sai định dạng

            TheLoai tl = new TheLoai();
            tl.setMaTL(parts[0].trim());
            tl.setTen(parts[1].trim());

            if (dstl.length == i) dstl = Arrays.copyOf(dstl, i + 1);
            dstl[i++] = tl;
        }
    } catch (IOException e) {
        System.out.println("Lỗi khi đọc file: " + e.getMessage());
    } finally {
        soLuong = i;
        dstl = Arrays.copyOf(dstl, soLuong); // cắt mảng vừa khít
    }
}

    
    
      
  public void thongKeTLTuDien() {
    int dem = 0; // Biến đếm số sách từ điển

    for (int i = 0; i < soLuong; i++) {
        // Kiểm tra xem tên sách có chứa "từ điển" không
        if (dstl[i].getTen().toLowerCase().contains("Van Hoc")) {
            dem++;
        }
    }

    System.out.println("Số lượng sách thuộc thể loại 'Van Hoc' là: " + dem);
}

   }
   
   
   
   

