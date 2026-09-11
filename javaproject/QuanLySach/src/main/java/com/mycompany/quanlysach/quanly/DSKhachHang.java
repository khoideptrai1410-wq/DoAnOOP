/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;



import com.mycompany.quanlysach.model.KhachHang;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DSKhachHang {
    KhachHang[] dskh;
    int n;
    

    // Constructor mặc định
    public DSKhachHang() {
        dskh = new KhachHang[0];
        n = 0;
    }

    // Constructor từ mảng KhachHang
    public DSKhachHang(KhachHang[] kh, int m) {
        if (m > 0 && kh != null) {
            dskh = Arrays.copyOf(kh, m);
            n = m;
        } else {
            dskh = new KhachHang[0];
            n = 0;
        }
    }

    // Constructor sao chép
    public DSKhachHang(DSKhachHang d) {
        dskh = Arrays.copyOf(d.dskh, d.n);
        n = d.n;
    }
    private Scanner sc = new Scanner(System.in);

    // Nhập danh sách khách hàng
    public void nhap() {
        System.out.print("Nhap so luong khach hang: ");
        n = sc.nextInt();
        sc.nextLine();
        dskh = new KhachHang[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin khach hang thu " + (i + 1) + ":");
            dskh[i] = new KhachHang();
            dskh[i].nhap();
        }
    }

    // Xuất danh sách khách hàng
    public void xuat() {
        System.out.println("Danh sach khach hang:");
        for (int i = 0; i < n; i++) {
           
            dskh[i].xuat();
            
        }
    }

    // Thêm 1 khách hàng
    public void them() {
        dskh = Arrays.copyOf(dskh, n + 1);
        dskh[n] = new KhachHang();
        System.out.println("Nhap thong tin khach hang moi:");
        dskh[n].nhap();
        n++;
    }


    public void them(KhachHang kh) {
        if (dskh == null) {
            dskh = new KhachHang[0];
            n = 0;
        }
        dskh = Arrays.copyOf(dskh, n + 1);
        dskh[n] = kh;
        n++;
    }


    // Sửa thông tin khách hàng theo mã
   
public void suaTheoMa(String ma) {
   
    boolean found = false;

    for (int i = 0; i < n; i++) {
        if (dskh[i].getMaKH().equals(ma)) {
            found = true;
            int chon;
            do {
                System.out.println("\n**SUA THONG TIN KHACH HANG**");
                System.out.println("1. Sua ma khach hang.");
                System.out.println("2. Sua hoj khach hang.");
                System.out.println("3. Sua ten khach hang.");
                System.out.println("4. Sua so dien thoai khach hang.");
                System.out.println("5. Sua dia chi khach hang.");
                System.out.println("6. Sua email khach hang.");
                System.out.println("0. Thoát");
                System.out.print("chon: ");
                chon = sc.nextInt();
                sc.nextLine(); // bỏ dòng trong

                switch (chon) {
                    case 1:
                        System.out.print("Nhap ma moi: ");
                        dskh[i].setMaKH(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhap ho moi: ");
                        dskh[i].setHo(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Nhap ten moi: ");
                        dskh[i].setTen(sc.nextLine());
                        break;
                    case 4:
                        System.out.print("Nhap so dien thoai moi: ");
                        dskh[i].setSdt(sc.nextLine());
                        break;
                    case 5:
                        System.out.print("Nhap dia chi moi: ");
                        dskh[i].setEmail(sc.nextLine());
                        break;
                    case 6:
                        System.out.print("Nhap email moi:: ");
                        dskh[i].setEmail(sc.nextLine());
                        break;
                    case 0:
                        System.out.println("thoat..");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le.!");
                }
            } while (chon != 0);
            break;
        }
    }

    if (!found) {
        System.out.println("khong tim thay khach hang co ma: " + ma);
    }
}


    // xoa thoe ma co tham so 
    public void xoaTheoMa(String ma) {
       
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (dskh[i].getMaKH().equals(ma)) {
                for (int j = i; j < n - 1; j++) {
                    dskh[j] = dskh[j + 1];
                }
                dskh = Arrays.copyOf(dskh, n-1);
                                
                n--;

                System.out.println("da xoa khach hang co ma:: " + ma);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("khong tim thay khach  hang co ma :: " + ma);
        }
    }

    // tim khach hang theo ma
    public KhachHang timTheoMa(String ma) {
        
        for (int i = 0; i < n; i++) {
            if (dskh[i].getMaKH().equals(ma)) {
                return dskh[i];
            }
        }
        return null;
    }


    
    
    // Ghi file khachhang.txt theo định dạng / (mỗi KhachHang trên 1 dòng)
public void ghiFile() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/khachhang.txt"))) {
        for (int i = 0; i < n; i++) {
            // Ghi theo định dạng: maKH/ho/ten/sdt/diaChi/email
            bw.write(dskh[i].getMaKH() + "/" +
                     dskh[i].getHo() + "/" +
                     dskh[i].getTen() + "/" +
                     dskh[i].getSdt() + "/" +
                     dskh[i].getDiaChi() + "/" +
                     dskh[i].getEmail());
            bw.newLine(); // xuống dòng
        }
    } catch (IOException e) {
        System.out.println("Lỗi khi ghi file: " + e.getMessage());
    }
}

// Đọc file khachhang.txt theo định dạng / và lưu vào mảng dskh
public void docFile() {
    int i = 0;
    try (BufferedReader br = new BufferedReader(new FileReader("data/khachhang.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue; // bỏ dòng trống

            String[] parts = line.split("/"); // tách theo dấu /
            if (parts.length < 6) continue;   // dòng sai định dạng

            KhachHang kh = new KhachHang();
            kh.setMaKH(parts[0].trim());
            kh.setHo(parts[1].trim());
            kh.setTen(parts[2].trim());
            kh.setSdt(parts[3].trim());
            kh.setDiaChi(parts[4].trim());
            kh.setEmail(parts[5].trim());

            if (dskh.length == i) dskh = Arrays.copyOf(dskh, i + 1);
            dskh[i++] = kh;
        }
    } catch (IOException e) {
        System.out.println("Lỗi khi đọc file: " + e.getMessage());
    } finally {
        n = i;
        dskh = Arrays.copyOf(dskh, n); // cắt mảng vừa khít
    }
}


    public void timTheoTen(String ten) {
        if (n == 0) {
            System.out.println("danh sach khach hang trong.!");
            return;
        }

        boolean found = false;
        System.out.println("\n**KET QUA TIM KIEM THEO TEN**");
        for (int i = 0; i < n; i++) {
            if (dskh[i].getTen().toLowerCase().contains(ten.toLowerCase())) {
                dskh[i].xuat();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay khach hang co ten: " + ten);
        }
    }


    public void thongKeCungTen() {
        if (n == 0) {
            System.out.println("Danh sach trong!");
            return;
        }

        System.out.printf("| %-30s | %-8s |\n", "Ten khach hang", "So luong");
        System.out.println("|------------------------------|---------|");

        boolean[] dadem = new boolean[n]; // đánh dấu các họ đã thống kê
        boolean found=false;
        int count;
        for (int i = 0; i < n; i++) {
            if(dadem[i]){
                continue;
            }
           count=1;
           for(int j=i+1;j<n;j++){
               if(dskh[i].getTen().equalsIgnoreCase(dskh[j].getTen())){
                  dadem[j]=true;   
                  count++;
               }
           }
           if(count>1){
            System.out.printf("|%-30s |%-8d|\n",dskh[i].getTen(),count);
               System.out.println("|------------------------------|--------|");
            found=true;
           }
           
        }
        if(!found){
            System.out.println("khong co khach hang nao cung ten");
        }
    
    }
    
    
    




    

        

}
