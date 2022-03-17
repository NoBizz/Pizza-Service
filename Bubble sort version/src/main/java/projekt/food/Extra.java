package projekt.food;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * A modification that targets configurable values in a {@link Food.Config}.
 *
 * @param <C> The target {@link Food.Config} type
 */
public interface Extra<C extends Food.Config> {

    /**
     * The name of this extra.
     *
     * @return The name of this extra
     */
    String getName();

    /**
     * The priority of the extra, lower is calculated first.
     *
     * @return The priority of this extra
     */
    int getPriority();

    /**
     * Applies the modifications of this extra to the provided {@link C config}.
     *
     * @param config {@link Food.Config} to modify
     */
    void apply(C config);

    //parametarise for maximum input?

    public static <C extends Food.Config, E extends Extra> void writeToConfig(C config, List<ExtraImpl> extras){

        //temp var
        ExtraImpl tempextra;

        //no need for a new list, the existing list is being directly rearanged
        for(int i = 0; i < extras.size(); i++){

            if(i != extras.size() && extras.get(i).getPriority() > extras.get(i+1).getPriority()){

                //buble sort per Priority
                tempextra = extras.get(i+1);
                extras.set(i+1, extras.get(i));
                extras.set(i,tempextra);

                //implement alphabetical sorting

                //get the first character of the name of the Extras and compare them
                if(extras.get(i).getPriority() == extras.get(i+1).getPriority()){

                    if((int)extras.get(i).getName().charAt(0) > extras.get(i+1).getName().charAt(0)){

                        //buble sort by alphabet
                        tempextra = extras.get(i+1);
                        extras.set(i+1,extras.get(i));
                        extras.set(i,tempextra);


                    }

                }

            }

        }

        for(ExtraImpl ex :extras){
            ex.apply(config);
        }

    }
}
