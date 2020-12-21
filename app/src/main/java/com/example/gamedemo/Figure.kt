package com.example.gamedemo

class Figure(name: String?, imageFigure: Int?, color: Int?, checkDoubleClick: Boolean?) : Piece(name, imageFigure, color, checkDoubleClick) {
    constructor() : this("", null, null, null)

    lateinit var listOfPossibleMoves: MutableList<Int>

    fun possibleMoves(currentPosition: Int, step: Int = 1, axisX: Int, axisY: Int): MutableList<Int> {
        var possiblePosition: Int
        val volume = axisX * axisY

        listOfPossibleMoves = mutableListOf()
        //First
        possiblePosition = currentPosition + 1
        if (possiblePosition.rem(axisX) != 1) listOfPossibleMoves.add(possiblePosition)
        //Second
        possiblePosition = currentPosition - 1
        if (currentPosition != 1 && currentPosition.rem(axisX) != 1) listOfPossibleMoves.add(possiblePosition)
        //Third
        possiblePosition = currentPosition + axisX
        if (possiblePosition <= volume) listOfPossibleMoves.add(possiblePosition)
        //Fourth
        possiblePosition = currentPosition - axisX
        if (possiblePosition > 0) listOfPossibleMoves.add(possiblePosition)
        //Fifth
        possiblePosition = currentPosition + (axisX * step) + 1
        if (currentPosition.rem(axisX) != 0 && possiblePosition <= volume) listOfPossibleMoves.add(possiblePosition)
        //Sixth
        possiblePosition = currentPosition - (axisX * step) + 1
        if (possiblePosition >= 1 && currentPosition.rem(axisX) != 0) listOfPossibleMoves.add(possiblePosition)
        //Seventh
        possiblePosition = currentPosition + (axisX * step) - 1
        if (currentPosition != 1 && currentPosition.rem(axisX) != 1 && possiblePosition <= volume) listOfPossibleMoves.add(possiblePosition)
        //Eighth
        possiblePosition = currentPosition - (axisX * step) - 1
//        Log.i("DemoLogFigure", "possible " + possiblePosition + " " + "current " + currentPosition)
//        Log.i("DemoLogFigure", currentPosition.rem(possiblePosition).toString())
        if (possiblePosition > 0) {
            if (currentPosition.rem(axisX) != 1) listOfPossibleMoves.add(possiblePosition)
        }

        return listOfPossibleMoves
    }


}