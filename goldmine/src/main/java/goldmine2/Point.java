package goldmine2;

public class Point {
	public int col = 0;
	public int row = 0 ;
	public int value = 0;

	@Override
	public String toString() {
		return " (" + col + "," + row + "):" + value;
	}

	public int rowPlus(int i) {		
		return row + i;
	}
}
