package com.example.gamedemo

class EnemyFigure(name: String?, imageFigure: Int?, color: Int?, checkDoubleClick: Boolean?, step: Int?, stepIndex: Int?,  startPossition: Int?,  curPossition: Int?,  endPossition: Int?) : Piece(name, imageFigure, color, checkDoubleClick, step, stepIndex, startPossition, curPossition, endPossition) {
    constructor() : this("", null, null, null, -1, null, null, null, null)
}