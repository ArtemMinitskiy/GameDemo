package com.example.gamedemo

open class Piece(var name: String?, var imageFigure: Int?, var color: Int?, var checkDoubleClick: Boolean?, var step: Int?, var stepIndex: Int?, var startPossition: Int?, var curPossition: Int?, var endPossition: Int?) {
    constructor() : this("", null, null, null, null, null, null, null, null)
}
