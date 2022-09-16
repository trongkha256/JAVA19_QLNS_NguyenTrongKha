package cybersoft;

import java.util.Formatter;
import java.util.Scanner;

public class TruongPhong extends NhanVien {
	private int soNhanVien;

	public TruongPhong() {
		super();
	}

	public TruongPhong(String maSo, String hoTen, String soDienThoai, float soNgayLam, float luongMotNgay,
			float luongThang, int soNhanVien) {
		super(maSo, hoTen, soDienThoai, soNgayLam, luongMotNgay, luongThang);
		this.soNhanVien = soNhanVien;
	}

	public int getSoNhanVien() {
		return soNhanVien;
	}

	public void setSoNhanVien(int soNhanVien) {
		this.soNhanVien = soNhanVien;
	}

	@Override
	public float tinhLuong() {
		this.luongMotNgay = 200;
		this.luongThang = this.soNgayLam * this.luongMotNgay + 100 * this.soNhanVien;
		return this.luongThang;
	}

	@Override
	public void xuatThongTin(int stt) {
		super.xuatThongTin(stt);
		System.out.println(String.format("%-30s", this.soNhanVien));
	}

	@Override
	public void nhapThongTin(Scanner scanner) {
		super.nhapThongTin(scanner);
		System.out.print("Số nhân viên dưới quyền: ");
		this.soNhanVien = Integer.parseInt(scanner.nextLine());
	}

}
