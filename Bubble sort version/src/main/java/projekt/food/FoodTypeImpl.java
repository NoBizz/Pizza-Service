package projekt.food;

import java.util.ArrayList;
import java.util.List;

public class FoodTypeImpl <F extends Food,C extends Food.Config> implements FoodType{

    private String name;
    private List compatibaleExtras;
    private List<Food.Variant<F,C>> foodVariants;


    FoodTypeImpl(String name, List<Food.Variant<F,C>> compatibaleExtras){

        this.name = name;
        this.compatibaleExtras = compatibaleExtras;

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<? extends Extra> getCompatibleExtras() {
        return this.compatibaleExtras;
    }

    @Override
    public void addFoodVariant(Food.Variant variant) {
        this.foodVariants.add(variant);
    }

    @Override
    public List<? extends Food.Variant> getFoodVariants() {
        return null;
    }
}
