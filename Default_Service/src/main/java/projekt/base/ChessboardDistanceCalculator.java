package projekt.base;

public class ChessboardDistanceCalculator implements DistanceCalculator {

	/**
	 * Calculates the distance between location points a and b, equating to the time needed to traverse between a and b
	 * The distance is the longest of either distance between the x- or y-parts of both points.
	 * @param a point a 
	 * @param b point b
	 * @return the distance between both points
	 */
	@Override
	public double calculateDistance(Location a, Location b) {
		return Math.max(Math.abs(a.getX()-b.getX()), Math.abs(a.getY()-b.getY()));
	}

}
