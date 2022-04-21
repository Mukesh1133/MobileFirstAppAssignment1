package com.example.mobilefirstapplicationassignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilefirstapplicationassignment1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   private var arrList1 = ArrayList<DataModel>()
   private var arrList2 = ArrayList<DataModel>()

    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        arrList2.add(DataModel("Player1", "https://images.unsplash.com/photo-1514846326710-096e4a8035e0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDh8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60"))
        arrList2.add(DataModel("Player2", "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDEyfHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=500&q=60"))
        arrList2.add(DataModel("Player3", "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDV8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60"))
        arrList2.add(DataModel("Player4", "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDEyfHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=500&q=60"))
        arrList2.add(DataModel("Player5", "https://images.unsplash.com/photo-1528892952291-009c663ce843?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzB8fHBvcnRyYWl0fGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60"))
        arrList2.add(DataModel("Player6", "https://images.unsplash.com/photo-1531746020798-e6953c6e8e04?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8cG9ydHJhaXR8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60"))
        arrList2.add(DataModel("Player7", "https://images.unsplash.com/photo-1519345182560-3f2917c472ef?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzR8fHBvcnRyYWl0fGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60"))
        arrList2.add(DataModel("Player8", "https://images.unsplash.com/photo-1614204424926-196a80bf0be8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mzh8fHBvcnRyYWl0fGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60"))
        arrList2.add(DataModel("player9", "https://images.unsplash.com/photo-1527203561188-dae1bc1a417f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mzl8fHBvcnRyYWl0fGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60"))
        arrList2.add(DataModel("player10", "https://images.unsplash.com/photo-1560250097-0b93528c311a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDh8fHBvcnRyYWl0fGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60"))

        binding?.rvList2?.layoutManager = LinearLayoutManager(this)
        binding?.rvList1?.layoutManager = LinearLayoutManager(this)


        val itemAdapterTop: ItemAdapter = ItemAdapter(arrList1){

        }
        val itemAdapterBottom: ItemAdapter = ItemAdapter(arrList2) {
            var item = arrList2[it]
            arrList2.remove(item)
            arrList1.add(item)
            itemAdapterTop.notifyDataSetChanged()
        }
        binding?.rvList1?.adapter = itemAdapterTop
        binding?.rvList2?.adapter = itemAdapterBottom

        binding?.btnShuffle?.setOnClickListener {
            arrList2.shuffle()
            itemAdapterBottom.notifyDataSetChanged()
            Toast.makeText(this, "SHUFFLED", Toast.LENGTH_SHORT).show()
        }
    }
}