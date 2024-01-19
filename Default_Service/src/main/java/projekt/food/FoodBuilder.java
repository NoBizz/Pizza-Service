package projekt.food;

import java.util.List;

/**
 * A functional interface, used to build different dishes ordered by customers
 *
 * @param <F> The Foodtype, the dishes type of food
 * @param <C> The Configtype, the dishes configuration
 * @param <V> The Varianttype, The dish variant
 */
@FunctionalInterface
public interface FoodBuilder<F extends Food, C extends Food.Config, V extends Food.Variant<F, C>> {
	
	/**
	 * 
	 * @return
	 */
	
	F build(C config, V variant, List<Extras> list);

}
