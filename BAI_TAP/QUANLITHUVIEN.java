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

        if (maSach.contains("|") || tenSach.contains("|") || loaiSach.contains("|") || tacGia.contains("|")) {
            System.out.println("Thong tin sach khong duoc chua ky tu | !");
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

    public String ChuyenThanhChuoi() {
        return maSach + "|" + tenSach + "|" + loaiSach + "|" + tacGia + "|"
                + namXuatBan + "|" + donGia + "|" + soluong;
    }

    public void GanThongTin(String thongTin) {
        String[] tt = thongTin.split("\\|", -1);

        maSach = tt[0];
        tenSach = tt[1];
        loaiSach = tt[2];
        tacGia = tt[3];
        namXuatBan = Integer.parseInt(tt[4]);
        donGia = Double.parseDouble(tt[5]);
        soluong = Integer.parseInt(tt[6]);
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

    public double Phivanchuyen() {
        return 0.05 * Thanhtien();
    }

    public double Tongtien() {
        return Thanhtien() + Phivanchuyen();
    }
}

public class QUANLITHUVIEN {
    static ArrayList<String> danhSachMaSach = new ArrayList<>();

    static ArrayList<String> danhSachSach = new ArrayList<>();

    public static void BAI1(Scanner sc) {
        int[] soLuong = new int[6];
        int tong = 0;
        int lonNhat;

        System.out.println("----- BAI 1: MANG SO LUONG 5 CUON SACH -----");

        for (int i = 1; i <= 5; i++) {
            do {
                soLuong[i] = SACH.NhapSoNguyen(sc, "Nhap so luong cuon sach thu " + i + ": ");
                if (soLuong[i] < 0) {
                    System.out.println("So luong khong duoc am. Vui long nhap lai!");
                }
            } while (soLuong[i] < 0);
        }

        System.out.println("\nDanh sach so luong:");
        lonNhat = soLuong[1];

        for (int i = 1; i <= 5; i++) {
            System.out.println("Cuon sach thu " + i + ": " + soLuong[i]);
            tong += soLuong[i];

            if (soLuong[i] > lonNhat) {
                lonNhat = soLuong[i];
            }
        }

        System.out.println("Tong so luong: " + tong);
        System.out.println("So luong lon nhat: " + lonNhat);
    }

    public static void ThemMaSach(Scanner sc) {
        System.out.print("Nhap ma sach can them: ");
        String maSach = sc.nextLine().trim();

        if (maSach.isEmpty()) {
            System.out.println("Ma sach khong duoc de trong!");
            return;
        }

        if (danhSachMaSach.contains(maSach)) {
            System.out.println("Ma sach da ton tai!");
        } else {
            danhSachMaSach.add(maSach);
            System.out.println("Them ma sach thanh cong.");
        }
    }

    public static void HienThiMaSach() {
        if (danhSachMaSach.isEmpty()) {
            System.out.println("Danh sach ma sach dang rong!");
            return;
        }

        System.out.println("----- DANH SACH MA SACH -----");
        for (int i = 0; i < danhSachMaSach.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachMaSach.get(i));
        }
    }

    public static void TimMaSach(Scanner sc) {
        System.out.print("Nhap ma sach can tim: ");
        String maCanTim = sc.nextLine().trim();

        int viTri = -1;
        for (int i = 0; i < danhSachMaSach.size(); i++) {
            if (danhSachMaSach.get(i).equalsIgnoreCase(maCanTim)) {
                viTri = i;
                break;
            }
        }

        if (viTri == -1) {
            System.out.println("Khong tim thay ma sach " + maCanTim);
        } else {
            System.out.println("Tim thay ma sach " + danhSachMaSach.get(viTri)
                    + " tai vi tri " + (viTri + 1));
        }
    }

    public static void XoaMaSach(Scanner sc) {
        System.out.print("Nhap ma sach can xoa: ");
        String maCanXoa = sc.nextLine().trim();

        for (int i = 0; i < danhSachMaSach.size(); i++) {
            if (danhSachMaSach.get(i).equalsIgnoreCase(maCanXoa)) {
                danhSachMaSach.remove(i);
                System.out.println("Xoa ma sach thanh cong.");
                return;
            }
        }

        System.out.println("Khong tim thay ma sach can xoa.");
    }

    public static void MENU_BAI2(Scanner sc) {
        int chon;

        do {
            System.out.println("\n----- BAI 2: ARRAYLIST MA SACH -----");
            System.out.println("1. Them ma sach");
            System.out.println("2. Hien thi ma sach");
            System.out.println("3. Tim ma sach");
            System.out.println("4. Xoa ma sach");
            System.out.println("0. Quay lai menu chinh");

            chon = SACH.NhapSoNguyen(sc, "Chon chuc nang: ");

            switch (chon) {
                case 1:
                    ThemMaSach(sc);
                    break;
                case 2:
                    HienThiMaSach();
                    break;
                case 3:
                    TimMaSach(sc);
                    break;
                case 4:
                    XoaMaSach(sc);
                    break;
                case 0:
                    System.out.println("Quay lai menu chinh.");
                    break;
                default:
                    System.out.println("Chuc nang khong hop le. Vui long chon lai!");
            }
        } while (chon != 0);
    }

    public static int TimViTriSach(String maCanTim) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] thongTin = danhSachSach.get(i).split("\\|", -1);

            if (thongTin[0].equalsIgnoreCase(maCanTim)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean KiemTraTrungMa(String maSach, int viTriBoQua) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] thongTin = danhSachSach.get(i).split("\\|", -1);

            if (i != viTriBoQua && thongTin[0].equalsIgnoreCase(maSach)) {
                return true;
            }
        }
        return false;
    }

    public static void ThemSach(Scanner sc) {
        SACH sachMoi = new SACH();

        do {
            sachMoi.NHAP(sc);

            if (KiemTraTrungMa(sachMoi.maSach, -1)) {
                System.out.println("Ma sach da ton tai. Vui long nhap lai thong tin sach!");
            } else {
                break;
            }
        } while (true);

        danhSachSach.add(sachMoi.ChuyenThanhChuoi());
        System.out.println("Them sach thanh cong.");
    }

    public static void HienThiSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach sach dang rong!");
            return;
        }

        System.out.println("----- DANH SACH SACH -----");
        for (int i = 0; i < danhSachSach.size(); i++) {
            SACH sach = new SACH();
            sach.GanThongTin(danhSachSach.get(i));

            System.out.println("\nThong tin sach thu " + (i + 1) + ":");
            sach.XUAT();
        }
    }

    public static void TimSach(Scanner sc) {
        System.out.print("Nhap ma sach can tim: ");
        String maCanTim = sc.nextLine().trim();

        int viTri = TimViTriSach(maCanTim);

        if (viTri == -1) {
            System.out.println("Khong tim thay sach co ma " + maCanTim);
        } else {
            SACH sach = new SACH();
            sach.GanThongTin(danhSachSach.get(viTri));
            System.out.println("Thong tin sach can tim:");
            sach.XUAT();
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
        SACH sachMoi = new SACH();

        do {
            sachMoi.NHAP(sc);

            if (KiemTraTrungMa(sachMoi.maSach, viTri)) {
                System.out.println("Ma sach moi da ton tai. Vui long nhap lai!");
            } else {
                break;
            }
        } while (true);

        danhSachSach.set(viTri, sachMoi.ChuyenThanhChuoi());
        System.out.println("Cap nhat sach thanh cong.");
    }

    public static void TinhTongSoLuong() {
        int tongSL = 0;

        for (int i = 0; i < danhSachSach.size(); i++) {
            SACH sach = new SACH();
            sach.GanThongTin(danhSachSach.get(i));
            tongSL += sach.soluong;
        }

        System.out.println("Tong so luong sach: " + tongSL);
    }

    public static void TinhTongGiaTri() {
        double tongGT = 0;

        for (int i = 0; i < danhSachSach.size(); i++) {
            SACH sach = new SACH();
            sach.GanThongTin(danhSachSach.get(i));
            tongGT += sach.Thanhtien();
        }

        System.out.println("Tong gia tri sach: " + tongGT);
    }

    public static void MENU_BAI3(Scanner sc) {
        int chon;

        do {
            System.out.println("\n----- BAI 3: ARRAYLIST THONG TIN SACH -----");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("0. Quay lai menu chinh");

            chon = SACH.NhapSoNguyen(sc, "Chon chuc nang: ");

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
                case 0:
                    System.out.println("Quay lai menu chinh.");
                    break;
                default:
                    System.out.println("Chuc nang khong hop le. Vui long chon lai!");
            }
        } while (chon != 0);
    }

    public static void MENU_BAI4(Scanner sc) {
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
            System.out.println("8. Thoat");

            chon = SACH.NhapSoNguyen(sc, "Chon chuc nang: ");

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
                    System.out.println("Thoat menu quan li thu vien.");
                    break;
                default:
                    System.out.println("Chuc nang khong hop le. Vui long chon lai!");
            }
        } while (chon != 8);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chon;

        do {
            System.out.println("\n========== CHUONG TRINH THUC HANH ==========");
            System.out.println("1. Bai 1 - Mang int[] soLuong");
            System.out.println("2. Bai 2 - ArrayList<String> ma sach");
            System.out.println("3. Bai 3 - ArrayList<String> thong tin sach");
            System.out.println("4. Bai 4 - Menu quan li thu vien");
            System.out.println("0. Thoat chuong trinh");

            chon = SACH.NhapSoNguyen(sc, "Chon bai (1, 2, 3, 4, 0): ");

            switch (chon) {
                case 1:
                    BAI1(sc);
                    break;
                case 2:
                    MENU_BAI2(sc);
                    break;
                case 3:
                    MENU_BAI3(sc);
                    break;
                case 4:
                    MENU_BAI4(sc);
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai!");
            }
        } while (chon != 0);

        sc.close();
    }
}
