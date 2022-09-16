package cybersoft;

import java.util.Formatter;
import java.util.Scanner;

public class CongTy {
	private String ten;
	private String maSoThue;
	private double doanhThuThang;

	public double getDoanhThuThang() {
		return doanhThuThang;
	}

	public void setDoanhThuThang(double doanhThuThang) {
		this.doanhThuThang = doanhThuThang;
	}

	public void nhapThongTin(Scanner scanner) {
		System.out.println("---Nhập thông tin công ty---");
		System.out.print("Tên công ty: ");
		this.ten = scanner.nextLine();
		System.out.print("Mã số thuế: ");
		this.maSoThue = scanner.nextLine();
		System.out.print("Doanh thu tháng: ");
		this.doanhThuThang = Double.parseDouble(scanner.nextLine());
	}

	private void header() {
		System.out.println("-----------------------------Thông tin công ty--------------------------------");
		System.out.printf("%-30s%-30s%-30s", "Tên công ty", "Mã số thuế", "Doanh thu tháng");
		System.out.print("\n------------------------------------------------------------------------------");
	}

	public void xuatThongTin() {
		StringBuilder thongTin = new StringBuilder();
		Formatter fmt = new Formatter(thongTin);

		header();
		fmt.format("\n%-30s%-30s%-15.2f", this.ten, this.maSoThue, this.doanhThuThang);
		System.out.print(thongTin.toString());

	}
}
