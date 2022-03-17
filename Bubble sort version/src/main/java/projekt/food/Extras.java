package projekt.food;

import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;


public final class Extras {


    // make the inout to the constructor somehow be a configuration
    // need to pas on a functional interface ot the specified configurations

    public static final Extra<Pizza.Config> EXTRA_HAM;
    public static final Extra<Pizza.Config> EXTRA_OLIVES;
    public static final Extra<Pasta.Config> EXTRA_THICK;
    public static final Extra<Saucable.Config> SPICY_SAUCE;
    public static final Extra<Saucable.Config> EXTRA_SAUCE;
    public static final Extra<Saucable.Config> NO_SAUCE;
    public static final Extra<IceCream.Config> RAINBOW_SPRINKLES;
    public static final Extra<IceCream.Config> EXTRA_SCOOP;


    public static Map<String, Extra<?>> ALL;


    Extras(){

        //look at config
        //figure out how to chnage values

        EXTRA_HAM = new ExtraImpl<Pizza.Config>("Extra Ham", 5, x -> {

        });
        EXTRA_OLIVES = new ExtraImpl<Pizza.Config>("Extra Olives", 5, x -> {

        });

        EXTRA_THICK = new ExtraImpl<Pasta.Config>("Extra Thick", 4, x -> {

        });

        SPICY_SAUCE = new ExtraImpl<Saucable.Config>("Spicy Sauce", 3, x -> {

        });

        EXTRA_SAUCE = new ExtraImpl<Saucable.Config>("Extra Sauce", 4, x -> {

        });

        NO_SAUCE = new ExtraImpl<Saucable.Config>("No Sauce", 5, x -> {
        });


        RAINBOW_SPRINKLES = new ExtraImpl<IceCream.Config>("Rainbow Sprinkles", 5, x -> {

        });

        EXTRA_SCOOP = new ExtraImpl<IceCream.Config>("Extra Scoop", 2, x -> {

        });

        ALL.put("Extra Ham",EXTRA_HAM);
        ALL.put("Extra Olives", EXTRA_OLIVES);
        ALL.put("Extra Thick",EXTRA_THICK);
        ALL.put("Spicy Sauce",SPICY_SAUCE);
        ALL.put("Extra Sauce",EXTRA_SAUCE);
        ALL.put("No Sauce",NO_SAUCE);
        ALL.put("Rainbow Sprinkles",RAINBOW_SPRINKLES);
        ALL.put("Extra Scoup",EXTRA_SCOOP);
    }


    }

