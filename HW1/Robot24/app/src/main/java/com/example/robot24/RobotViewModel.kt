package com.example.robot24

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.math.cos

private const val TAG = "RobotViewModel"

class RobotViewModel : ViewModel() {

    private var turnCount = 0;

    fun advanceTurn() {
        turnCount = (turnCount % 3) + 1
    }

    var turnCounter : Int
        get() = turnCount
        set(newCount) {
            turnCount = newCount
        }
}