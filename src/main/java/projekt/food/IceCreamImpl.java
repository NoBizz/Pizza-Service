package projekt.food;

import java.math.BigDecimal;
import java.util.List;

class IceCreamImpl implements IceCream{
    final BigDecimal price;
    final double weight;
    final Food.Variant<?, ?> foodVariant;
    final List<? extends Extra<?>> extras;
    final String flavor;

    public IceCreamImpl(BigDecimal price, double weight, Food.Variant<?, ?> foodVariant, List<? extends Extra<?>> extras, String flavor) {
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
}
