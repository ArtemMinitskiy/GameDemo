package com.example.gamedemo

class Grass(name: String?, imageFigure: Int?, color: Int?, checkDoubleClick: Boolean?, step: Int?, stepIndex: Int?,  startPossition: Int?,  curPossition: Int?,  endPossition: Int?) : Piece(name, imageFigure, color, checkDoubleClick, step, stepIndex, startPossition, curPossition, endPossition) {
    constructor() : this("", null, null, null, null, null, null, null, null)
}