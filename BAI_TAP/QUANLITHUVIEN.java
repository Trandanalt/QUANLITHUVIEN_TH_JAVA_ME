package BAI_TAP;
import java.util.Scanner;

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
    }
}