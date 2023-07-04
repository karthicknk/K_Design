package com.k_design.example

import android.os.Bundle
import android.view.MenuItem
import android.view.animation.Animation
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.k_design.example.fragment.*

class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{

    lateinit var toolbar: Toolbar
    lateinit var navView: NavigationView
    lateinit var drawer: DrawerLayout
    lateinit var appLogo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar_aa) as Toolbar
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        navView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        navView.setNavigationItemSelectedListener(this)
        toggle.syncState()


        openHome()
        setToolbar()
        // this is use to splash anim functions and SplashApplication app
//        useStarterLibrary()
    }

    private fun openHome() {
        val fragment = EdittextFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mainframe, fragment)
        transaction.commit()
        supportActionBar?.title = "Edittext_LR"
        navView.setCheckedItem(R.id.edittext_lr)
    }

    fun abc(){

    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Edittext_LR"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            drawer.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
          R.id.edittext_lr -> {
              openHome()
              drawer.closeDrawers()
          }
            R.id.splash_screen ->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.mainframe, SplashFragment())
                    .commit()
                supportActionBar?.title = "Splash Screen"
                drawer.closeDrawers()
            }
            R.id.buttons -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.mainframe, ButtonsFragment())
                    .commit()
                supportActionBar?.title = "Buttons"
                drawer.closeDrawers()
            }
            R.id.date_and_time -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.mainframe, DataTimeFragment())
                    .commit()
                supportActionBar?.title = "Data Time"
                drawer.closeDrawers()
            }
            R.id.expandable_view -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.mainframe, ExpandableFragment())
                    .commit()
                supportActionBar?.title = "Expandable"
                drawer.closeDrawers()
            }
            R.id.collapsingToolbarss -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.mainframe, CollapsingToolbar())
                    .commit()
                supportActionBar?.title = "Expandable"
                drawer.closeDrawers()
            }

        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun useStarterLibrary() {
//        appLogo = findViewById(R.id.imageView_main)
//        StarterAnimation(getAnimList(), object : OnAnimationListener {
//            override fun onStartAnim() { // TODO::
//            }
//
//            override fun onRepeat() { // TODO::
//            }
//
//            override fun onEnd() {
//                whatToDoNext()
//            }
//        }).startSequentialAnimation(appLogo)
    }

    private fun whatToDoNext() {
//        appLogo!!.visibility = View.GONE
//        var intent = Intent(this, MainActivity1::class.java)
//        startActivity(intent)
//        overridePendingTransition(R.anim.whole_animation, R.anim.no_animaiton)
//        finish()
    }

    private fun getAnimList(): ArrayList<Animation> {
        val animList = ArrayList<Animation>()

        // We need to add INSTANCE when ever we need to access a object file in kotlin from java class
        // This denotes that CreateAnim is a singleton file and can able to have only one instance
//        animList.add(createAnimation(applicationContext, R.anim.no_animaiton))
//        animList.add(createAnimation(applicationContext, R.anim.rotate))
//        animList.add(createAnimation(applicationContext, R.anim.zoom_out_fast))
//        animList.add(createAnimation(applicationContext, R.anim.fade_in))
        return animList
    }

}