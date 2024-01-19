package projekt.base;

/**
 * @author Jason L
 */
class Location {
	
	private final int x;
	private final int y;
	
	/**
	 * Public Constructor of this class, initializing the location coordinate field.
	 * Models the location of a customer.
	 * @param x the x coordinate of the location
	 * @param y the y coordinate of the location
	 */
	public Location(int x, int y) {
		this.x = x;
		this.y= y;
	}

	/**
	 * 
	 * @return the x location coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @return the y location coordinate
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sums the current location and the given location points
	 * @param location the location point to add
	 * @return the sum
	 */
	public Location add(Location location){
		return new Location(x+location.getX(), y+location.getY());
	}
	/**
	 * Subtracts the given location point from the current location
	 * @param location the location point to subtract
	 * @return the difference
	 */
	public Location subtract(Location location){
		return new Location(x-location.getX(), y-location.getY());
	}
	
}
