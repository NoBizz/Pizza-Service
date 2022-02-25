package projekt.base;

class ManhattanDistanceCalculator implements DistanceCalculator {

	/**
	 * Calculates the distance between location points a and b, equating to the time needed to traverse between a and b
	 * The distance is the sum of distance between the x- and y-parts of both points.
	 * @param a point a 
	 * @param b point b
	 * @return the distance between both points
	 */
	@Override
	public double calculateDistance(Location a, Location b) {
		return Math.abs(a.getX()-b.getX())+Math.abs(a.getY()-b.getY());
	}

}
