package com.gildedrose.updaters

import com.gildedrose.Item

class AgedBrieUpdater(item: Item) : DefaultUpdater(item) {

    /**
     * Updates the quality for aged brie
     * "Aged Brie" actually increases in Quality the older it gets
     */
    override fun updateQuality() {
        item.quality++
        if(item.sellIn < 0) item.quality++
    }
}