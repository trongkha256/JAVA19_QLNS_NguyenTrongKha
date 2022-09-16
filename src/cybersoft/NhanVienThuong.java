package cybersoft;

import java.util.Formatter;
import java.util.Scanner;

public class NhanVienThuong extends NhanVien {
	/* properties */
	private TruongPhong truongPhongQuanLy;
	private String maSoTruongPhong;

	public NhanVienThuong() {
		super();
	}

	public NhanVienThuong(String maSo, String hoTen, String soDienThoai, float soNgayLam, float luongMotNgay,
			float luongThang, String maSoTruongPhong) {
		super(maSo, hoTen, soDienThoai, soNgayLam, luongMotNgay, luongThang);
		this.maSoTruongPhong = maSoTruongPhong;
	}

	public String getMaSoTruongPhong() {
		return maSoTruongPhong;
	}

	public void setMaSoTruongPhong(String maSoTruongPhong) {
		this.maSoTruongPhong = maSoTruongPhong;
	}

	public float getLuongMotNgay() {
		return luongMotNgay;
	}

	public TruongPhong getTruongPhongQuanLy() {
		return truongPhongQuanLy;
	}

	public void setTruongPhongQuanLy(TruongPhong truongPhongQuanLy) {
		this.truongPhongQuanLy = truongPhongQuanLy;
	}

	@Override
	public float tinhLuong() {
		this.luongMotNgay = 100;
		this.luongThang = this.soNgayLam * this.luongMotNgay;
		return this.luongThang;

	}

	@Override
	public void nhapThongTin(Scanner scanner) {
		super.nhapThongTin(scanner);

		System.out.println("Có trưởng phòng quản lý chưa?");
		System.out.println("1: có");
		System.out.println("2: không");

		int choice = Integer.parseInt(scanner.nextLine());
		if (choice == 1) {
			System.out.print("Mã trưởng phòng: ");
			maSoTruongPhong = scanner.nextLine();
		} else if (choice == 2) {
			maSoTruongPhong = "";
		} else {
			System.out.println("Vui lòng nhập lại");
		}
		;
	}

	@Override
	public void xuatThongTin(int stt) {
		super.xuatThongTin(stt);
		System.out.println(String.format("%-30s", this.maSoTruongPhong));
	}

}
