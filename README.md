# Đồ án OOP - Quản lý sách

## Giới thiệu

Đây là đồ án môn **Lập trình hướng đối tượng (OOP)** được xây dựng bằng **Java**, với mục tiêu mô phỏng hệ thống quản lý cửa hàng sách.

Chương trình hoạt động theo mô hình menu trên console, cho phép quản lý sách và các đối tượng liên quan như tác giả, thể loại, nhà xuất bản, nhà cung cấp, khách hàng, nhân viên, hóa đơn và phiếu nhập.

Dữ liệu của chương trình được lưu trữ bằng các file `.txt` trong thư mục `data/`.

## Công nghệ sử dụng

- Java
- Maven
- Java 24
- Console / Command Line
- File I/O với các file `.txt`

## Chức năng chính

Chương trình cung cấp các nhóm chức năng chính:

1. **Quản lý sách**
   - Quản lý sách giáo khoa
   - Quản lý sách tham khảo
   - Thêm, sửa, xóa, tìm kiếm và hiển thị thông tin sách
   - Quản lý số lượng tồn và đơn giá

2. **Quản lý tác giả**

3. **Quản lý nhà cung cấp**

4. **Quản lý hóa đơn và chi tiết hóa đơn**

5. **Quản lý phiếu nhập và chi tiết phiếu nhập**

6. **Quản lý khách hàng**

7. **Quản lý nhân viên**

8. **Quản lý nhà xuất bản**

9. **Thống kê**

## Kiến thức OOP được áp dụng

Dự án sử dụng nhiều thành phần quan trọng của lập trình hướng đối tượng:

- **Class và Object**
- **Đóng gói (Encapsulation)** thông qua thuộc tính và getter/setter
- **Kế thừa (Inheritance)**
- **Đa hình (Polymorphism)** thông qua override phương thức
- **Trừu tượng (Abstraction)** thông qua abstract class
- **Interface**

Ví dụ:

- `Nguoi` là abstract class và triển khai interface `IHienThi`.
- `Sach` là abstract class.
- `SachGiaoKhoa` và `SachThamKhao` kế thừa từ `Sach`.
- `SachGiaoKhoa` và `SachThamKhao` override phương thức `nhapSach()` và `xuat()`.

## Cấu trúc dự án

```
DoAnOOP/
└── javaproject/
    └── QuanLySach/
        ├── pom.xml
        ├── data/
        │   ├── sach.txt
        │   ├── tacgia.txt
        │   ├── theloai.txt
        │   ├── nxb.txt
        │   ├── nhacungcap.txt
        │   ├── khachhang.txt
        │   ├── nhanvien.txt
        │   ├── hoadon.txt
        │   ├── ct_hd.txt
        │   ├── phieunhaphang.txt
        │   └── ct_pnh.txt
        │
        ├── src/
        │   └── main/
        │       └── java/
        │           └── com/
        │               └── mycompany/
        │                   └── quanlysach/
        │                       ├── model/
        │                       │   ├── Sach.java
        │                       │   ├── SachGiaoKhoa.java
        │                       │   ├── SachThamKhao.java
        │                       │   ├── Nguoi.java
        │                       │   ├── KhachHang.java
        │                       │   ├── NhanVien.java
        │                       │   ├── TacGia.java
        │                       │   ├── TheLoai.java
        │                       │   ├── NhaXuatBan.java
        │                       │   ├── NhaCungCap.java
        │                       │   ├── HoaDon.java
        │                       │   ├── ChiTietHoaDon.java
        │                       │   ├── PhieuNhap.java
        │                       │   ├── ChiTietPhieuNhap.java
        │                       │   └── IHienThi.java
        │                       │
        │                       └── quanly/
        │                           ├── QuanLy.java
        │                           ├── QuanLySP.java
        │                           ├── QuanLyTG.java
        │                           ├── QuanLyTL.java
        │                           ├── QuanLyNXB.java
        │                           ├── QuanLyNCC.java
        │                           ├── QuanLyKH.java
        │                           ├── QuanLyNV.java
        │                           ├── QuanLyHD.java
        │                           ├── QuanLyPN.java
        │                           ├── QuanLyThongKe.java
        │                           └── MainMenu.java
        │
        └── target/
            └── ... (các file build do Maven tạo)
```

## Mô hình lớp chính

### Nhóm sách

```
                 Sach
                /    \
               /      \
      SachGiaoKhoa   SachThamKhao
```

`Sach` chứa các thông tin dùng chung như mã sách, tên sách, đơn giá, số lượng tồn, năm xuất bản, tác giả, thể loại và nhà xuất bản.

`SachGiaoKhoa` bổ sung thông tin môn học và cấp học.

`SachThamKhao` bổ sung thông tin trình độ và lĩnh vực.

### Nhóm người

`Nguoi` là abstract class chứa các thông tin chung như họ tên, số điện thoại, địa chỉ và email. Các lớp quản lý đối tượng người được xây dựng dựa trên mô hình này.

## Lưu trữ dữ liệu

Dữ liệu được lưu trong thư mục:

```
javaproject/QuanLySach/data/
```

Một số file dữ liệu:

| File | Nội dung |
|---|---|
| `sach.txt` | Danh sách sách |
| `tacgia.txt` | Danh sách tác giả |
| `theloai.txt` | Danh sách thể loại |
| `nxb.txt` | Danh sách nhà xuất bản |
| `nhacungcap.txt` | Danh sách nhà cung cấp |
| `khachhang.txt` | Danh sách khách hàng |
| `nhanvien.txt` | Danh sách nhân viên |
| `hoadon.txt` | Hóa đơn |
| `ct_hd.txt` | Chi tiết hóa đơn |
| `phieunhaphang.txt` | Phiếu nhập hàng |
| `ct_pnh.txt` | Chi tiết phiếu nhập |

## Yêu cầu môi trường

- **JDK 24** hoặc môi trường Java tương thích với cấu hình Maven hiện tại.
- **Apache Maven**
- IDE hỗ trợ Java như IntelliJ IDEA, NetBeans hoặc Eclipse.

Project hiện cấu hình Maven với:

```xml
<maven.compiler.release>24</maven.compiler.release>
```

## Cài đặt và chạy

Clone repository:

```bash
git clone https://github.com/khoideptrai1410-wq/DoAnOOP.git
cd DoAnOOP/javaproject/QuanLySach
```

Build project bằng Maven:

```bash
mvn clean package
```

Sau khi build, chạy chương trình bằng IDE với class main của project hoặc chạy JAR được Maven tạo trong thư mục `target/`.

## Menu chương trình

Menu chính của chương trình gồm:

```
===== MENU CHINH =====
1. QUAN LY SACH
2. QUAN LY TAC GIA
3. QUAN LY NHA CUNG CAP
4. QUAN LY HOA DON VA CTHD
5. QUAN LY PHIEU NHAP VA CTPN
6. QUAN LY KHACH HANG
7. QUAN LY NHAN VIEN
8. QUAN LY NHA XUAT BAN
9. LUA CHON MENU THONG KE
0. Thoat
```

## Mục tiêu đồ án

Đồ án nhằm thực hành các kiến thức lập trình hướng đối tượng trong Java thông qua việc xây dựng một chương trình quản lý sách có nhiều đối tượng và chức năng liên quan.

## Tác giả

**Đăng Khôi**

Repository: https://github.com/khoideptrai1410-wq/DoAnOOP
