package com.example.indiasos

import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.material.navigation.NavigationView
import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat


class callscreen : AppCompatActivity() {
    var reqcode=1000
    lateinit var add:AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_callscreen)

        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),reqcode)


        val opnumber=intent.getStringExtra("displaynumber")


        val main:DrawerLayout=findViewById(R.id.main)
        val lines:ImageView=findViewById(R.id.lines)
        val navigation:NavigationView=findViewById(R.id.navigation)


        lines.setOnClickListener {
            if(main.isDrawerOpen(Gravity.LEFT)){
                main.closeDrawer(Gravity.LEFT)
            }
            else{
                main.openDrawer(Gravity.LEFT)

            }
        }
        val opname=intent.getStringExtra("displayname").toString()
        val opadd=intent.getStringExtra("displayadd").toString()
        val opename=intent.getStringExtra("displayename").toString()



        val btn1:ImageView=findViewById(R.id.btn1)
        val number="100"
        btn1.setOnClickListener {
            val i:Intent=Intent(Intent.ACTION_CALL)
            i.data= Uri.parse("tel:$number")
            Toast.makeText(applicationContext,"calling police",Toast.LENGTH_LONG).show()
            startActivity(i)

        }
        val ambub:ImageView=findViewById(R.id.ambub)
        val ambunumber="102"

        ambub.setOnClickListener {
            val i:Intent=Intent(Intent.ACTION_CALL)
            i.data= Uri.parse("tel:$ambunumber")
            Toast.makeText(applicationContext,"calling Ambulance",Toast.LENGTH_LONG).show()
            startActivity(i)
        }

        val mahilab:ImageView=findViewById(R.id.mahilab)
        val mahila="7827170170"

        mahilab.setOnClickListener {
            val i:Intent=Intent(Intent.ACTION_CALL)
            i.data= Uri.parse("tel:$mahila")
            Toast.makeText(applicationContext,"calling Mahila helpline",Toast.LENGTH_LONG).show()
            startActivity(i)
        }

        val fireb:ImageView=findViewById(R.id.fireb)
        val fire="101"

        fireb.setOnClickListener {
            val i:Intent=Intent(Intent.ACTION_CALL)
            i.data= Uri.parse("tel:$fire")
            Toast.makeText(applicationContext,"calling Firebrigade",Toast.LENGTH_LONG).show()
            startActivity(i)
        }

        val emergencyb:Button=findViewById(R.id.emergencyb)

        emergencyb.setOnClickListener {
            val i:Intent=Intent(Intent.ACTION_CALL)
            i.data=Uri.parse("tel:$opnumber")
            startActivity(i)
        }
        val cyber:ImageView=findViewById(R.id.cyber)
        val cybern="155620"

        cyber.setOnClickListener {
            val i:Intent=Intent(Intent.ACTION_CALL)
            i.data= Uri.parse("tel:$cybern")
            Toast.makeText(applicationContext,"calling cyber crime department",Toast.LENGTH_LONG).show()
            startActivity(i)
        }

        val railway:ImageView=findViewById(R.id.railway)

        val railwayn="1072"
        railway.setOnClickListener {
            val i:Intent=Intent(Intent.ACTION_CALL)
            i.data= Uri.parse("tel:$railwayn")
            Toast.makeText(applicationContext,"calling Railway accident service",Toast.LENGTH_LONG).show()
            startActivity(i)
        }

        val disaster:ImageView=findViewById(R.id.disaster)

        val disastern="02114247001"
        disaster.setOnClickListener {
            val i:Intent=Intent(Intent.ACTION_CALL)
            i.data= Uri.parse("tel:$disastern")
            Toast.makeText(applicationContext,"calling NDRF",Toast.LENGTH_LONG).show()
            startActivity(i)
        }

        val roadaccident:ImageView=findViewById(R.id.roadaccident)

        val road="1073"
        roadaccident.setOnClickListener {
            val i:Intent=Intent(Intent.ACTION_CALL)
            i.data= Uri.parse("tel:$road")
            Toast.makeText(applicationContext,"calling Road emergency service",Toast.LENGTH_LONG).show()
            startActivity(i)
        }

        val children:ImageView=findViewById(R.id.children)

        val child=" 1098"
        children.setOnClickListener {
            val i:Intent=Intent(Intent.ACTION_CALL)
            i.data= Uri.parse("tel:$child")
            Toast.makeText(applicationContext,"calling child helpline",Toast.LENGTH_LONG).show()
            startActivity(i)
        }

        MobileAds.initialize(this){}
        add=findViewById(R.id.add)
        val adrequest=AdRequest.Builder().build()

        add.loadAd(adrequest)




        val header:View=navigation.getHeaderView(0)

        val name:TextView=header.findViewById(R.id.name)
        val address:TextView=header.findViewById(R.id.address)

        name.text=opname
        address.text=opadd


    }
    fun onoptionselected(item: MenuItem):Boolean{
        when(item.itemId){
            R.id.aboutk ->{
                val i:Intent=Intent(Intent.ACTION_VIEW)
                i.data=Uri.parse("www.linkedin.com/in/suhas-suryawanshi-b33452253")
                Toast.makeText(applicationContext,"Redirecting",Toast.LENGTH_LONG).show()
            startActivity(i)
            }


        }
        return true
    }


}
