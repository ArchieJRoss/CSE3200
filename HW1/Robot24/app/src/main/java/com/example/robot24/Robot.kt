package com.example.robot24

import android.widget.ImageView

data class Robot (private val view: ImageView, private val smallImg: Int, private val largeImg: Int, public val color: String, public var energy: Int) {
    public fun setViewSmall() {
        view.setImageResource(smallImg)
    }

    public fun setViewLarge() {
        view.setImageResource(largeImg)
    }

}