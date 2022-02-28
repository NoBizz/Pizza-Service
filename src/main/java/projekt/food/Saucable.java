package projekt.food;

import java.util.function.UnaryOperator;

/**
 * Sauce interface for dishes that can be sauced.
 */
public interface Saucable extends Food{
    /**
     * The name of the sauce.
     *
     * @return name of sauce
     */
    String getSauce();

    /**
     * Saucaeble.Config extending Food.Config.
     */
    interface Config extends Food.Config{
        /**
         * A sauces operator.
         *
         * @param sauceMutator unaryOperator of a sauce
         */
        void sauce(UnaryOperator<String> sauceMutator);

        /**
         * Concatination of all sauces unaryOperators.
         * @return concatination of unaryOperators
         */
        UnaryOperator<String> getSauceMutator();
    }

    /**
     * Sauceable.Variant extending Food.Variant.
     */
    interface Variant extends Food.Variant{
        /**
         * Base Sauce of a Sauceble.Variant.
         * @return base Sauce
         */
        String getBaseSauce();
    }
}
