package com.gildedrose.updaters

import com.gildedrose.Item

class ConjuredUpdater(item: Item) : DefaultUpdater(item) {

    /**
     * Updates the quality for conjured items
     * "Conjured" items degrade in Quality twice as fast as normal items
     */
    override fun updateQuality() {
        item.quality -= 2
        if(item.sellIn < 0) item.quality -= 2
    }
}