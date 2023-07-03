package com.k_design.example.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class Viewpager_Splash_Adapter(context: Context?,fragment: FragmentManager) : FragmentStatePagerAdapter(fragment) {

    var fragment : MutableList<Fragment> = ArrayList()

    override fun getCount(): Int {
        return fragment.size
    }

    override fun getItem(position: Int): Fragment {
        return fragment.get(position)
    }

    fun addFragment(fragments: Fragment){
        fragment.add(fragments)
        notifyDataSetChanged()
    }
}