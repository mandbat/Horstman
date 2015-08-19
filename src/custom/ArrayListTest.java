package custom;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		
		ArrayList<Employee> empList = new ArrayList<>(5);
		empList.ensureCapacity(3);
		empList.add(new Employee("Ivan ", 15, 50));
		empList.add(new Employee("Andrey ", 32, 65));
		empList.add(new Employee("Andrey ", 32, 65));
		empList.add(new Employee("Andrey ", 32, 65));


		for (Employee e : empList) {
			System.out.println("Имя: " + e.getName() + "\t Возраст: " + e.getAge() + "\t Вес:" + e.getWeight());
		}
		System.out.println("Всего работников: " + empList.size());
	}
}

class Employee {

	private String name;
	private int age;
	private int weight;

	public Employee(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	String getName() {
		return name;
	}

	int getAge() {
		return age;
	}

	int getWeight() {
		return weight;
	}
	
	void setAge(int age){
		
	}

}