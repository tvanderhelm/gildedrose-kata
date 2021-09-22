package com.gildedrose

import com.gildedrose.updaters.SulfurasUpdater
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SulfurasUpdaterTest {

    val SULFURAS = "Sulfuras, Hand of Ragnaros"

    val POSITIVE_QUALITY_AMOUNT = 10
    val POSITIVE_SELL_IN_VALUE = 5
    val MAX_QUALITY_AMOUNT = 80

    @Test
    fun `Sulfuras on update dont update sellIn or quality`() {
        val item = Item(SULFURAS, POSITIVE_SELL_IN_VALUE, POSITIVE_QUALITY_AMOUNT)
        val updater = SulfurasUpdater(item)
        updater.onUpdate()
        Assertions.assertEquals(POSITIVE_SELL_IN_VALUE, item.sellIn)
        Assertions.assertEquals(POSITIVE_QUALITY_AMOUNT, item.quality)
    }

    @Test
    fun `Sulfuras quality could up to 80`() {
        val item = Item(SULFURAS, POSITIVE_SELL_IN_VALUE, MAX_QUALITY_AMOUNT)
        val updater = SulfurasUpdater(item)
        updater.onUpdate()
        Assertions.assertEquals(POSITIVE_SELL_IN_VALUE, item.sellIn)
        Assertions.assertEquals(MAX_QUALITY_AMOUNT, item.quality)
    }
}