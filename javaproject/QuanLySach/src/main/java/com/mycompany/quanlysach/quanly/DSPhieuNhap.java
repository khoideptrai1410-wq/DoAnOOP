/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;



import com.mycompany.quanlysach.model.PhieuNhap;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Scanner;

public class DSPhieuNhap {
    PhieuNhap[] dspnh;
    int n;
    

    // Constructor mặc định
    public DSPhieuNhap() {
        dspnh = new PhieuNhap[0];
        n = 0;
    }

    // Constructor từ mảng PhieuNhap
    public DSPhieuNhap(PhieuNhap[] pnh, int m) {
        if (m > 0 && pnh != null) {
            dspnh = Arrays.copyOf(pnh, m);
            n = m;
        } else {
            dspnh = new PhieuNhap[0];
            n = 0;
        }
    }

    // Constructor sao chép
    public DSPhieuNhap(DSPhieuNhap d) {
        dspnh = Arrays.copyOf(d.dspnh, d.n);
        n = d.n;
    }
  
    // Nhập danh sách phiếu nhập hàng
    public void nhap() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phieu nhap: ");
        n = sc.nextInt();
        sc.nextLine();
        dspnh = new PhieuNhap[n];
        for (int i = 0; i < n; i++) {
            System.out.println("phieu nhap thu : " + (i + 1) + ":");
            dspnh[i] = new PhieuNhap();
            dspnh[i].nhap();
        }
    }

    // Xuất danh sách phiếu nhập hàng
    public void xuat() {
        System.out.println("Danh sach phieu nhap:");
        for (int i = 0; i < n; i++) {
           
            dspnh[i].xuat();
            
        }
    }

   // them 1 phieu nhap
    public void them() throws ParseException {
        dspnh = Arrays.copyOf(dspnh, n + 1);
        dspnh[n] = new PhieuNhap();
        System.out.println("Nhap phieu nhap moi:");
        dspnh[n].nhap();
        n++;
    }


    
    public void them(PhieuNhap pn) {
        if (dspnh == null) {  // nếu mảng chưa khởi tạo
            dspnh = new PhieuNhap[0];
            n = 0;
        }

        // Mở rộng mảng thêm 1 phần tử
        dspnh = Arrays.copyOf(dspnh, n + 1);

        // Thêm phần tử
        dspnh[n] = pn;
        n++;
    }


    // Sửa phiếu nhập hàng theo mã
   public void suaTheoMa(String ma) throws ParseException {
    Scanner sc = new Scanner(System.in);
    boolean found = false;

    for (int i = 0; i < n; i++) {
        if (dspnh[i].getNgayNhap().equals(ma)) {
            found = true;
            int chon;
            do {
                System.out.println("\n====sua thong tin phieu nhap====");
                System.out.println("1. Sua ma phieu nhap");
                System.out.println("2. Sua ma nhan vien");
                System.out.println("3. Sua ma nha cung cap");
                System.out.println("4. Sua ngay nhap ");
                System.out.println("0. Thoát");
                System.out.print("Chọn: ");
                chon = sc.nextInt();
                sc.nextLine(); // bỏ dòng thừa

                switch (chon) {
                    case 1:
                        System.out.print("Nhap ma phieu nhap moi: ");
                        dspnh[i].setMaPN(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhap ma nhan vien moi: ");
                        dspnh[i].setMaNV(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Nhap ma nha cung cap moi: ");
                        dspnh[i].setMaNCC(sc.nextLine());
                        break;
                    case 4:
                        System.out.print("Nhap ngay laop (yyyy/MM/dd): ");
                            String ngay = sc.nextLine();
                        dspnh[i].setNgayNhap(ngay);
                        break;
                    case 0:
                        System.out.println("Thoat.");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } while (chon != 0);
            break;
        }
    }

    if (!found) {
        System.out.println("Khong tim thay ma phieu:: " + ma);
    }
}

   

        // Xóa phiếu nhập hàng theo mã
        public void xoaTheoMa(String mapn) {
          
            boolean found = false;

            for (int i = 0; i < n; i++) {
                if (dspnh[i].getMaPN().equals(mapn)) {
                    for (int j = i; j < n - 1; j++) {
                        dspnh[j] = dspnh[j + 1];
                    }
                    n--;
                    dspnh = Arrays.copyOf(dspnh, n);
                    System.out.println("da xoa phieu nhap co ma:: " + mapn);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Khong tim thay phieu nhap co ma: " + mapn);
            }
        }

    // Tìm phiếu nhập hàng theo mã
    public PhieuNhap timTheoMa(String ma) {
        
        for (int i = 0; i < n; i++) {
            if (dspnh[i].getMaPN().equals(ma)) {
                return dspnh[i];
            }
        }

       return null;
    }

    
  
    // Ghi file phieunhaphang.txt theo định dạng / (mỗi PhieuNhap trên 1 dòng)
public void ghiFile() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/phieunhaphang.txt"))) {
        for (int i = 0; i < n; i++) {
            // Ghi theo định dạng: maPN/maNV/maNCC/ngayNhap/tongTien
            bw.write(dspnh[i].getMaPN() + "/" +
                     dspnh[i].getMaNV() + "/" +
                     dspnh[i].getMaNCC() + "/" +
                     dspnh[i].getNgayNhapString() + "/" +
                     dspnh[i].getTongTien());
            bw.newLine(); // xuống dòng
        }
    } catch (IOException e) {
        System.out.println("Lỗi khi ghi file: " + e.getMessage());
    }
}

// Đọc file phieunhaphang.txt theo định dạng / và lưu vào mảng dspnh
public void docFile() throws ParseException {
    int i = 0;
    try (BufferedReader br = new BufferedReader(new FileReader("data/phieunhaphang.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue; // bỏ dòng trống

            String[] parts = line.split("/"); // tách theo dấu /
            if (parts.length < 5) continue;   // dòng sai định dạng

            PhieuNhap pn = new PhieuNhap();
            pn.setMaPN(parts[0].trim());
            pn.setMaNV(parts[1].trim());
            pn.setMaNCC(parts[2].trim());
            pn.setNgayNhap(parts[3].trim()); // hoặc parse Date nếu cần
            pn.setTongTien(Double.parseDouble(parts[4].trim()));

            if (dspnh.length == i) dspnh = Arrays.copyOf(dspnh, i + 1);
            dspnh[i++] = pn;
        }
    } catch (IOException e) {
        System.out.println("Lỗi khi đọc file: " + e.getMessage());
    } finally {
        n = i;
        dspnh = Arrays.copyOf(dspnh, n); // cắt mảng vừa khít
    }
}


  public void thongKeTongTienTheoNam() {
    if (n == 0) {
        System.out.println("Danh sach phieu nhap trong!");
        return;
    }

    boolean[] daDem = new boolean[n]; // đánh dấu phiếu nhập đã thống kê năm
    System.out.println("\n=== THONG KE TONG TIEN THEO NAM ===");

    for (int i = 0; i < n; i++) {
        if (daDem[i]) continue;

        // Lấy năm của phiếu i
        LocalDate date = dspnh[i].getNgayNhap().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int namHienTai = date.getYear();  // sửa tên biến
        double tongTien = dspnh[i].getTongTien();

        for (int j = i + 1; j < n; j++) {
            LocalDate dateJ = dspnh[j].getNgayNhap().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (dateJ.getYear() == namHienTai) { // so sánh với cùng năm
                tongTien += dspnh[j].getTongTien();
                daDem[j] = true;
            }
        }

        System.out.printf("Nam: %d | Tong tien: %.2f\n", namHienTai, tongTien);
    }
}

}

  
    





