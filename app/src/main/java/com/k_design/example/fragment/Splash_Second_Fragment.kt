package com.k_design.example.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.k_design.example.R


class Splash_Second_Fragment : Fragment() {

    var imageView : ImageView? = null
    var translateScale : Animation? = null
    var isFirstAnimation : Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_splash_second,container,false)

        val hold: Animation = AnimationUtils.loadAnimation(context, R.anim.hold)
        translateScale = AnimationUtils.loadAnimation(context, R.anim.translate_scale);
        imageView = view.findViewById(R.id.header_icon)

        translateScale!!.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                if (!isFirstAnimation) {
                    imageView!!.clearAnimation()
//                    val intent = Intent(context, MainActivity::class.java)
//                    startActivity(intent)
//                    finish()

                    // MainActivity
//                    overridePendingTransition(0, 0)
//                    val relativeLayout: View = findViewById(R.id.login_container)
//                    val animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
//                    relativeLayout.startAnimation(animation)
                }
                isFirstAnimation = true
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        hold.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                imageView!!.clearAnimation()
                imageView!!.startAnimation(translateScale)
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        imageView!!.startAnimation(hold)

        return view
    }

}