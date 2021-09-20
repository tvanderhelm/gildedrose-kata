package com.gildedrose.updaters

import com.gildedrose.Item

class SulfurasUpdater(item: Item) : DefaultUpdater(item) {

    override fun onUpdate() {
        // do nothing
        // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
        // "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters
    }
}