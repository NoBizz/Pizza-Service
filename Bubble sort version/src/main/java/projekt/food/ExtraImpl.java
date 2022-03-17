package projekt.food;

import java.util.function.Consumer;

public class ExtraImpl<C extends Food.Config> implements Extra<C> {

   private String name;
   private int priority;

   //Type parametarize for maximum input
   private Consumer<C> configMutator;


   //parametarize config mutator mor maximumamount of inputs
    ExtraImpl(String name, int priority,Consumer<C> conf){

        this.name = name;
        this.priority = priority;
        this.configMutator = conf;


    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public void apply(C config) {

        this.configMutator.accept(config);

    }
}
