package cybersoft;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import cybersoft.CongTy;
import cybersoft.GiamDoc;
import cybersoft.NhanVien;
import cybersoft.NhanVienThuong;
import cybersoft.TruongPhong;

public class QuanLy {
	private List<NhanVien> danhSachNhanVien;
	private CongTy congTy;
	float tongLuong;
	double loiNhuanThang = 0;
		
	private List<NhanVienThuong> danhSachNhanVienThuong;
	private List<TruongPhong> danhSachTruongPhong;
	private List<GiamDoc> danhSachGiamDoc;
	
	public QuanLy() {
		danhSachNhanVien = new ArrayList<>();
		danhSachNhanVienThuong = new ArrayList<>();
		danhSachTruongPhong = new ArrayList<>();
		danhSachGiamDoc = new ArrayList<>();
		tongLuong = 0;
		congTy = new CongTy();
	}
	
	public List<NhanVienThuong> getDanhSachNhanVienThuong() {
		return danhSachNhanVienThuong;
	}

	public void setDanhSachNhanVienThuong(List<NhanVienThuong> danhSachNhanVienThuong) {
		this.danhSachNhanVienThuong = danhSachNhanVienThuong;
	}

	public List<TruongPhong> getDanhSachTruongPhong() {
		return danhSachTruongPhong;
	}

	public void setDanhSachTruongPhong(List<TruongPhong> danhSachTruongPhong) {
		this.danhSachTruongPhong = danhSachTruongPhong;
	}

	public List<GiamDoc> getDanhSachGiamDoc() {
		return danhSachGiamDoc;
	}

	public void setDanhSachGiamDoc(List<GiamDoc> danhSachGiamDoc) {
		this.danhSachGiamDoc = danhSachGiamDoc;
	}
	public double getLoiNhuanThang() {
		return loiNhuanThang;
	}

	public void setLoiNhuanThang(double loiNhuanThang) {
		this.loiNhuanThang = loiNhuanThang;
	}
	
	public void nhapThongTinCongTy(Scanner scanner) {
		congTy.nhapThongTin(scanner);
	}
	
	public void xuatThongTinCongTy() {
		congTy.xuatThongTin();
	}
	
	public boolean them(NhanVien nv) {
		if(nv == null)
			return false;
		if(nv.getMaSo() == null || nv.getMaSo().equals(""))
			return false;
			
		return danhSachNhanVien.add(nv);
	}
	
	public boolean xoa(String maSo) {
		return false;
	}
	public void header(String thongTinHeader, String thongTin) {
		System.out.println("------------------------------------------------ Danh sách " + thongTinHeader +" -----------------------------------------------------------");
		System.out.printf("\n%-5s%-15s%-30s%-20s%-20s%-20s%-20s%-30s","STT","Mã số","Họ tên","Số điện thoại","Số ngày làm","Lương một ngày","Lương tháng",thongTin);
		System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------");
	}
	public void xuatDanhSachNhanVien() {
		int stt = 1;
		header("nhân sự toàn công ty","");
		for(NhanVien nv:danhSachNhanVien) {
			nv.tinhLuong();
			System.out.println();
			nv.xuatThongTin(stt);
			stt++;
		}
	}
		
	// danh sách nhân viên
	public List<NhanVienThuong> dsNhanVienThuong(){
		for(NhanVien nv:danhSachNhanVien) {
			if(nv instanceof NhanVienThuong) {
				danhSachNhanVienThuong.add((NhanVienThuong) nv);
			}
		}
		return danhSachNhanVienThuong;
	}

	public List<TruongPhong> dsTruongPhong(){
		for(NhanVien nv:danhSachNhanVien) {
			if(nv instanceof TruongPhong) {
				danhSachTruongPhong.add((TruongPhong) nv);
			}
		}
		return danhSachTruongPhong;
	}	

	public List<GiamDoc> dsGiamDoc(){
		for(NhanVien nv:danhSachNhanVien) {
			if(nv instanceof GiamDoc) {
				danhSachGiamDoc.add((GiamDoc) nv);
			}
		}
		return danhSachGiamDoc;
	}				

	public NhanVienThuong nvLuongCaoNhat() {
		NhanVienThuong nv = this.danhSachNhanVienThuong.get(0);
				
		for(NhanVienThuong nhanVien:danhSachNhanVienThuong) {
			if(nhanVien.getLuongThang() > nv.getLuongThang() && danhSachNhanVienThuong.isEmpty() == false) {
				nv = nhanVien;
			}
			if(danhSachNhanVienThuong.isEmpty() == true) { //chỗ này không đúng nhưng chưa biết làm ntn khi nếu chưa nhập nhân viên ! chưa biết cách làm
				System.out.println("Công ty không có nhân viên");
			}
		}
		return nv;
	}

	public TruongPhong tpNhieuNhanVienThuong() {
		TruongPhong tp = this.danhSachTruongPhong.get(0);
		
		for(TruongPhong truongPhong:danhSachTruongPhong) {
			if(truongPhong.getSoNhanVien() > tp.getSoNhanVien() && danhSachTruongPhong.isEmpty() == false) {
				tp = truongPhong;
			}
		}
		return tp;
	}

	public GiamDoc gdNhieuCoPhan() {
		GiamDoc gd = this.danhSachGiamDoc.get(0);
		
		for(GiamDoc giamDoc:danhSachGiamDoc) {
			if(giamDoc.getSoCoPhan() > gd.getSoCoPhan() && danhSachGiamDoc.isEmpty() == false) {
				gd = giamDoc;
			}
		}
		return gd;
	}

	public float tongLuongCongTy() {
		this.tongLuong = 0;
		for(NhanVien nhanSu:danhSachNhanVien) {
			this.tongLuong = this.tongLuong + nhanSu.tinhLuong();
		}
		return this.tongLuong;
	}

	public double tinhLoiNhuan() {
		loiNhuanThang = congTy.getDoanhThuThang() - this.tongLuong;
		return this.loiNhuanThang;
			 
	}	
	

	public void xuatDSGiamDoc(){
		int stt = 1;
		this.dsGiamDoc();
		
		for(GiamDoc gd : danhSachGiamDoc) {
			gd.tinhLuong();
			gd.thuNhapGiamDoc();
			System.out.println(String.format("%-5s%-15s%-30s%-25.2f",stt,gd.getMaSo(),gd.getHoTen(),gd.getThuNhapGiamDoc()));
			stt++;
		}
	} 
	
	public void xoaNhanVien(String maNS) {
		int i = 0;
		
		for(NhanVien nv : danhSachNhanVien) {
			if(nv.getMaSo().equals(maNS) && nv!=null) {
				i++;
				if(nv instanceof GiamDoc) {
					this.danhSachNhanVien.remove(nv);
					this.danhSachGiamDoc.remove(nv);
					break;
				}
				if(nv instanceof NhanVienThuong) {
					if(!((NhanVienThuong) nv).getMaSoTruongPhong().equals("")) {
						
						for(TruongPhong tp:danhSachTruongPhong) {
							if(tp.getMaSo() == ((NhanVienThuong) nv).getMaSoTruongPhong())
							{	
								tp.setSoNhanVien(tp.getSoNhanVien() -1);
								this.danhSachNhanVien.remove(nv);
								this.danhSachNhanVienThuong.remove(nv);
								break;
							}
						}
						break;
					}
					if(((NhanVienThuong) nv).getMaSoTruongPhong().equals("")) {
						this.danhSachNhanVienThuong.remove(nv);
						this.danhSachNhanVien.remove(nv);
						break;
					}
				}
				if(nv instanceof TruongPhong) {
					for (NhanVienThuong nvs : danhSachNhanVienThuong){
						if(nvs.getMaSoTruongPhong().equals(maNS)) {
							((NhanVienThuong) nv).setMaSoTruongPhong("");
						}
					}
					this.danhSachNhanVien.remove(nv);
					this.danhSachTruongPhong.remove(nv);
					break;
					
				}
			}
		}
		if(i==0) {
			System.out.println("Error");
		}
	}
}
