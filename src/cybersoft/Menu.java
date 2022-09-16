package cybersoft;

import java.util.Scanner;

import cybersoft.QuanLy;
import cybersoft.GiamDoc;
import cybersoft.NhanVien;
import cybersoft.NhanVienThuong;
import cybersoft.TruongPhong;

public class Menu {
	private QuanLy controller;
	private Scanner scanner = new Scanner(System.in);
	private double loiNhuanThang = 0;

	public Menu() {
		controller = new QuanLy();
	}

	public void start() {

		int option;

		do {
			inMenu();
			option = Integer.parseInt(scanner.nextLine());
		} while (xuLyMenu(option));
	}

	public void inMenu() {
		System.out.println("\nDanh sách chức năng:");
		System.out.println("\t1. Nhập thông tin công ty.");
		System.out.println("\t2. In thông tin công ty.");
		System.out.println("\t3. Thêm nhân sự.");
		System.out.println("\t4. Xóa nhân sự.");
		System.out.println("\t5. In danh sách nhân sự.");
		System.out.println("\t6. In tổng lương công ty.");
		System.out.println("\t7. Phân bổ nhân sự.");
		System.out.println("\t8. Tìm kiếm.");
		System.out.println("\t9. In danh sách nhân viên theo thứ tự lương giảm dần.");
		System.out.println("\t10. Danh sách thu nhập của giám đốc.");
		System.out.println("\t0. Thoát.");
		System.out.print("Lựa chọn: ");
	}

	public boolean xuLyMenu(int option) {
		boolean isContinue = true;
		String maNSXoa;

		if (option == 1)
			controller.nhapThongTinCongTy(scanner);
		else if (option == 2)
			controller.xuatThongTinCongTy();

		else if (option == 3)
			themNhanVien();

		else if (option == 4) {
			System.out.print("Nhập mã nhân sự muốn xóa: ");
			maNSXoa = scanner.nextLine();
			controller.xoaNhanVien(maNSXoa);
		} else if (option == 5)
			controller.xuatDanhSachNhanVien();

		else if (option == 6)
			System.out.print("Tổng lương công ty: " + controller.tongLuongCongTy());

		else if (option == 7) {
		}

		else if (option == 8)
			timKiem();

		else if (option == 9) {
		} else if (option == 10) {
			System.out.println(String.format("%-5s%-15s%-30s%-30s", "STT", "Mã số", "Họ tên", "Thu nhập"));
			System.out.println("-----------------------------------------------------------------------");
			controller.xuatDSGiamDoc();
		} else if (option == 0)
			isContinue = false;
		else
			System.out.println("Lựa chọn không hợp lệ.");

		return isContinue;
	}

	private void themNhanVien() {
		System.out.println("Loại nhân viên:");
		System.out.println("1. Nhân viên");
		System.out.println("2. Trưởng phòng");
		System.out.println("3. Giám đốc");
		System.out.print("Lựa chọn: ");

		NhanVien nhanVien;

		switch (Integer.parseInt(scanner.nextLine())) {
			case 1:
				nhanVien = new NhanVienThuong();
				break;
			case 2:
				nhanVien = new TruongPhong();
				break;
			case 3:
				nhanVien = new GiamDoc();
				break;
			default:
				System.out.println("Loại nhân viên không hợp lệ.");
				return;
		}

		nhanVien.nhapThongTin(scanner);
		controller.them(nhanVien);
	}

	private void timKiem() {
		System.out.println("1. Tìm nhân viên thường có lương cao nhất.");
		System.out.println("2. Tìm trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất.");
		System.out.println("3. Tìm giám đốc có số lượng cổ phẩn nhiều nhất.");
		System.out.print("Lựa chọn: ");
		int choice = Integer.parseInt(scanner.nextLine());
		if (choice == 1) {
			controller.dsNhanVienThuong();
			controller.header("nhân viên có lương cao nhất", "Mã trưởng phòng");
			controller.nvLuongCaoNhat().xuatThongTin(1);
		} else if (choice == 2) {
			controller.dsTruongPhong();
			controller.header("trưởng phòng có nhân viên dưới quyền nhiều nhất", "Số nhân viên QL");
			controller.tpNhieuNhanVienThuong().xuatThongTin(1);
		} else if (choice == 3) {
			controller.dsGiamDoc();
			controller.header("giám đốc có số cổ phần nhiều nhất", "Số cổ phần");
			controller.gdNhieuCoPhan().xuatThongTin(1);
		} else
			System.out.println("Error");
	}

}
