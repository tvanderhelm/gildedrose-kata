package com.gildedrose

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BackstagepassUpdaterTest {

    @Test
    fun `Backstage passes sellIn above 10 on update increase quality by 1`() {
        val items = arrayOf(Item(GildedRose.BACKSTAGE_PASSES, 11, 10))
        val app = GildedRose(items)
        app.updateQuality()
        Assertions.assertEquals(10, app.items[0].sellIn)
        Assertions.assertEquals(11, app.items[0].quality)
    }

    @Test
    fun `Backstage passes sellIn under 5 on update increase quality by 3`() {
        val items = arrayOf(Item(GildedRose.BACKSTAGE_PASSES, 5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        Assertions.assertEquals(4, app.items[0].sellIn)
        Assertions.assertEquals(13, app.items[0].quality)
    }

    @Test
    fun `Backstage passes sellIn under 10 on update increase quality by 2`() {
        val items = arrayOf(Item(GildedRose.BACKSTAGE_PASSES, 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        Assertions.assertEquals(9, app.items[0].sellIn)
        Assertions.assertEquals(12, app.items[0].quality)
    }

    @Test
    fun `Backstage passes sellIn negative on update quality drops to 0`() {
        val items = arrayOf(Item(GildedRose.BACKSTAGE_PASSES, 1, 10))
        val app = GildedRose(items)
        app.updateQuality()
        Assertions.assertEquals(0, app.items[0].sellIn)
        Assertions.assertEquals(13, app.items[0].quality)
        app.updateQuality()
        Assertions.assertEquals(-1, app.items[0].sellIn)
        Assertions.assertEquals(0, app.items[0].quality)
    }

}