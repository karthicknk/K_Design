package com.k_design.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Memes : Serializable {

    var LEFT = 0
    var TWO = 1
    var RIGHT = 2

    var type = 0


    @SerializedName("id")
    var ids: Int = 0

    @SerializedName("name")
    var name1: String? = null
    var name2: String? = null

    @SerializedName("url")
    var urls1: String? = null
    var urls2: String? = null

    fun setId(idss: Int) {
        ids = idss
    }

    fun getId(): Int? {
        return ids
    }

    fun setname1(name: String?) {
        name1 = name
    }

    fun getname1(): String? {
        return name1
    }

    fun setname2(name: String?) {
        name2 = name
    }

    fun getname2(): String? {
        return name2
    }

    fun seturl1(url: String?) {
        urls1 = url
    }

    fun getUrl1(): String? {
        return urls1
    }

    fun seturl2(url: String?) {
        urls2 = url
    }

    fun getUrl2(): String? {
        return urls2
    }

    fun settype(types: Int) {
        type = types
    }

    fun gettypes(): Int {
        return type
    }

    override fun toString(): String {
        return "Memes(type=$type, ids=$ids, name1=$name1, name2=$name2, urls1=$urls1, urls2=$urls2)"
    }
}