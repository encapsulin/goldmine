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
		Point pointX = getPoint(matrix, 0, 0);
		route.addPoint(pointX);
		findSubRoutes(route, matrix);	

	}

	void findSubRoutes(Route route, int[][] matrix) {
		//System.out.println(route);
		Point point = route.getLastPoint();
		
		Point pointRight = getPoint(matrix, point.row, point.col + 1);
		if(pointRight != null) {
			Route routeX = route.clone();
			routeX.addPoint(pointRight);
			System.out.println(routeX);
			routes.add(routeX);
			findSubRoutes(routeX,matrix);
		}
		
		Point pointRightUp = getPoint(matrix, point.row-1, point.col + 1);
		if(pointRightUp != null) {
			Route routeX = route.clone();
			routeX.addPoint(pointRightUp);
			routes.add(routeX);
			findSubRoutes(routeX,matrix);
		}
		
		Point pointRightDown = getPoint(matrix, point.row+1, point.col + 1);				
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
		if (row >= 0 && row < rows && col < cols) {
			point = new Point();
			point.col = col;
			point.row = row;
			point.value = matrix[row][col];
		}
		return point;
	}

}
