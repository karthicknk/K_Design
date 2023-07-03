package com.k_design.example.fragment

//import com.anurag.multiselectionspinner.MultiSelectionSpinnerDialog
//import com.anurag.multiselectionspinner.MultiSpinner
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.anurag.multiselectionspinner.MultiSelectionSpinnerDialog
import com.k_design.example.R
import com.mcdev.filledboxspinner.FilledBoxSpinner
import com.mcdev.filledboxspinner.OnItemSelectedListener
import com.zeeshan.material.multiselectionspinner.MultiSelectionSpinner

//import io.apptik.widget.multiselectspinner.BaseMultiSelectSpinner
//import io.apptik.widget.multiselectspinner.MultiSelectSpinner

class ButtonsFragment : Fragment() , MultiSelectionSpinnerDialog.OnMultiSpinnerSelectionListener{

    companion object{const val TAG = "ButtonsFragment"}
    lateinit var multiSelectionSpinner : MultiSelectionSpinner
//    lateinit var apptik_multiselectSpinner : MultiSelectSpinner
    lateinit var btn_submits : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_buttons,container,false)

        btn_submits = view.findViewById(R.id.btn_submits)
        var name : MutableList<String> = ArrayList()
        name.add("karthi")
        name.add("arun")
        name.add("gopal")
        name.add("siva")
        name.add("senthil")


        //-------------------- com.zeeshan.material.multiselectionspinner.MultiSelectionSpinner
        multiSelectionSpinner = view.findViewById(R.id.multi_Selection)
        multiSelectionSpinner.setItems(name)
        multiSelectionSpinner.setOnItemSelectedListener(object :
            MultiSelectionSpinner.OnItemSelectedListener {
            override fun onItemSelected(view: View?, isSelected: Boolean, position: Int) {
//                Toast.makeText(MainActivity.this, "On Item selected : " + isSelected, Toast.LENGTH_SHORT).show();
                var namess = multiSelectionSpinner.selectedItems.toString()
                Log.e(TAG, "nameeeeeeeeeeeeeeeeeee: " + namess)
            }

            override fun onSelectionCleared() {
//                Toast.makeText(MainActivity.this, "All items are unselected", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onSelectionClearedddddddd: "  )
            }
        })


        //---------- io.apptik.widget.multiselectspinner.MultiSelectSpinner
//        apptik_multiselectSpinner = view.findViewById(R.id.apptik_multiselectSpinner)
//        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_multiple_choice, name)
//        apptik_multiselectSpinner.setListAdapter(adapter).setListener<BaseMultiSelectSpinner>(
//            BaseMultiSelectSpinner.MultiSpinnerListener {
//                var role_value = apptik_multiselectSpinner.getSelectedItem().toString()
//                Log.e(TAG, "apptik_namesssss: " + role_value)
//
//            }).setMaxSelectedItems<BaseMultiSelectSpinner>(2)
//            .setSpinnerItemLayout<BaseMultiSelectSpinner>(R.layout.custom_spinner_item)
//            .setAllUncheckedText<BaseMultiSelectSpinner>("Select Name")



        //---------- com.anurag.multiselectionspinner.MultiSpinner
//        val multiSpinner : MultiSpinner = view.findViewById(R.id.spinnerMultiSpinner)
//        multiSpinner.setAdapterWithImage(context,name,name,this)
//
//        //Setting Multi Selection Spinner with out image.
//        //multiSpinner.setAdapterWithOutImage(this,contentList,this)
//        multiSpinner.initMultiSpinner(context,multiSpinner)


        //---------------------------- FilledBoxSpinner
        val filledBoxSpinner: FilledBoxSpinner = view.findViewById(R.id.filled_box_spinner)
        filledBoxSpinner.setItems(name)
        filledBoxSpinner.isSearchable(false)
        filledBoxSpinner.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(itemValue: String) {
                    Log.e(TAG, "FilledBoxSpinnerrrrrrrr: "  )
                    Toast.makeText(context,"FilledBoxSpinner: " + itemValue.toString() ,Toast.LENGTH_SHORT).show()
            }

        })


        //-------------------------- com.mcdev.splitbuttonlibrary.SplitButton
//        var splitBtn: SplitButton = view.findViewById(R.id.split_btn)
//
//        splitBtn.setTextColor(R.color.black)
//        splitBtn.setIconColor(android.R.color.white)
//        splitBtn.setBgColor(android.R.color.holo_orange_light)
//        splitBtn.setMenuItems(R.menu.split_menu)
//        splitBtn.itemColor = android.R.color.holo_blue_dark
//        splitBtn.setOnButtonClickListener(object : OnButtonClickListener{
//            override fun onClick(itemId: Int, itemTitle: String?) {
//                Log.e(TAG, "SplitButtonnnnnn: " + itemTitle.toString() )
//                Log.e(TAG, "SplitButton_itemIdddd: " + itemId )
//                Toast.makeText(context,"SplitButton_itemId: " + itemId,Toast.LENGTH_SHORT).show()
//            }
//        })

        //------------------spinner normal
        var spinner : Spinner = view.findViewById(R.id.spinner_normal)
        val adapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_spinner_dropdown_item,name)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Log.e(TAG, "Spinnerrrrrrrr: " + parent!!.selectedItem )
                Toast.makeText(context,"Spinner: " + parent.selectedItem , Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        //----------rodiobutton
        var radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{radioGroup,i ->
            var radio= radioGroup.findViewById<RadioButton>(i)
            var name = radio.text.toString()
            Log.e(TAG, "RadioButtonnnnnn:  " + name )
        })

        //-------------CheckBox
        var reg_java = view.findViewById<CheckBox>(R.id.reg_java)
        var reg_kotlin = view.findViewById<CheckBox>(R.id.reg_kotlin)
        var reg_php = view.findViewById<CheckBox>(R.id.reg_php)
        var reg_net = view.findViewById<CheckBox>(R.id.reg_net)


//        btn_submits.setOnClickListener(object :OnClickListener{
//            override fun onClick(v: View?) {
//                var arraych : MutableList<String> = ArrayList()
//                if (reg_java.isChecked){
//                    var checked = reg_java.text.toString()
//                    arraych.add(checked)
//                }
//                if (reg_kotlin.isChecked){
//                    var checked = reg_kotlin.text.toString()
//                    arraych.add(checked)
//                }
//                if (reg_php.isChecked){
//                    var checked = reg_php.text.toString()
//                    arraych.add(checked)
//                }
//                if (reg_net.isChecked){
//                    var checked = reg_net.text.toString()
//                    arraych.add(checked)
//                }
//                Log.e(TAG, "CheckBox_checkeddddd: " + arraych.toString() )
//            }
//        })

        return view

    }

    //---------- com.anurag.multiselectionspinner.MultiSpinner
    override fun OnMultiSpinnerItemSelected(chosenItems: MutableList<String>?) {

        //This is where you get all your items selected from the Multi Selection Spinner :)
        for (i in chosenItems!!.indices){

            Log.e("chosenItems",chosenItems[i])
        }
    }


}