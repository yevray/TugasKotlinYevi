package com.project.tugaskotlinyevi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView

class PreviewAnimasiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview_animasi)

        val namaAnimasi: String = intent.getStringExtra("nama_anim").toString()

        val txt_animasi = findViewById<TextView>(R.id.txt_animasi)
        if (namaAnimasi.equals("Animasi Fade UP")){
            txt_animasi.visibility = View.INVISIBLE
        }else{
            txt_animasi.visibility = View.VISIBLE
        }

        val text_btn = findViewById<TextView>(R.id.text_btn)
        text_btn.text = namaAnimasi
        val btn_anim = findViewById<CardView>(R.id.btn_anim)
        btn_anim.setOnClickListener(View.OnClickListener {
            if (namaAnimasi.equals("Animasi Fade UP")){
                val animation = AnimationUtils.loadAnimation(this, R.anim.anim_fade_in)
                txt_animasi.startAnimation(animation)
                txt_animasi.visibility = View.VISIBLE
            }else if(namaAnimasi.equals("Animasi Fade Down")){
                val animation = AnimationUtils.loadAnimation(this, R.anim.anim_fade_out)
                txt_animasi.startAnimation(animation)
                Handler(Looper.getMainLooper()).postDelayed({}, 4000)
            }else if(namaAnimasi.equals("Animasi Zoom IN")){
                val animation = AnimationUtils.loadAnimation(this, R.anim.anim_zoom_in)
                txt_animasi.startAnimation(animation)
            }else if(namaAnimasi.equals("Animasi Zoom Out")){
                val animation = AnimationUtils.loadAnimation(this, R.anim.anim_zoom_out)
                txt_animasi.startAnimation(animation)
            }else if(namaAnimasi.equals("Animasi Rotate")){
                val animation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate)
                txt_animasi.startAnimation(animation)
            }else if(namaAnimasi.equals("Animasi Move")){
                val animation = AnimationUtils.loadAnimation(this, R.anim.anim_move)
                txt_animasi.startAnimation(animation)
            }
        })
    }
}