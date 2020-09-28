//package com.example.viewpagerfragment
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.Window
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.room.Room
//import kotlinx.android.synthetic.main.activity_memo.*
//
//class RoomActivity : AppCompatActivity() {
//
//    var helper: RoomHelper? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
//        setContentView(R.layout.activity_memo)
//
//        helper = Room.databaseBuilder(this, RoomHelper::class.java, "room_memo")
//            .allowMainThreadQueries()
//            .build()
//
//        val adapter=RoomAdapter()
//        adapter.helper = helper
//
//        adapter.listData.addAll(helper?.roomMemoDao()?.getAll() ?: mutableListOf())
//        recyclerMemo.adapter = adapter
//        recyclerMemo.layoutManager = LinearLayoutManager(this)
//
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
//    }
//}