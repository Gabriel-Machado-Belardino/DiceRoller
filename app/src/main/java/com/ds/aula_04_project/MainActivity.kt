package com.ds.aula_04_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isInvisible


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()

            //val resultTextView: TextView = findViewById(R.id.textView)
            //resultTextView.text = "6"

           //val toast = Toast.makeText(this, "Rolou um Dado!", Toast.LENGTH_SHORT)
            //toast.show()
        }

    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        val diceImage : ImageView = findViewById(R.id.imageView)
        resultTextView.text = diceRoll.toString()
        /*
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
        */
        val drawableResouce = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6  //else pois desta maneira sempre havera um valor ao sair do when
        }
        diceImage.setImageResource(drawableResouce)
        diceImage.contentDescription = diceRoll.toString()
    }
}
class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
