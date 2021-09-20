package com.gildedrose

import com.gildedrose.updaters.*

class GildedRose(var items: Array<Item>) {

    companion object {
        const val AGED_BRIE = "Aged Brie"
        const val SULFURAS = "Sulfuras, Hand of Ragnaros"
        const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
        const val CONJURED = "Conjured Mana Cake"
    }

    /**
     * Updates quality value and sellIn value for the given items.
     * For items which require a special treatment we use a custom Updater.
     * For all other items we use the DefaultUpdater.
     * @see "https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/main/GildedRoseRequirements.txt" for requirements
     */
    fun updateQuality() {
        items.forEach { item ->
             val updater : GildedRoseUpdater = when(item.name) {
                AGED_BRIE -> AgedBrieUpdater(item)
                SULFURAS -> SulfurasUpdater(item)
                BACKSTAGE_PASSES -> BackstagepassUpdater(item)
                CONJURED -> ConjuredUpdater(item)
                else -> DefaultUpdater(item)
            }
            updater.onUpdate()
        }
    }
}

