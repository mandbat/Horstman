package custom;

import java.util.Arrays;

public class SortObject {

	public static void main(String[] args) {
		
		//br02 change

		Item[] items = new Item[3];
		items[0] = new Item("it-01", 10, 10, 10);
		items[1] = new Item("it-02", 20, 10, 10);
		items[2] = new Item("it-03", 5, 5, 5);

		for (Item i : items) {
			System.out.println(i.getId() + " - " + i.getVolume());
		}

		Arrays.sort(items);

		System.out.println("Sorted:");
		for (Item i : items) {
			System.out.println(i.getId() + " - " + i.getVolume());
		}
		
		System.out.println("Класс реализует Comparable? - " + ((items[0] instanceof Comparable<?>)?"Да":"Нет"));
		
	}

}

class Item implements Comparable<Item>, Cloneable {

	private int heigh;
	private int width;
	private int lengthy;
	private String id;

	@Override
	public int compareTo(Item o) {

		int this_volume = this.heigh * this.width * this.lengthy;
		int o_volume = o.heigh * o.width * o.lengthy;

		return Integer.compare(this_volume, o_volume);

	}

	public Item(String id, int heigh, int lengthy, int width) {
		this.id = id;
		this.heigh = heigh;
		this.lengthy = lengthy;
		this.width = width;
	}

	public int getVolume() {
		return this.heigh * this.width * this.lengthy;
	}

	public String getId() {
		return this.id;
	}

}