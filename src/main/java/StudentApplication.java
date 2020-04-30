import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import common.Lib;
import common.Share;
import dao.StudentDAO;
import entity.Student;

public class StudentApplication {
	public static Scanner scanner = new Scanner(System.in);

	public static void run() throws ParseException {
		StudentDAO dao = new StudentDAO();
		String choose;
		boolean exit = false;
		// show menu
		System.out.println(Share.menu());
		while (true) {
			System.out.println("--- Chon chức năng bạn muốn ---");
			choose = scanner.nextLine();
			switch (choose) {
			case "1":
				System.out.println("1. Hiển thị danh sách sinh viên");
				Share.displayListStudent(dao.showAll());
				break;
			case "2":
				System.out.println("2. Thêm sinh viên");
				Student student = Share.inputInfoStudent();
				try {
					if (student == null) {
						System.out.println("Them moi khong thanh cong !!");
						Share.displayListStudent(dao.showAll());
					} else {
						dao.save(student);
						System.out.println("Them moi thanh cong !!");
						Share.displayListStudent(dao.showAll());
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Them moi khong thanh cong !!");
				}
				break;
			case "3":
				System.out.println("3. Sủa sinh viên theo mã sinh viên");
				try {
					System.out.println("Nhap ma sinh vien ban muon sua");
					Long id = Share.inputId();
					if (id != null) {
						Student std = dao.findById(id);
						Share.displayStudent(std);
						System.out.println("Nhập thông tin cần sửa: ");
						Student stde = Share.inputInfoStudent();
						if (stde == null) {
							System.out.println("Sua khong thanh cong !!");
							Share.displayListStudent(dao.showAll());
						} else {
							stde.setId(std.getId());
							dao.update(stde);
							System.out.println("Sua thanh cong !!");
							Share.displayListStudent(dao.showAll());
						}
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Tim kiem theo ma khong thanh cong !!");
				}
				break;
			case "4":
				System.out.println("4. Xóa sinh viên theo mã sinh viên");
				try {
					System.out.println("Nhap ma sinh vien ban muon xoa");
					Long id = Share.inputId();
					if (id != null) {
						Student std = dao.findById(id);
						Share.displayStudent(std);
						System.out.println("Bạn có chắc chắn muốn xóa sinh viên có mã là " + std.getId() + " (y/n)");
						String select = scanner.nextLine();
						switch (select) {
						case "y":
							dao.delete(std.getId());
							System.out.println("Xoa thanh cong !!");
							Share.displayListStudent(dao.showAll());
							break;
						case "n":
							exit = true;
							break;
						case "0":
							System.out.println("exited!");
							exit = true;
							break;
						default:
							System.out.println("invalid! please choose action in below menu:");
							break;
						}
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Xóa khong thanh cong !!");
				}
				break;
			case "5":
				System.out.println("5. Tìm kiếm sinh viên theo lựa chọn");
				System.out.println("-- Chọn kiểu tìm kiếm --");
				System.out.println("5.1 : mã sinh viên");
				System.out.println("5.2 : tên sinh viên");
				System.out.println("5.3 : gioi tinh ");
				String select1 = scanner.nextLine();
				switch (select1) {
				case "5.1":
					System.out.println("5.1 : mã sinh viên");
					try {
						System.out.println("Nhap ma sinh vien ban muon tim kiem");
						Long id = Share.inputId();
						if (id != null) {
							Student obj = new Student();
							obj.setId(id);
							List<Student> result = dao.search(obj);
							Share.displayListStudent(result);
						}

					} catch (Exception e) {
						System.out.println(e.getMessage());
						System.out.println("Tim kiem theo ma khong thanh cong !!");
					}
					break;
				case "5.2":
					System.out.println("5.2 : tên sinh viên");
					try {
						System.out.println("Nhap ten sinh vien ban muon tim kiem");
						String name = Share.inputName();
						Student obj = new Student();
						obj.setName(name);
						List<Student> listStd = dao.search(obj);
						Share.displayListStudent(listStd);
					} catch (Exception e) {
						System.out.println(e.getMessage());
						System.out.println("Tim kiem theo ten khong thanh cong !!");
					}
					break;
				case "5.3":
					System.out.println("5.3 : gioi tinh ");
					try {
						System.out.println("Nhập gioi tinh (nam/nu) :");
						String sex = Share.inputSex();
						if (sex != null) {
							List<Student> listStd = dao.searchBySex(Lib.genSex(sex));
							Share.displayListStudent(listStd);
						} 

					} catch (Exception e) {
						System.out.println(e.getMessage());
						System.out.println("Tim kiem theo diem khong thanh cong !!");
					}
					break;
				case "0":
					System.out.println("exited!");
					exit = true;
					break;
				default:
					System.out.println("invalid! please choose action in below menu:");
					break;
				}
				break;
			case "0":
				System.out.println("exited!");
				exit = true;
				break;
			default:
				System.out.println("invalid! please choose action in below menu:");
				break;
			}
			if (exit) {
				break;
			}
			try {
				// assuming it takes 20 secs to complete the task
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// show menu
			System.out.println(Share.menu());
		}
	}

	public static void main(String[] args) throws ParseException {
		System.out.println("LOADING DATA ...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("--- LOADING DATA SUCCESSFUL ---");
		System.out.println("Let's start project ...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		run();
	}

}
