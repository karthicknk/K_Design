package com.k_design.example.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class Viewpager_Edittext_Adapter(context: Context?, fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    var fragment : MutableList<Fragment> = ArrayList()
//    var title : MutableList<String> = ArrayList()

    override fun getCount(): Int {
        return fragment.size
    }

    override fun getItem(position: Int): Fragment {
        return fragment.get(position)
    }

//    override fun getPageTitle(position: Int): CharSequence? {
//        return title.get(position)
//    }

    fun addFragment(fragments: Fragment){
        fragment.add(fragments)
//        title.add(string)
        notifyDataSetChanged()
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }
}