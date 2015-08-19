package custom;

public class ClonableTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		System.out.println("Тестирование клонирования с автоувеличением поля \"i\" у клона");
		
		ItemClonable itMain = new ItemClonable(2);
		ItemClonable itClone = null;
		itClone = (ItemClonable) itMain.clone();
		
		System.out.println("itMain.i  = " + itMain.i);
		System.out.println("itClone.i = " + itClone.i);
		System.out.println("itMain == itClone: " + (itMain == itClone));

		System.out.println("Меняем: itMain.i = " + 7);
		itMain.i = 7;
		System.out.println("itMain.i  = " + itMain.i);
		System.out.println("itClone.i = " + itClone.i);
		System.out.println("itClone.i остается прежним. Т.е. itClone - клон от itMain");
	}

}

class ItemClonable implements Cloneable {
	
	public int i;
	
	public ItemClonable(int i) {
		this.i = i;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		ItemClonable tmp = (ItemClonable) super.clone();
		tmp.i++; 
		return tmp;
	}
	
}
