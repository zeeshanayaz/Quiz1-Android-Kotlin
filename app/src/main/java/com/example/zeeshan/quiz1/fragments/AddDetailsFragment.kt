package com.example.zeeshan.quiz1.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.zeeshan.quiz1.R
import com.example.zeeshan.quiz1.interfaces.FragmentOneInteraction
import com.example.zeeshan.quiz1.models.User


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AddDetailsFragment : Fragment() {

    var sendDataInteraction : FragmentOneInteraction? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_details, container, false)

        val firstName = view.findViewById<EditText>(R.id.first_name_id)
        val lastName = view.findViewById<EditText>(R.id.last_name_id)
        val regNo = view.findViewById<EditText>(R.id.reg_no_id)
        val groupOfStudy = view.findViewById<EditText>(R.id.study_group_id)
        val addUserBtn = view.findViewById<Button>(R.id.add_user_btn)

        addUserBtn.setOnClickListener {
            if(!firstName.text.isEmpty()){

                if(!lastName.text.isEmpty()){

                    if (!regNo.text.isEmpty()){

                        if(!groupOfStudy.text.isEmpty()){

                            var curUser = User("${firstName.text.toString()} ${lastName.text}",
                                    regNo.text.toString().toInt(), groupOfStudy.text.toString())
//                            Toast.makeText(activity!!, curUser.toString(), Toast.LENGTH_SHORT).show()

                            if(sendDataInteraction != null){
                                sendDataInteraction?.sendData(curUser)
                            }
//                            Clearing Text on Successful data send
                            firstName.text.clear()
                            lastName.text.clear()
                            regNo.text.clear()
                            groupOfStudy.text.clear()

                        }
                        else groupOfStudy.setError("Insert Group of Study")

                    }
                    else regNo.setError("Insert Registration Number")

                }
                else lastName.setError("Insert Last Name")

            }
            else firstName.setError("Insert First Name")
        }

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            sendDataInteraction = context as FragmentOneInteraction
        }
        catch (e: Exception){
            Toast.makeText(activity!!, "Can not cast Interface", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDetach() {
        super.onDetach()
        sendDataInteraction = null
    }

}
