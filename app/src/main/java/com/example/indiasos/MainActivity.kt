package com.example.indiasos

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.indiasos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit1:EditText=findViewById(R.id.edit1);
        val edit2:EditText=findViewById(R.id.edit2);
        val edit3:EditText=findViewById(R.id.edit3);
        val edit4:EditText=findViewById(R.id.edit4);
        val btn:Button=findViewById(R.id.btn)

        loaddata()


        btn.setOnClickListener {
                val user = edit1.text.toString()
                val number = edit4.text.toString()
                val add=edit2.text.toString()
                val ename=edit3.text.toString()
                val shared: SharedPreferences = getSharedPreferences("shareddata", MODE_PRIVATE)
                val editor: Editor = shared.edit()
                var flag=1;

                editor.apply {

                    putString("username", user)
                    putString("number", number)
                    putString("add",add)
                    putString("ename",ename)
                    putInt("flag",flag)
                }.apply()
                Toast.makeText(applicationContext, "Data saved", Toast.LENGTH_LONG).show()

                loaddata()
            }


    }
    private fun loaddata(){
        val shared:SharedPreferences=getSharedPreferences("shareddata", MODE_PRIVATE)
        val opname=shared.getString("username",null)
        val opnumber=shared.getString("number",null)
        val opadd=shared.getString("add",null)
        val opename=shared.getString("ename",null)
        val flagsign=shared.getInt("flag",0)

        if (flagsign==1) {
            val i: Intent = Intent(applicationContext, callscreen::class.java)
            i.putExtra("displayname", opname)
            i.putExtra("displaynumber", opnumber)
            i.putExtra("displayadd",opadd)
            i.putExtra("displayename",opename)
            startActivity(i)
            finish()
        }


    }
}