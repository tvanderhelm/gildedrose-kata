package com.gildedrose

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AgedBrieUpdaterTest {

    @Test
    fun `Aged brie on update should lower sell in and increase quality`() {
        val items = arrayOf(Item(GildedRose.AGED_BRIE, 5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        Assertions.assertEquals(4, app.items[0].sellIn)
        Assertions.assertEquals(11, app.items[0].quality)
    }

    @Test
    fun `Aged brie sellIn passed on update doubles quality increment`() {
        val items = arrayOf(Item(GildedRose.AGED_BRIE, 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        Assertions.assertEquals(-1, app.items[0].sellIn)
        Assertions.assertEquals(12, app.items[0].quality)
    }

    @Test
    fun `Quality cant go above 50`() {
        val items = arrayOf(Item(GildedRose.AGED_BRIE, 5, 49))
        val app = GildedRose(items)
        app.updateQuality()
        Assertions.assertEquals(4, app.items[0].sellIn)
        Assertions.assertEquals(50, app.items[0].quality)
        app.updateQuality()
        Assertions.assertEquals(3, app.items[0].sellIn)
        Assertions.assertEquals(50, app.items[0].quality)
    }

}