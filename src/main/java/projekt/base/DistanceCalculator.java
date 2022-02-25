package projekt.base;

/**
 * Functional interface used to calculate the distance between two {@link Location#Location(int, int) Location(int, int)} 
 * points a and b, equating to the time needed to traverse between a and b.
 * 
 * @author Jason L
 *
 */
@FunctionalInterface
public interface DistanceCalculator {
	
	/**
	 * Calculates the distance between location points a and b, equating to the time needed to traverse between a and b
	 * @param a point a 
	 * @param b point b
	 * @return the distance between both points
	 */
	double calculateDistance(Location a, Location b);

}
