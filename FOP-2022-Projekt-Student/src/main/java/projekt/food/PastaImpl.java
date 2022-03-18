package projekt.food;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

class PastaImpl implements Pasta{
    final BigDecimal price;
    final double weight;
    final Food.Variant<?, ?> foodVariant;
    final List<? extends  Extra<?>> extras;
    final double thickness;
    final String sauce;

    final FoodBuilder<Pasta,Pasta.Config,Pasta.Variant> BUILDER = new FoodBuilder<Pasta, Pasta.Config, Variant>() {
        @Override
        public Pasta build(Pasta.Config config, Variant Variant, List<Extras> compatible_extras) {
            return new PastaImpl(price,weight,foodVariant,extras,thickness,sauce);
        }
    };




    /**
     * Constructor of PastaImpl sets the objectconstants to the given params
     * @param price of pasta
     * @param weight of pasta
     * @param foodVariant of pasta
     * @param extras in pasta
     * @param thickness of noodle
     * @param sauce of pasta
     */
    PastaImpl(BigDecimal price, double weight, Food.Variant<?, ?> foodVariant, List<? extends  Extra<?>> extras, double thickness, String sauce){
        this.price = price;
        this.weight = weight;
        this.foodVariant = foodVariant;
        this.extras = extras;
        this.thickness = thickness;
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
    public double getThickness() {
        return this.thickness;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSauce() {
        return this.sauce;
    }

    private static class Config implements Pasta.Config{
        UnaryOperator<BigDecimal> priceMutator;
        DoubleUnaryOperator weightMutator;
        DoubleUnaryOperator thicknessMutator;
        UnaryOperator<String> sauceMutator;

        /**
         * {@inheritDoc}
         */
        @Override
        public void price(UnaryOperator<BigDecimal> priceMutator) {
           this.priceMutator = priceMutator;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public UnaryOperator<BigDecimal> getPriceMutator() {
            return this.priceMutator;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void weight(DoubleUnaryOperator weightMutator) {
            this.weightMutator = weightMutator;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public DoubleUnaryOperator getWeightMutator() {
            return this.weightMutator;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void thickness(DoubleUnaryOperator thicknessMutator) {
            this.thicknessMutator = thicknessMutator;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public DoubleUnaryOperator getThicknessMutator() {
            return this.thicknessMutator;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void sauce(UnaryOperator<String> sauceMutator) {
            this.sauceMutator = sauceMutator;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public UnaryOperator<String> getSauceMutator() {
            return this.sauceMutator;
        }
    }
}
