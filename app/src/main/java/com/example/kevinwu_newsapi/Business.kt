package com.example.kevinwu_newsapi

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.json.JSONObject


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_DATA = "no data recieve"


/**
 * A simple [Fragment] subclass.
 * Use the [Business.newInstance] factory method to
 * create an instance of this fragment.
 */
class Business : Fragment() {
    // TODO: Rename and change types of parameters
    private var data: String? = "No data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            data = it.getString(ARG_DATA)
            val obj: JSONObject = JSONObject(data)
            Log.d("My App", obj.toString())
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_business, container, false)
        view?.findViewById<TextView>(R.id.burger)?.text = data
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Business.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(data: String) =
            Business().apply {
                arguments = Bundle().apply {
                    putString(ARG_DATA, data)
                }
            }
    }
}