package goldmine2;

import java.util.ArrayList;
import java.util.List;

public class Route {

	List<Point> points = new ArrayList<>();
	int profit = 0;
	
	public Route addPoint(Point point) {
		points.add(point);
		profit = points.stream().mapToInt(p->p.value).sum();
		return this;
	}
	
	@Override
	public String toString() {
		String str = "Route:";
		for(Point point:points)
			str += point.toString();
		return str;
	}

	public Point getLastPoint() {
		return points.get(points.size()-1);
	}
	
	public Route clone() {
		Route route = new Route();
		route.points.addAll(points);
		return route;
	}
}
