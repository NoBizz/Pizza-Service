package projekt.food;

import java.math.BigDecimal;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

/**
 * Interface for Pizzas dishes.
 */
public interface Pizza extends Saucable{
	
	Pizza.Variant MARGHERITA = (Variant) new PizzaImpl.Variant("Margherita", FoodTypes.PIZZA ,BigDecimal.valueOf(9.75), 0.8, "Tomato", 30.0);
	Pizza.Variant HAWAII = (Variant) new PizzaImpl.Variant("Hawaii", FoodTypes.PIZZA, BigDecimal.valueOf(13.75), 0.8, "Tomato", 30.0);
	Pizza.Variant Rucola = (Variant) new PizzaImpl.Variant("Rucola", FoodTypes.PIZZA, BigDecimal.valueOf(14.50), 0.9, "Tomato", 30.0);
	Pizza.Variant BBQ = (Variant) new PizzaImpl.Variant("BBQ", FoodTypes.PIZZA, BigDecimal.valueOf(14.50), 1.1, "BBQ", 30.0);
	
    /**
     * Gets a pizzas diameter as a double value.
     *
     * @return diameter of pizza
     */
    double getDiameter();

    /**
     * Config for pizza.
     */
    interface Config extends Saucable.Config{
        /**
         * Sets the DoubleUnaryOperator of a pizza.
         *
         * @param diameterMutator of pizza
         */
        void diameter(DoubleUnaryOperator diameterMutator);

        /**
         * Gets the DoubleUnaryOperator of all pizzas.
         *
         * @return DoubleUnaryOperator of all pizzas
         */
        DoubleUnaryOperator getDiameterMutator();
    }

    /**
     * Pizza.Variant extending Sauceable.Variant.
     */
    interface Variant extends Saucable.Variant{
        /**
         * Base Diameter of a Pizza.Variant.
         * @return
         */
        double getBaseDiameter();
    }
}
