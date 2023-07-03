package com.k_design.example.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import androidx.annotation.ContentView
import com.k_design.example.R

class CustomExpandableListAdapter(var context: Context?,var expandableListTitle : List<String>?,
                                  var expandableListDetail :HashMap<String, List<String>>?) : BaseExpandableListAdapter() {

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return expandableListDetail!!.get(this.expandableListTitle!!.get(groupPosition))!!.get(childPosition)
    }

    override fun getGroup(groupPosition: Int): Any {
        return expandableListTitle!!.get(groupPosition)
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        var string = getChild(groupPosition ,childPosition) as String
        var convertView = convertView
        if (convertView == null){
            val layoutInflater = this.context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.list_item_expandable,null)
        }
        var textView = convertView!!.findViewById(R.id.expandedListItem) as TextView
        textView.text = string

        return convertView
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var string = getGroup(groupPosition) as String
        var convertView = convertView
        if (convertView == null){
            val layoutInflater = this.context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.list_group_expandable,null)
        }
        var textView = convertView!!.findViewById(R.id.listTitle) as TextView
        textView.text = string

        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return this.expandableListDetail!!.get(this.expandableListTitle!!.get(groupPosition))!!.size
    }

    override fun getGroupCount(): Int {
        return expandableListTitle!!.size
    }



    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}