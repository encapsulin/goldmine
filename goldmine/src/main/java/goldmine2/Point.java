package goldmine2;

public class Point {
	public Integer col = 0;
	public Integer row = 0 ;
	public Integer value = 0;

	@Override
	public String toString() {
		return "(" + col + "," + row + ")=" + value;
	}

	public int rowPlus(int i) {		
		return row + i;
	}
}
