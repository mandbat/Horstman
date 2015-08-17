package myclasses;

public class Obj {

	private int i;

	public Obj(int k) {
		i = k;
	}

	/**
	 * 
	 * @param x —одержит величину на которую необходимо увеличить значение переменной
	 */
	public void changeI(int x) {
		i = i * x;
	}
	
	/**
	 * ¬озвращает переменную I
	 * @return возвращает значение
	 */
	public int getI() {
		return i;
	}

}