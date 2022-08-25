package com.example.gamedemo

import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

//class GameRules {
//    fun isDead(pieceList: ArrayList<Piece>, currentEPs: Int): Boolean {
//        // Death check
//        val attackRadius: MutableList<Int> =
//            Figure().possibleMoves(currentEPs, 1,
//                MainActivity.NUMBER_OF_COLUMS,
//                MainActivity.NUMBER_OF_ROWS
//            )
//        attackRadius.sort()
//        for (index in 0..attackRadius.size - 1) {
//            if (pieceList.get(attackRadius.get(index)) is Figure) {
//                Toast.makeText(this, "You are DEAD!", Toast.LENGTH_LONG).show()
//                checkStep = false
//                return true
//            }
//        }
//        attackRadius.clear()
//        return false
//    }
//
//    fun deathAttackMove(pieceList: ArrayList<Piece>, currentEPs: Int) {
//        // Death attack
//        val attackRadius: MutableList<Int> =
//            Figure().possibleMoves(currentEPs, 1,
//                MainActivity.NUMBER_OF_COLUMS,
//                MainActivity.NUMBER_OF_ROWS
//            )
//        attackRadius.sort()
//        for (index in 0..attackRadius.size - 1) {
//            if (pieceList.get(attackRadius.get(index)) is Figure) {
//                pieceList.set(
//                    currentEPs,
//                    Grass("Coffee", null, null, null, null, null, null, null, null)
//                )
//                pieceList.set(
//                    attackRadius.get(index),
//                    EnemyFigure(
//                        "Coffee",
//                        R.drawable.bandit_run_animation,
//                        null,
//                        false,
//                        null,
//                        null,
//                        null,
//                        null,
//                        null
//                    )
//                )
//                Toast.makeText(this, "You are DEAD!", Toast.LENGTH_LONG).show()
//                checkStep = false
//            }
//        }
//        attackRadius.clear()
//        adapter = PieceAdapter(this, pieceList, this)
//        board_grid.adapter = adapter
//    }
//
//    fun isWin(pieceList: ArrayList<Piece>, currentEPs: Int, winPossition: Int): Boolean {
//        if (pieceList.get(winPossition) is Figure) {
//            pieceList.set(
//                winPossition,
//                Figure(
//                    "Figure",
//                    null,
//                    null,
//                    null,
//                    null,
//                    null,
//                    null,
//                    null,
//                    null
//                )
//            )
//            pieceList.set(
//                currentEPs,
//                Grass("Coffee", null, null, null, null, null, null, null, null)
//            )
//            Toast.makeText(this, "You are WIN!", Toast.LENGTH_LONG).show()
//            return true
//        }
//
//        return false
//    }
//
//    fun steps(step: Int, axisX: Int, currentEP: Int?, endEP: Int?, direction: String, stepIndex: Int): Int {
//        var stepI = step
//        val checkEnemyPossition: Int
//        if (endEP!! - currentEP!! > axisX) {
//            checkEnemyPossition = endEP / axisX
//        } else {
//            checkEnemyPossition = endEP
//        }
//        val diffPositions = checkEnemyPossition - currentEP
//
//        when (diffPositions) {
//            axisX - 1 -> {
//                while (stepIndex < (2 * (axisX - 1))) {
//                    if (stepIndex >= axisX - 1) {
//                        stepI = -step
//                    }
//                    break
//                }
//            }
//            0 -> {
//                while (stepIndex < (2 * (axisX - 1))) {
//                    if (stepIndex < axisX - 1) {
//                        stepI = -step
//                    } else {
//                        stepI = step
//                    }
//                    break
//                }
//            }
//            else -> {
//                if (diffPositions != 0 && diffPositions < checkEnemyPossition - 1) {
//                    when (direction) {
//                        "Right" -> {
//                            while (stepIndex < (2 * (axisX - 1))) {
//                                if (stepIndex >= diffPositions) {
//                                    stepI = -step
//                                }
//                                if (stepIndex >= diffPositions + axisX - 1) {
//                                    stepI = step
//                                }
//                                break
//                            }
//                        }
//                        "Left" -> {
//                            while (stepIndex < (2 * (axisX - 1))) {
//                                if (stepIndex < axisX - diffPositions - 1) {
//                                    stepI = -step
//                                }
//                                if (stepIndex >= axisX - diffPositions + axisX - 2) {
//                                    stepI = -step
//                                }
//                                break
//                            }
//                        }
//                    }
//                }
//
//            }
//        }
//        return stepI
//
//    }
//
//    fun universalEnemyMoves(pieceList: ArrayList<Piece>, enemyFigure: Piece) {
//        val newEnemyPossition: Int
//
//        val step = enemyFigure.step
//        val enemyCurrentPossition = enemyFigure.curPossition!!
//
//        val enemyEndPosition = enemyFigure.endPossition
//        var stepIndex: Int = enemyFigure.stepIndex!!
//        if (stepIndex == 5) {
//            enemyFigure.stepIndex = 0
//            stepIndex = 0
//        } else {
//            enemyFigure.stepIndex = enemyFigure.stepIndex!! + 1
//            stepIndex = enemyFigure.stepIndex!!
//        }
//
//        val enemyStep: Int = steps(
//            step!!,
//            MainActivity.NUMBER_OF_COLUMS,
//            enemyFigure.startPossition,
//            enemyEndPosition,
//            "Right",
//            stepIndex
//        )
//
//        newPiece = pieceList.get(enemyCurrentPossition)
//        oldPosition = enemyCurrentPossition
//        newEnemyPossition = enemyCurrentPossition + enemyStep
//        oldPiece = pieceList.get(newEnemyPossition)
//        pieceList.set(newEnemyPossition, newPiece)
//        pieceList.set(oldPosition!!, oldPiece)
//        enemyFigure.curPossition = newEnemyPossition
//
//        checkStep = false
//        adapter = PieceAdapter(this, pieceList, this)
//        board_grid.adapter = adapter
//        oldPiece = Piece()
//        newPiece = Piece()
//
//    }
//
//    companion object {
//        const val NUMBER_OF_COLUMS = 4
//        const val NUMBER_OF_ROWS = 8
//
//    }
//
//}