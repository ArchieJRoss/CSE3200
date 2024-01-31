package com.example.robot24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import robot.Robot

class MainActivity : AppCompatActivity() {

    private lateinit var yellowImg : ImageView
    private lateinit var redImg : ImageView
    private lateinit var whiteImg : ImageView
    private lateinit var counter_clockwise : Button
    private lateinit var clockwise : Button

    private var turnCount = 0
//    private val robots listOf()

    private val robots = listOf(
        Robot(false, R.drawable.red_large, R.drawable.red_small),
        Robot(false, R.drawable.yellow_large, R.drawable.yellow_small),
        Robot(false, R.drawable.white_large, R.drawable.white_small)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counter_clockwise = findViewById(R.id.rotateCounterClockwise)
        clockwise = findViewById(R.id.rotateClockwise)

//        yellowImg = findViewById(R.id.yellowRobot)
//        redImg = findViewById(R.id.redRobot)
//        whiteImg = findViewById(R.id.whiteRobot)

        counter_clockwise.setOnClickListener {
            counterClockwiseTurn()
        }

        clockwise.setOnClickListener {
            clockwiseTurn()
        }
//        redImg.setOnClickListener {
//            advanceTurn()
//        }
//        whiteImg.setOnClickListener {
//            advanceTurn()
//        }
//        yellowImg.setOnClickListener {
//            advanceTurn()
//        }
    }
    private fun counterClockwiseTurn() {
        turnCount += 1
        if (turnCount > 3) {
            turnCount = 1
        }
        setImages()
    }
    private fun clockwiseTurn() {
        turnCount -= 1
        if (turnCount < 1) {
            turnCount = 3
        }
        setImages()
    }
    private fun setImages() {
        if (turnCount == 1) {
            redImg.setImageResource(R.drawable.red_large)
            whiteImg.setImageResource(R.drawable.white_small)
            yellowImg.setImageResource(R.drawable.yellow_small)

        } else if (turnCount == 2) {
            whiteImg.setImageResource(R.drawable.white_large)
            redImg.setImageResource(R.drawable.red_small)
            yellowImg.setImageResource(R.drawable.yellow_small)
        } else {
            yellowImg.setImageResource(R.drawable.yellow_large)
            redImg.setImageResource(R.drawable.red_small)
            whiteImg.setImageResource(R.drawable.white_small)
        }
    }
//    private fun setRobotTurn(){
//        for(robot in robots){
//            robot.myTurn = false
//        }
//        robots[turnCount - 1].myTurn = true;
//    }
}

//    var myTurn : Boolean,
//    var largeimgRes : Int,
//    val smallimgRes : Int