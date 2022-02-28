package projekt.food;

import java.math.BigDecimal;
import java.util.List;

class PastaImpl implements Pasta{
    final BigDecimal price;
    final double weight;
    final Food.Variant<?, ?> foodVariant;
    final List<? extends  Extra<?>> extras;
    final double thickness;
    final String sauce;

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
}
