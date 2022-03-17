package projekt.food;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class FoodTypes<F extends Food,C extends Food.Config>{

    public final FoodType<Food,Pizza.Config> PIZZA;
    public final FoodType<Food,Pasta.Config> PASTA;
    public final FoodType<Food,IceCream.Config> ICE_CREAM;

    public static Map<String,FoodType> ALL;

    /**
     * Create lists of extras for each coresponding food type
     * and apply them
     */
    FoodTypes(){



        List<Extra> pizzacompatible = new ArrayList<>();

        pizzacompatible.add(Extras.ALL.get("Extra Ham"));
        pizzacompatible.add(Extras.ALL.get("Extra Olives"));
        pizzacompatible.add(Extras.ALL.get("Extra Sauce"));
        pizzacompatible.add(Extras.ALL.get("Spicy Sauce"));
        pizzacompatible.add(Extras.ALL.get("No Sauce"));


        List<Extra> pastacompatible = new ArrayList<>();

        pizzacompatible.add(Extras.ALL.get("Extra Thick"));
        pizzacompatible.add(Extras.ALL.get("Extra Sauce"));
        pizzacompatible.add(Extras.ALL.get("Spicy Sauce"));
        pizzacompatible.add(Extras.ALL.get("No Sauce"));

        List<Extra> ice_creamcompatible = new ArrayList<>();

        pizzacompatible.add(Extras.ALL.get("Rainbow Sprinkles"));
        pizzacompatible.add(Extras.ALL.get("Extra Scoop"));
        pizzacompatible.add(Extras.ALL.get("Extra Cream"));
        pizzacompatible.add(Extras.ALL.get("Extra Chocolate"));
        pizzacompatible.add(Extras.ALL.get("Extra Strawberries"));


        PIZZA = new FoodTypeImpl("Pizza",pizzacompatible);
        PASTA = new FoodTypeImpl("Pasta",pastacompatible);
        ICE_CREAM = new FoodTypeImpl("Ice Cream",ice_creamcompatible);

        ALL.put("Pizza",PIZZA);
        ALL.put("Pasta",PASTA);
        ALL.put("Ice Cream",ICE_CREAM);

    }
}
