package BAI_TAP;
import java.util.Scanner;
import java.time.LocalDate;

class SACH {
    public String maSach;
    public String tenSach;
    public String tacGia;
    public int namXuatBan;
    public double donGia;
    public int soluong;

    public void NHAP (Scanner sc) {
        System.out.println("-----Nhap thong tin sach:-------");
        System.out.printf("Nhap ma sach: ");
        maSach = sc.nextLine();

        System.out.printf("Nhap ten sach: ");
        tenSach = sc.nextLine();

        System.out.printf("Nhap tac gia: ");
        tacGia = sc.nextLine();

        System.out.printf("Nhap nam xuat ban: ");
        namXuatBan = sc.nextInt();

        System.out.printf("Nhap don gia: ");
        donGia = sc.nextDouble();

        System.out.printf("Nhap so luong: ");
        soluong = sc.nextInt();
    }

    public double Thanhtien () {
        return donGia * soluong;
    }

    public double Phivanchuyen () {
        return 0.05*Thanhtien();
    }

    public double Tongtien () {
        return Thanhtien() + Phivanchuyen();
    }

    public void XUAT() {
        System.out.println("-----Thong tin sach:-------");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("Don gia: " + donGia);
        System.out.println("So luong: " + soluong);
    }

    public void Kiemtrahople() {
        int namhientai = LocalDate.now().getYear();
        int hople = 1;

        if (donGia <= 0) {
            System.out.println("Don gia khong hop le!");
            hople = 0;
        }

        if (soluong < 0) {
            System.out.println("So luong khong hop le!");
            hople = 0;
        }

        if (namXuatBan < 1900 || namXuatBan > namhientai) {
            System.out.println("Nam xuat ban khong hop le!");
            hople = 0;
        }

        if (hople == 1) {
            System.out.println("Thong tin sach hop le.");
        }
    }

    public void Phanloaigia() {
        System.out.print("Phan loai gia sach: ");
        if (donGia < 50000) {
            System.out.println("Sach gia thap");
        } else if (donGia >= 50000 && donGia < 100000) {
            System.out.println("Sach gia trung binh");
        } else if (donGia >= 100000 && donGia < 200000) {
            System.out.println("Sach gia cao");
        } else {
            System.out.println("Sach gia dac biet");  
        }
    }

    public void Phanloaitonkho() {
        System.out.print("Phan loai ton kho: ");
        if (soluong == 0) {
            System.out.println("Het sach");
        } else if (soluong >= 1 && soluong <= 5) {
            System.out.println("Sap het");
        } else if (soluong > 6 && soluong <= 20) {
            System.out.println("Con it");
        } else {
            System.out.println("Con nhieu");
        }
    }

    public void Chonloaisach(Scanner sc) {
        int loaiSach;

        System.out.println("-----LOAI SACH-----");
        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");

        System.out.printf("Chon loai sach: ");
        loaiSach = sc.nextInt();

        switch (loaiSach) {
            case 1:
                System.out.println("Loai sach: Sach giao khoa");
                break;
            case 2:
                System.out.println("Loai sach: Sach tham khao");
                break;
            case 3:
                System.out.println("Loai sach: Sach chuyen nganh");
                break;
            case 4:
                System.out.println("Loai sach: Sach khac");
                break;
            default:
                System.out.println("Khong co loai sach nay!");
        }
    }
}

public class QUANLITHUVIEN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SACH sach = new SACH();
        sach.NHAP(sc);
        sach.XUAT();

        System.out.println("Thanh tien: " + sach.Thanhtien());
        System.out.println("Phi van chuyen: " + sach.Phivanchuyen());
        System.out.println("Tong tien: " + sach.Tongtien());
        System.out.println("\n");

        System.out.printf("Kiem tra tinh hop le cua thong tin sach: \n");
        sach.Kiemtrahople();
        System.out.println("\n");
        sach.Phanloaigia();
        sach.Phanloaitonkho();
        sach.Chonloaisach(sc);

        sc.close();
    }
}