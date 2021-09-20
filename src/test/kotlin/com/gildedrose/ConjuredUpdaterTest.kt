package com.gildedrose

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ConjuredUpdaterTest {

    @Test
    fun `Conjured items sellIn positive on update drops quality by 2`() {
        val items = arrayOf<Item>(Item(GildedRose.CONJURED, 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        Assertions.assertEquals(9, app.items[0].sellIn)
        Assertions.assertEquals(8, app.items[0].quality)
    }

    @Test
    fun `Conjured items sellIn negative on update drops quality by 4`() {
        val items = arrayOf<Item>(Item(GildedRose.CONJURED, -1, 10))
        val app = GildedRose(items)
        app.updateQuality()
        Assertions.assertEquals(-2, app.items[0].sellIn)
        Assertions.assertEquals(6, app.items[0].quality)
    }


}