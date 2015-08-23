package custom;

public class Obj {

	private int i;

	public Obj(int k) {
		i = k;
	}

	public void changeI(int x) {
		i = i * x;
	}
	
	public int getI() {
		return i;
	}

}