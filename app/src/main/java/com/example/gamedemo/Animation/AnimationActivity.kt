package com.example.gamedemo.Animation

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Point
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.gamedemo.*
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationActivity : AppCompatActivity(),
    AdapterCallback {
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

//        imageView.layoutParams.height = Utils().getViewHeight(board_grid)
//        imageView.layoutParams.width = Utils().getViewWidth(board_grid) / 3 - 16

        imageView.layoutParams.height = 100
        imageView.layoutParams.width = 220
        imageView.requestLayout()

        // load cards
        pieceList.add(
            Grass(
                "Coffee",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            )
        )
        pieceList.add(
            Grass(
                "Coffee",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            )
        )
        pieceList.add(
            Grass(
                "null",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            )
        )
        pieceList.add(
            Grass(
                "Coffee4",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            )
        )
        pieceList.add(
            Grass(
                "Coffee6",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            )
        )
        pieceList.add(
            Grass(
                "Coffee",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            )
        )
        pieceList.add(
            Grass(
                "Rock1",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            )
        )
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))


//        var display = windowManager.defaultDisplay!!
//
//        val size = Point()
//        display.getSize(size)
//        val width: Int = size.x

//        imageView.background = ContextCompat.getDrawable(this, R.drawable.hero_knight_run_1)

        adapter = PieceAdapter2(this, pieceList, this)
        board_grid.adapter = adapter

        myLog("board_grid height ", Utils().getViewHeight(board_grid))
        myLog("board_grid weight ", Utils().getViewWidth(board_grid))
        myLog("board_grid height ", board_grid.height)
        myLog("board_grid weight ", board_grid.width)

//        imageView.setBackgroundResource(R.drawable.knight_run_animation)
//        mAnimation = imageView.getBackground() as AnimationDrawable?

//        val display = windowManager.defaultDisplay
//        animation = Animation(backgroundImage, fabLayout, tab_layout, display)

        btnStart.setOnClickListener {
            val param = imageView.layoutParams as ViewGroup.MarginLayoutParams
            param.setMargins(220 + 32, 210, 0, 0)
            imageView.layoutParams = param
//            mAnimation!!.start()
        }

        btnStop.setOnClickListener {
            mAnimation!!.stop()

        }

        btnInversion.setOnClickListener {
            val param = imageView.layoutParams as ViewGroup.MarginLayoutParams
            for (index in 0..Utils().getViewWidth(board_grid) / 3 + 8) {
//                Handler(Looper.getMainLooper()).postDelayed({
                param.setMargins(32 + 220 * 2, 360 + 32, 0, 0)
//                param.setMargins(16 + index, (Utils().getViewHeight(board_grid) / 2 + 16) * 2, 0, 0)
                imageView.layoutParams = param
//                }, 0)
            }

            //0
//            param.setMargins(32, 32, 0, 0) // Where 32 margin
            //1
//            param.setMargins(32 + 220, 32, 0, 0)
            //2
//            param.setMargins(32 + 220 * 2, 32, 0, 0)
            //3
//            param.setMargins(32, 210, 0, 0)
            //4
//            param.setMargins(32 + 220, 210, 0, 0)
            //5
//            param.setMargins(32 + 220 * 2, 210, 0, 0)
            //6
//            param.setMargins(32, 180 * 2 + 32, 0, 0)
            //7
//            param.setMargins(32 + 220, 180 * 2 + 32, 0, 0)
            //8
//            param.setMargins(32 + 220 * 2, 180 * 2 + 32, 0, 0)






//            animSlide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide)
//            imageView.startAnimation(animSlide)


        }

//        createAnimation()
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
        bm0 = BitmapFactory.decodeResource(
            resources,
            R.drawable.hero_knight_run_0
        )
        bm1 = BitmapFactory.decodeResource(
            resources,
            R.drawable.hero_knight_run_1
        )
        bm2 = BitmapFactory.decodeResource(
            resources,
            R.drawable.hero_knight_run_2
        )
        bm3 = BitmapFactory.decodeResource(
            resources,
            R.drawable.hero_knight_run_3
        )
        bm4 = BitmapFactory.decodeResource(
            resources,
            R.drawable.hero_knight_run_4
        )
        bm5 = BitmapFactory.decodeResource(
            resources,
            R.drawable.hero_knight_run_5
        )
        bm6 = BitmapFactory.decodeResource(
            resources,
            R.drawable.hero_knight_run_6
        )
        bm7 = BitmapFactory.decodeResource(
            resources,
            R.drawable.hero_knight_run_7
        )
        bm8 = BitmapFactory.decodeResource(
            resources,
            R.drawable.hero_knight_run_8
        )
        bm9 = BitmapFactory.decodeResource(
            resources,
            R.drawable.hero_knight_run_9
        )

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
        return ""
    }

    fun myLog(str: String, message: Any) {
        Log.i("DemoLog", (str + message))
    }

}