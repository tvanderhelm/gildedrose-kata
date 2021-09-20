package com.gildedrose.updaters

import com.gildedrose.Item

open class DefaultUpdater(open val item : Item) : GildedRoseUpdater {

    override fun onUpdate() {
        updateSellIn()
        updateQuality()
        qualityCheck()
    }

    /**
     * Updates the quality for the given item.
     * Every day the quality is lowered by one.
     * Once the sell by date has passed, Quality degrades twice as fast
     */
    open fun updateQuality() {
        item.quality--
        if(item.sellIn < 0) item.quality--
    }

    /**
     * Updates the sellIn value for the given item.
     * Every day the sellIn value is lowered by one.
     */
    private fun updateSellIn() {
        item.sellIn--
    }

    /**
     * Checks if the updated quality is still in range
     * The Quality of an item is never negative
     * The Quality of an item is never more than 50
     */
    private fun qualityCheck() {
        if(item.quality < 0) item.quality = 0
        if(item.quality > 50) item.quality = 50
    }
}