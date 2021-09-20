package com.gildedrose

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SulfurasUpdaterTest {

    @Test
    fun `Sulfuras on update dont update sellIn or quality`() {
        val items = arrayOf(Item(GildedRose.SULFURAS, 5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        Assertions.assertEquals(5, app.items[0].sellIn)
        Assertions.assertEquals(10, app.items[0].quality)
    }

    @Test
    fun `Sulfuras quality could up to 80`() {
        val items = arrayOf(Item(GildedRose.SULFURAS, 5, 80))
        val app = GildedRose(items)
        app.updateQuality()
        Assertions.assertEquals(5, app.items[0].sellIn)
        Assertions.assertEquals(80, app.items[0].quality)
    }
}