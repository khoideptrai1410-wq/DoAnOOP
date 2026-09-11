/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;


import com.mycompany.quanlysach.model.NhaXuatBan;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class DSNXB {
    NhaXuatBan[] dsnxb;
    int n;

    public DSNXB(){
        dsnxb=new NhaXuatBan[0];
        n=0;
    }

    public DSNXB(NhaXuatBan[] nxb,int n){
        if(n>0&&nxb!=null){
            this.dsnxb=Arrays.copyOf(nxb, n);
            this.n=n;
        }
        else {
            this.dsnxb=new NhaXuatBan[0];
            this.n=0;
        }
    }
    public DSNXB(DSNXB d){
        
        this.dsnxb=Arrays.copyOf(d.dsnxb, d.n);
        this.n=d.n;
       
    }
    
    private Scanner sc = new Scanner(System.in);

    public void nhap(){
        System.out.print("Nhap so luong nha xuat ban :: ");
        n=sc.nextInt();
        sc.nextLine();
        dsnxb=new NhaXuatBan[n];
        for(int i=0;i<n;i++){
            System.out.println("Nhap thong tin NXB thu: "+(i+1)+":");
            dsnxb[i]=new NhaXuatBan();
            dsnxb[i].nhap();
        }
    }

    public void xuat(){
        System.out.println("Danh sach NXB::");
        for(int i=0;i<n;i++){
           
            dsnxb[i].xuat();
           
        }
    }

    //them mot nxb
    public void them(){
        dsnxb = Arrays.copyOf(dsnxb, n + 1);
        dsnxb[n] = new NhaXuatBan();
        System.out.println("Nhap thong tin NXB moi.:");
        dsnxb[n].nhap();
        n++;
    }

    // Thêm 1 NhaXuatBan vào danh sách
    public void them(NhaXuatBan nxb) {
     
        dsnxb = Arrays.copyOf(dsnxb, n + 1);
        dsnxb[n] = nxb;
        n++;
    }


    //Sua thong tin theo ma
   
    public void suaTheoMa(String ma) {
    
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (dsnxb[i].getMaNhaXuatBan().equals(ma)) {
                 found = true;
                 int chon;
                 do {
                    System.out.println("\n=== SUA THONG TIN NHA XUAT BAN ===");
                    System.out.println("1. SUA ma NhaXuatBan");
                    System.out.println("2. Sua ten NhaXuatBan");
                    System.out.println("3. Sua dia chi");
                    System.out.println("4. Sua so dien thoai");
                    System.out.println("5. Sua email");
                    System.out.println("0. Thoat");
                    System.out.print("Chon: ");
                    chon = sc.nextInt();
                    sc.nextLine(); // bỏ dòng trống

                     switch (chon) {
                    case 1:
                        System.out.print("Nhap ma NhaXuatBan moi: ");
                        dsnxb[i].setMaNhaXuatBan(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhap ten NhaXuatBan moi: ");
                        dsnxb[i].setTenNhaXuatBan(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Nhap dia chi moi: ");
                        dsnxb[i].setDiaChi(sc.nextLine());
                        break;
                    case 4:
                        System.out.print("Nhap so dien thoai moi: ");
                        dsnxb[i].setSDT(sc.nextLine());
                        break;
                    case 5:
                        System.out.print("Nhap email moi: ");
                        dsnxb[i].setEmail(sc.nextLine());
                        break;
                    case 0:
                        System.out.println("Thoat chuc nang sua.");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                    }
                } while (chon != 0);
                 break;
           }
    }

    if (!found) {
        System.out.println("khong tim thay NXB co ma: " + ma);
    }
}

     // Xoa nxb theo ma
    public void xoaTheoMa(String ma) {
       
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (dsnxb[i].getMaNhaXuatBan().equals(ma)) {
               
                for (int j = i; j < n - 1; j++) {
                    dsnxb[j] = dsnxb[j + 1];
                }
                n--;
               
                dsnxb = Arrays.copyOf(dsnxb, n);

                System.out.println("da xoa nxb co ma:: " + ma);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay nxb co ma: " + ma);
        }
    }

     // Tim nxb theo ma
    public NhaXuatBan timTheoMa(String ma) {
        for(int i=0;i<n;i++){
            if(dsnxb[i].getMaNhaXuatBan().equals(ma)){
                return dsnxb[i];
            }
        }
        return null;
    }
   

   
    // Ghi file nxb.txt theo định dạng / (mỗi NhaXuatBan trên 1 dòng)
public void ghiFile() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/nxb.txt"))) {
        for (int i = 0; i < n; i++) {
            // Ghi theo định dạng: maNhaXuatBan/tenNhaXuatBan/diaChi/SDT/email
            bw.write(dsnxb[i].getMaNhaXuatBan() + "/" +
                     dsnxb[i].getTenNhaXuatBan() + "/" +
                     dsnxb[i].getDiaChi() + "/" +
                     dsnxb[i].getSDT() + "/" +
                     dsnxb[i].getEmail());
            bw.newLine(); // xuống dòng
        }
    } catch (IOException e) {
        System.out.println("Loi khi ghi file: " + e.getMessage());
    }
}

// Đọc file nxb.txt theo định dạng / và lưu vào mảng dsnxb
public void docFile() {
    int i = 0;
    try (BufferedReader br = new BufferedReader(new FileReader("data/nxb.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue; // bỏ dòng trống

            String[] parts = line.split("/"); // tách theo dấu /
            if (parts.length < 5) continue;   // dòng sai định dạng

            NhaXuatBan nxb = new NhaXuatBan();
            nxb.setMaNhaXuatBan(parts[0].trim());
            nxb.setTenNhaXuatBan(parts[1].trim());
            nxb.setDiaChi(parts[2].trim());
            nxb.setSDT(parts[3].trim());
            nxb.setEmail(parts[4].trim());

            if (dsnxb.length == i) dsnxb = Arrays.copyOf(dsnxb, i + 1);
            dsnxb[i++] = nxb;
        }
    } catch (IOException e) {
        System.out.println("Lỗi khi đọc file: " + e.getMessage());
    } finally {
        n = i;
        dsnxb = Arrays.copyOf(dsnxb, n); // cắt mảng vừa khít
    }
}


    // 1. Tìm kiếm NhaXuatBan theo tên
public void timTheoTen(String ten) {
    if (n == 0) {
        System.out.println("Danh sach trong.!");
        return;
    }

    boolean found = false;
    System.out.println("\n**KET QUA TIM KIEM NXB THEO TEN**");
    for (int i = 0; i < n; i++) {
        if (dsnxb[i].getTenNhaXuatBan().toLowerCase().contains(ten.toLowerCase())) {
            dsnxb[i].xuat();
            found = true;
        }
    }

    if (!found) {
        System.out.println("Khong tim thay nxb nao co te: " + ten);
    }
}

// 2. Thống kê NhaXuatBan ở TP.HCM
public void thongKeNXB_HCM() {
    if (n == 0) {
        System.out.println("Danh sach trong!");
        return;
    }

    int dem = 0;
    System.out.println("\n**DANH SACH NXB O TP HO CHI MINH**");
    for (int i = 0; i < n; i++) {
       
        if (dsnxb[i].getDiaChi().toLowerCase().contains("HCM".toLowerCase()) || dsnxb[i].getDiaChi().toLowerCase().contains("Hồ Chí Minh".toLowerCase())) {
            dsnxb[i].xuat();
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
