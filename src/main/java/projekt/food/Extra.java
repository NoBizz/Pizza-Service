package projekt.food;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;


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
     */
    int getPriority();

    /**
     * Applies the modifications of this extra to the provided {@link C config}.
     */
    void apply(C config);

    /**
     * sorts the list by priority (and alphabetical - if two items have the same priority)  applies the modification of any extra included in the list to the configuration
     * @param config is the configuration that is beeing changed
     * @param extras are the added extras
     * @param <C> extends Food.Config, are the possible configurations
     */

    static <C extends Food.Config> void writeToConfig(C config, List<ExtraImpl<C>> extras) {

        if ( config == null || extras == null ){
            return;
        }

        Comparator<ExtraImpl<C>> listComparator = new Comparator<ExtraImpl<C>>() {


            @Override
            public int compare(ExtraImpl<C> o1, ExtraImpl<C> o2) {

                if (o1.getPriority() < o2.getPriority()) {
                    return -1;
                }
                if (o1.getPriority() > o2.getPriority()) {
                    return 1;
                }

                if (o1.getPriority() == o2.getPriority()) {

                    int length = Math.min(o1.getName().length(), o2.getName().length());

                    for (int i = 0; i < length; i++) {

                        if (o1.getName().charAt(i) < o2.getName().charAt(i)) {
                            return -1;
                        }
                        if (o1.getName().charAt(i) > o2.getName().charAt(i)) {
                            return 1;
                        }
                    }
                    return 0;
                }

                return 0;
            }
        };



        Stream<ExtraImpl<C>> listStream = extras.stream();

        List<ExtraImpl<C>> sortedList = listStream.sorted(listComparator).toList();


        for (ExtraImpl<C> cExtra : sortedList) {

            cExtra.apply(config);

        }


    }
}


