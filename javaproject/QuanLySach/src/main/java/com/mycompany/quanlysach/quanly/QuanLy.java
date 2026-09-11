/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysach.quanly;



import java.text.ParseException;

/**
 *
 * @author Asus
 */

public class QuanLy {
    public static DSSach dssach=new DSSach();
    public static DSTacGia dstg=new DSTacGia();
    public static DSNhaCungCap dsncc=new DSNhaCungCap();
    public static DSHoaDon dshd=new DSHoaDon();
    public static DSPhieuNhap dspnh=new DSPhieuNhap();
    public static DSCTHD dsct_hd=new DSCTHD();
    public static DSCTPN dsct_pnh=new DSCTPN();
    public static DSKhachHang dskh=new DSKhachHang();
    public static DSNXB dsnxb=new DSNXB();
    public static DSTheLoai dstl=new DSTheLoai();
    public static DSNhanVien dsnv=new DSNhanVien();


    public DSSach getDSSach(){
        return dssach;
    }

    public DSTacGia getDSTacGia(){
        return dstg;
    }

    public DSNhaCungCap getDSNhaCungCap(){
        return dsncc;
    }

    public DSHoaDon getDSHoaDon(){
        return dshd;
    }

    public DSPhieuNhap getDSPhieuNhap(){
        return dspnh;
    }

    public DSCTHD getDSCTHD(){
        return dsct_hd;
    }

    public DSCTPN getDSCTPN(){
        return dsct_pnh;
    }

    public DSKhachHang getDSKhachHang(){
        return dskh;
    }

    public DSNXB getDSNXB(){
        return dsnxb;
    }

    public DSTheLoai getDSTL(){
        return dstl;
    }

    public DSNhanVien getDSNhanVien(){
        return dsnv;
    }
    
    public void docFile() throws ParseException{
        dssach.docFile();
        dstg.docFile();
        dspnh.docFile();
        dsnxb.docFile();
        dstl.docFile();
        dsnv.docFile();
        dsncc.docFile();
        dskh.docFile();
        dshd.docFile();
        dsct_hd.docFile();
        dsct_pnh.docFile();
    }

    public void ghiFile(){
            dssach.ghiFile();
            dstg.ghiFile();
            dspnh.ghiFile();
            dsnxb.ghiFile();
            dsnv.ghiFile();
            dstl.ghiFile();
            dsncc.ghiFile();
            dskh.ghiFile();
            dshd.ghiFile();
            dsct_hd.ghiFile();
            dsct_pnh.ghiFile();
    }

    
    public void menuChinh(){}
   
    

  
    

   

    

     

   
}
