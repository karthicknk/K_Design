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
import com.k_design.example.adapter.Viewpager_Splash_Adapter

class SplashFragment : Fragment() {

    lateinit var viewpagerSplashAdapter: Viewpager_Splash_Adapter
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_splash,container,false)

//        tabLayout = view.findViewById(R.id.splash_tablayout)
        viewPager = view.findViewById(R.id.splash_viewpager)

        viewpagerSplashAdapter = Viewpager_Splash_Adapter(context,childFragmentManager)
        viewpagerSplashAdapter.addFragment(Splash_First_Fragment())
        viewpagerSplashAdapter.addFragment(Splash_Second_Fragment())
        viewpagerSplashAdapter.addFragment(Splash_Third_Fragment())
        viewPager.adapter = viewpagerSplashAdapter
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