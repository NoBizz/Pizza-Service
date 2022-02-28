package projekt.food;

import java.util.function.UnaryOperator;

public interface IceCream extends Food{
    /**
     * Gets the icecreams flavor.
     *
     * @return flavor of icecream
     */
    String getFlavor();

    /**
     * Config for icecreams.
     */
    interface Config extends Saucable.Config{
        /**
         * Set an icecreams operator.
         * @param flavorMutator of an icecream
         */
        void flavor(UnaryOperator<String> flavorMutator);

        /**
         * Gets all icecreams operators.
         * @return unaryOperator of icecreams
         */
        UnaryOperator<String> getFlavorMutator();
    }

    /**
     * IceCream.Variant extending Food.Variant.
     */
    interface Variant extends Food.Variant{
        /**
         * Base Flavor of a IceCream.Variant.
         * @return base Falvor
         */
        String getBaseFlavor();
    }
}
