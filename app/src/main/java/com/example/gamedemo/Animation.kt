package com.example.gamedemo

import android.graphics.Point
import android.view.Display
import android.view.ViewGroup.MarginLayoutParams
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout

class Animation(imageView: ImageView, linearLayout: LinearLayout, tabLayout: TabLayout, display: Display) : AppCompatActivity() {

    val backgroundImage = imageView
    val fabLayout = linearLayout
    val tab_layout = tabLayout
    val myDisplay = display

    val tabWidth: Int
        get() {
            val size = Point()
            myDisplay.getSize(size)
            val width: Int = size.x
            val tabWidth = width / numberOfTabs
            return tabWidth
        }

    val numberOfTabs: Int
        get() {
            return tab_layout.tabCount
        }

    fun getWidth(position: Int) {
        val tabLayoutHeight = tab_layout.layoutParams.height

        backgroundImage.layoutParams.width = tabWidth

        val param = backgroundImage.layoutParams as MarginLayoutParams
        param.setMargins(tabWidth * position, 0, 0, tabLayoutHeight)
        backgroundImage.layoutParams = param

        fabLayout.layoutParams.width = tabWidth
        fabLayout.layoutParams.height = tabLayoutHeight

        val layoutParam = fabLayout.layoutParams as MarginLayoutParams
        layoutParam.setMargins(tabWidth * position, 0, 0, 40)
        fabLayout.layoutParams = layoutParam

    }

}