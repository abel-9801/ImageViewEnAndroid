package com.develou.imageview_en_android

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.*
import androidx.core.view.ViewCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sunset: ImageView = findViewById(R.id.sunset)
        sunset.setImageResource(R.drawable.sunset)

        createImageViewAndAdd()
    }

    private fun createImageViewAndAdd() {
        val layout: ConstraintLayout = findViewById(R.id.constraintlayout) // (1)

        val waterfall = ImageView(this).apply { // (2)
            id = ViewCompat.generateViewId()
            scaleType = ImageView.ScaleType.CENTER_CROP
            setImageResource(R.drawable.waterfall)
        }

        layout.addView(waterfall) // (3)
        
        val constraintSet = ConstraintSet() // (4)
        constraintSet.clone(layout) // (5)
        with(constraintSet){// (6)
            constrainedHeight(waterfall.id, true)
            constrainedWidth(waterfall.id, true)
            connect(waterfall.id, TOP, R.id.guideline_vertical_center, BOTTOM)
            connect(waterfall.id, LEFT, PARENT_ID, LEFT)
            connect(waterfall.id, RIGHT, PARENT_ID, RIGHT)
            connect(waterfall.id, BOTTOM, PARENT_ID, BOTTOM)
            applyTo(layout)
        }
    }
}