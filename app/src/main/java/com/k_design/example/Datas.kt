package com.k_design.example

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Datas {

    @SerializedName("memes")
    @Expose
    var memes: List<Memes>? = null

    fun setmemes(memess: List<Memes>){
        memes = memess
    }

    fun getmemes() : List<Memes>?{
        return memes
    }

    override fun toString(): String {
        return "Datas(memes=$memes)"
    }
}