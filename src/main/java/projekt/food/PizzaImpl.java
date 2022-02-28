package projekt.food;

import java.io.ObjectInputFilter;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

class PizzaImpl implements Pizza{
    final BigDecimal price;
    final double weight;
    final Food.Variant<?, ?> foodVariant;
    final List<? extends  Extra<?>> extras;
    final double diameter;
    final String sauce;

    PizzaImpl(BigDecimal price, double weight, Food.Variant<?, ?> foodVariant, List<? extends  Extra<?>> extras, double diameter, String sauce){
        this.price = price;
        this.weight = weight;
        this.foodVariant = foodVariant;
        this.extras = extras;
        this.diameter = diameter;
        this.sauce = sauce;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getWeight() {
        return this.weight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Food.Variant<?, ?> getFoodVariant() {
        return this.foodVariant;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<? extends Extra<?>> getExtras() {
        return this.extras;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getDiameter() {
        return this.diameter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSauce() {
        return this.sauce;
    }

    private static class Config implements Pizza.Config{

        /**
        * {@inheritDoc}
        */
        @Override
        public void price(UnaryOperator<BigDecimal> priceMutator) {

        }

        /**
        * {@inheritDoc}
        */
        @Override
        public UnaryOperator<BigDecimal> getPriceMutator() {
            return null;
        }

        /**
        * {@inheritDoc}
        */
        @Override
        public void weight(DoubleUnaryOperator weightMutator) {

        }

        /**
        * {@inheritDoc}
        */
        @Override
        public DoubleUnaryOperator getWeightMutator() {
            return null;
        }

        @Override
        public void diameter(DoubleUnaryOperator diameterMutator) {

        }

        /**
        * {@inheritDoc}
        */
        @Override
        public DoubleUnaryOperator getDiameterMutator() {
            return null;
        }

        /**
        * {@inheritDoc}
        */
        @Override
        public void sauce(UnaryOperator<String> sauceMutator) {

        }

        /**
        * {@inheritDoc}
        */
        @Override
        public UnaryOperator<String> getSauceMutator() {
            return null;
        }
    }
}
