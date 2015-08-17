package myclasses;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class StaticTest {

	public static void main(String[] args) {
		Date currDate = new Date();
		System.out.println("1. " + currDate.toString());
		A1.changeDate(currDate);
		System.out.println("1. " + currDate.toString());

		String s1 = "123";
		System.out.println(s1);
		Str.changeStr(s1);
		System.out.println(s1);

	}

}

class A1 {

	static void changeDate(Date dd) {

		System.out.println("2. " + dd);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(dd);
		cal.add(Calendar.HOUR, 1);
		dd = cal.getTime();
		System.out.println("2. " + dd);

	}

}

class Str {
	static void changeStr(String str) {
		str = str + " + new";
		System.out.println(str);
	}
}
