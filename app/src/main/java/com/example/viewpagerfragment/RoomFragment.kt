package com.example.viewpagerfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.room.Room

class RoomFragment : Fragment() {

    var helper:RoomHelper? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate((R.layout.fragment_memo), container, false)
        setContentView(view)
        return view
    }

    private fun setContentView(view:View) {
        helper = context?.let {
            Room.databaseBuilder(it, RoomHelper::class.java, "room_memo")
                .allowMainThreadQueries()
                .build()
        }

        val adapter = RoomAdapter()
        adapter.helper = helper

//        adapter.listData.addAll(helper?.roomMemoDao()?.getAll() ?: mutableListOf())
//        recyclerMemo.adapter = adapter
//        recyclerMemo.layoutManager = LinearLayoutManager(context)

//        buttonSave.setOnClickListener {
//            if (editMemo.text.toString().isNotEmpty()) {
//                val memo = RoomMemo(editMemo.text.toString(), System.currentTimeMillis())
//                helper?.roomMemoDao()?.insert(memo)
//
//                adapter.listData.clear()
//                adapter.listData.addAll(helper?.roomMemoDao()?.getAll() ?: mutableListOf())
//                adapter.notifyDataSetChanged()
//                editMemo.setText("")
//            }
//        }
    }
}
