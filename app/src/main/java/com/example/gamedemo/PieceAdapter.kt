package com.example.gamedemo

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.board_cell.view.*

class PieceAdapter(context: Context, pieceList: ArrayList<Piece>, private var adapterCallback: AdapterCallback) : BaseAdapter() {

    var piecesList = pieceList
    var context: Context? = context
    var environmentCell = ""

    override fun getCount(): Int {
        return piecesList.size
    }

    override fun getItem(position: Int): Piece? {
        return piecesList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val piece = this.piecesList[position]
        val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val pieceView = inflator.inflate(R.layout.board_cell, null)
//        if (piece.name == null){pieceView.board_cell.visibility = View.GONE }
//        if (piece.imageFigure == null) {
//            pieceView.frame.setBackgroundColor(Color.parseColor("#3700B3"))
//            pieceView.frame.background = (ContextCompat.getDrawable(context!!, R.drawable.border_green));
//
//        }
//        if (piece.imageFigure != null) {
//            pieceView.frame.setBackgroundColor(Color.parseColor("#3700B3"))
//        }

        pieceView.board_cell.setOnClickListener {
            environmentCell = adapterCallback.doThings(position)
            when (environmentCell) {
                "Figure" -> pieceView.board_cell.background = ContextCompat.getDrawable(context!!, R.drawable.border_blue)
                "Enemy" -> pieceView.board_cell.background = ContextCompat.getDrawable(context!!, R.drawable.border_red)
                "Grass" -> pieceView.board_cell.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            }
        }

        piece.imageFigure?.let { pieceView.figureImage.setImageResource(it) }
        pieceView.name.text = piece.name

        return pieceView
    }

}