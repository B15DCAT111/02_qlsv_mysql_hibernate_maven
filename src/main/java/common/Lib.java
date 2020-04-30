package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class Lib {

	public static Date convertStringToDate(String date) throws ParseException {
		return new SimpleDateFormat("dd/MM/yyyy").parse(date);
	}

	public static boolean genSex(String sex) {
		if (sex.equals("nam")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkDate(String date) {
		String datePattern = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";
		return date.matches(datePattern);
	}

	public static boolean checkNumber(String number) {
		String numberPattern = "[0-9]+";
		return number.matches(numberPattern);
	}

	public static boolean checkSex(String sex) {
		if (null == sex || !sex.equals("nam") || !sex.equals("nu")) {
			return false;
		}
		return true;
	}

	public static String convertDateToString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(date);
	}

}
