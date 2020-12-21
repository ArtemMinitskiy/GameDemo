package com.example.gamedemo

class Grass(name: String?, imageFigure: Int?, color: Int?, checkDoubleClick: Boolean?) : Piece(name, imageFigure, color, checkDoubleClick) {
    constructor() : this("", null, null, null)
}