package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val textStadiumCount: TextView = findViewById(R.id.textStadiumCount)

        val numberOfColumns = 2
        val layoutManager = GridLayoutManager(this, numberOfColumns)

        recyclerView.layoutManager = layoutManager

        val stadiumList = generateStadiumList()

        val adapter = StadiumAdapter(stadiumList) { count ->
            textStadiumCount.text = count.toString()
        }
        recyclerView.adapter = adapter

        textStadiumCount.text = stadiumList.size.toString()
    }

    private fun generateStadiumList(): List<Stadium> {
        val listOfStadiums = mutableListOf<Stadium>()

        listOfStadiums.add(Stadium("Luseyl Stadyumu", "Luseyl", "80.000 seats", R.drawable.luseyl))
        listOfStadiums.add(Stadium("El–Beyt Stadyumu", "Havr", "60.000 seats", R.drawable.elbeyt))
        listOfStadiums.add(Stadium("Stadyum 974", "Doha", "40.000 seeats", R.drawable.dokuzyuzyetmisdort))
        listOfStadiums.add(Stadium("Es–Sümame Stadyumu", "Doha", "40.000 seats", R.drawable.essumame))
        listOfStadiums.add(Stadium("Eğitim Şehri Stadyumu", "Er–Reyyan", "45.350 seats", R.drawable.egitimsehri))
        listOfStadiums.add(Stadium("Ahmed bin Ali Stadyumu", "Er–Reyyan", "44.740 seats", R.drawable.ahmedbinali))
        listOfStadiums.add(Stadium("Uluslararası Halife Stadyumu", "Er–Reyyan", "40.000 seats", R.drawable.uluslararasihalife))
        listOfStadiums.add(Stadium("El–Cenub Stadyumu", "Vekre", "40.000 seats", R.drawable.elcenub))

        return listOfStadiums
    }
}