package com.example.gamedemo

import android.content.Context
import android.graphics.Point
import android.os.Build
import android.view.View
import android.view.WindowManager

class Utils {

    fun getViewHeight(view: View): Int {
        val wm = view.context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val deviceWidth: Int

        val size = Point()
        display.getSize(size)
        deviceWidth = size.y
        val widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(deviceWidth, View.MeasureSpec.AT_MOST)
        val heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        view.measure(widthMeasureSpec, heightMeasureSpec)
        return view.measuredHeight //        view.getMeasuredWidth();
    }

    fun getViewWidth(view: View): Int {
        val wm = view.context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val deviceWidth: Int

        val size = Point()
        display.getSize(size)
        deviceWidth = size.x

        val widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(deviceWidth, View.MeasureSpec.AT_MOST)
        val heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        view.measure(widthMeasureSpec, heightMeasureSpec)
        return view.measuredWidth
    }

    private fun createListWithSteps(
        step: Int,
        numberOfColums: Int,
        currentEnemyPosition: Int?,
        endEnemyPosition: Int?,
        direction: String
    ): MutableList<Int> {
        val enemyMoves: MutableList<Int> = mutableListOf()
        val checkEnemyPossition: Int

        if (endEnemyPosition!! - currentEnemyPosition!! > numberOfColums) {
            checkEnemyPossition = endEnemyPosition / numberOfColums
        } else {
            checkEnemyPossition = endEnemyPosition
        }
        val diffPositions = checkEnemyPossition - currentEnemyPosition
        val numberOfSteps = numberOfColums - 1
        when (diffPositions) {
            numberOfColums - 1 -> {
                for (i in 0..numberOfColums - 2) {
                    enemyMoves.add(step)
                }
                for (i in 0..numberOfColums - 2) {
                    enemyMoves.add(-step)
                }
            }
            0 -> {
                for (i in 0..numberOfColums - 2) {
                    enemyMoves.add(-step)
                }
                for (i in 0..numberOfColums - 2) {
                    enemyMoves.add(step)
                }
            }
            else -> {
                if (diffPositions != 0 && diffPositions < checkEnemyPossition - 1) {
                    when (direction) {
                        "Right" -> {
                            for (i in 0..diffPositions - 1) {
                                enemyMoves.add(step)
                            }
                            for (i in 0..numberOfColums - 2) {
                                enemyMoves.add(-step)
                            }
                            for (i in 0..(numberOfSteps - diffPositions) - 1) {
                                enemyMoves.add(step)
                            }
                        }
                        "Left" -> {
                            for (i in 0..(numberOfSteps - diffPositions) - 1) {
                                enemyMoves.add(-step)
                            }
                            for (i in 0..numberOfColums - 2) {
                                enemyMoves.add(step)
                            }
                            for (i in 0..diffPositions - 1) {
                                enemyMoves.add(-step)
                            }
                        }
                    }
                }

            }
        }

        return enemyMoves
    }


//    fun enemyHorizontalMoves() {
//        enemyHorizontalStep++
//        newPiece = pieceList.get(currentEnemyHorizontalPos!!)
//        oldPosition = currentEnemyHorizontalPos
//        currentEnemyHorizontalPos =
//            currentEnemyHorizontalPos!! + enemyHorizontalMoves.get(enemyHorizontalStep)
//        oldPiece = pieceList.get(currentEnemyHorizontalPos!!)
//        pieceList.set(currentEnemyHorizontalPos!!, newPiece)
//        pieceList.set(oldPosition!!, oldPiece)
//
////        Log.i("DemoLog", "Position: " + currentEnemyHorizontalPos)
//        if (enemyHorizontalStep == 5) enemyHorizontalStep = -1
//        stepTest = false
//        adapter = PieceAdapter(this, pieceList, this)
//        board_grid.adapter = adapter
//        oldPiece = Piece()
//        newPiece = Piece()
//    }
//
//    fun enemyDiagonalMoves() {
//        enemyDiagonalStep++
//        newPiece = pieceList.get(currentEnemyDiagonalPos!!)
//        oldPosition = currentEnemyDiagonalPos
//        currentEnemyDiagonalPos =
//            currentEnemyDiagonalPos!! + enemyDiagonalMoves.get(enemyDiagonalStep)
//        oldPiece = pieceList.get(currentEnemyDiagonalPos!!)
//        pieceList.set(currentEnemyDiagonalPos!!, newPiece)
//        pieceList.set(oldPosition!!, oldPiece)
//
//        if (enemyDiagonalStep == 5) enemyDiagonalStep = -1
////        step++
//        stepTest = false
//        adapter = PieceAdapter(this, pieceList, this)
//        board_grid.adapter = adapter
//        oldPiece = Piece()
//        newPiece = Piece()
//
//    }
}