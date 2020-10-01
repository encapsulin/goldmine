package goldmine2;

import java.util.ArrayList;
import java.util.List;

import goldmine.Misc;

public class Goldmine2 {

	List<Route> routes = new ArrayList<>();

	public static void main(String[] args) {
		Goldmine2 goldmine = new Goldmine2();
		goldmine.solve("matrix.txt");
	}

	void solve(String fileName) {
		int[][] matrix = Misc.readMatrixFromFile(fileName);

		Route route = new Route();
		route.addPoint(new Point());
		findSubRoutes(route, matrix);
		

	}

	void findSubRoutes(Route route, int[][] matrix) {
		System.out.println(route);
		Point point = route.getLastPoint();
		
		Point pointRight = getPoint(matrix, point.row, point.col + 1);
		Point pointRightUp = getPoint(matrix, point.row, point.col + 1);
		Point pointRightDown = getPoint(matrix, point.row, point.col + 1);
		
		if(pointRight != null) {
			Route routeX = route.clone();
			routeX.addPoint(pointRight);
			routes.add(routeX);
			findSubRoutes(routeX,matrix);
		}
		
		if(pointRightUp != null) {
			Route routeX = route.clone();
			routeX.addPoint(pointRightUp);
			routes.add(routeX);
			findSubRoutes(routeX,matrix);
		}
		
		if(pointRightDown != null) {
			Route routeX = route.clone();
			routeX.addPoint(pointRightDown);
			routes.add(routeX);
			findSubRoutes(routeX,matrix);
		}
		

	}

	private Point getPoint(int[][] matrix, int row, int col) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		Point point = null;
		if (row <= rows && col <= cols) {
			point.col = col;
			point.row = row;
			point.value = matrix[row][col];
		}
		return point;
	}

}
