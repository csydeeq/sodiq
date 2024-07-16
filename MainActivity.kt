package com.example.assignment1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var recipeSpinner: Spinner
    private lateinit var showRecipeButton: Button
    private lateinit var recipeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recipeSpinner = findViewById(R.id.recipeSpinner)
        showRecipeButton = findViewById(R.id.showRecipeButton)
        recipeTextView = findViewById(R.id.recipeTextView)

        // Set up Spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.recipe_types,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            recipeSpinner.adapter = adapter
        }

        recipeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Do nothing for now
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        showRecipeButton.setOnClickListener {
            val selectedPosition = recipeSpinner.selectedItemPosition
            val recipes = resources.getStringArray(R.array.recipes)
            recipeTextView.text = recipes[selectedPosition]
        }
    }
}
