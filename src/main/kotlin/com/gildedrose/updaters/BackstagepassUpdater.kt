package com.gildedrose.updaters

import com.gildedrose.Item

class BackstagepassUpdater(item: Item) : DefaultUpdater(item) {

    /**
     *  Updates the quality for Backstagepasses.
     *  "Backstage passes", increases in Quality as its SellIn value approaches;
     *   Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
     *   Quality drops to 0 after the concert
     */
    override fun updateQuality() {
        if (item.sellIn < 0) {
            item.quality = 0
        } else {
            item.quality++
            if(item.sellIn < 10) item.quality++
            if(item.sellIn < 5) item.quality++
        }
    }
}