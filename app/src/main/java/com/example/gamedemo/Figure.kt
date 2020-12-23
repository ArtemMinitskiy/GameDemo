package com.example.gamedemo

import android.util.Log

class Figure(name: String?, imageFigure: Int?, color: Int?, checkDoubleClick: Boolean?, step: Int?, stepIndex: Int?,  startPossition: Int?,  curPossition: Int?,  endPossition: Int?) : Piece(name, imageFigure, color, checkDoubleClick, step, stepIndex, startPossition, curPossition, endPossition) {
    constructor() : this("", null, null, null, null, null, null, null, null)

    lateinit var listOfPossibleMoves: MutableList<Int>

    fun possibleMoves(currentPosition: Int, step: Int = 1, axisX: Int, axisY: Int): MutableList<Int> {
        var possiblePosition: Int
        val volume = axisX * axisY

        listOfPossibleMoves = mutableListOf()
        //First
        possiblePosition = currentPosition + 1
        if ((currentPosition + 1).rem(axisX) != 0) {
//            Log.i("DemoLogFigure", "possible 1 " + possiblePosition)
            listOfPossibleMoves.add(possiblePosition)
        }
        //Second
        possiblePosition = currentPosition - 1
        if (possiblePosition >= 0 && currentPosition.rem(axisX) != 0) {
//            Log.i("DemoLogFigure", "possible 2 " + possiblePosition)
            listOfPossibleMoves.add(possiblePosition)

        }
        //Third
        possiblePosition = currentPosition + axisX
        if (possiblePosition < volume) {
//            Log.i("DemoLogFigure", "possible 3 " + possiblePosition)
            listOfPossibleMoves.add(possiblePosition)
        }
        //Fourth
        possiblePosition = currentPosition - axisX
        if (possiblePosition >= 0) {
//            Log.i("DemoLogFigure", "possible 4 " + possiblePosition)
            listOfPossibleMoves.add(possiblePosition)
        }
        //Fifth
        possiblePosition = currentPosition + (axisX * step) + 1
        if (possiblePosition < volume) {
            if ((currentPosition + 1).rem(axisX) != 0) {
                listOfPossibleMoves.add(possiblePosition)
//                Log.i("DemoLogFigure", "possible 5 " + possiblePosition)
            }
        }
        //Sixth
        possiblePosition = currentPosition - (axisX * step) + 1
        if (possiblePosition > 0) {
            if ((currentPosition + 1).rem(axisX) != 0) {
//                Log.i("DemoLogFigure", "possible 6 " + possiblePosition)
                listOfPossibleMoves.add(possiblePosition)
            }
        }
        //Seventh
        possiblePosition = currentPosition + (axisX * step) - 1
        if (possiblePosition < volume) {
            if (currentPosition != 0) {
                if ((currentPosition).rem(axisX) != 0) {
//                    Log.i("DemoLogFigure", "possible 7 " + possiblePosition)
                    listOfPossibleMoves.add(possiblePosition)
                }
            }
        }
        //Eighth
        possiblePosition = currentPosition - (axisX * step) - 1
        if (possiblePosition >= 0) {
            if ((currentPosition).rem(axisX) != 0) {
//                Log.i("DemoLogFigure", "possible 8 " + possiblePosition)
                listOfPossibleMoves.add(possiblePosition)
            }
        }

        return listOfPossibleMoves
    }


}