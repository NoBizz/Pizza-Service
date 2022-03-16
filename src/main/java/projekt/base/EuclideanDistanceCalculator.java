package projekt.base;

/**
 * 
 * @author Jason L
 */
public class EuclideanDistanceCalculator implements DistanceCalculator {

	/**
	 * Calculates the euclidian distance between location points a and b, equating to the time needed to traverse between a and b
	 * @param a point a 
	 * @param b point b
	 * @return the distance between both points
	 */
	@Override
	public double calculateDistance(Location a, Location b) {
		return Math.sqrt(Math.pow((a.getX()-b.getX()), 2) + Math.pow(a.getY()-b.getY(), 2));
	}

}
