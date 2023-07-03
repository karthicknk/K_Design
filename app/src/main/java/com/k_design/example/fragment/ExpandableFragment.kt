package com.k_design.example.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import androidx.fragment.app.Fragment
import com.k_design.example.ExpandableListDataPump
import com.k_design.example.R
import com.k_design.example.adapter.CustomExpandableListAdapter


class ExpandableFragment : Fragment() {

    companion object {const val TAG = "ExpandableFragment"}
    var expandableListView: ExpandableListView? = null
    var expandableListAdapter: ExpandableListAdapter? = null
    var expandableListTitle: List<String>? = null
    var expandableListDetail: HashMap<String, List<String>>? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.expandable_fragment,container,false)

        expandableListView = view.findViewById(R.id.expandableListView)
//        expandableListDetail = ExpandableListDataPump.getData()
        expandableListDetail = ExpandableListDataPump.getData
        expandableListTitle = ArrayList(expandableListDetail!!.keys)
        Log.e(TAG, "onCreateViewwww: " + expandableListDetail )
        expandableListAdapter = CustomExpandableListAdapter(context, expandableListTitle, expandableListDetail)
        expandableListView!!.setAdapter(expandableListAdapter)

        return view
    }


}