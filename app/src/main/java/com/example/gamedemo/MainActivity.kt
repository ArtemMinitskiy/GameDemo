package com.example.gamedemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterCallback {

    var adapter: PieceAdapter? = null
    var pieceList = ArrayList<Piece>()

    lateinit var pMoves: MutableList<Int>
    var enemysCurPossitions: MutableList<Int> = mutableListOf(20)
    var enemysCurPossitions2: MutableList<Int> = mutableListOf(0)
    var checkStep: Boolean = false
    var stepIndex: Int = -1
    var oldPosition: Int? = -1
    var newPiece: Piece = Piece()
    var oldPiece: Piece = Piece()
    var checkFigureDoubleClick = false

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        board_grid.numColumns = NUMBER_OF_COLUMS

        // load cards
        pieceList.add(EnemyFigure("Coffee", R.drawable.enemy, null, false))
        pieceList.add(Grass("Rock1", R.drawable.border_yellow, null, null))
        pieceList.add(Grass("Coffee", null, null, null))
        pieceList.add(Grass("null", null, null, null))
        pieceList.add(Grass("Coffee4", null, null, null))
        pieceList.add(Grass("Coffee6", null, null, null))
        pieceList.add(Grass("Coffee", null, null, null))
        pieceList.add(Grass("Rock1", null, null, null))
        pieceList.add(Grass("null", null, null, null))
        pieceList.add(Grass("Coffee4", null, null, null))
        pieceList.add(Grass("Coffee5", null, null, null))
        pieceList.add(Grass("null", null, null, null))
        pieceList.add(Grass("Coffee6", null, null, null))
        pieceList.add(Grass("Rock2", null, null, null))
        pieceList.add(Grass("Rock2", null, null, null))
        pieceList.add(Grass("null", null, null, null))
        pieceList.add(Grass("Rock1", null, null, null))
        pieceList.add(Grass("null", null, null, null))
        pieceList.add(Grass("Coffee4", null, null, null))
        pieceList.add(Grass("Coffee5", null, null, null))
        pieceList.add(EnemyFigure("Coffee", R.drawable.enemy, null, false))
        pieceList.add(Grass("Coffee", null, null, null))
        pieceList.add(Grass("Rock1", null, null, null))
        pieceList.add(Grass("null", null, null, null))
        pieceList.add(Grass("Coffee4", null, null, null))
        pieceList.add(Grass("Coffee5", null, null, null))
        pieceList.add(Grass("null", null, null, null))
        pieceList.add(Grass("Coffee6", null, null, null))
        pieceList.add(Grass("Rock2", null, null, null))
        pieceList.add(Figure("Figure", R.drawable.chess_horse, null, null))
        pieceList.add(Grass("null", null, null, null))
        pieceList.add(Grass("null", null, null, null))

        adapter = PieceAdapter(this, pieceList, this)
        board_grid.adapter = adapter

        resetFab.setOnClickListener {
            if (checkStep == true) {

                stepIndex++
                if (!isDead(pieceList, enemysCurPossitions)) {
                    universalEnemyMoves(pieceList, 1, 21, 24, enemysCurPossitions)
                }

                if (!isDead(pieceList, enemysCurPossitions2)) {
                    Handler(Looper.getMainLooper()).postDelayed({
                        universalEnemyMoves(pieceList, 5, 1, 16, enemysCurPossitions2)
                    }, 500)
                }

                Handler(Looper.getMainLooper()).postDelayed({
                    if (stepIndex == (2 * (NUMBER_OF_COLUMS - 1)) - 1) stepIndex = -1
                }, 1000)
                checkFigureDoubleClick = false
            }
        }

        layout.setOnClickListener {
            for (index in 0..(NUMBER_OF_COLUMS * NUMBER_OF_ROWS) - 1) {
                val tv = board_grid.getChildAt(index) as View
                tv.background = getDrawable(R.drawable.default_background)
            }
            for (index in 0..(NUMBER_OF_COLUMS * NUMBER_OF_ROWS) - 1) {
                if (pieceList.get(index) is EnemyFigure) {
                    pieceList.get(index).checkDoubleClick = false
                }
            }
        }
    }

    fun isDead(pieceList: ArrayList<Piece>, currentEPs: MutableList<Int>): Boolean {
        // Death check
        val attackRadius: MutableList<Int> = Figure().possibleMoves(currentEPs.get(0) + 1, 1, NUMBER_OF_COLUMS, NUMBER_OF_ROWS)
        for (index in 0..attackRadius.size - 1) {
            if (pieceList.get(attackRadius.get(index) - 1) is Figure) {
                pieceList.set(currentEPs.get(0), Grass("Coffee", null, null, null))
                pieceList.set(
                    attackRadius.get(index) - 1,
                    EnemyFigure("Coffee", R.drawable.enemy, null, false)
                )
                Toast.makeText(this, "You are DEAD!", Toast.LENGTH_LONG).show()
                checkStep = false
                return true
            }
        }
        attackRadius.clear()
        return false
    }

    fun isWin(pieceList: ArrayList<Piece>, currentEPs: Int, winPossition: Int): Boolean {
        if (pieceList.get(winPossition) is Figure) {
            pieceList.set(winPossition, Figure("Figure", R.drawable.chess_horse, null, null))
            pieceList.set(currentEPs, Grass("Coffee", null, null, null))
            Toast.makeText(this, "You are WIN!", Toast.LENGTH_LONG).show()
            return true
        }

        return false
    }

    fun steps(step: Int, axisX: Int, currentEP: Int?, endEP: Int?, direction: String): Int {
        var stepI = step
        val checkEnemyPossition: Int
        if (endEP!! - currentEP!! > axisX) {
            checkEnemyPossition = endEP / axisX
        } else {
            checkEnemyPossition = endEP
        }
        val diffPositions = checkEnemyPossition - currentEP

        when (diffPositions) {
            axisX - 1 -> {
                while (stepIndex < (2 * (axisX - 1))) {
                    if (stepIndex >= axisX - 1) {
                        stepI = -step
                    }
                    break
                }
            }
            0 -> {
                while (stepIndex < (2 * (axisX - 1))) {
                    if (stepIndex < axisX - 1) {
                        stepI = -step
                    } else {
                        stepI = step
                    }
                    break
                }
            }
            else -> {
                if (diffPositions != 0 && diffPositions < checkEnemyPossition - 1) {
                    when (direction) {
                        "Right" -> {
                            while (stepIndex < (2 * (axisX - 1))) {
                                if (stepIndex >= diffPositions) {
                                    stepI = -step
                                }
                                if (stepIndex >= diffPositions + axisX - 1) {
                                    stepI = step
                                }
                                break
                            }
                        }
                        "Left" -> {
                            while (stepIndex < (2 * (axisX - 1))) {
                                if (stepIndex < axisX - diffPositions - 1) {
                                    stepI = -step
                                }
                                if (stepIndex >= axisX - diffPositions + axisX - 2) {
                                    stepI = -step
                                }
                                break
                            }
                        }
                    }
                }

            }
        }
        return stepI

    }

    fun universalEnemyMoves(
        pieceList: ArrayList<Piece>,
        step: Int,
        enemyStartPossition: Int,
        enemyEndPosition: Int?,
        mutableCurEnemysPossition: MutableList<Int>
    ) {
        var newEnemyPossition: Int
        val enemyStep: Int =
            steps(step, NUMBER_OF_COLUMS, enemyStartPossition, enemyEndPosition, "")

        for (index in 0..mutableCurEnemysPossition.size - 1) {
            newEnemyPossition = mutableCurEnemysPossition.get(index)

            newPiece = pieceList.get(newEnemyPossition)
            oldPosition = newEnemyPossition
            newEnemyPossition = newEnemyPossition + enemyStep
            oldPiece = pieceList.get(newEnemyPossition)
            pieceList.set(newEnemyPossition, newPiece)
            pieceList.set(oldPosition!!, oldPiece)
            mutableCurEnemysPossition.set(index, newEnemyPossition)

            checkStep = false
            adapter = PieceAdapter(this, pieceList, this)
            board_grid.adapter = adapter
            oldPiece = Piece()
            newPiece = Piece()

        }

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun doThings(position: Int): String {
        var cell = ""

        if (pieceList.get(position) is Figure) {
            if (!checkFigureDoubleClick) {
                cell = "Figure"
                newPiece = pieceList.get(position)
                oldPosition = position

                pMoves = Figure().possibleMoves(position + 1, 1, NUMBER_OF_COLUMS, NUMBER_OF_ROWS)
                for (index in 0..pMoves.size - 1) {
                    val tv = board_grid.getChildAt(pMoves.get(index) - 1) as View
                    tv.background = getDrawable(R.drawable.border_green)
                }
                checkFigureDoubleClick = true
            }
        }

        if (checkStep == false) {
            if (pieceList.get(position) is Grass) {
                if (oldPosition!! >= 0) {
                    if (pMoves.contains(position + 1)) {
                        cell = "Grass"
                        oldPiece = pieceList.get(position)
                        pieceList.set(position, newPiece)
                        pieceList.set(oldPosition!!, oldPiece)

                        adapter = PieceAdapter(this, pieceList, this)
                        board_grid.adapter = adapter

                        checkStep = !isWin(pieceList, oldPosition!!, 1)
                        newPiece = Piece()
                        oldPiece = Piece()
                        oldPosition = -1
                        pMoves.clear()

                    }
                }
            }
        }

        if (pieceList.get(position) is EnemyFigure) {
            if (!pieceList.get(position).checkDoubleClick!!) {
                cell = "Enemy"
                pMoves = Figure().possibleMoves(position + 1, 1, NUMBER_OF_COLUMS, NUMBER_OF_ROWS)
                for (index in 0..pMoves.size - 1) {
                    val tv = board_grid.getChildAt(pMoves.get(index) - 1) as View
                    tv.background = getDrawable(R.drawable.border_red)
                }
                pieceList.get(position).checkDoubleClick = true
            } else {
                pMoves = Figure().possibleMoves(position + 1, 1, NUMBER_OF_COLUMS, NUMBER_OF_ROWS)
                for (index in 0..pMoves.size - 1) {
                    val tv = board_grid.getChildAt(pMoves.get(index) - 1) as View
                    tv.background = getDrawable(R.drawable.default_background)
                }
                val tv = board_grid.getChildAt(position) as View
                tv.background = getDrawable(R.drawable.default_background)
                pieceList.get(position).checkDoubleClick = false
            }
        }

        return cell
    }

    companion object {
        const val NUMBER_OF_COLUMS = 4
        const val NUMBER_OF_ROWS = 8
    }

    fun myLog(str: String, message: Any) {
        Log.i("DemoLog", (str + message))
    }

}