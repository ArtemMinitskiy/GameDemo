package com.example.gamedemo

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationActivity : AppCompatActivity(), AdapterCallback {
    //class AnimationActivity : AppCompatActivity() {
    var mAnimation: AnimationDrawable? = null
    lateinit var animSlide: Animation

    var adapter: PieceAdapter2? = null
    var pieceList = ArrayList<Piece>()

    var scaleType: Float = 1.0F

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        board_grid.numColumns = 3

        // load cards
        pieceList.add(Grass("Coffee", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("null", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee4", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee6", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Rock1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))

//        var display = windowManager.defaultDisplay!!
//
//        val size = Point()
//        display.getSize(size)
//        val width: Int = size.x

        adapter = PieceAdapter2(this, pieceList, this)
        board_grid.adapter = adapter


//        imageView.setBackgroundResource(R.drawable.knight_run_animation)
//        mAnimation = imageView.getBackground() as AnimationDrawable?

//        val display = windowManager.defaultDisplay
//        animation = Animation(backgroundImage, fabLayout, tab_layout, display)


        btnStart.setOnClickListener {
            mAnimation!!.start()
        }

        btnStop.setOnClickListener {
            mAnimation!!.stop()

        }

        btnInversion.setOnClickListener {
//            if (scaleType == 1.0F) {
//                imageView.scaleX = -scaleType
//            } else {
//                imageView.scaleX = scaleType
//            }
            animSlide =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_from_left)
            imageView.startAnimation(animSlide)
//            val param = imageView.layoutParams as MarginLayoutParams
//            for (index in 0..500) {
//                Handler(Looper.getMainLooper()).postDelayed({
//                    param.setMargins(index, 0, 0, 0)
//                    imageView.layoutParams = param
//                }, 2000)
//            }


        }

        createAnimation()
    }

    fun createAnimation() {

        mAnimation = AnimationDrawable()
        val bm0: Bitmap
        val bm1: Bitmap
        val bm2: Bitmap
        val bm3: Bitmap
        val bm4: Bitmap
        val bm5: Bitmap
        val bm6: Bitmap
        val bm7: Bitmap
        val bm8: Bitmap
        val bm9: Bitmap
        bm0 = BitmapFactory.decodeResource(resources, R.drawable.hero_knight_run_0)
        bm1 = BitmapFactory.decodeResource(resources, R.drawable.hero_knight_run_1)
        bm2 = BitmapFactory.decodeResource(resources, R.drawable.hero_knight_run_2)
        bm3 = BitmapFactory.decodeResource(resources, R.drawable.hero_knight_run_3)
        bm4 = BitmapFactory.decodeResource(resources, R.drawable.hero_knight_run_4)
        bm5 = BitmapFactory.decodeResource(resources, R.drawable.hero_knight_run_5)
        bm6 = BitmapFactory.decodeResource(resources, R.drawable.hero_knight_run_6)
        bm7 = BitmapFactory.decodeResource(resources, R.drawable.hero_knight_run_7)
        bm8 = BitmapFactory.decodeResource(resources, R.drawable.hero_knight_run_8)
        bm9 = BitmapFactory.decodeResource(resources, R.drawable.hero_knight_run_9)

        val frame0: BitmapDrawable
        val frame1: BitmapDrawable
        val frame2: BitmapDrawable
        val frame3: BitmapDrawable
        val frame4: BitmapDrawable
        val frame5: BitmapDrawable
        val frame6: BitmapDrawable
        val frame7: BitmapDrawable
        val frame8: BitmapDrawable
        val frame9: BitmapDrawable
        frame0 = BitmapDrawable(resources, bm0)
        frame1 = BitmapDrawable(resources, bm1)
        frame2 = BitmapDrawable(resources, bm2)
        frame3 = BitmapDrawable(resources, bm3)
        frame4 = BitmapDrawable(resources, bm4)
        frame5 = BitmapDrawable(resources, bm5)
        frame6 = BitmapDrawable(resources, bm6)
        frame7 = BitmapDrawable(resources, bm7)
        frame8 = BitmapDrawable(resources, bm8)
        frame9 = BitmapDrawable(resources, bm9)
        mAnimation = AnimationDrawable()
        mAnimation!!.isOneShot = false
        mAnimation!!.addFrame(frame0, 50)
        mAnimation!!.addFrame(frame1, 50)
        mAnimation!!.addFrame(frame2, 50)
        mAnimation!!.addFrame(frame3, 50)
        mAnimation!!.addFrame(frame4, 50)
        mAnimation!!.addFrame(frame5, 50)
        mAnimation!!.addFrame(frame6, 50)
        mAnimation!!.addFrame(frame7, 50)
        mAnimation!!.addFrame(frame8, 50)
        mAnimation!!.addFrame(frame9, 50)
        imageView.setBackground(mAnimation)
        mAnimation!!.setVisible(true, true)
        mAnimation!!.start()
    }

    override fun doThings(position: Int): String {
        myLog("", position)

        return ""
    }

    fun myLog(str: String, message: Any) {
        Log.i("DemoLog", (str + message))
    }
}