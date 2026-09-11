/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;




import java.io.IOException;
import com.mycompany.quanlysach.model.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


import java.util.Arrays;
import java.util.Scanner;

public class DSSach {
    private Sach[] ds;
    private int soLuong;

    public DSSach() {
        ds = new Sach[0];
        soLuong = 0;
    }
     public DSSach(Sach[] ds, int n) {
        this.soLuong = n;
        this.ds = Arrays.copyOf(ds, n);
    }

    // ================== NHẬP DANH SÁCH SÁCH ==================
    public void nhapSach() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sach: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
          System.out.println("\n=== Sach thu " + (i + 1) + " ===");
       
          System.out.println("1. Sach giao khoa");
          System.out.println("2. Sach tham khao");
          System.out.print("Chon loai sach: ");
          int loai = Integer.parseInt(sc.nextLine());

           Sach s;
           switch (loai) {
            case 1 -> s = new SachGiaoKhoa();
            case 2 -> s = new SachThamKhao();
            default -> {
                System.out.println("Loai khong hop le, mac dinh: Sach giao khoa");
                s = new SachGiaoKhoa();
            }
            }
            s.nhapSach();
            while (timTheoMa(s.getID_Sach()) != null) {
                 System.out.println(" Ma sach da ton tai! Vui long nhap lai ma khac!");
                 System.out.print("Nhap lai ma sach: ");
                 String maMoi = sc.nextLine();
                s.setID_Sach(maMoi);
            }

        ds = Arrays.copyOf(ds, soLuong + 1);
        ds[soLuong++] = s;
        System.out.println(" Da them sach thanh cong!\n");
        }

    System.out.println("=== Da nhap " + n + " quyen sach thanh cong! ===");
    }

    public Sach nhap1Sach(){
    Scanner sc = new Scanner(System.in);
    System.out.println("1. Sach giao khoa");
    System.out.println("2. Sach tham khao");
    System.out.print("Chon loai sach: ");
    int loai = sc.nextInt();
    sc.nextLine();

    Sach s;
    switch(loai){
        case 1 -> s = new SachGiaoKhoa();
        case 2 -> s = new SachThamKhao();
        default -> {
            System.out.println("Lua chon khong hop le, mac dinh: Sach giao khoa");
            s = new SachGiaoKhoa();
        }
    }
    s.nhapSach();
    return s;
    }

    
    public void them(Sach s) {
        ds = Arrays.copyOf(ds, soLuong + 1);
        ds[soLuong] = s;
        soLuong++;
    }
     public void xuatDS() {
        if (soLuong == 0)
            System.out.println("Danh sach trong!");
        else
            for (int i=0;i<soLuong;i++)
                ds[i].xuat();
    }

    public int getSoLuong() {
        return soLuong;
    }
    public void suaSach() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach can sua: ");
        String ma = sc.nextLine();
        Sach s = timTheoMa(ma);

        if (s == null) {
            System.out.println("Khong tim thay ma sach nay!");
            return;
        }

        int chon;
        do {
            System.out.println("\n=== MENU SUA THONG TIN SACH ===");
            System.out.println("1. Sua ten sach");
            System.out.println("2. Sua don gia");
            System.out.println("3. Sua so luong ton");
            System.out.println("4. Sua nam xuat ban");
            System.out.println("5. Xem thong tin hien tai");
            System.out.println("0. Thoat sua");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1 -> {
                    System.out.print("Nhap ten moi: ");
                    s.setTenSach(sc.nextLine());
                    System.out.println("Da cap nhat ten sach.");
                }
                case 2 -> {
                    System.out.print("Nhap don gia moi: ");
                    s.setDonGia(sc.nextInt());
                    System.out.println("✅ Da cap nhat don gia.");
                }
                case 3 -> {
                    System.out.print("Nhap so luong ton moi: ");
                    s.setSoLuongTon(Integer.parseInt(sc.nextLine()));
                    System.out.println("✅ Da cap nhat so luong ton.");
                }
                case 4 -> {
                    System.out.print("Nhap nam xuat ban moi: ");
                    s.setetNamXB(Integer.parseInt(sc.nextLine()));
                    System.out.println(" Da cap nhat nam xuat ban.");
                }
                case 5 -> s.xuat();
                case 0 -> System.out.println("Thoat sua.");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }
    public void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach muon xoa: ");
        String maSach = sc.nextLine();

        int vtr = -1;
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getID_Sach().equalsIgnoreCase(maSach)) {
                vtr = i;
                break;
            }
        }

        if (vtr != -1) {
            for (int i = vtr; i < soLuong - 1; i++)
                ds[i] = ds[i + 1];
            ds = Arrays.copyOf(ds, --soLuong);
            System.out.println(" Da xoa sach thanh cong.");
        } else {
            System.out.println(" Khong tim thay ma sach ban muon xoa!");
        }
    }
      public void xoaTheoMa(String ma) {
        boolean found = false;

        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getID_Sach().equals(ma)) {
                // Dịch chuyển các phần tử phía sau lên trước
                for (int j = i; j < soLuong - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                soLuong--;
                ds = Arrays.copyOf(ds, soLuong);

                System.out.println("da xoa sach co ma: " + ma);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay sach co ma: " + ma);
        }
    }

    public void timKiemTheoMa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach ban muon tim: ");
        String maSach = sc.nextLine();

        Sach s = timTheoMa(maSach);
        if (s == null) System.out.println(" Khong tim thay sach!");
        else s.xuat();
    }

    public void timKiemTheoTen() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten sach ban muon tim: ");
        String tenSach = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getTenSach().toLowerCase().contains(tenSach.toLowerCase())) {
                ds[i].xuat();
                found = true;
            }
        }
        if (!found) System.out.println(" Khong tim thay ten sach nay!");
    }

    public Sach timTheoMa(String ma) {
        for (int i = 0; i < soLuong; i++)
            if (ds[i].getID_Sach().equalsIgnoreCase(ma))
                return ds[i];
        return null;
    }
    public boolean capNhatSoLuong(String maSach, int soLuongThem) {
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getID_Sach().equalsIgnoreCase(maSach)) {
                ds[i].setSoLuongTon(ds[i].getSoLuongTon() + soLuongThem);
                return true;
            }
        }
        return false;
    }
    public void thongKeTonKho() {
        int tong = 0;
        for (int i = 0; i < soLuong; i++)
            tong += ds[i].getSoLuongTon();
        System.out.println("Tong so luong ton kho: " + tong);
    }
   
   
   
    
   

   public void docFile() {
    int i = 0; // số lượng sách thực tế
    try (BufferedReader br = new BufferedReader(new FileReader("data/sach.txt"))) {
        String line;

        // Nếu mảng rỗng, tạo mảng ban đầu 1 phần tử để tránh lỗi
        if (ds == null || ds.length == 0) ds = new Sach[1];

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue; // bỏ dòng trống

            String[] parts = line.split("/");
            if (parts.length < 11) continue; // dòng sai định dạng, bỏ qua

            int mahieu;
            try {
                mahieu = Integer.parseInt(parts[0].trim());
            } catch (NumberFormatException e) {
                continue; // nếu không phải số, bỏ qua dòng
            }

            Sach s;
            if (mahieu == 1) s = new SachGiaoKhoa();
            else if (mahieu == 2) s = new SachThamKhao();
            else continue; // bỏ dòng sai loại

            // Gán các thuộc tính chung
            s.setID_Sach(parts[1].trim());
            s.setTenSach(parts[2].trim());
            s.setDonGia(Double.parseDouble(parts[3].trim()));
            s.setSoLuongTon(Integer.parseInt(parts[4].trim()));
            s.setetNamXB(Integer.parseInt(parts[5].trim()));
            s.setMaTacGia(parts[6].trim());
            s.setMaNhaXB(parts[7].trim());
            s.setMaTheLoai(parts[8].trim());

            // Gán thuộc tính riêng
            if (mahieu == 1) {
                ((SachGiaoKhoa) s).setMonHoc(parts[9].trim());
                ((SachGiaoKhoa) s).setCapHoc(parts[10].trim());
            } else if (mahieu == 2) {
                ((SachThamKhao) s).setTrinhDo(parts[9].trim());
                ((SachThamKhao) s).setLinhVuc(parts[10].trim());
            }

            // Mở rộng mảng nếu đầy
            if (i == ds.length) ds = Arrays.copyOf(ds, (ds.length == 0 ? 1 : ds.length * 2));

            ds[i++] = s;
        }
    } catch (IOException e) {
        System.out.println("Lỗi khi đọc file: " + e.getMessage());
    } finally {
        soLuong = i;
        ds = Arrays.copyOf(ds, soLuong); // cắt mảng vừa khít
    }
}


    // Ghi file sach.txt theo định dạng / (mỗi sách trên 1 dòng)
public void ghiFile() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/sach.txt"))) {
        for (int i = 0; i < soLuong; i++) {
            StringBuilder sb = new StringBuilder();
            
            if (ds[i] instanceof SachGiaoKhoa) {
                sb.append("1"); // đánh dấu giao khoa
                sb.append("/").append(ds[i].getID_Sach())
                  .append("/").append(ds[i].getTenSach())
                  .append("/").append(ds[i].getDonGia())
                  .append("/").append(ds[i].getSoLuongTon())
                  .append("/").append(ds[i].getNamXB())
                  .append("/").append(ds[i].getMaTacGia())
                  .append("/").append(ds[i].getMaNhaXB())
                  .append("/").append(ds[i].getMaTheLoai())
                  .append("/").append(((SachGiaoKhoa) ds[i]).getMonHoc())
                  .append("/").append(((SachGiaoKhoa) ds[i]).getCapHoc());
            } else if (ds[i] instanceof SachThamKhao) {
                sb.append("2"); // đánh dấu tham khảo
                sb.append("/").append(ds[i].getID_Sach())
                  .append("/").append(ds[i].getTenSach())
                  .append("/").append(ds[i].getDonGia())
                  .append("/").append(ds[i].getSoLuongTon())
                  .append("/").append(ds[i].getNamXB())
                  .append("/").append(ds[i].getMaTacGia())
                  .append("/").append(ds[i].getMaNhaXB())
                  .append("/").append(ds[i].getMaTheLoai())
                  .append("/").append(((SachThamKhao) ds[i]).getTrinhDo())
                  .append("/").append(((SachThamKhao) ds[i]).getLinhVuc());
            }
            
            bw.write(sb.toString());
            bw.newLine(); // xuống dòng
        }
    } catch (IOException e) {
        System.out.println("Loi khi ghi file: " + e.getMessage());
    }
}


    
    
    
    
    
    
    

    public void thongKeLoaiSach() {
    int demGiaoKhoa = 0;
    int demThamKhao = 0;

    for (int i = 0; i < soLuong; i++) {
        if (ds[i] instanceof SachGiaoKhoa) demGiaoKhoa++;
        else if (ds[i] instanceof SachThamKhao) demThamKhao++;
    }

    System.out.println("\n===== THONG KE LOAI SACH =====");
    System.out.println("Tong so sach: " + soLuong);
    System.out.println("Sach giao khoa: " + demGiaoKhoa);
    System.out.println("Sach tham khao: " + demThamKhao);
    System.out.println("-------------------------------");
}



    
    
    
}
