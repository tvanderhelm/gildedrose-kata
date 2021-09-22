package com.gildedrose

import com.gildedrose.updaters.ConjuredUpdater
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ConjuredUpdaterTest {

    val CONJURED = "Conjured Mana Cake"

    val SELL_IN_CHANGE_PER_UPDATE = -1
    val QUALITY_CHANGE_PER_UPDATE = -2
    val QUALITY_CHANGE_DOUBLED_PER_UPDATE = -4

    val NEGATIVE_SELL_IN_AMOUNT = -1
    val POSITIVE_QUALITY_AMOUNT = 10
    val POSITIVE_SELL_IN_VALUE = 5

    @Test
    fun `Conjured items sellIn positive on update drops quality by 2`() {
        val item = Item(CONJURED, POSITIVE_SELL_IN_VALUE, POSITIVE_QUALITY_AMOUNT)
        val updater = ConjuredUpdater(item)
        updater.onUpdate()
        Assertions.assertEquals(POSITIVE_SELL_IN_VALUE + SELL_IN_CHANGE_PER_UPDATE, item.sellIn)
        Assertions.assertEquals(POSITIVE_QUALITY_AMOUNT + QUALITY_CHANGE_PER_UPDATE, item.quality)
    }

    @Test
    fun `Conjured items sellIn negative on update drops quality by 4`() {
        val item = Item(CONJURED, NEGATIVE_SELL_IN_AMOUNT, POSITIVE_QUALITY_AMOUNT)
        val updater = ConjuredUpdater(item)
        updater.onUpdate()
        Assertions.assertEquals(NEGATIVE_SELL_IN_AMOUNT + SELL_IN_CHANGE_PER_UPDATE, item.sellIn)
        Assertions.assertEquals(POSITIVE_QUALITY_AMOUNT + QUALITY_CHANGE_DOUBLED_PER_UPDATE, item.quality)
    }


}