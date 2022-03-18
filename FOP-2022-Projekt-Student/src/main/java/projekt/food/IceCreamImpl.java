package projekt.food;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

class IceCreamImpl implements IceCream{
    final BigDecimal price;
    final double weight;
    final Food.Variant<?, ?> foodVariant;
    final List<? extends Extra<?>> extras;
    final String flavor;
    
    //static final FoodBuilder<Pizza, Pizza.Config, Food.Variant> BUILDER;

    /**
     * Constructor of IceCreamImpl sets the objectconstants to the given params
     * @param price
     * @param weight
     * @param foodVariant
     * @param extras
     * @param flavor
     */
    IceCreamImpl(BigDecimal price, double weight, Food.Variant<?, ?> foodVariant, List<? extends Extra<?>> extras, String flavor) {
        this.price = price;
        this.weight = weight;
        this.foodVariant = foodVariant;
        this.extras = extras;
        this.flavor = flavor;
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
    public String getFlavor() {
        return this.flavor;
    }

    private static class Config implements IceCream.Config{
        UnaryOperator<BigDecimal> priceMutator;
        DoubleUnaryOperator weightMutator;
        UnaryOperator<String> flavorMutator;

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
        public void flavor(UnaryOperator<String> flavorMutator) {
            this.flavorMutator = flavorMutator;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public UnaryOperator<String> getFlavorMutator() {
            return this.flavorMutator;
        }
    }
    
    /**
     * {@link Food.Variant}
     *
     */
    static class Variant implements Food.Variant<Food, Config>{
    	
    	String name;
    	FoodType type;
    	BigDecimal basePrice;
    	double baseWeight;
    	
    	Variant(String name, FoodType type, BigDecimal basePrice, double baseWeight){
    		this.name = name;
    		this.type = type;
    		this.basePrice = basePrice;
    		this.baseWeight = baseWeight;
    	}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public FoodType<Food, Config> getFoodType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal getBasePrice() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public double getBaseWeight() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Config createEmptyConfig() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Food create(List<? extends Extra<? super Config>> extras) {
			// TODO Auto-generated method stub
			return null;
		}
    }
}
