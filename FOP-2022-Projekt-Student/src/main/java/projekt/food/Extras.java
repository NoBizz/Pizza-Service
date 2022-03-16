package projekt.food;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class Extras {

    public final Extra<Pizza.Config> EXTRA_HAM;
    public final Extra<Pizza.Config> EXTRA_OLIVES;
    public final Extra<Pasta.Config> EXTRA_THICK;
    public final Extra<Saucable.Config> SPICY_SAUCE;
    public final Extra<Saucable.Config> EXTRA_SAUCE;
    public final Extra<Saucable.Config> NO_SAUCE;
    public final Extra<IceCream.Config> RAINBOW_SPRINKLES;
    public final Extra<IceCream.Config> EXTRA_SCOOP;
    public final Extra<IceCream.Config> EXTRA_CREAM;
    public final Extra<IceCream.Config> EXTRA_CHOCOLATE;
    public final Extra<IceCream.Config> EXTRA_STRAWBERRIES;
    public Map<String, Extra<?>> ALL;

    /**
     * the constructor is declared private and prevents objects from being created outside of class
     * and initializes the attributes (extras) of the class using the class ExtraImpl.
     * It also adjusts the attributes of the {...}Impl classes like price, weigt, ... .
     */

    private Extras() {


        EXTRA_HAM = new ExtraImpl<Pizza.Config>("Extra Ham", 5, x -> {
            x.weight(y -> y + 0.1);
            x.price(z -> z.add(new BigDecimal("1.0")));
        });
        EXTRA_OLIVES = new ExtraImpl<Pizza.Config>("Extra Olives", 5, x -> {
            x.weight(y -> y + 0.05);
            x.price(z -> z.add(new BigDecimal("0.8")));
        });

        EXTRA_THICK = new ExtraImpl<Pasta.Config>("Extra Thick", 4, x -> {
            x.weight(y -> y * 2);
            x.price(z -> z.add(new BigDecimal("4.0")));
            x.thickness(z -> z * 2);
        });

        SPICY_SAUCE = new ExtraImpl<Saucable.Config>("Spicy Sauce", 3, x -> {
            x.price(z -> z.add(new BigDecimal("0.5")));
            x.sauce(y -> "Spicy");
        });

        EXTRA_SAUCE = new ExtraImpl<Saucable.Config>("Extra Sauce", 4, x -> {
            x.weight(y -> y + 0.12);
            x.price(z -> z.add(new BigDecimal("1.25")));
            x.sauce(m -> "Extra");
        });

        NO_SAUCE = new ExtraImpl<Saucable.Config>("No Sauce", 5, x -> {
            x.weight(y -> {
                    if (y - 0.1 >= 0) {
                        return y -= 0.1;
                    }
                    return 0.0;
                }
            );
            x.price(z -> {
                if (z.compareTo(new BigDecimal("-1")) < 0) {
                    z = new BigDecimal("0.0");
                }
                return z.add(new BigDecimal("-1"));
            });

            x.sauce(y -> null);
        });

        RAINBOW_SPRINKLES = new ExtraImpl<IceCream.Config>("Rainbow Sprinkles", 5, x -> {
            x.weight(y -> y + 0.03);
            x.price(z -> new BigDecimal("0.5"));
        });

        EXTRA_SCOOP = new ExtraImpl<IceCream.Config>("Extra Scoop", 2, x -> {
            x.weight(y -> y + 0.1);
            x.price(z -> new BigDecimal("3.0"));
        });

        EXTRA_CREAM = new ExtraImpl<IceCream.Config>("Extra Cream", 3, x -> {
            x.weight(y -> y + 0.05);
            x.price(z -> new BigDecimal("1.0"));
        });
        EXTRA_CHOCOLATE = new ExtraImpl<IceCream.Config>("Extra Chocolate", 5, x -> {
            x.weight(y -> y + 0.02);
            x.price(z -> new BigDecimal("0.3"));
        });
        EXTRA_STRAWBERRIES = new ExtraImpl<IceCream.Config>("Extra Strawberries", 4, x -> {
            x.weight(y -> y + 0.15);
            x.price(z -> new BigDecimal("1.5"));
        });

        ALL = new HashMap<>();
        ALL.put("Extra Ham",EXTRA_HAM );
        ALL.put("Extra Olives",EXTRA_OLIVES);
        ALL.put("Extra Thick",EXTRA_THICK);
        ALL.put("Spicy Sauce",SPICY_SAUCE);
        ALL.put("Extra Sauce",EXTRA_SAUCE);
        ALL.put("No Sauce", NO_SAUCE);
        ALL.put("Rainbow Sprinkles", RAINBOW_SPRINKLES);
        ALL.put("Extra Scoop", EXTRA_SCOOP);
        ALL.put("Extra Cream", EXTRA_CREAM);
        ALL.put("Extra Chocolate", EXTRA_CHOCOLATE);
        ALL.put("Extra Strawberries",EXTRA_STRAWBERRIES);

    }


}
