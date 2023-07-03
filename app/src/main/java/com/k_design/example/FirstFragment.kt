package com.k_design.example

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.k_design.example.R.layout.first_fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragment : Fragment() {

    companion object{const val TAG = "FirstFragment"}
    lateinit var allRecyclerView : RecyclerView
    var multiLayoutAdapter : MultiLayoutAdapter? = null
    var list : MutableList<Memes> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(first_fragment,container,false)

        allRecyclerView = view.findViewById(R.id.allRecyclerView)
        allRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        multiLayoutAdapter = MultiLayoutAdapter(context,list)
        allRecyclerView.adapter = multiLayoutAdapter

        GetMultiFunction()

        return view
    }

    fun GetMultiFunction() {
        var apiClient = ApiClient()
        var apiInterface = apiClient.getApiClientMultiLayout()!!.create(ApiInterface::class.java)
        var call: Call<MultiLayoutModul> = apiInterface.GetMultilayout("https://api.imgflip.com/get_memes")
        call.enqueue(object : Callback<MultiLayoutModul> {
            override fun onResponse(call: Call<MultiLayoutModul>, response: Response<MultiLayoutModul>) {
                Log.e(TAG, "onResponseeeee: " + response.body() )
                var multiLayoutModul: MultiLayoutModul? = response.body()
                GetRoomFunction(multiLayoutModul)
            }

            override fun onFailure(call: Call<MultiLayoutModul>, t: Throwable) {

            }
        })

    }

    fun GetRoomFunction(multiLayoutModul : MultiLayoutModul?) {
        try {
            var datas = multiLayoutModul!!.getDatass()
            var memes: List<Memes>? = datas!!.getmemes()
            var mMemes: MutableList<Memes> = ArrayList()
            var isValue = false
            var i = 0
            var a = 0

            while (i < memes!!.size) {
                if (a == 0) {
                    var memess = Memes()
                    memess.setname1(memes[i].getname1())
                    memess.seturl1(memes[i].getUrl1())
                    if (isValue) {
                        memess.settype(memess.LEFT)
                    } else {
                        memess.settype(memess.RIGHT)
                    }
                    i++
                    a++
                    isValue = !isValue
                    mMemes.add(memess)
                } else {
                    var memess = Memes()
                    memess.setname1(memes[i].getname1())
                    memess.seturl1(memes[i].getUrl1())
                    i++
                    if (i < memes!!.size) {
                        memess.setname2(memes[i].getname1())
                        memess.seturl2(memes[i].getUrl1())
                        memess.settype(memess.TWO)
                    } else {
                        memess.settype(memess.RIGHT)
                    }
                    i++
                    a--
                    mMemes.add(memess)
                }
            }
            list.addAll(mMemes)
            multiLayoutAdapter!!.notifyDataSetChanged()
        }catch (e : Exception){
            e.printStackTrace()
        }

    }

}
