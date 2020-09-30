package goldmine;

import java.util.ArrayList;
import java.util.List;

public class Goldmine {

	public static void main(String[] args) {
		System.out.println(solve("matrix.txt") == 12);
		System.out.println(solve("matrix4.txt") == 83);
		System.out.println(solve("matrix2.txt") == 32);
		System.out.println(solve("matrix3.txt") == 16);
	}
	
	public static int solve(String fileName) {
		int[][] matrix = Misc.readMatrixFromFile(fileName);
		Misc.show(matrix);

		List<Point> list = new ArrayList<>();

		int row = 0;
		Point point = new Point();
		for (int col = 0; col < matrix[0].length; col++) {
			point = findMaxRowForCurrentColumnAndPreviousRow(matrix, col, point.row);
			list.add(point);
		}

		System.out.println(list);
		int summ = list.stream().map(p -> p.value).reduce(0, (a, b) -> a + b);
		System.out.println(summ);
		return summ;
	}

	public static Point findMaxRowForCurrentColumnAndPreviousRow(int[][] matrix, int currentColumn,
			Integer previousRow) {
		Point point = new Point();
		int iRow = 0;
		for (int[] row : matrix) {

			if (previousRow == null || Math.abs(previousRow - iRow) <= 1)
				if (point.value < row[currentColumn]) {
					point.value = row[currentColumn];
					point.col = currentColumn;
					point.row = iRow;
				}
			iRow++;
		}
		return point;
	}
}
