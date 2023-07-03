package com.k_design.example

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MultiLayoutAdapter(var context: Context?, var list: MutableList<Memes>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TAG = "MultiLayoutAdapter"
        var LEFT = 0
        var TWO = 1
        var RIGHT = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == LEFT) {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.row_left, parent, false)
            return LAYOUT_LEFT(view)
        }
        if (viewType == TWO) {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.row_two, parent, false)
            return LAYOUT_TWO(view)
        } else {
            var view =
                LayoutInflater.from(parent.context).inflate(R.layout.row_right, parent, false)
            return LAYOUT_RIGHT(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var memes = list!!.get(position)
        when (holder.itemViewType) {
            LEFT -> {
                (holder as LAYOUT_LEFT).textView1!!.text = memes.getname1()
                Picasso.with(context).load(memes.getUrl1()).into(holder.imageView1)
            }
            TWO -> {
                (holder as LAYOUT_TWO).textView1!!.text = memes.getname1()
                (holder as LAYOUT_TWO).textView2!!.text = memes.getname2()
                Picasso.with(context).load(memes.getUrl1()).into(holder.imageView1)
                Picasso.with(context).load(memes.getUrl2()).into(holder.imageView2)
            }
            RIGHT -> {
                (holder as LAYOUT_RIGHT).textView1!!.text = memes.getname1()
                Picasso.with(context).load(memes.getUrl1()).into(holder.imageView1)
            }
        }
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    class LAYOUT_LEFT(view: View) : RecyclerView.ViewHolder(view) {
        var textView1: TextView? = null
        var imageView1: ImageView? = null

        init {
            textView1 = view.findViewById(R.id.left_text)
            imageView1 = view.findViewById(R.id.left_img)
        }
    }

    class LAYOUT_TWO(view: View) : RecyclerView.ViewHolder(view) {
        var textView1: TextView? = null
        var textView2: TextView? = null
        var imageView1: ImageView? = null
        var imageView2: ImageView? = null

        init {
            textView1 = view.findViewById(R.id.two_left_text)
            textView2 = view.findViewById(R.id.two_right_text)
            imageView1 = view.findViewById(R.id.two_left_img)
            imageView2 = view.findViewById(R.id.two_right_img)
        }
    }

    class LAYOUT_RIGHT(view: View) : RecyclerView.ViewHolder(view) {
        var textView1: TextView? = null
        var imageView1: ImageView? = null

        init {
            textView1 = view.findViewById(R.id.right_text)
            imageView1 = view.findViewById(R.id.right_img)
        }
    }

    override fun getItemViewType(position: Int): Int {
        var memes = list!!.get(position)
        if (memes != null) {
            return memes.gettypes()
        }
        return 0
    }
}