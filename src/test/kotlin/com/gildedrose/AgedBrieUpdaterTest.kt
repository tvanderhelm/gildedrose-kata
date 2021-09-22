package com.gildedrose

import com.gildedrose.updaters.AgedBrieUpdater
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AgedBrieUpdaterTest {

    val AGED_BRIE = "Aged Brie"

    val SELL_IN_CHANGE_PER_UPDATE = -1
    val QUALITY_CHANGE_PER_UPDATE = 1
    val QUALITY_CHANGE_DOUBLED_PER_UPDATE = 2

    val NEGATIVE_SELL_IN_AMOUNT = -1
    val POSITIVE_QUALITY_AMOUNT = 10
    val POSITIVE_SELL_IN_VALUE = 5
    val MAX_QUALITY_AMOUNT = 50

    @Test
    fun `Aged brie on update should lower sell in and increase quality`() {
        val item = Item(AGED_BRIE, POSITIVE_SELL_IN_VALUE, POSITIVE_QUALITY_AMOUNT)
        val updater = AgedBrieUpdater(item)
        updater.onUpdate()
        Assertions.assertEquals(POSITIVE_SELL_IN_VALUE + SELL_IN_CHANGE_PER_UPDATE, item.sellIn)
        Assertions.assertEquals(POSITIVE_QUALITY_AMOUNT + QUALITY_CHANGE_PER_UPDATE, item.quality)
    }

    @Test
    fun `Aged brie sellIn passed on update doubles quality increment`() {
        val item = Item(AGED_BRIE, NEGATIVE_SELL_IN_AMOUNT, POSITIVE_QUALITY_AMOUNT)
        val updater = AgedBrieUpdater(item)
        updater.onUpdate()
        Assertions.assertEquals(NEGATIVE_SELL_IN_AMOUNT + SELL_IN_CHANGE_PER_UPDATE, item.sellIn)
        Assertions.assertEquals(POSITIVE_QUALITY_AMOUNT + QUALITY_CHANGE_DOUBLED_PER_UPDATE, item.quality)
    }

    @Test
    fun `Quality cant go above 50`() {
        val item = Item(AGED_BRIE, POSITIVE_SELL_IN_VALUE, MAX_QUALITY_AMOUNT - QUALITY_CHANGE_PER_UPDATE)
        val updater = AgedBrieUpdater(item)
        updater.onUpdate()
        Assertions.assertEquals(POSITIVE_SELL_IN_VALUE + SELL_IN_CHANGE_PER_UPDATE, item.sellIn)
        Assertions.assertEquals(MAX_QUALITY_AMOUNT, item.quality)
        updater.onUpdate()
        Assertions.assertEquals(POSITIVE_SELL_IN_VALUE + (SELL_IN_CHANGE_PER_UPDATE * 2), item.sellIn)
        Assertions.assertEquals(MAX_QUALITY_AMOUNT, item.quality)
    }

}