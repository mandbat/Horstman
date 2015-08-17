package myclasses;

import static java.lang.System.out;

public class FinalTest {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		St1 obj1 = new St1(6);
		System.out.println(obj1.a);
		St2 obj2 = new St2(3);
		System.out.println(obj2.a);
		
		out.println("sdsd");

	}

}

class St1 {
	static int a;
	
	public St1(int k) {
		a = k;
	}
}

class St2 {
	final int a;

	public St2(int k) {
		a = k;
	}
}
