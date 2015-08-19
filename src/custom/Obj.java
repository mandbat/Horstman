package custom;

public class Obj {

	private int i;

	public Obj(int k) {
		i = k;
	}

	/**
	 * 
	 * @param x �������� �������� �� ������� ���������� ��������� �������� ����������
	 */
	public void changeI(int x) {
		i = i * x;
	}
	
	/**
	 * ���������� ���������� I
	 * @return ���������� ��������
	 */
	public int getI() {
		return i;
	}

}