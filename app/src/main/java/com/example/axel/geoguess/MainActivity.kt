package com.example.axel.geoguess

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import android.support.v7.widget.helper.ItemTouchHelper.*
import java.util.*
import android.support.v7.widget.helper.ItemTouchHelper.Callback.makeMovementFlags
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mGeoObjects = ArrayList<GeoObject>()

        for (i in GeoObject.isInEurope.indices) {
            mGeoObjects.add(GeoObject(GeoObject.isInEurope[i], GeoObject.GeoImageList[i]))

        }
        val mGeoRecyclerView = findViewById<RecyclerView>(R.id.geoImageViewList)
        val mLayoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)

        mGeoRecyclerView!!.layoutManager = mLayoutManager
        val mAdapter = GeoObjectAdapter(this, mGeoObjects)

        mGeoRecyclerView.adapter = mAdapter

        val simpleItemTouchCallback =
                object : ItemTouchHelper.SimpleCallback(0, LEFT or RIGHT) {
                    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
                        return makeMovementFlags(0, LEFT or RIGHT)
                    }

                    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                                        target: RecyclerView.ViewHolder): Boolean {
                        return false
                    }

                    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {

                        val position = viewHolder.adapterPosition

                        if (GeoObject.isInEurope[position].equals(true) && swipeDir == 4) {
                            Toast.makeText(this@MainActivity, "Correct! It is in EU$position", Toast.LENGTH_SHORT).show()
                        }else if(GeoObject.isInEurope[position].equals(false) && swipeDir == 8) {
                            Toast.makeText(this@MainActivity, "Correct! It is outside EU$position", Toast.LENGTH_SHORT).show()
                        }else if(GeoObject.isInEurope[position].equals(true) && swipeDir == 8) {
                            Toast.makeText(this@MainActivity, "Wrong! It is in EU$position", Toast.LENGTH_SHORT).show()
                        }else if(GeoObject.isInEurope[position].equals(false) && swipeDir == 4) {
                            Toast.makeText(this@MainActivity, "Wrong! It is outside EU$position", Toast.LENGTH_SHORT).show()
                        }
                    }

                }
        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)

        itemTouchHelper.attachToRecyclerView(mGeoRecyclerView)


    }
}
