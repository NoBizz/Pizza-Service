package projekt.food;

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
    
   /* final static FoodBuilder<Pizza, Pizza.Config, Variant> BUILDER = new FoodBuilder<Pizza, Pizza.Config, Variant>() {
        @Override
        public Pizza build(Pizza.Config config, Variant Variant, List<Extras> compatible_extras) {
            return new PizzaImpl(price,weight,Variant,extras,diameter,sauce);
        }
    };*/
    
//DONE
    /**
     * Constructor of PizzaImpl sets the objectconstants to the given params
     * @param price of pizza
     * @param weight of pizza
     * @param foodVariant of pizza
     * @param extras on pizza
     * @param diameter of pizza
     * @param sauce of pizza
     */
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

    /**
     * {@link Food.Config}
     *
     */
    private static class Config implements Pizza.Config{
        UnaryOperator<BigDecimal> priceMutator;
        DoubleUnaryOperator weightMutator;
        DoubleUnaryOperator diameterMutator;
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

        @Override
        public void diameter(DoubleUnaryOperator diameterMutator) {
            this.diameterMutator = diameterMutator;
        }

        /**
        * {@inheritDoc}
        */
        @Override
        public DoubleUnaryOperator getDiameterMutator() {
            return this.diameterMutator;
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
    
    /**
     * {@link Food.Variant}
     *
     */
    static class Variant implements Saucable.Variant{
    	
    	String name;
    	FoodType type;
    	BigDecimal basePrice;
    	double baseWeight;
    	String baseSauce;
    	double baseDiameter;
    	
    	Variant(String name, FoodType type, BigDecimal basePrice, double baseWeight, String baseSauce, double baseDiameter){
    		this.name = name;
    		this.type = type;
    		this.basePrice = basePrice;
    		this.baseWeight = baseWeight;
    		this.baseSauce = baseSauce;
    		this.baseDiameter = baseDiameter;
    	}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public FoodType getFoodType() {
			return type;
		}

		@Override
		public BigDecimal getBasePrice() {
			return basePrice;
		}

		@Override
		public double getBaseWeight() {
			return baseWeight;
		}
    	

    }
}
