package com.example.gamedemo

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.board_cell.view.*
import kotlinx.android.synthetic.main.board_cell.view.board_cell
import kotlinx.android.synthetic.main.board_cell.view.figureImage
import kotlinx.android.synthetic.main.board_cell.view.figureImage2
import kotlinx.android.synthetic.main.board_cell.view.frame
import kotlinx.android.synthetic.main.board_cell.view.name
import kotlinx.android.synthetic.main.board_cell_2.view.*

class PieceAdapter(
    context: Context,
    pieceList: ArrayList<Piece>,
    private var adapterCallback: AdapterCallback
) : BaseAdapter() {

    var piecesList = pieceList
    var context: Context? = context
    var environmentCell = ""

    //Animation
    var mAnimation: AnimationDrawable? = null
    lateinit var animSlide: Animation

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
        pieceView.board_cell.background = ContextCompat.getDrawable(context!!, R.drawable.isometric_pixel_flat)
//        if (piece.name == null){pieceView.board_cell.visibility = View.GONE }
//        if (piece.imageFigure == null) {
//            pieceView.frame.setBackgroundColor(Color.parseColor("#3700B3"))
//            pieceView.frame.background = (ContextCompat.getDrawable(context!!, R.drawable.border_green));
//
//        }
//        if (piece.imageFigure != null) {
//            pieceView.frame.setBackgroundColor(Color.parseColor("#3700B3"))
//        }

        if (piece.name == "Figure") {
            pieceView.figureImage2.setBackgroundResource(R.drawable.knight_run_animation)
            mAnimation = pieceView.figureImage2.getBackground() as AnimationDrawable?
            mAnimation!!.start()
        }
        if (piece.name == "EnemyFigure" || piece.name == "EnemyFigure2") {
            pieceView.figureImage2.setBackgroundResource(R.drawable.bandit_run_animation)
            mAnimation = pieceView.figureImage2.getBackground() as AnimationDrawable?
            mAnimation!!.start()
        }
        if (piece.name == "WinCell") {
            pieceView.figureImage2.setBackgroundResource(R.drawable.chest_animation)
            mAnimation = pieceView.figureImage2.getBackground() as AnimationDrawable?
            mAnimation!!.start()
        }

        pieceView.board_cell.setOnClickListener {
            environmentCell = adapterCallback.doThings(position)
            when (environmentCell) {
                "Figure" -> pieceView.board_cell.background = ContextCompat.getDrawable(context!!, R.drawable.isometric_pixel_flat_possible_moves)
                "Enemy" -> pieceView.board_cell.background = ContextCompat.getDrawable(context!!, R.drawable.isometric_pixel_flat_attack_radius)
                "Grass" -> pieceView.board_cell.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            }
        }

        piece.imageFigure?.let { pieceView.figureImage2.setImageResource(it) }
        pieceView.name.text = piece.name

        return pieceView
    }

}