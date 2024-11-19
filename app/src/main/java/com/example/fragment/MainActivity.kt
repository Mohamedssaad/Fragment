package com.example.fragment

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(),Comunictactor {
    lateinit var btnload:Button
    lateinit var dynamicFragment: DynamicFragment
    private val TAG="StaticFragment"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.i(TAG, "Activity onCreate:Start ")

        setContentView(R.layout.activity_main)
        Log.i(TAG, "Activity onCreate:End ")

        btnload=findViewById(R.id.btnload)
        btnload.setOnClickListener({

            //create objetfrom dynamic frafment
            dynamicFragment= DynamicFragment()
             var mgr=supportFragmentManager //get an object from manger
            val transaction= mgr.beginTransaction()
            transaction.add(R.id.dynamicContainer,dynamicFragment,"dynamicFragment")
            transaction.commit()

        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
            
        }


    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "Activity onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "Activity onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "Activity onPause: ")
    }


    override fun onStop() {
        super.onStop()
        Log.i(TAG, "Activity onStop: ")
    }

    override fun onDestroy() {
        Log.i(TAG, "Activity onDestroy: ")
        super.onDestroy()
    }

    override fun changeData(data: String) {

        val mgr:FragmentManager =supportFragmentManager
        val fragment2: DynamicFragment? =mgr.findFragmentByTag("dynamicFragment") as DynamicFragment
        fragment2?.sayHallo(data)
    }


}