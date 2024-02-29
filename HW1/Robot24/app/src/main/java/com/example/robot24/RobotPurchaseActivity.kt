package com.example.robot24

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.robot24.databinding.ActivityRobotPurchaseBinding

class RobotPurchaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRobotPurchaseBinding
    private var currEnergy = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRobotPurchaseBinding.inflate(layoutInflater)
        setContentView(binding.root)


        currEnergy = intent.getIntExtra(MainActivity.key, -1)
        println("Energy is: $currEnergy")
        binding.energyResult.text = currEnergy.toString()

        binding.rewardAButton.setOnClickListener {
            makePurchase(1)
        }
        binding.rewardBButton.setOnClickListener {
            makePurchase(2)
        }
        binding.rewardCButton.setOnClickListener {
            makePurchase(3)
        }
    }

    private fun makePurchase(cost: Int) {
        if((currEnergy - cost) >= 0) {
            currEnergy -= cost
            binding.energyResult.text = currEnergy.toString()
            Toast.makeText(this, "Purchase Complete.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Insufficient energy!", Toast.LENGTH_SHORT).show()
        }
    }
}