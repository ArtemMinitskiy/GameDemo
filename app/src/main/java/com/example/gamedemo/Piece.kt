package com.example.gamedemo

open class Piece(var name: String?, var imageFigure: Int?, var color: Int?, var checkDoubleClick: Boolean?) {
    constructor() : this("", null, null, null)
}
