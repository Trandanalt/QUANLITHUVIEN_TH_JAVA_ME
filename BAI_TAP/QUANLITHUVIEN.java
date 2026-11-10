package BAI_TAP;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

class SACH {
    public String maSach;
    public String tenSach;
    public String loaiSach;
    public String tacGia;
    public int namXuatBan;
    public double donGia;
    public int soluong;

    public void NHAP(Scanner sc) {
        int hople;

        do {
            System.out.println("----- Nhap thong tin sach -----");

            System.out.print("Nhap ma sach: ");
            maSach = sc.nextLine().trim();

            System.out.print("Nhap ten sach: ");
            tenSach = sc.nextLine().trim();

            System.out.print("Nhap loai sach: ");
            loaiSach = sc.nextLine().trim();

            System.out.print("Nhap tac gia: ");
            tacGia = sc.nextLine().trim();

            namXuatBan = NhapSoNguyen(sc, "Nhap nam xuat ban: ");
            donGia = NhapSoThuc(sc, "Nhap don gia: ");
            soluong = NhapSoNguyen(sc, "Nhap so luong: ");

            hople = Kiemtrahople();

            if (hople == 0) {
                System.out.println("Thong tin sach khong hop le. Vui long nhap lai!\n");
            }
        } while (hople == 0);
    }

    public int Kiemtrahople() {
        int namHienTai = LocalDate.now().getYear();
        int hople = 1;

        if (maSach.isEmpty() || tenSach.isEmpty() || loaiSach.isEmpty() || tacGia.isEmpty()) {
            System.out.println("Ma sach, ten sach, loai sach va tac gia khong duoc de trong!");
            hople = 0;
        }

        if (donGia <= 0 || !Double.isFinite(donGia)) {
            System.out.println("Don gia khong hop le!");
            hople = 0;
        }

        if (soluong < 0) {
            System.out.println("So luong khong hop le!");
            hople = 0;
        }

        if (namXuatBan < 1900 || namXuatBan > namHienTai) {
            System.out.println("Nam xuat ban khong hop le!");
            hople = 0;
        }

        if (hople == 1) {
            System.out.println("Thong tin sach hop le.");
        }

        return hople;
    }

    public static int NhapSoNguyen(Scanner sc, String thongBao) {
        while (true) {
            System.out.print(thongBao);
            String duLieu = sc.nextLine();

            try {
                return Integer.parseInt(duLieu.trim());
            } catch (NumberFormatException e) {
                System.out.println("Du lieu khong hop le. Vui long nhap so nguyen!");
            }
        }
    }

    public static double NhapSoThuc(Scanner sc, String thongBao) {
        while (true) {
            System.out.print(thongBao);
            String duLieu = sc.nextLine();

            try {
                double ketQua = Double.parseDouble(duLieu.trim());
                if (Double.isFinite(ketQua)) {
                    return ketQua;
                }
                System.out.println("Du lieu khong hop le. Vui long nhap lai!");
            } catch (NumberFormatException e) {
                System.out.println("Du lieu khong hop le. Vui long nhap so!");
            }
        }
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
}

public class QUANLITHUVIEN {
    static ArrayList<SACH> danhSachSach = new ArrayList<>();

    public static int TimViTriSach(String maCanTim) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            if (danhSachSach.get(i).maSach.equalsIgnoreCase(maCanTim)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean KiemTraTrungMa(String maSach, int viTriBoQua) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            if (i != viTriBoQua && danhSachSach.get(i).maSach.equalsIgnoreCase(maSach)) {
                return true;
            }
        }
        return false;
    }

    public static void ThemSach(Scanner sc) {
        System.out.println("Nhap so luong sach can them: ");
        int soluong = SACH.NhapSoNguyen(sc, "So luong: ");

        for (int i = 0; i < soluong; i++) {
            while (true) {
                System.out.println("\nNhap thong tin sach thu " + (i + 1) + ":");

                SACH sachMoi = new SACH();
                sachMoi.NHAP(sc);

                if (KiemTraTrungMa(sachMoi.maSach, -1)) {
                    System.out.println("Ma sach da ton tai. Vui long nhap lai!");
                } else {
                    danhSachSach.add(sachMoi);
                    System.out.println("Them sach thanh cong.");
                    break;
                }
            }
        }
    }

    public static void HienThiSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach sach dang rong!");
            return;
        }

        System.out.println("----- DANH SACH SACH -----");
        for (int i = 0; i < danhSachSach.size(); i++) {
            System.out.println("\nThong tin sach thu " + (i+1) + ":");
            danhSachSach.get(i).XUAT();
        }
    }

    public static void TimSach(Scanner sc) {
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

    public static void XoaSach(Scanner sc) {
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

    public static void SuaSach(Scanner sc) {
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

            if (KiemTraTrungMa(sachMoi.maSach, viTri)) {
                System.out.println("Ma sach moi da ton tai. Vui long nhap lai!");
            } else {
                danhSachSach.set(viTri, sachMoi);
                System.out.println("Cap nhat sach thanh cong.");
                break;
            }
        } while (true);
    }

    public static void TinhTongSoLuong() {
        int tongSL = 0;

        for (int i = 0; i < danhSachSach.size(); i++) {
            tongSL += danhSachSach.get(i).soluong;
        }

        System.out.println("Tong so luong sach: " + tongSL);
    }

    public static void TinhTongGiaTri() {
        double tongGT = 0;

        for (int i = 0; i < danhSachSach.size(); i++) {
            tongGT += danhSachSach.get(i).Thanhtien();
        }

        System.out.println("Tong gia tri sach: " + tongGT);
    }

    public static void MENU(Scanner sc) {
        int chon;

        do {
            System.out.println("\n----- MENU QUAN LI THU VIEN -----");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("0. Thoat");

            chon = SACH.NhapSoNguyen(sc, "Chon chuc nang (0-7): ");

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
                case 0:
                    System.out.println("Thoat menu quan li thu vien.");
                    break;
                default:
                    System.out.println("Chuc nang khong hop le. Vui long chon lai!");
            }
        } while (chon != 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tiepTuc;
        do {
            MENU(sc);

            System.out.print("Tiep tuc? (1.Y / 0.N): ");
            tiepTuc = sc.nextInt();

            if (tiepTuc != 1 && tiepTuc != 0) {
                System.out.println("Lua chon khong hop le !!!");
            } else if (tiepTuc == 0) {
                break;
            }
        } while (tiepTuc == 1);
    }
}

