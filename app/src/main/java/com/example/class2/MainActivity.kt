package com.example.class2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*

class MainActivity : AppCompatActivity() {
   lateinit var diceImage:ImageView
   lateinit var numberText: TextView
   lateinit var nameText: EditText
   lateinit var playerNameTxt:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.diceImg)
        numberText = findViewById(R.id.numberTxt)
        nameText = findViewById(R.id.editPlayerNameET)
        playerNameTxt = findViewById(R.id.playerName)

        val rollButton  = findViewById<Button>(R.id.rollBtn)
        val updateBtn:Button = findViewById(R.id.updateButton)
        updateBtn.setOnClickListener{updateName(it)} // it - instance of the button
        rollButton.setOnClickListener{rollDice()}
    }

    private fun updateName(view: View){
        playerNameTxt.text = nameText.text

        nameText.text.clear()
        nameText.clearFocus()

        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken,0)
    }

    private fun rollDice(){
        val randomNum = (1..6).random()

        numberText.text = randomNum.toString()

        val imgSrc = when (randomNum){
            1 -> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(imgSrc)
        Toast.makeText(this, randomNum.toString(),
            Toast.LENGTH_SHORT).show()
    }
}