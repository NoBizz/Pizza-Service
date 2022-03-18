package projekt.food;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import projekt.food.Pizza.Config;

public final class FoodTypes<F extends Food,C extends Food.Config>{
	
    public static List<Extra<?>> pizzacompatible = new ArrayList<>();
    public static List<Extra<?>> pastacompatible = new ArrayList<>();
    public static List<Extra<?>> ice_creamcompatible = new ArrayList<>();

    public static final FoodType<PizzaImpl,Pizza.Config> PIZZA = new FoodTypeImpl("Pizza", pizzacompatible);
    public static final FoodType<PastaImpl,Pasta.Config> PASTA = new FoodTypeImpl("Pasta",pastacompatible);
    public static final FoodType<IceCreamImpl,IceCream.Config> ICE_CREAM = new FoodTypeImpl("Ice Cream",ice_creamcompatible);

    public static Map<String, FoodType> ALL;
    
    //TODO static initializer
    

    /**
     * Create lists of extras for each coresponding food type
     * and apply them
     */
    private FoodTypes(){



        pizzacompatible.add(Extras.ALL.get("Extra Ham"));
        pizzacompatible.add(Extras.ALL.get("Extra Olives"));
        pizzacompatible.add(Extras.ALL.get("Extra Sauce"));
        pizzacompatible.add(Extras.ALL.get("Spicy Sauce"));
        pizzacompatible.add(Extras.ALL.get("No Sauce"));


        

        pastacompatible.add(Extras.ALL.get("Extra Thick"));
        pastacompatible.add(Extras.ALL.get("Extra Sauce"));
        pastacompatible.add(Extras.ALL.get("Spicy Sauce"));
        pastacompatible.add(Extras.ALL.get("No Sauce"));

        

        ice_creamcompatible.add(Extras.ALL.get("Rainbow Sprinkles"));
        ice_creamcompatible.add(Extras.ALL.get("Extra Scoop"));
        ice_creamcompatible.add(Extras.ALL.get("Extra Cream"));
        ice_creamcompatible.add(Extras.ALL.get("Extra Chocolate"));
        ice_creamcompatible.add(Extras.ALL.get("Extra Strawberries"));


        ALL.put("Pizza",PIZZA);
        ALL.put("Pasta",PASTA);
        ALL.put("Ice Cream",ICE_CREAM);

    }
}
