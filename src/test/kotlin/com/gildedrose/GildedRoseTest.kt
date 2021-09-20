package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `Item on update lowered sellIn and quality by one`() {
        val items = arrayOf<Item>(Item("foo", 5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, app.items[0].sellIn)
        assertEquals(9, app.items[0].quality)
    }

    @Test
    fun `Item sellIn date is passed on update quality lowered by two`() {
        val items = arrayOf<Item>(Item("foo", -1, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-2, app.items[0].sellIn)
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun `Item quality cant get negative`() {
        val items = arrayOf<Item>(Item("foo", 10, 1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
        app.updateQuality()
        assertEquals(8, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }



}


