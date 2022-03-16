package projekt.food;

import java.util.LinkedList;
import java.util.List;

public class FoodTypeImpl<F extends Food, C extends Food.Config> implements FoodType<F, C> {

    private final String name;
    private final List<? extends Extra< ? super C>> compatibleExtras;
    private final List<Food.Variant<F,C>> foodVariants = new LinkedList<Food.Variant<F,C>>(); // ?

    /**
     * the constructor initializes the constants name and compatibleExtras with its actual parameters
     * @param name is the name of the foodtype
     * @param compatibleExtras are the extras compatible with this foodtype
     */


    public FoodTypeImpl (String name, List <? extends Extra< ? super C>> compatibleExtras){

        this.name = name;
        this. compatibleExtras = compatibleExtras;



    }







    /**
     * {@inheritDoc}
     */

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public List<? extends Extra<? super C>> getCompatibleExtras() {
        return this.compatibleExtras;
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void addFoodVariant(Food.Variant<F, C> variant) {

    }

    /**
     * {@inheritDoc}
     */

    @Override
    public List<? extends Food.Variant<F, C>> getFoodVariants() {
        return null;
    }
}
