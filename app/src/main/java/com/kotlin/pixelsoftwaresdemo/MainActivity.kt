package com.kotlin.pixelsoftwaresdemo

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardProductList = findViewById<CardView>(R.id.cardProductList)
        val cardOrderStatus = findViewById<CardView>(R.id.cardOrderStatus)

        cardOrderStatus.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, OrderStatus::class.java)
            startActivity(intent)
        })


        cardProductList.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, ProductList::class.java)
            startActivity(intent)
        })

    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Confirmation")
        builder.setMessage("Are You Sure You Want to Quit ?")
        builder.setPositiveButton(
            "Yes"
        ) { dialogInterface, i -> finish() }
        builder.setNegativeButton("No", null)
        builder.show()
    }
}