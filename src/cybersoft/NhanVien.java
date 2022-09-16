package cybersoft;

import java.util.Formatter;
import java.util.Scanner;

public class NhanVien {
	/* properties */
	protected String maSo;
	protected String hoTen;
	protected String soDienThoai;
	protected float soNgayLam;
	protected float luongMotNgay;
	protected float luongThang;
	
	/* constructors */
	public NhanVien() {
		
	}
	public NhanVien(String maSo, String hoTen, String soDienThoai, float soNgayLam, float luongMotNgay, float luongThang) {
		this.maSo = maSo;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.soNgayLam = soNgayLam;
		this.luongMotNgay = luongMotNgay;
		this.luongThang = luongThang;
	}
	
	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public float getSoNgayLam() {
		return soNgayLam;
	}

	public void setSoNgayLam(float soNgayLam) {
		this.soNgayLam = soNgayLam;
	}

	public float getLuongMotNgay() {
		return luongMotNgay;
	}

	public void setLuongMotNgay(float luongMotNgay) {
		this.luongMotNgay = luongMotNgay;
	}

	public float getLuongThang() {
		return this.luongThang;
	}

	public void setLuongThang(float luongThang) {
		this.luongThang = luongThang;
	}
	public String getMaSo() {
		return this.maSo;
	}
	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public float tinhLuong() {
		this.luongThang = this.soNgayLam * this.luongMotNgay;
		return this.luongThang;
	}
	
	public void xuatThongTin(int stt) {
		StringBuilder thongTin = new StringBuilder();
		Formatter fmt = new Formatter(thongTin);
			
		fmt.format("%-5s%-15s%-30s%-20s%-20.0f%-20.2f%-20.2f",stt, this.maSo,this.hoTen,this.soDienThoai,this.soNgayLam,this.luongMotNgay,this.luongThang);
		System.out.print(thongTin.toString());
	}
	
	public void nhapThongTin(Scanner scanner) {
		System.out.print("Nhập mã số: ");
		this.maSo = scanner.nextLine();
		System.out.print("Nhập họ tên: ");
		this.hoTen = scanner.nextLine();
		System.out.print("Nhập số điện thoại: ");
		this.soDienThoai = scanner.nextLine();
		System.out.print("Nhập số ngày làm: ");
		this.soNgayLam = Float.parseFloat(scanner.nextLine());
		
	}

	
}