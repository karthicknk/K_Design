package com.k_design.example.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.postDelayed
import androidx.fragment.app.Fragment
import com.k_design.example.R


class Splash_First_Fragment : Fragment() {

    var logo: ImageView? = null
    var title: TextView? = null
     var slogan:TextView? = null
    var developer: TextView? = null
    var topAnimation: Animation? = null
    var bottomAnimation:Animation? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_splash_first,container,false)

        logo=view.findViewById(R.id.logo);
        title=view.findViewById(R.id.title);
        slogan=view.findViewById(R.id.slogan);
        developer=view.findViewById(R.id.developer);

        topAnimation= AnimationUtils.loadAnimation(context, R.anim.top_animation);
        bottomAnimation=AnimationUtils.loadAnimation(context,R.anim.bottom_animation);
        logo!!.setAnimation(topAnimation);
        title!!.setAnimation(bottomAnimation);
        slogan!!.setAnimation(bottomAnimation);
        developer!!.setAnimation(bottomAnimation);

        return view
    }
}