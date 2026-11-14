package BAI_TAP;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.text.DecimalFormat;

class SACH {
    int namHienTai = LocalDate.now().getYear();
    private String maSach;
    private String tenSach;
    private String loaiSach;
    private String tacGia;
    private int namXuatBan;
    private double donGia;
    private int soluong;

    public SACH() {
    }

    public SACH(String maSach, String tenSach, String loaiSach,
                String tacGia, int namXuatBan, double donGia, int soluong) {
        setMaSach(maSach);
        setTenSach(tenSach);
        setLoaiSach(loaiSach);
        setTacGia(tacGia);
        setNamXuatBan(namXuatBan);
        setDonGia(donGia);
        setSoluong(soluong);
    }

    public void NHAP(Scanner sc) {
        int hople;

        do {
            System.out.println("----- Nhap thong tin sach -----");

            System.out.print("Nhap ma sach: ");
            setMaSach(sc.nextLine().trim());

            System.out.print("Nhap ten sach: ");
            setTenSach(sc.nextLine().trim());

            System.out.print("Nhap loai sach: ");
            setLoaiSach(sc.nextLine().trim());

            System.out.print("Nhap tac gia: ");
            setTacGia(sc.nextLine().trim());

            do {
                System.out.printf("Nhap nam xuat ban: ");
                namXuatBan = sc.nextInt();

                if (namXuatBan < 1900 || namXuatBan > namHienTai)
                        System.out.println("Nam xuat ban ko hop le, nhap lai !!!");
            } while (namXuatBan < 1900 || namXuatBan > namHienTai);

            do {
                System.out.print("Nhap don gia: ");
                donGia = sc.nextDouble();

                if (donGia < 0 || !Double.isFinite(donGia))
                    System.out.println("Don gia nhap ko hop le, nhap lai !!!");
            } while (donGia < 0 || !Double.isFinite(donGia));

            do {
                System.out.print("Nhap so luong: ");
                soluong = sc.nextInt();
                sc.nextLine();

                if (soluong < 0)
                    System.out.println("So luong nhap ko hop le, nhap lai !!!"); 
            } while (soluong < 0 || !Double.isFinite(soluong));

            hople = Kiemtrahople();

            if (hople == 0) {
                System.out.println("Thong tin sach khong hop le. Vui long nhap lai!\n");
            }
        } while (hople == 0);
    }

    private int Kiemtrahople() {
        int hople = 1;

        if (maSach.isEmpty() || tenSach.isEmpty() || loaiSach.isEmpty() || tacGia.isEmpty()) {
            System.out.println("Ma sach, ten sach, loai sach va tac gia khong duoc de trong!");
            hople = 0;
        }

        if (hople == 1) {
            System.out.println("Thong tin sach hop le.");
        }

        return hople;
    }

    public void XUAT() {
        System.out.println("----- Thong tin sach -----");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Loai sach: " + loaiSach);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("Don gia: " + donGia);
        System.out.println("So luong: " + soluong);
    }

    public double Thanhtien() {
        return donGia * soluong;
    }

    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }   

    public void setDonGia(double donGia) {
        if (donGia > 0 && Double.isFinite(donGia)) {
            this.donGia = donGia;
        }
    }

    public void setSoluong(int soluong) {
        if (soluong >= 0) {
            this.soluong = soluong;
        }
    }

    public void setNamXuatBan(int namXuatBan) {
        int namHienTai = LocalDate.now().getYear();

        if (namXuatBan >= 1900 && namXuatBan <= namHienTai) {
            this.namXuatBan = namXuatBan;
        }
    }
}

class QUANLITHUVIEN {
    ArrayList<SACH> danhSachSach = new ArrayList<>();

    private int TimViTriSach(String maCanTim) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            if (danhSachSach.get(i).getMaSach().equalsIgnoreCase(maCanTim)) {
                return i;
            }
        }
        return -1;
    }

    private boolean KiemTraTrungMa(String maSach, int viTriBoQua) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            if (i != viTriBoQua && danhSachSach.get(i).getMaSach().equalsIgnoreCase(maSach)) {
                return true;
            }
        }
        return false;
    }

    public void ThemSach(Scanner sc) {
        System.out.printf("Nhap so luong sach can them: ");
        int soluong = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < soluong; i++) {
            while (true) {
                System.out.println("\nNhap thong tin sach thu " + (i + 1) + ":");

                SACH sachMoi = new SACH();
                sachMoi.NHAP(sc);

                if (KiemTraTrungMa(sachMoi.getMaSach(), -1)) {
                    System.out.println("Ma sach da ton tai. Vui long nhap lai!");
                } else {
                    danhSachSach.add(sachMoi);
                    System.out.println("Them sach thanh cong.");
                    break;
                }
            }
        }
    }

    public void HienThiSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach sach dang rong!");
            return;
        }

        System.out.println("----- DANH SACH SACH -----");
        for (int i = 0; i < danhSachSach.size(); i++) {
            if (danhSachSach.size() == 1) {
                System.out.println("\nThong tin sach:");
                danhSachSach.get(i).XUAT();
            } else {
                System.out.println("\nThong tin sach thu " + (i+1) + ":");
                danhSachSach.get(i).XUAT();
            }
        }
    }

    public void TimSach(Scanner sc) {
        System.out.print("Nhap ma sach can tim: ");
        String maCanTim = sc.nextLine().trim();

        int viTri = TimViTriSach(maCanTim);

        if (viTri == -1) {
            System.out.println("Khong tim thay sach co ma " + maCanTim);
        } else {
            System.out.println("Thong tin sach can tim:");
            danhSachSach.get(viTri).XUAT();
        }
    }

    public void XoaSach(Scanner sc) {
        System.out.print("Nhap ma sach can xoa: ");
        String maCanXoa = sc.nextLine().trim();

        int viTri = TimViTriSach(maCanXoa);

        if (viTri == -1) {
            System.out.println("Khong tim thay sach can xoa.");
        } else {
            danhSachSach.remove(viTri);
            System.out.println("Xoa sach thanh cong.");
        }
    }

    public void SuaSach(Scanner sc) {
        System.out.print("Nhap ma sach can sua: ");
        String maCanSua = sc.nextLine().trim();

        int viTri = TimViTriSach(maCanSua);

        if (viTri == -1) {
            System.out.println("Khong tim thay sach can sua.");
            return;
        }

        System.out.println("Nhap lai toan bo thong tin sach:");
        SACH sachMoi;

        do {
            sachMoi = new SACH();
            sachMoi.NHAP(sc);

            if (KiemTraTrungMa(sachMoi.getMaSach(), viTri)) {
                System.out.println("Ma sach moi da ton tai. Vui long nhap lai!");
            } else {
                danhSachSach.set(viTri, sachMoi);
                System.out.println("Cap nhat sach thanh cong.");
                break;
            }
        } while (true);
    }

    public void TinhTongSoLuong() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        int tongSL = 0;

        for (int i = 0; i < danhSachSach.size(); i++) {
            tongSL += danhSachSach.get(i).getSoluong();
        }

        System.out.println("Tong so luong sach: " + df.format(tongSL));
    }

    public void TinhTongGiaTri() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        double tongGT = 0;

        for (int i = 0; i < danhSachSach.size(); i++) {
            tongGT += danhSachSach.get(i).Thanhtien();
        }

        System.out.println("Tong gia tri sach: " + df.format(tongGT));
    }

    private void Xuatthongtinkho(SACH sach) {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        double thanhtien;
        double phivanchuyen;
        double tongtiennhap;

        thanhtien = sach.Thanhtien();
        phivanchuyen = thanhtien * 0.05;
        tongtiennhap = thanhtien + phivanchuyen;

        System.out.println("--Ma sach: " + sach.getMaSach());
        System.out.println("+ Thanh tien: " + df.format(thanhtien));
        System.out.println("+ Phi van chuyen: " + df.format(phivanchuyen));
        System.out.println("+ Tong tien nhap: " + df.format(tongtiennhap));
    }

    public void Quanlikho(Scanner sc) {
        int truy_xuat;

        if (danhSachSach.isEmpty()) {
            System.out.println("Kho chua co sach!");
            return;
        }

        System.out.println("1. Truy xuat toan bo sach");
        System.out.println("2. Truy xuat 1 sach cu the");
        do {
            System.out.printf("Lua chon (1,2): ");
            truy_xuat = sc.nextInt();
            sc.nextLine();

            if (truy_xuat != 1 && truy_xuat != 2) {
                System.out.println("Lua chon khong hop le. Vui long chon lai!");
            }
        } while (truy_xuat != 1 && truy_xuat != 2);

        if (truy_xuat == 1) {
            System.out.println("----- Truy xuat kho -----");
            for (int i = 0; i < danhSachSach.size(); i++) {
                Xuatthongtinkho(danhSachSach.get(i));
            }
        } else {
            System.out.print("Nhap ma sach can truy xuat: ");
            String maCanTruyXuat = sc.nextLine().trim();

            int viTri = TimViTriSach(maCanTruyXuat);

            if (viTri == -1) {
                System.out.println("Khong tim thay sach co ma " + maCanTruyXuat);
            } else {
                Xuatthongtinkho(danhSachSach.get(viTri));
            }
        }
    }

    public void MENU(Scanner sc) {
        int chon;

        System.out.println("\n----- MENU QUAN LI THU VIEN -----");
        System.out.println("1. Them sach");
        System.out.println("2. Hien thi sach");
        System.out.println("3. Tim sach");
        System.out.println("4. Xoa sach");
        System.out.println("5. Sua sach");
        System.out.println("6. Tinh tong so luong");
        System.out.println("7. Tinh tong gia tri");
        System.out.println("8. Quan li kho");
        System.out.println("0. Thoat");

        System.out.print("Chon chuc nang: ");
        chon = sc.nextInt();
        sc.nextLine();

        switch (chon) {
            case 1:
                ThemSach(sc);
                break;
            case 2:
                HienThiSach();
                break;
            case 3:
                TimSach(sc);
                break;
            case 4:
                XoaSach(sc);
                break;
            case 5:
                SuaSach(sc);
                break;
            case 6:
                TinhTongSoLuong();
                break;
            case 7:
                TinhTongGiaTri();
                break;
            case 8:
                Quanlikho(sc);
                break;
            case 0:
                System.out.println("Thoat menu quan li thu vien.");
                break;
            default:
                System.out.println("Chuc nang khong hop le. Vui long chon lai!");
        }
    }
}

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QUANLITHUVIEN quanlithuvien = new QUANLITHUVIEN();
        int tiepTuc;

        do {
            quanlithuvien.MENU(sc);
            do {
                System.out.print("\nTiep tuc? (1.Y / 0.N): ");
                tiepTuc = sc.nextInt();
                sc.nextLine();

                if (tiepTuc != 1 && tiepTuc != 0) {
                    System.out.println("Lua chon khong hop le !!!");
                } else if (tiepTuc == 0) {
                    break;
                }
            } while (tiepTuc != 1 && tiepTuc != 0);
        } while (tiepTuc == 1);
    }
}

