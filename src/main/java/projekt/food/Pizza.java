package projekt.food;

import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

/**
 * Interface for Pizzas dishes.
 */
public interface Pizza extends Saucable{
    /**
     * Gets a pizzas diameter as a double value.
     *
     * @return diameter of pizza
     */
    double getDiameter();

    /**
     * Config for pizza.
     */
    interface Config extends  Saucable.Config{
        /**
         * Sets the DoubleUnaryOperator of a pizza.
         *
         * @param diameterMutator of pizza
         */
        void diameter(DoubleUnaryOperator diameterMutator); //???

        /**
         * Gets the DoubleUnaryOperator of all pizzas.
         *
         * @return DoubleUnaryOperator of all pizzas
         */
        DoubleUnaryOperator getDiameterMutator(); //???
    }

    /**
     * Pizza.Variant extending Sauceable.Variant.
     */
    interface Variant extends Saucable.Variant{
        /**
         * Base Diameter of a Pizza.Variant.
         * @return
         */
        String getBaseDiameter();
    }
}
