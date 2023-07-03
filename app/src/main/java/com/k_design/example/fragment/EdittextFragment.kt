package com.k_design.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.google.android.material.tabs.TabLayout
import com.k_design.example.R
import com.k_design.example.adapter.Viewpager_Edittext_Adapter

class EdittextFragment : Fragment() {

    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout
    lateinit var viewpagerEdittextAdapter: Viewpager_Edittext_Adapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_edittext,container,false)

        viewPager = view.findViewById(R.id.edit_viewpager)
//        tabLayout = view.findViewById(R.id.tab_layout)

        viewpagerEdittextAdapter = Viewpager_Edittext_Adapter(context,childFragmentManager)
        viewpagerEdittextAdapter.addFragment(ViewPager_Edit_First())
        viewpagerEdittextAdapter.addFragment(ViewPager_Edit_Second())

        viewPager.adapter = viewpagerEdittextAdapter
//        tabLayout.setupWithViewPager(viewPager)

        viewPager.addOnPageChangeListener(object : OnPageChangeListener{
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })


        return view
    }
}