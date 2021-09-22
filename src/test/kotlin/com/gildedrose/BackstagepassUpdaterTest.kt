package com.gildedrose

import com.gildedrose.updaters.BackstagepassUpdater
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BackstagepassUpdaterTest {

    val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"

    val SELL_IN_CHANGE_PER_UPDATE = -1
    val QUALITY_CHANGE_PER_UPDATE = 1
    val QUALITY_CHANGE_DOUBLED_PER_UPDATE = 2
    val QUALITY_CHANGE_TRIPLED_PER_UPDATE = 3

    val POSITIVE_QUALITY_AMOUNT = 10
    val NEGATIVE_SELL_IN_VALUE = -1
    val SELL_IN_VALUE_ABOVE_TEN = 11
    val SELL_IN_VALUE_BELOW_FIVE = 3
    val SELL_IN_VALUE_BETWEEN_FIVE_AND_TEN = 7

    val MINIMUM_QUALITY_AMOUNT = 0

    @Test
    fun `Backstage passes sellIn above 10 on update increase quality by 1`() {
        val item = Item(BACKSTAGE_PASSES, SELL_IN_VALUE_ABOVE_TEN, POSITIVE_QUALITY_AMOUNT)
        val updater = BackstagepassUpdater(item)
        updater.onUpdate()
        Assertions.assertEquals(SELL_IN_VALUE_ABOVE_TEN + SELL_IN_CHANGE_PER_UPDATE, item.sellIn)
        Assertions.assertEquals(POSITIVE_QUALITY_AMOUNT + QUALITY_CHANGE_PER_UPDATE, item.quality)
    }

    @Test
    fun `Backstage passes sellIn under 5 on update increase quality by 3`() {
        val item = Item(BACKSTAGE_PASSES, SELL_IN_VALUE_BELOW_FIVE, POSITIVE_QUALITY_AMOUNT)
        val updater = BackstagepassUpdater(item)
        updater.onUpdate()
        Assertions.assertEquals(SELL_IN_VALUE_BELOW_FIVE + SELL_IN_CHANGE_PER_UPDATE, item.sellIn)
        Assertions.assertEquals(POSITIVE_QUALITY_AMOUNT + QUALITY_CHANGE_TRIPLED_PER_UPDATE, item.quality)
    }

    @Test
    fun `Backstage passes sellIn under 10 on update increase quality by 2`() {
        val item = Item(BACKSTAGE_PASSES, SELL_IN_VALUE_BETWEEN_FIVE_AND_TEN, POSITIVE_QUALITY_AMOUNT)
        val updater = BackstagepassUpdater(item)
        updater.onUpdate()
        Assertions.assertEquals(SELL_IN_VALUE_BETWEEN_FIVE_AND_TEN + SELL_IN_CHANGE_PER_UPDATE, item.sellIn)
        Assertions.assertEquals(POSITIVE_QUALITY_AMOUNT + QUALITY_CHANGE_DOUBLED_PER_UPDATE, item.quality)
    }

    @Test
    fun `Backstage passes sellIn negative on update quality drops to 0`() {
        val item = Item(BACKSTAGE_PASSES, NEGATIVE_SELL_IN_VALUE, POSITIVE_QUALITY_AMOUNT)
        val updater = BackstagepassUpdater(item)
        updater.onUpdate()
        Assertions.assertEquals(NEGATIVE_SELL_IN_VALUE + SELL_IN_CHANGE_PER_UPDATE, item.sellIn)
        Assertions.assertEquals(MINIMUM_QUALITY_AMOUNT, item.quality)
    }

}