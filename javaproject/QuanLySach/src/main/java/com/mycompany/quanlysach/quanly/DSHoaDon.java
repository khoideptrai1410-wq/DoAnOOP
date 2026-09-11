/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;



import com.mycompany.quanlysach.model.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class DSHoaDon {
    HoaDon[] dshd;
    int n;

   

    public DSHoaDon() {
        dshd = new HoaDon[0];
        n = 0;
    }

    public DSHoaDon(HoaDon[] hd, int m) {
        if (m > 0 && hd != null) {
            dshd = Arrays.copyOf(hd, m);
            n = m;
        } else {
            dshd = new HoaDon[0];
            n = 0;
        }
    }

    // Constructor sao chép
    public DSHoaDon(DSHoaDon d) {
        dshd = Arrays.copyOf(d.dshd, d.n);
        n = d.n;
    }

     private Scanner sc = new Scanner(System.in);

    // Nhập danh sách hóa đơn
    public void nhap() throws ParseException {
        System.out.print("Nhap so luong hoa don: ");
        n = sc.nextInt();
        sc.nextLine();
        dshd = new HoaDon[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin hoa don thu " + (i + 1) + ":");
            dshd[i] = new HoaDon();
            dshd[i].nhap();
        }
    }

    public void xuat() {
        System.out.println("Danh sach hoa don:");
        for (int i = 0; i < n; i++) {
            
            dshd[i].xuat();
         
        }
    }

    // Thêm 1 hóa đơn
    public void them() throws ParseException {
        dshd = Arrays.copyOf(dshd, n + 1);
        dshd[n] = new HoaDon();
        System.out.println("Nhap thong tin hoa don moi:");
        dshd[n].nhap();
        n++;
    }


   public void them(HoaDon hd) {
        if (dshd == null) {
            dshd = new HoaDon[0];
            n = 0;
        }
        dshd = Arrays.copyOf(dshd, n + 1);
        dshd[n] = hd;
        n++;
    }

    public void suaTheoMa(String ma) throws ParseException {
      
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (dshd[i].getMaHD().equals(ma)) {
                found = true;
                int chon;
                do {
                    System.out.println("\n--Sua thong tin hoa don--");
                    System.out.println("1. Sua ma hoa don");
                    System.out.println("2. Sua ngay lap (dd/mm/yyyy)");
                    System.out.println("3. Sua ma khach hang");
                    System.out.println("4. Sua ma nhan vien");
                    System.out.println("0. Thoat");
                    System.out.print("Chọn: ");
                    chon = sc.nextInt();
                    sc.nextLine(); 

                    switch (chon) {
                        case 1:
                            System.out.print("Nhap ma hoa don moi ");
                            String ma1=sc.nextLine();
                            dshd[i].setMaHD(ma1);
                            break;
                        case 2:
                            System.out.print("Nhap ngay laop (dd/mm/yyyy): ");
                            String ngay = sc.nextLine();
                            dshd[i].setNgayBan(ngay);
                            break;
                        case 3:
                            System.out.print("Nhap ma khach hang moi: ");
                            dshd[i].setMaKH(sc.nextLine());
                            break;
                        case 4:
                            System.out.print("Nhap ma nhan vien moi: ");
                            dshd[i].setMaNV(sc.nextLine());
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
            System.out.println("khong tim thay hoa don co ma: " + ma);
        }
    }


    public void xoaTheoMa(String ma) {
       
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (dshd[i].getMaHD().equals(ma)) {
                for (int j = i; j < n - 1; j++) {
                    dshd[j] = dshd[j + 1];
                }
                n--;
                dshd = Arrays.copyOf(dshd, n);
                System.out.println("da xoa ma hoa don co ma: " + ma);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay ma hoa don co ma:: " + ma);
        }
    }

    // Tìm hóa đơn theo mã
    public HoaDon timTheoMa(String ma) {
        
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMaHD().equals(ma)) {
                return dshd[i];
            }
        }

       return null;
    }

    
    

    // Ghi file hoadon.txt theo định dạng / (mỗi HoaDon trên 1 dòng)
public void ghiFile() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/hoadon.txt"))) {
        for (int i = 0; i < n; i++) {
            // Ghi theo định dạng: maHD/ngayBan/tongTien/maKH/maNV
            bw.write(dshd[i].getMaHD() + "/" +
                     dshd[i].getNgayBanString() + "/" +
                     dshd[i].getTongTien() + "/" +
                     dshd[i].getMaKH() + "/" +
                     dshd[i].getMaNV());
            bw.newLine(); // xuống dòng
        }
    } catch (IOException e) {
        System.out.println("Lỗi khi ghi file: " + e.getMessage());
    }
}

// Đọc file hoadon.txt theo định dạng / và lưu vào mảng dshd
public void docFile() throws ParseException {
    int i = 0;
    try (BufferedReader br = new BufferedReader(new FileReader("data/hoadon.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue; // bỏ dòng trống

            String[] parts = line.split("/"); // tách theo dấu /
            if (parts.length < 5) continue;   // dòng sai định dạng

            HoaDon hd = new HoaDon();
            hd.setMaHD(parts[0].trim());
            hd.setNgayBan(parts[1].trim()); // hoặc parse Date nếu cần
            hd.setTongTien(Double.parseDouble(parts[2].trim()));
            hd.setMaKH(parts[3].trim());
            hd.setMaNV(parts[4].trim());

            if (dshd.length == i) dshd = Arrays.copyOf(dshd, i + 1);
            dshd[i++] = hd;
        }
    } catch (IOException e) {
        System.out.println("Loi khi doc file: " + e.getMessage());
    } finally {
        n = i;
        dshd = Arrays.copyOf(dshd, n); // cắt mảng vừa khít
    }
}

    
    public void thongKeDoanhThu() {
    double tongDoanhThu = 0;

    for (int i = 0; i < n; i++) {
        tongDoanhThu += dshd[i].getTongTien();
    }

    System.out.println("=== THONG KE DOANH THU ===");
    System.out.println("→ Tong doanh thu: " + tongDoanhThu + " VND");
}

  
    
















































//tinh tong tien 4quy cua nam x
    public void tong4quy(){
        System.out.println("nhap nam muon tinh:");
        Scanner sc=new Scanner(System.in);
        int nam= sc.nextInt();
        double q1=0,q2=0,q3=0,q4=0;
        DateTimeFormatter Formater= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for(int i=0;i<n;i++){
            LocalDate ngay = LocalDate.parse(dshd[i].getNgayBanString(), Formater);
            if(ngay.getYear()==nam){
                switch (ngay.getMonthValue()){
                    case 1: case 2: case 3: q1+=dshd[i].getTongTien();
                    case 4: case 5: case 6: q2+=dshd[i].getTongTien();
                    case 7: case 8: case 9: q3+=dshd[i].getTongTien();
                    case 10: case 11: case 12: q4+=dshd[i].getTongTien();
                }
            }
        }
        System.out.println("tong q1:"+q1+" |  q2: "+q2+"|    q3:"+q3+"|   q4:"+q4);
    }
    

    


}
