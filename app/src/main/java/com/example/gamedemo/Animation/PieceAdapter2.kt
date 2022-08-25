package com.example.gamedemo.Animation

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import com.example.gamedemo.AdapterCallback
import com.example.gamedemo.Piece
import com.example.gamedemo.R
import com.example.gamedemo.Utils
import kotlinx.android.synthetic.main.activity_animation.*
import kotlinx.android.synthetic.main.board_cell.view.board_cell
import kotlinx.android.synthetic.main.board_cell.view.figureImage
import kotlinx.android.synthetic.main.board_cell.view.name
import kotlinx.android.synthetic.main.board_cell_2.view.*

class PieceAdapter2(context: Context, pieceList: ArrayList<Piece>, private var adapterCallback: AdapterCallback) : BaseAdapter() {

    var piecesList = pieceList
    var context: Context? = context
    var environmentCell = ""
    var cellSizes: ArrayList<Float> = arrayListOf()

    //Anim
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
        val pieceView = inflator.inflate(R.layout.board_cell_2, null)

        if (piece.name == "Coffee1") {
            pieceView.figureImage2.setBackgroundResource(R.drawable.knight_run_animation)
            mAnimation = pieceView.figureImage2.getBackground() as AnimationDrawable?
            mAnimation!!.start()
            animSlide = AnimationUtils.loadAnimation(context, R.anim.slide)
            pieceView.figureImage2.startAnimation(animSlide)
        }
        if (piece.name == "Coffee2") {
            pieceView.figureImage2.setBackgroundResource(R.drawable.knight_run_animation)
            mAnimation = pieceView.figureImage2.getBackground() as AnimationDrawable?
            mAnimation!!.start()
            animSlide = AnimationUtils.loadAnimation(context, R.anim.slide_from_left)
            pieceView.figureImage2.startAnimation(animSlide)
        }

        pieceView.board_cell.setOnClickListener {

            cellSizes.add(pieceView.board_cell.height.toFloat())
            cellSizes.add(pieceView.board_cell.width.toFloat())

            adapterCallback.getCellScale(cellSizes, position)

//            Log.i("Demo", pieceView.board_cell.height.toString())
//            Log.i("Demo", pieceView.board_cell.width.toString())

            environmentCell = adapterCallback.doThings(position)
            when (environmentCell) {
                "Figure" -> {
                    pieceView.board_cell.background = ContextCompat.getDrawable(context!!, R.drawable.border_blue)
                }
                "Enemy" -> pieceView.board_cell.background =
                    ContextCompat.getDrawable(context!!,
                        R.drawable.border_red
                    )
                "Grass" -> pieceView.board_cell.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            }
        }

        piece.imageFigure?.let { pieceView.figureImage.setImageResource(it) }
        pieceView.name.text = piece.name

        return pieceView
    }

}