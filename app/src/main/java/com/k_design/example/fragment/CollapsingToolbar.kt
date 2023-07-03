package com.k_design.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import com.k_design.example.CustomViewPager
import com.k_design.example.FirstFragment
import com.k_design.example.R
import com.k_design.example.SecondFragment

class CollapsingToolbar : Fragment() , AppBarLayout.OnOffsetChangedListener {

    private var mMaxScrollSize = 0
    private val PERCENTAGE_TO_ANIMATE_AVATAR = 20
    private var mIsAvatarShown = true
    lateinit var locationRelation : RelativeLayout
    lateinit var college_tabs : TextView
    var appbarLayout: AppBarLayout? = null
    lateinit var viewPager: CustomViewPager
    lateinit var tabLayout: TabLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.activity_main1, container, false)


        // window statusbar text color BLACK used to this below line
        requireActivity()!!.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//  set status text dark
//        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity1@this,R.color.white));// set status background white

        locationRelation = view.findViewById(R.id.locationRelation)
//        college_tabs = findViewById(R.id.college_tabs)

        appbarLayout = view.findViewById(R.id.materialup_appbar) as AppBarLayout

        appbarLayout!!.addOnOffsetChangedListener(this)

        viewPager = view.findViewById(R.id.college_viewpager) as CustomViewPager
        setUpViewPager(viewPager)

        tabLayout = view.findViewById(R.id.college_tabs) as TabLayout
        tabLayout.setupWithViewPager(viewPager)

        return view
    }

    fun setUpViewPager(viewPager: ViewPager){
        var mViewPager = ViewPagerAdapter(fragmentManager)

        mViewPager.addFragment(FirstFragment(), "First")
        mViewPager.addFragment(SecondFragment(), "Second")

        viewPager.adapter = mViewPager
    }

    internal class ViewPagerAdapter(manager: FragmentManager?) : FragmentStatePagerAdapter(manager!!){

        var mfragment : MutableList<Fragment> = ArrayList()
        var mtitle : MutableList<String> = ArrayList()

        override fun getCount(): Int {
            return mfragment.size
        }

        override fun getItem(position: Int): Fragment {
            return mfragment[position]
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mtitle[position]
        }

        fun addFragment(fragment: Fragment, title : String){
            mfragment.add(fragment)
            mtitle.add(title)
            notifyDataSetChanged()
        }

    }


    override fun onOffsetChanged(appBarLayout: AppBarLayout, i: Int) {
        if (mMaxScrollSize == 0) mMaxScrollSize = appBarLayout.totalScrollRange
        val percentage = Math.abs(i) * 100 / mMaxScrollSize

        if (percentage >= PERCENTAGE_TO_ANIMATE_AVATAR && mIsAvatarShown) {
            mIsAvatarShown = false

            locationRelation!!.visibility = View.GONE
            locationRelation!!.animate()
                .scaleY(0f).scaleX(0f)
                .start()
            //dumy!!.visibility = View.GONE


        }
        if (percentage <= PERCENTAGE_TO_ANIMATE_AVATAR && !mIsAvatarShown) {
            mIsAvatarShown = true
//            college_tabs!!.animate()
//                .scaleY(1f).scaleX(1f)
//                .start()
            locationRelation!!.visibility = View.VISIBLE

            locationRelation!!.animate()
                .scaleY(1f).scaleX(1f)
                .start()
            //tabLayout!!.visibility = View.VISIBLE

            //dumy!!.visibility = View.VISIBLE

        }
    }
}