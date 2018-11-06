package com.example.zeeshan.quiz1.adapters

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.zeeshan.quiz1.fragments.AddDetailsFragment
import com.example.zeeshan.quiz1.fragments.ListFragment

class FragmentViewPagerAdapter(var ctx: Context, var fm: FragmentManager) : FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        when(position){
            0 ->  return ListFragment()
            else -> return AddDetailsFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0-> return "List"
            else -> return "Add Student"
        }
//        return super.getPageTitle(position)
//        "TAB ${position+1}"

    }
    override fun getCount(): Int {
        return 2
    }

}