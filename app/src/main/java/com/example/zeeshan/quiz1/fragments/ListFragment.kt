package com.example.zeeshan.quiz1.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zeeshan.quiz1.MainActivity
import com.example.zeeshan.quiz1.R
import com.example.zeeshan.quiz1.adapters.ListAdapter
import com.example.zeeshan.quiz1.interfaces.FragmentTwoInteraction
import com.example.zeeshan.quiz1.models.User


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ListFragment : Fragment() {

    val myList: ArrayList<User> = ArrayList<User>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val user = User("Zeeshan Ayaz", 123, "Computer Science")
        myList.add(user)

        val listAdapter = ListAdapter(activity!!,myList)
        recyclerView.adapter = listAdapter

        val mainActivity = activity as MainActivity
        mainActivity.setInteractionTwo(object : FragmentTwoInteraction {
            override fun recieveData(user: User) {
                myList.add(user)
                listAdapter.notifyDataSetChanged()
            }
        })


        return view
    }


}
