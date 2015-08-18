package custom;

import java.util.Arrays;

public class SortObject {

	public static void main(String[] args) {
		
		Item[] items = new Item[3];
		items[0] = new Item("it-01", 10, 10, 10);
		items[1] = new Item("it-02", 20, 10, 10);
		items[2] = new Item("it-03", 5, 5, 5);
		
		for (Item i : items){
			System.out.println(i.getId());
		}
		
		Arrays.sort(items);
		
		System.out.println("Sorted:");
		for (Item i : items){
			System.out.println(i.getId());
		}
	}

}

class Item implements Comparable<Item> {

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

	public String getId() {
		return this.id;
	}

}