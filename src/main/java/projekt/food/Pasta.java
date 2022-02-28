package projekt.food;

import java.util.function.DoubleUnaryOperator;

/**
 * Interface for Pasta dishes.
 */
public interface Pasta extends Saucable{
    /**
     * Gets the thickness of a noodle.
     *
     * @return thichness of noodle
     */
    double getThickness();

    /**
     * Config for pasta.
     */
    interface Config extends Saucable.Config{
        /**
         * Sets the DoubleUnaryOperator of a noodle.
         *
         * @param thicknessMutator of noodle
         */
        void thickness(DoubleUnaryOperator thicknessMutator);

        /**
         * Get all the pastas unaryOperators.
         *
         * @return DoubleUnaryOperator of all pastas
         */
        DoubleUnaryOperator getThicknessMutator();
    }

    /**
     * Pasta.Variant extending Sauceable.Variant.
     */
    interface Variant extends Saucable.Variant{
        /**
         * Base Diameter of Pasta.Variant.
         * @return base Thickness
         */
        String getBaseThickness();
    }
}
