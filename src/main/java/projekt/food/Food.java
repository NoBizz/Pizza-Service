package projekt.food;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * An immutable, configured dish.
 *
 * <p>
 * Instances of this interface are constructed via {@link Variant#create(List)} using the base values from a {@link Variant}
 * which are configured using the provided list of {@link Extra Extras}. The create method uses the appropriate {@link Config}
 * for the variant to store the modifications made by the provided extras.
 * </p>
 *
 * @see Config
 * @see Variant
 * @see Extra
 * @see FoodType
 */
public interface Food {

    /**
     * The price of this food.
     *
     * <p>
     * This is defined using the base value from {@link Variant#getBasePrice()} and configured
     * using {@link Config#price(UnaryOperator)}.
     * </p>
     *
     * @return The price of this food
     */
    BigDecimal getPrice();

    /**
     * The weight of this food.
     *
     * <p>
     * This is defined using the base value from {@link Variant#getBaseWeight()} and configured
     * using {@link Config#weight(DoubleUnaryOperator)}.
     * </p>
     *
     * @return The weight of this food
     */
    double getWeight();

    /**
     * The food variant.
     *
     * @return The food variant
     */
    Variant<?, ?> getFoodVariant();

    /**
     * The extras that this food was configured with.
     *
     * @return The extras that this food was configured with
     */
    List<? extends Extra<?>> getExtras();

    /**
     * A configurable set of functions that defines the changes needed to convert the base values of a
     * {@link Variant} into a concrete instance of {@link Food}.
     *
     * <p>
     * This interface and sub-interfaces have two methods for each configurable value of the following form. Let {@code bar} be
     * the name of a configurable value of type {@code Bar}:
     * </p>
     * <p>
     * <i>Please note that this is only the general form, and that the generic functional interface {@link UnaryOperator} may be
     * replaced with a primitive equivalent.</i>
     * </p>
     * <ol>
     *     <li>
     *         <code><pre>
     *         void bar(UnaryOperator&lt;Bar&gt; barMutator);
     *         </pre></code>
     *     </li>
     *     <li>
     *         <code><pre>
     *         UnaryOperator&lt;Bar&gt; getBarMutator();
     *         </pre></code>
     *     </li>
     * </ol>
     * <p>
     * Method 1 provides external access to append a new mutator to the existing mutator. This can usually be achieved with the
     * help of {@link UnaryOperator#andThen(Function)}.
     * </p>
     * <p>
     * Method 2 returns the mutator configured by method 1. The returned mutator is the result of concatenating all previous
     * inputs into method 1.
     * </p>
     */
    interface Config {

        /**
         * Concatenates the result of all previous calls to this method with the provided {@code priceMutator}.
         *
         * <p>
         * The provided {@link UnaryOperator} accepts the result produced by the function provided to the previous call to this
         * method and produces a new price. The new price does not necessarily have to be different from the previous one, and
         * may even be exactly the same value.
         * </p>
         *
         * @param priceMutator A {@link UnaryOperator} which determines a new price based on the previous value
         */
        void price(UnaryOperator<BigDecimal> priceMutator);

        /**
         * The price mutator accepts a base price and produces a configured price.
         *
         * <p>
         * The function returned by this method is the result of concatenating all previous inputs into the
         * {@link #price(UnaryOperator)} method.
         * </p>
         *
         * @return The price mutation function
         */
        UnaryOperator<BigDecimal> getPriceMutator();

        /**
         * Concatenates the result of all previous calls to this method with the provided {@code weightMutator}.
         *
         * <p>
         * The provided {@link DoubleUnaryOperator} accepts the result produced by the function provided to the previous call to
         * this method and produces a new weight. The new weight does not necessarily have to be different from the previous
         * one, and may even be exactly the same value.
         * </p>
         *
         * @param weightMutator A {@link DoubleUnaryOperator} which determines a new weight based on the previous value
         */
        void weight(DoubleUnaryOperator weightMutator);

        /**
         * The weight mutator accepts a base weight and produces a configured weight.
         *
         * <p>
         * The function returned by this method is the result of concatenating all previous inputs into the
         * {@link #weight(DoubleUnaryOperator)}  method.
         * </p>
         *
         * @return The weight mutation function
         */
        DoubleUnaryOperator getWeightMutator();
    }

    /**
     * A specific kind of dish like Pizza Margherita or Spaghetti Bolgnese.
     *
     * <p>
     * A food variant stores base values for a specific dish. For example, the {@link #getBasePrice() base price}, may be
     * mutated with the help of a {@link Config}. After it has been configured, these values become a concrete
     * instance of {@link Food}, which may not be modified after it has been created.
     * </p>
     *
     * <p>
     * To create a new instance of the food described by this variant, use the method {@link #create(List)} which accepts a
     * list of {@link Extra Extras} to configure the new instance. This configuration parameter is used internally to mutate
     * base values such as {@link #getBasePrice()}, {@link #getBaseWeight()} or new base values defined in subtypes of this
     * interface. Providing an empty list will create a food with the base values for this variant.
     * </p>
     *
     * @param <F> The target {@link Food} type
     * @param <C> The target {@link Config} type
     */
    interface Variant<F extends Food, C extends Config> {

        /**
         * The name of this variant.
         *
         * <p>
         * This may be something similar to {@code "Pizza Margherita"}.
         * </p>
         *
         * @return The name of this variant
         */
        String getName();

        /**
         * The food type in which this variant is grouped.
         *
         * <p>
         * For example, if this variant was named {@code "Pizza Margherita"}, the matching food type would be {@code "Pizza"}.
         * </p>
         *
         * @return The food type of this variant
         */
        FoodType<F, C> getFoodType();

        /**
         * The base price of this variant.
         *
         * @return The base price of this variant
         */
        BigDecimal getBasePrice();

        /**
         * The base weight of this variant.
         *
         * @return The weight price of this variant
         */
        double getBaseWeight();

        /**
         * Creates an empty {@link Config} for this variant.
         *
         * @return An empty {@link Config} for this variant
         */
        C createEmptyConfig();

        /**
         * Creates a new instance of {@link Food} described by this variant, its base values and modifications defined by the
         * provided list of {@link Extra Extras}.
         *
         * <p>
         * The provided extras are {@link Extra#apply(Config) applied} to an instance of {@link Config}. After this config has
         * been fully "configured" by the extras, the base values from this variant are supplied to the config's mutators to
         * calculate the food's concrete values. Providing an empty list will create a food with the base values for this
         * variant.
         * </p>
         *
         * @param extras The list of {@link Extra Extras} to configure the resultant {@link Food}
         * @return An instance of {@link Food} based on the values from this variant and configured by the provided extras
         */
        F create(List<? extends Extra<? super C>> extras);
    }
}
