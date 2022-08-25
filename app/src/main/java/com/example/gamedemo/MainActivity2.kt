package com.example.gamedemo

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gamedemo.Animation.AnimationActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

class MainActivity2 : AppCompatActivity(), AdapterCallback {

    var adapter: PieceAdapter? = null
    var pieceList = ArrayList<Piece>()

    lateinit var enemyFigure: EnemyFigure
    lateinit var pMoves: MutableList<Int>
    lateinit var figurePossibleMoves: MutableList<Int>

    var checkStep: Boolean = false
    var isFigureDead: Boolean = false
    var isFigureDeadIndex: Int = 0

    var oldPosition: Int? = -1
    var newPiece: Piece = Piece()
    var oldPiece: Piece = Piece()
    var checkFigureDoubleClick = false

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        board_grid.numColumns = NUMBER_OF_COLUMS

        // load cards
        pieceList.add(
            EnemyFigure(
                "EnemyFigure",
                null,
                null,
                false,
                5,
                -1,
                0,
                0,
                15
            )
        )
        pieceList.add(
            Grass(
                "WinCell",
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
        pieceList.add(Grass("Coffee", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("null", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee4", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee6", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Rock1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("null", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee4", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee5", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("null", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee6", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Rock2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Rock2", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("null", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Rock1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("null", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee4", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee5", null, null, null, null, null, null, null, null))
        pieceList.add(EnemyFigure("EnemyFigure2", null, null, false, 1, -1, 20, 20, 23))
        pieceList.add(Grass("Coffee", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Rock1", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("null", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee4", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee5", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("null", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Coffee6", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("Rock2", null, null, null, null, null, null, null, null))
        pieceList.add(Figure("Figure", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("null", null, null, null, null, null, null, null, null))
        pieceList.add(Grass("null", null, null, null, null, null, null, null, null))

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
       pieceList.add(Grass("Lava", null, null, null, null, null, null, null, null))

        adapter = PieceAdapter(this, pieceList, this)
        board_grid.adapter = adapter

        resetFab.setOnClickListener {
            if (checkStep == true) {
                var checkName = "Figure"
//                GlobalScope.async {
                for (index in 0..(NUMBER_OF_COLUMS * NUMBER_OF_ROWS) - 1) {
                    if (pieceList.get(index) is EnemyFigure) {
                        enemyFigure = pieceList.get(index) as EnemyFigure

                        if (!enemyFigure.name.equals(checkName)) {
                            isFigureDead = isDead(pieceList, index)
                            isFigureDeadIndex = index
                            if (!isDead(pieceList, index)) {
                                this@MainActivity2.runOnUiThread {
                                    universalEnemyMoves(pieceList, enemyFigure)
                                }
//                                    delay(500L)

                            }
                            checkName = enemyFigure.name.toString()
                        }

                    }

//                    }
                }
                if (isFigureDead) {
                    deathAttackMove(pieceList, isFigureDeadIndex)
                }

                checkFigureDoubleClick = false
            }
        }

        layout.setOnClickListener {
            for (index in 0..(NUMBER_OF_COLUMS * NUMBER_OF_ROWS) - 1) {
                if (pieceList.get(index) is EnemyFigure) {
                    pieceList.get(index).checkDoubleClick = false
                }
                val tv = board_grid.getChildAt(index) as View
                tv.background = getDrawable(R.drawable.isometric_pixel_flat)
                checkFigureDoubleClick = false
            }
        }
    }

    fun isDead(pieceList: ArrayList<Piece>, currentEPs: Int): Boolean {
        // Death check
        val attackRadius: MutableList<Int> =
            Figure().possibleMoves(currentEPs, 1, NUMBER_OF_COLUMS, NUMBER_OF_ROWS)
        attackRadius.sort()
        for (index in 0..attackRadius.size - 1) {
            if (pieceList.get(attackRadius.get(index)) is Figure) {
                Toast.makeText(this, "You are DEAD!", Toast.LENGTH_LONG).show()
                checkStep = false
                return true
            }
        }
        attackRadius.clear()
        return false
    }

    fun deathAttackMove(pieceList: ArrayList<Piece>, currentEPs: Int) {
        // Death attack
        val attackRadius: MutableList<Int> =
            Figure().possibleMoves(currentEPs, 1, NUMBER_OF_COLUMS, NUMBER_OF_ROWS)
        attackRadius.sort()
        for (index in 0..attackRadius.size - 1) {
            if (pieceList.get(attackRadius.get(index)) is Figure) {
                pieceList.set(
                    currentEPs,
                    Grass("Coffee", null, null, null, null, null, null, null, null)
                )
                pieceList.set(
                    attackRadius.get(index),
                    EnemyFigure(
                        "Coffee",
                        R.drawable.bandit_run_animation,
                        null,
                        false,
                        null,
                        null,
                        null,
                        null,
                        null
                    )
                )
                Toast.makeText(this, "You are DEAD!", Toast.LENGTH_LONG).show()
                checkStep = false
            }
        }
        attackRadius.clear()
        adapter = PieceAdapter(this, pieceList, this)
        board_grid.adapter = adapter
    }

    fun isWin(pieceList: ArrayList<Piece>, currentEPs: Int, winPossition: Int): Boolean {
        if (pieceList.get(winPossition) is Figure) {
            pieceList.set(
                winPossition,
                Figure(
                    "Figure",
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
            pieceList.set(
                currentEPs,
                Grass("Coffee", null, null, null, null, null, null, null, null)
            )
            Toast.makeText(this, "You are WIN!", Toast.LENGTH_LONG).show()
            return true
        }

        return false
    }

    fun steps(step: Int, axisX: Int, currentEP: Int?, endEP: Int?, direction: String, stepIndex: Int): Int {
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

    fun universalEnemyMoves(pieceList: ArrayList<Piece>, enemyFigure: Piece) {
        val newEnemyPossition: Int

        val step = enemyFigure.step
        val enemyCurrentPossition = enemyFigure.curPossition!!

        val enemyEndPosition = enemyFigure.endPossition
        var stepIndex: Int = enemyFigure.stepIndex!!
        if (stepIndex == 5) {
            enemyFigure.stepIndex = 0
            stepIndex = 0
        } else {
            enemyFigure.stepIndex = enemyFigure.stepIndex!! + 1
            stepIndex = enemyFigure.stepIndex!!
        }

        val enemyStep: Int = steps(
            step!!,
            NUMBER_OF_COLUMS,
            enemyFigure.startPossition,
            enemyEndPosition,
            "Right",
            stepIndex
        )

        newPiece = pieceList.get(enemyCurrentPossition)
        oldPosition = enemyCurrentPossition
        newEnemyPossition = enemyCurrentPossition + enemyStep
        oldPiece = pieceList.get(newEnemyPossition)
        pieceList.set(newEnemyPossition, newPiece)
        pieceList.set(oldPosition!!, oldPiece)
        enemyFigure.curPossition = newEnemyPossition

        checkStep = false
        adapter = PieceAdapter(this, pieceList, this)
        board_grid.adapter = adapter
        oldPiece = Piece()
        newPiece = Piece()

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun doThings(position: Int): String {
        var cell = ""
        val enemyDirection: Int

        if (pieceList.get(position) is Figure) {
            if (!checkFigureDoubleClick) {
                cell = "Figure"
                newPiece = pieceList.get(position)
                oldPosition = position
                figurePossibleMoves = Figure().possibleMoves(position, 1, NUMBER_OF_COLUMS, NUMBER_OF_ROWS)
                for (index in 0..figurePossibleMoves.size - 1) {
                    val tv = board_grid.getChildAt(figurePossibleMoves.get(index)) as View
                    tv.background = getDrawable(R.drawable.isometric_pixel_flat_possible_moves)
                }

                checkFigureDoubleClick = true
            }
        }

        if (checkStep == false) {
            if (pieceList.get(position) is Grass) {
                if (oldPosition!! >= 0) {
                    if (figurePossibleMoves.contains(position)) {
                        cell = "Grass"
                        oldPiece = pieceList.get(position)
                        pieceList.set(position, newPiece).also {pieceList.set(oldPosition!!, oldPiece) }
//                        pieceList.set(oldPosition!!, oldPiece)

                        adapter = PieceAdapter(this, pieceList, this)
                        board_grid.adapter = adapter

                        checkStep = !isWin(pieceList, oldPosition!!, 1)
                        newPiece = Piece()
                        oldPiece = Piece()
                        oldPosition = -1
                        figurePossibleMoves.clear()

                    }
                }
            }
        }

        if (pieceList.get(position) is EnemyFigure) {
            if (!pieceList.get(position).checkDoubleClick!!) {
                cell = "Enemy"
                pMoves = Figure().possibleMoves(position, 1, NUMBER_OF_COLUMS, NUMBER_OF_ROWS)
                for (index in 0..pMoves.size - 1) {
                    val tv = board_grid.getChildAt(pMoves.get(index)) as View
                    tv.background = getDrawable(R.drawable.isometric_pixel_flat_attack_radius)
                }

                enemyFigure = pieceList.get(position) as EnemyFigure

                enemyDirection = steps(
                    enemyFigure.step!!,
                    NUMBER_OF_COLUMS,
                    enemyFigure.startPossition,
                    enemyFigure.endPossition,
                    "",
                    enemyFigure.stepIndex!! + 1
                )

                if (enemyDirection > 0) {
                    board_grid.getChildAt(position + enemyDirection).background =
                        getDrawable(R.drawable.isometric_pixel_flat_attack_radius_right)
                    if (enemyDirection >= NUMBER_OF_COLUMS) {
                        board_grid.getChildAt(position + enemyDirection).background =
                            getDrawable(R.drawable.isometric_pixel_flat_attack_radius_right_diagonal)
                    }
                } else {
                    board_grid.getChildAt(position + enemyDirection).background =
                        getDrawable(R.drawable.isometric_pixel_flat_attack_radius_left)
                    if (enemyDirection <= -NUMBER_OF_COLUMS) {
                        board_grid.getChildAt(position + enemyDirection).background =
                            getDrawable(R.drawable.isometric_pixel_flat_attack_radius_left_diagonal)
                    }
                }
                pieceList.get(position).checkDoubleClick = true
            } else {
                pMoves = Figure().possibleMoves(position, 1, NUMBER_OF_COLUMS, NUMBER_OF_ROWS)
                for (index in 0..pMoves.size - 1) {
                    val tv = board_grid.getChildAt(pMoves.get(index)) as View
                    tv.background = getDrawable(R.drawable.isometric_pixel_flat)
                }
                val tv = board_grid.getChildAt(position) as View
                tv.background = getDrawable(R.drawable.isometric_pixel_flat)
                pieceList.get(position).checkDoubleClick = false
            }
        }

        return cell
    }

    override fun getCellScale(listOfCellSize: ArrayList<Float>, position: Int) {
        TODO("Not yet implemented")
    }

    companion object {
        const val NUMBER_OF_COLUMS = 8
        const val NUMBER_OF_ROWS = 8

        fun myLog(str: String, message: Any) = Log.i("DemoLog", (str + ": " + message))

    }

}