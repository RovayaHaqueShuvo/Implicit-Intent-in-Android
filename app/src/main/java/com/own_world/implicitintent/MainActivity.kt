package com.own_world.implicitintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.own_world.implicitintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)



        // Calling using intent
        binding.btnCall.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" + binding.etNumber.getText())
            startActivity(intent)
        })

        // Call log
        binding.btnCallLog.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.type = CallLog.Calls.CONTENT_TYPE
            startActivity(intent)
        })

        //Contact
        binding.btnContact.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = ContactsContract.Contacts.CONTENT_TYPE
            startActivity(intent)
        })

        // browser
        binding.btnBrowser.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://tutorial.eyehunts.com/")
            startActivity(intent)
        })

        // Gallery
        binding.btnGallery.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("content://media/external/images/media/")
            startActivity(intent)
        })

        // camera
        binding.btnCamera.setOnClickListener(View.OnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        })

        // alarm
        binding.btnAlarm.setOnClickListener(View.OnClickListener {
            val intent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
            startActivity(intent)
        })
    }





    }
