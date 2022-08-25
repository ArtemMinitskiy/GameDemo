package com.example.gamedemo

interface AdapterCallback {
    fun doThings(position: Int): String
    fun getCellScale(listOfCellSize :ArrayList<Float>, position: Int)
}