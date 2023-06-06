package com.project.tugaskotlinyevi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.tugaskotlinyevi.R

class AnimationFragment(context: Context) : Fragment() {

    private lateinit var list_animasi : RecyclerView
    private lateinit var arrayDataAnimasi : ArrayList<DataAnimasi>
    lateinit var iconAnimasi : Array<Int>
    lateinit var namaAnimasi : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_animation, container, false)

        iconAnimasi = arrayOf(
            R.drawable.ic_up,
            R.drawable.ic_down,
            R.drawable.ic_zoom_in,
            R.drawable.ic_zoom_out,
            R.drawable.ic_rotate,
            R.drawable.ic_move,
        )

        namaAnimasi = arrayOf(
            "Animasi Fade UP",
            "Animasi Fade Down",
            "Animasi Zoom IN",
            "Animasi Zoom Out",
            "Animasi Rotate",
            "Animasi Move"
        )

        list_animasi = view.findViewById(R.id.list_animasi)
        list_animasi.layoutManager = LinearLayoutManager(view.context)
        list_animasi.setHasFixedSize(true)

        arrayDataAnimasi = arrayListOf<DataAnimasi>()
        for (i in iconAnimasi.indices){
            val dat_anim = DataAnimasi(
                iconAnimasi[i],
                namaAnimasi[i]
            )
            arrayDataAnimasi.add(dat_anim)
        }
        list_animasi.adapter = AnimasiAdapter(arrayDataAnimasi, view.context)

        return view
    }
}