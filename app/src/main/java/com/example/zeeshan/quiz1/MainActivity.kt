package com.example.zeeshan.quiz1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.widget.Toast
import com.example.zeeshan.quiz1.adapters.FragmentViewPagerAdapter
import com.example.zeeshan.quiz1.interfaces.FragmentTwoInteraction
import com.example.zeeshan.quiz1.interfaces.FragmentOneInteraction
import com.example.zeeshan.quiz1.models.User

class MainActivity : AppCompatActivity(), FragmentOneInteraction {

    var recieveDataInteraction : FragmentTwoInteraction? = null

//    override fun sendData(user: User){
//        Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show()
//
//        recieveDataInteraction?.recieveData(user)
//
//    }
    override fun sendData(user: User) {
        Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show()

        recieveDataInteraction?.recieveData(user)
    }
    public fun setInteractionTwo(interactionTwo: FragmentTwoInteraction) {
        this.recieveDataInteraction = interactionTwo
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = findViewById<ViewPager>(R.id.view_pager)


        var adapter = FragmentViewPagerAdapter(this, supportFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
