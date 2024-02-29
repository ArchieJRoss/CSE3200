package com.example.robot24

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.robot24.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val robotViewModel: RobotViewModel by viewModels()
    companion object {
        const val key = "energy"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val robots = listOf(
            Robot(binding.redRobot, R.drawable.red_small, R.drawable.red_large, "Red", 0),
            Robot(binding.whiteRobot, R.drawable.white_small, R.drawable.white_large, "White", 0),
            Robot(binding.yellowRobot, R.drawable.yellow_small, R.drawable.yellow_large, "Yellow", 0)
        )

        binding.redRobot.setOnClickListener {
            robotViewModel.advanceTurn()
            saveTurnCounter(robotViewModel.turnCounter)
            setUI(robots)
        }

        binding.whiteRobot.setOnClickListener {
            robotViewModel.advanceTurn()
            saveTurnCounter(robotViewModel.turnCounter)
            setUI(robots)
        }

        binding.yellowRobot.setOnClickListener {
            robotViewModel.advanceTurn()
            saveTurnCounter(robotViewModel.turnCounter)
            setUI(robots)
        }

        binding.newActivityButton.setOnClickListener {
            val intent = Intent(this, RobotPurchaseActivity::class.java)
            intent.putExtra(key, robots[robotViewModel.turnCounter-1].energy)
            startActivity(intent)
        }


        robotViewModel.turnCounter = loadTurnCounter();
        setUI(robots)

    }


    private fun setUI(robots: List<Robot>) {
        val turnCount = robotViewModel.turnCounter
        if(turnCount == 0) {
            robots.forEachIndexed { index, robot ->
                robot.setViewLarge()
            }
            return
        }


        robots.forEachIndexed { index, robot ->
            if ((turnCount - 1) % robots.size == index) {
                robot.setViewLarge()
                robot.energy++
                binding.messageBox.setText("${robot.color} Robot's Turn")
            } else {
                robot.setViewSmall()
            }
        }
    }

    private fun saveTurnCounter(turnCount: Int) {
        val sharedPrefs = getSharedPreferences("MyAppPreferences", MODE_PRIVATE)
        sharedPrefs.edit().putInt("turnCount", turnCount).apply()
    }

    private fun loadTurnCounter(): Int {
        val sharedPrefs = getSharedPreferences("MyAppPreferences", MODE_PRIVATE)
        return sharedPrefs.getInt("turnCount", 0)
    }
}