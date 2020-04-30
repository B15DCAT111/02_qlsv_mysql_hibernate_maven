package common;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import entity.Student;

public class Share {
	public static String menu() {

		return "           ,-----.    ,--.     ,---.   ,--.   ,--.  \n"
				+ "          '  .-.  '   |  |    '   .-'   \\  `.'  /   \n"
				+ "          |  | |  |   |  |    `.  `-.    \\     /   \n"
				+ "          '  '-'  '-. |  '--. .-'    |    \\   /    \n"
				+ "           `-----'--' `-----' `-----'      `-'     \n" +

				"=========================== MENU ===========================   \n"
				+ "| 1. Hiển thị danh sách sinh viên                          | \n"
				+ "| 2. Thêm sinh viên                                        | \n"
				+ "| 3. Sủa sinh viên theo mã sinh viên                       | \n"
				+ "| 4. Xóa sinh viên theo mã sinh viên                       | \n"
				+ "| 5. Tìm kiếm sinh viên theo lựa chọn                      | \n"
				+ "| \t5.1 : mã sinh viên                                     | \n"
				+ "| \t5.2 : tên sinh viên                                    | \n"
				+ "| \t5.3 : Gioi Tinh                                        | \n"
				+ "============================================================ \n";
	}

	public static Student inputInfoStudent() throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap tên sinh vien : ");
		String name = scanner.nextLine();
		System.out.println("Nhập gioi tinh (nam/nu) :");
		String sex = scanner.nextLine();
		if (Lib.checkSex(sex) != false) {
			System.out.println("Gioi tinh nhap sai dinh dang");
			return null;
		}
		System.out.println("Nhập ngay sinh (dd/mm/yyyy) : ");
		String bod = scanner.nextLine();
		if (!Lib.checkDate(bod)) {
			System.out.println("Ngay nhap sai dinh dang");
			return null;
		}

		return new Student(name, Lib.genSex(sex), Lib.convertStringToDate(bod));
	}

	/**
	 * Hien thi danh sach sinh vien
	 *
	 * @param listStd
	 */
	public static void displayListStudent(List<Student> listStd) {
		if (null != listStd && listStd.size() > 0) {
			listStd.forEach((Student std) -> {
				String sex;
				String bod = Lib.convertDateToString(std.getBod());
				if (std.isSex()) {
					sex = "Nam";
				} else {
					sex = "Nu";
				}
				System.out.println(std.getId() + "." + std.getName() + " - " + sex + " - " + bod);
			});
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------------------------------------------");
		} else {
			System.out.println("Danh sach sinh viên trống !");
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------------------------------------------");
		}

	}

	/**
	 * Hien thi 1 sinh vien
	 *
	 * @param std
	 */
	public static void displayStudent(Student std) {
		System.out.println("--- Ket qua tim kiem ---");
		if (null != std && null != std.getId()) {
			String sex;
			String bod = Lib.convertDateToString(std.getBod());
			if (std.isSex()) {
				sex = "Nam";
			} else {
				sex = "Nu";
			}
			System.out.println(std.getId() + "." + std.getName() + " - " + sex + " - " + bod);
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------------------------------------------");
		} else {
			System.out.println("Không có sinh viên nào thỏa mãn điều kiện tìm kiếm !");
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------------------------------------------");
		}

	}

	public static Long inputId() {
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		if (!Lib.checkNumber(id)) {
			System.out.println("id phai co dinh dang so");
			return null;
		}
		return Long.parseLong(id);
	}

	public static String inputName() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public static String inputSex() {
		Scanner scanner = new Scanner(System.in);
		String sex = scanner.nextLine();
		if (Lib.checkSex(sex) != false) {
			System.out.println("Gioi tinh nhap sai dinh dang");
			return null;
		}
		return sex;
	}

}
