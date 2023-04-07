package com.example.mobilproject

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.ActionMode
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.mobilproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
   // private lateinit var  sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
       timerFinish()

    }
    fun setupBinding(){
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root

        setContentView(view)
    }

     fun loginAction(view: View){

         val intent=Intent(applicationContext,NextActivity::class.java)
         startActivity(intent)



     }
    fun timerFinish(){

        object :CountDownTimer(10000,1000){

            override fun onFinish() {
                binding.timer.text="0"
              val alert=AlertDialog.Builder(this@MainActivity)
                alert.setTitle("bilgilendirme")
                alert.setMessage("geçerli süres içinde giriş yapmadınız! tekrar aktarılıyorsunuz...")

                alert.setPositiveButton("tamam"){dialog,which->

                    Toast.makeText(this@MainActivity,"tekrar deneeyiniz",Toast.LENGTH_LONG).show()
                }
                alert.show()
            }

            override fun onTick( p0:Long) {
               binding.timer.text="${(p0/1000)+1}"
            }
        }.start()


    }





}