package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    val SELL_IN_CHANGE_PER_UPDATE = -1
    val QUALITY_CHANGE_PER_UPDATE = -1
    val QUALITY_CHANGE_DOUBLED_PER_UPDATE = -2

    val POSITIVE_QUALITY_AMOUNT = 10
    val POSITIVE_SELL_IN_VALUE = 5
    val LOW_POSITIVE_QUALITY_AMOUNT = 1
    val NEGATIVE_SELL_IN_AMOUNT = -1
    val MINIMUM_QUALITY_AMOUNT = 0

    val DEFAULT_ITEM_NAME = "foo"

    @Test
    fun `Item on update lowered sellIn and quality by one`() {
        val items = arrayOf(Item(DEFAULT_ITEM_NAME, POSITIVE_SELL_IN_VALUE, POSITIVE_QUALITY_AMOUNT))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(POSITIVE_SELL_IN_VALUE + SELL_IN_CHANGE_PER_UPDATE, app.items[0].sellIn)
        assertEquals(POSITIVE_QUALITY_AMOUNT + QUALITY_CHANGE_PER_UPDATE, app.items[0].quality)
    }

    @Test
    fun `Item sellIn date is passed on update quality lowered by two`() {
        val items = arrayOf(Item(DEFAULT_ITEM_NAME, NEGATIVE_SELL_IN_AMOUNT, POSITIVE_QUALITY_AMOUNT))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(NEGATIVE_SELL_IN_AMOUNT + SELL_IN_CHANGE_PER_UPDATE, app.items[0].sellIn)
        assertEquals(POSITIVE_QUALITY_AMOUNT + QUALITY_CHANGE_DOUBLED_PER_UPDATE, app.items[0].quality)
    }

    @Test
    fun `Item quality cant get negative`() {
        val items = arrayOf(Item(DEFAULT_ITEM_NAME, POSITIVE_SELL_IN_VALUE, LOW_POSITIVE_QUALITY_AMOUNT))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(POSITIVE_SELL_IN_VALUE + SELL_IN_CHANGE_PER_UPDATE, app.items[0].sellIn)
        assertEquals(MINIMUM_QUALITY_AMOUNT, app.items[0].quality)
        app.updateQuality()
        assertEquals(POSITIVE_SELL_IN_VALUE + (SELL_IN_CHANGE_PER_UPDATE * 2), app.items[0].sellIn)
        assertEquals(MINIMUM_QUALITY_AMOUNT, app.items[0].quality)
    }



}


