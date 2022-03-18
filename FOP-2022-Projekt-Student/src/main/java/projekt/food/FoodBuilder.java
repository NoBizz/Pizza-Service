package projekt.food;

import java.util.List;

public interface FoodBuilder<F extends Food, C extends Food.Config, V extends Food.Variant<F,C>>{

    F build(C config, V Variant, List<Extras> compatible_extras);

}
