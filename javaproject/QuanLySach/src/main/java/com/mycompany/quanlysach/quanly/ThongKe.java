/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;


import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
public class ThongKe {
    private Scanner sc=new Scanner(System.in);
    public void thongKeHoaDonTheoNgay(){
        String ngayA, ngayB;
        LocalDate dateA = null;
        LocalDate dateB = null;
         //dinh dang ngay
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            System.out.println("THONG KE HOA DON TU NGAY A ----> NGAY B");
            System.out.println("Nhap Ngay A: vd(yyyy/MM/dd):");
            ngayA = sc.nextLine();
            System.out.println("Nhap Ngay B: vd(yyyy/MM/dd):");
            ngayB = sc.nextLine();
           
            //chuyen String sang Localdate
            dateA = LocalDate.parse(ngayA, formatter);
            dateB = LocalDate.parse(ngayB, formatter);
        }catch(DateTimeParseException e){
            System.err.println("Loi: dinh dang ngay khong dung, (phai là yyyy-MM-dd). Vui long thu lai.");
            return;
        }

        System.out.print("Thong ke tong tien hoa don tu ngay : "+dateA+" denn ngay "+dateB+" = ");
        DSHoaDon hd=QuanLy.dshd;
        double tong=0;
        for(int i=0;i<hd.n;i++){
            LocalDate dateC=LocalDate.parse(hd.dshd[i].getNgayBanString(),formatter);
            if((dateC.isAfter(dateA)||dateC.isEqual(dateA))&&(dateC.isBefore(dateB)||dateC.isEqual(dateB))){
                tong+=hd.dshd[i].getTongTien();
            }
        }
        DecimalFormat df=new DecimalFormat("#,###");
        System.out.println(df.format(tong));
        
    }
    
    
    
    
    public void thongkehoadontheonagy(){
        Scanner sc= new Scanner(System.in);
        System.out.println("nhap ngay A");
        String ngaya=sc.nextLine();
        System.out.println("nhap ngay   B");
        String ngayb=sc.nextLine();
        DateTimeFormatter std=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datea=LocalDate.parse(ngaya,std);
        LocalDate dateb=LocalDate.parse(ngayb,std);
        DSHoaDon hd=QuanLy.dshd;
        double tong=0;
        for(int i=0;i<hd.n;i++){
            LocalDate datec=LocalDate.parse(hd.dshd[i].getNgayBanString(), std);
            if((datec.isAfter(datea))||(datec.equals(datea))&&(datec.isBefore(dateb))||(datec.equals(dateb))){
                tong+=hd.dshd[i].getTongTien();
            }
        }
        DecimalFormat df=new DecimalFormat("#,###");
        System.out.println("tong hoa don u ngya a->b la :"+df.format(tong));

        
                
                
                
                
                }
    




    public void thongKeThuChiTheoQuy(){
        System.out.println("Nhap nam: ");
        int nam=sc.nextInt();

        //dinh dang ngay
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DSHoaDon hd=QuanLy.dshd;
       
        double tt1=0,tt2=0,tt3=0,tt4=0,tt;
        for(int i=0;i<hd.n;i++){
            LocalDate dateA=LocalDate.parse(hd.dshd[i].getNgayBanString(),formatter);
            if(nam==dateA.getYear()){
                int month=dateA.getMonthValue();
                switch (month) {
                    case 1: case 2: case 3: tt1+=hd.dshd[i].getTongTien(); break;
                    case 4: case 5: case 6: tt2+=hd.dshd[i].getTongTien(); break;
                    case 7: case 8: case 9: tt3+=hd.dshd[i].getTongTien(); break;
                    case 10: case 11: case 12: tt4+=hd.dshd[i].getTongTien(); break;
                    default:
                        break;
                }
            }
        }
         DSPhieuNhap pnh=QuanLy.dspnh;
         double tc1=0,tc2=0,tc3=0,tc4=0,tc;
          for(int i=0;i<pnh.n;i++){
            LocalDate dateB=LocalDate.parse(pnh.dspnh[i].getNgayNhapString(),formatter);
            if(nam==dateB.getYear()){
                int month=dateB.getMonthValue();
                switch (month) {
                    case 1: case 2: case 3: tc1+=pnh.dspnh[i].getTongTien(); break;
                    case 4: case 5: case 6: tc2+=pnh.dspnh[i].getTongTien(); break;
                    case 7: case 8: case 9: tc3+=pnh.dspnh[i].getTongTien(); break;
                    case 10: case 11: case 12: tc4+=pnh.dspnh[i].getTongTien(); break;
                    default:
                        break;
                }
            }
        }
        tt=tt1+tt2+tt3+tt4;
        tc=tc1+tc2+tc3+tc4;

        //tinh loi loi nhuan
        double ln1,ln2,ln3,ln4,ln;
        ln1=tt1-tc1;
        ln2=tt2-tc2;
        ln3=tt3-tc3;
        ln4=tt4-tc4;
        ln=tt-tc;
        //Xuat bang thong ke
       

        DecimalFormat df = new DecimalFormat("#,###");

        System.out.println("========================================================================================================");
        System.out.printf("|                            BANG THONG KE THU CHI - LOI NHUAN THEO QUY CUA NAM : %-4d                     |\n", nam);
        System.out.println("========================================================================================================");
        System.out.printf("| %-12s | %15s | %15s | %15s | %15s |%15s |\n","", "Quy 1", "Quy 2", "Quy 3", "Quy 4", "Tong");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-12s | %15s | %15s | %15s | %15s |%15s |\n","Tong Thu", df.format(tt1), df.format(tt2), df.format(tt3), df.format(tt4), df.format(tt));
        System.out.printf("| %-12s | %15s | %15s | %15s | %15s |%15s |\n","Tong Chi", df.format(tc1), df.format(tc2), df.format(tc3), df.format(tc4), df.format(tc));
        System.out.printf("| %-12s | %15s | %15s | %15s | %15s |%15s |\n","Loi Nhuan", df.format(ln1), df.format(ln2), df.format(ln3), df.format(ln4), df.format(ln));
        System.out.println("========================================================================================================");

    }
    
  
    public void thongketheoquy(){
        System.out.println("nhap nam thong ke:");
        int nam=sc.nextInt();
        DecimalFormat std=new DecimalFormat("#,###");// dinh da theo so
        DateTimeFormatter formater= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        double tt1=0,tt2=0,tt3=0,tt4=0,tt=0;
        double tc1=0,tc2=0,tc3=0,tc4=0,tc=0;
        double ln1=0,ln2=0,ln3=0,ln4=0,ln=0;
        DSHoaDon hd=QuanLy.dshd;
        DSPhieuNhap pn=QuanLy.dspnh;
        for(int i=0;i<hd.n;i++){
            LocalDate ngay =LocalDate.parse(hd.dshd[i].getNgayBanString(),formater);
            if(ngay.getYear()==nam){
                switch(ngay.getMonthValue()){
                    case 1: case 2: case 3: tt1+=hd.dshd[i].getTongTien();
                    case 4: case 5: case 6: tt2+=hd.dshd[i].getTongTien();
                    case 7: case 8: case 9: tt3+=hd.dshd[i].getTongTien();
                    case 10: case 11: case 12: tt4+=hd.dshd[i].getTongTien();
                }
            }
            
        }
        for(int i=0;i<pn.n;i++){
            LocalDate ngay =LocalDate.parse(pn.dspnh[i].getNgayNhapString(),formater);
            if(ngay.getYear()==nam){
                switch(ngay.getMonthValue()){
                    case 1: case 2: case 3: tc1+=hd.dshd[i].getTongTien();
                    case 4: case 5: case 6: tc2+=hd.dshd[i].getTongTien();
                    case 7: case 8: case 9: tc3+=hd.dshd[i].getTongTien();
                    case 10: case 11: case 12: tc4+=hd.dshd[i].getTongTien();
                }
            }
            
        }
        tt=tt1+tt2+tt3+tt4;
        tc=tc1+tc1+tc3+tc4;
        ln1=tt1-tc1;
        ln2=tt2-tc2;
        ln3=tt3-tc3;
        ln4=tt4-tc4;
        ln=tt-tc;
        
        System.out.println("====BANG THONG KE THU CHI THEO QUY====");
        System.out.println("--------------------------------------------------");
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s","","quy 1","quy2","quy3","quy4","tong");
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s","tong thu",std.format(tt1),std.format(tt2),std.format(tt3),std.format(tt4),std.format(tt));
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s","tong chi",std.format(tc1),std.format(tc2),std.format(tc3),std.format(tc4),std.format(tc));
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s","loi nhuan",std.format(ln1),std.format(ln2),std.format(ln3),std.format(ln4),std.format(ln));
      
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    //thong ke tong tien hoa don cua khach hang theo quy
    public void thongKeHoaDonTheoKhachHang(){
       System.out.println("Nhap nam: ");
       int nam=sc.nextInt();
       sc.nextLine();
       
         //tinh tong tien cua tung khach hang
        DSHoaDon hd=QuanLy.dshd;
        DSKhachHang kh=QuanLy.dskh;
        double quy1[]=new double[kh.n];
        double quy2[]=new double[kh.n];
        double quy3[]=new double[kh.n];
        double quy4[]=new double[kh.n];
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for(int i=0;i<hd.n;i++){
          
            LocalDate dateA=LocalDate.parse(hd.dshd[i].getNgayBanString(),formatter);
            if(dateA.getYear()==nam){ //so sanh nam nhap vao voi nam cua hoa don
                for(int j=0;j<kh.n;j++){
                    if(hd.dshd[i].getMaKH().equals(kh.dskh[j].getMaKH())){//kiem tra makh trong HoaDon va KhachHang la giong nhau
                        switch (dateA.getMonthValue()) {
                            case 1: case 2: case 3: quy1[j]+=hd.dshd[i].getTongTien(); break;
                            case 4: case 5: case 6: quy2[j]+=hd.dshd[i].getTongTien(); break;
                            case 7: case 8: case 9: quy3[j]+=hd.dshd[i].getTongTien(); break;
                            case 10: case 11: case 12: quy4[j]+=hd.dshd[i].getTongTien(); break;
                            default:
                                break;
                        }
                    }
                }
            }
        }

        //in bang thong ke 
        System.out.println("================================================================================");
        System.out.printf("|==============BANG THONG KE HOA DON CUA KHACH HANG THEO QUY. NAM:%-4d =========|\n",nam);
        System.out.println("================================================================================");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n","MaKH", "Quy 1", "Quy 2", "Quy 3", "Quy 4", "Tong Cong");
        System.out.println("--------------------------------------------------------------------------------");
         DecimalFormat df=new DecimalFormat("#,###");
        for(int k=0;k<kh.n;k++){
            double tongcong=quy1[k]+quy2[k]+quy3[k]+quy4[k];
           
            System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n",kh.dskh[k].getMaKH(),df.format(quy1[k]),df.format(quy2[k]),df.format(quy3[k]),df.format(quy4[k]),df.format(tongcong));
            System.out.println("--------------------------------------------------------------------------------");
        }
        System.out.println("================================================================================");
       
    }
  
    
    
    public void thongKeHoaDonTheoNhanVien() {
    DSHoaDon hd = QuanLy.dshd;
    DSNhanVien nv = QuanLy.dsnv;

    System.out.println("==============================================================");
    System.out.println("|==========THONG KE NANG SUAT CUA NHAN VIEN LAM VIEC =========|");
    System.out.println("==============================================================");
    System.out.println("| MaNV |  SLHD  | TongTienHD |   MAX   |   MIN   |   AVG   |");
    System.out.println("---------------------------------------------------------------");

    DecimalFormat df = new DecimalFormat("#,###");

    for (int i = 0; i < nv.n; i++) {
        String maNV = nv.dsnv[i].getMaNV();
        int slhd = 0;
        double tong = 0, max = 0, min = Double.MAX_VALUE;

        for (int j = 0; j < hd.n; j++) {
            if (hd.dshd[j].getMaNV().equals(maNV)) {
                double tien = hd.dshd[j].getTongTien();
                slhd++;
                tong += tien;
                if (tien > max) max = tien;
                if (tien < min) min = tien;
            }
        }

        if (slhd > 0) {
            double avg = tong / slhd;
            System.out.printf("| %-5s | %6d | %11s | %7s | %7s | %7s |\n",
                    maNV, slhd,
                    df.format(tong),
                    df.format(max),
                    df.format(min),
                    df.format(avg));
        } else {
            System.out.printf("| %-5s | %6d | %11s | %7s | %7s | %7s |\n",
                    maNV, 0, "0", "0", "0", "0");
        }
    }

    System.out.println("===============================================================");
}

}
