package projekt.food;

/**
 * A sauce condiment
 * 
 * @author Jason L
 * @see Food
 */
public interface Saucable extends Food {
	
	/**
	 * @return A string describing what kind of sauce is given
	 */
	String getSauce();

}
