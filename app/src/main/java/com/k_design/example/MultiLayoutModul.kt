package com.k_design.example

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MultiLayoutModul {

    @SerializedName("success")
    @Expose
    var success : Boolean? = null

    @SerializedName("data")
    @Expose
    var datas : Datas? = null


    fun setsuccess(succes : Boolean){
        success = succes
    }
    fun getsuccess() : Boolean?{
        return success
    }
    fun setDatass(datass: Datas){
        datas = datass
    }
    fun getDatass() : Datas?{
        return datas
    }

    override fun toString(): String {
        return "MultiLayoutModul(success=$success, datas=$datas)"
    }
}