package com.example.gamedemo.Animation

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.example.gamedemo.AdapterCallback
import com.example.gamedemo.Grass
import com.example.gamedemo.Piece
import com.example.gamedemo.R
import kotlinx.android.synthetic.main.activity_animation.*


class AnimationActivity : AppCompatActivity(), AdapterCallback {

    var mAnimation: AnimationDrawable? = null
    lateinit var animSlide: Animation

    var adapter: PieceAdapter2? = null
    var pieceList = ArrayList<Piece>()

    var scaleType: Float = 1.0F

    val axisX = 217F
    val axisY = 180F

    var cellXSize = 0F
    var cellYSize = 0F

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        board_grid.numColumns = 3

//        imageView.layoutParams.height = Utils().getViewHeight(board_grid)
//        imageView.layoutParams.width = Utils().getViewWidth(board_grid) / 3 - 16


        // load cards
        pieceList.add(Grass("Coffee", null, null, null, null, null, null, null, null))
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
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))

        /*pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))

        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))

        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))

        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))

        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))

        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))

        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))

        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))

        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))

        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))

        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee1", null, null, null, null, null, null, null, null))*/


        adapter = PieceAdapter2(this, pieceList, this)
        board_grid.adapter = adapter
//        imageView.setBackgroundResource(R.drawable.knight_run_animation)
//        mAnimation = imageView.getBackground() as AnimationDrawable?

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
            val moveAnimation = TranslateAnimation(0F, axisX, 0F, axisY)
            moveAnimation.duration = 2000
            moveAnimation.fillAfter = true
            moveAnimation.setAnimationListener(animationMoveListener)
            imageView.startAnimation(moveAnimation)




            //0
//            param.setMargins(32, 32, 0, 0) // Where 32 margin

//            animSlide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide)
//            imageView.startAnimation(animSlide)

        }

        createAnimation()
    }

    var animationMoveListener: AnimationListener =
        object : AnimationListener {
            override fun onAnimationEnd(arg0: Animation) {
                myLog("onAnimationEnd", "")
            }

            override fun onAnimationRepeat(animation: Animation) {
                myLog("onAnimationRepeat", "")
            }
            override fun onAnimationStart(animation: Animation) {
                myLog("onAnimationStart", "")
            }
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
//        getImageViewPositionOnLine(position)
        return ""
    }

    override fun getCellScale(listOfCellSize: ArrayList<Float>, position: Int) {
        cellXSize = listOfCellSize.get(0)
        cellYSize = listOfCellSize.get(1)
        myLog("", cellXSize)
        myLog("", cellYSize)

        imageView.layoutParams.height = (cellXSize / 2).toInt()
        imageView.layoutParams.width = cellYSize.toInt()
        imageView.requestLayout()

        setImageViewStartPosition(cellXSize, cellYSize, position)
    }

    fun setImageViewStartPosition(shiftX: Float, shiftY: Float, position: Int) {
        val axisX = 3
        val currentAxisY = position / axisX + 1
        val startLine = axisX * currentAxisY - axisX
        val endLine = axisX * currentAxisY - 1
        val marginX = position - startLine
        val marginY = currentAxisY - 1

//        var moveAnimation = TranslateAnimation(0F, 0F, 0F, 0F)

        var moveAnimation = TranslateAnimation(0F, (shiftX + 32) * marginX, 0F, (shiftY - 32) * marginY)

        moveAnimation.duration = 2000
        moveAnimation.fillAfter = true
        moveAnimation.setAnimationListener(animationMoveListener)
        imageView.startAnimation(moveAnimation)

    }

    fun myLog(str: String, message: Any) {
        Log.i("DemoLog", (str + ": " + message))
    }

    fun getImageViewPositionOnLine(position: Int) {
        val axisX = 3
        myLog("position", position)
        val currentAxisY = position / axisX + 1
        myLog("currentAxisY", currentAxisY)
        val startLine = axisX * currentAxisY - axisX
        myLog("startLine", startLine)
        val endLine = axisX * currentAxisY - 1
        myLog("endLine", endLine)
        val marginX = position - startLine
        myLog("marginX", marginX)
        val marginY = currentAxisY - 1
        if (marginY > 0) {
            myLog("marginY", marginY)
        }
    }

}