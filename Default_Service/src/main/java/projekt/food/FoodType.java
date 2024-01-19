package projekt.food;

import java.util.List;

/**
 * A type of food, for example "Pizza" or "Pasta".
 *
 * @param <F> The target {@link Food} type
 * @param <C> The target {@link Food.Config} type
 * @see Food
 */
public interface FoodType<F extends Food, C extends Food.Config> {

    /**
     * The name of this food type.
     *
     * <p>
     * This may be something similar to {@code "Pizza"}.
     * </p>
     *
     * @return The name of this type
     */
    String getName();

    /**
     * The {@link Extra Extras} compatible with this food type.
     *
     * @return The {@link Extra Extras} compatible with this food type
     */
    List<? extends Extra<? super C>> getCompatibleExtras();

    /**
     * Adds a {@link Food.Variant} to this food type.
     *
     * @param variant The {@link Food.Variant} to add to this food type
     */
    void addFoodVariant(Food.Variant<F, C> variant);

    /**
     * The {@link Food.Variant food variants} that this food type are part of.
     *
     * <p>
     * For example, if this food type is "Pizza", this method might return the variants named:
     * </p>
     * <ul>
     *     <li>"Pizza Margherita"</li>
     *     <li>"Pizza Hawaii"</li>
     *     <li>"Pizza Rucola"</li>
     *     <li>"Pizza BBQ"</li>
     * </ul>
     *
     * @return The {@link Food.Variant food variants} that this food type are part of
     */
    List<? extends Food.Variant<F, C>> getFoodVariants();
}
