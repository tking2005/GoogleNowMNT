package nyc.c4q.tarynking.googlenowmnt;

import java.util.ArrayList;

/**
 * List of all the Recycler View Items which is cards
 */

public class ItemList extends ArrayList<CardsItem> {
    @Override
    public boolean add(CardsItem cardsList) { // we are adding cards inside the item list ( items are card)
        return super.add(cardsList);
    }

    @Override
    public CardsItem get(int index) {
        return super.get(index);
    }
}


