package projekt.food;

import java.util.function.Consumer;

class ExtraImpl<C extends Food.Config> implements Extra<C> {

    private final String name;
    private final int priority;
    private final Consumer<C> configMutator;


    /**
     * the construcor initializes the three private attributes of the ExtraImpl class.
     *
     * @param name          is the name of the extra which is added to the food
     * @param priority      is the priority in which the extra is added
     * @param configMutator is a consumer which accepts a configuration
     */

    ExtraImpl(String name, int priority, Consumer<C> configMutator) {

        this.name = name;
        this.priority = priority;
        this.configMutator = configMutator;

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
    public int getPriority() {
        return priority;
    }



    /**
     * applies the configuration of the provided extra to the food
     *
     * @param config contains the parameters to be changed like weight, price, etc
     */
    @Override
    public void apply(C config) {


        configMutator.accept(config);


    }
}
