package org.pwssv67.sandbox.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

object CustomArrangement {
    @Stable
    class SpaceBetweenWithMinimalPadding(private val padding: Dp) : Arrangement.HorizontalOrVertical {
        override val spacing = 0.dp

        override fun Density.arrange(
            totalSize: Int,
            sizes: IntArray,
            layoutDirection: LayoutDirection,
            outPositions: IntArray
        ) {
            val paddingPx = padding.roundToPx()
            if (layoutDirection == LayoutDirection.Ltr) {
                placeSpaceBetween(totalSize, sizes, outPositions, reverseInput = false, minimalPadding = paddingPx)
            } else {
                placeSpaceBetween(totalSize, sizes, outPositions, reverseInput = true, minimalPadding = paddingPx)
            }
        }

        override fun Density.arrange(
            totalSize: Int,
            sizes: IntArray,
            outPositions: IntArray
        ) {
            val paddingPx = padding.roundToPx()
            placeSpaceBetween(totalSize, sizes, outPositions, reverseInput = false, minimalPadding = paddingPx)
        }

        override fun toString() = "CustomArrangement#SpaceBetweenWithMinimalPadding"
    }

    internal fun placeSpaceBetween(
        totalSize: Int,
        size: IntArray,
        outPosition: IntArray,
        reverseInput: Boolean,
        minimalPadding: Int
    ) {
        val consumedSize = size.fold(0) { a, b -> a + b }
        val gapSize = if (size.size > 1) {
            (totalSize - consumedSize).toFloat() / (size.size - 1)
        } else {
            minimalPadding
        }
        var current = 0f
        size.forEachIndexed(reverseInput) { index, it ->
            outPosition[index] = current.roundToInt()
            current += it.toFloat() + gapSize.toFloat()
        }
    }

    private inline fun IntArray.forEachIndexed(reversed: Boolean, action: (Int, Int) -> Unit) {
        if (!reversed) {
            forEachIndexed(action)
        } else {
            for (i in (size - 1) downTo 0) {
                action(i, get(i))
            }
        }
    }
}