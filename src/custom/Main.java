package custom;

import java.util.Scanner;
import custom.ReportException;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int aa;
		try {
			aa = in.nextInt();

			if (aa > 10)
				throw new ReportException("����� ������ 10", "123");
			else System.out.println("It's ok!");

		} catch (ReportException e) {

			System.out.println("������ " + e.getMessage());
			System.out.println("��� " + e.getErrorCode());

		}
	}

}
