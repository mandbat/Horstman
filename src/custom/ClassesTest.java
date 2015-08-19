package custom;

import java.util.Objects;

/**
 * 
 * @author Andrey Main class
 */
public class ClassesTest {
	
	/**
	 * 
	 * @param args arguments
	 */

	public static void main(String[] args) {

		String a = "a";
		String b = "a";
		
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		
		System.out.println(Objects.hash(a,b));

	}
	
	/**
	 * 
	 * @param a Integer value
	 * @return String value
	 */
	public String getStr(int a){
		return Integer.toString(a);
	}

}

class A {

	@Override
	public boolean equals(Object obj) {

		return true;
	}

}

class B extends A {

}