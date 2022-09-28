package com.example.viewpagerexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter by lazy { ViewPagerAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1: Button = findViewById(R.id.button)
        btn1.setOnClickListener {
            val intent: Intent = Intent(this, pantalla2:: class.java)
            startActivity(intent)
        }

        pager.adapter = adapter
        val tabLayoutMediator = TabLayoutMediator(tab_layout,pager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when(position + 1){
                    1 -> {
                        tab.text = "Albunes"
                        tab.setIcon(R.drawable.ic_baseline_photo_album_24)
                        val badge:BadgeDrawable = tab.orCreateBadge
                        badge.backgroundColor = ContextCompat.getColor(applicationContext, R.color.red)
                        badge.number = 100
                        badge.maxCharacterCount = 3
                        badge.isVisible = true
                    }
                    2 -> {
                        tab.text = "Recientes"
                        tab.setIcon(R.drawable.ic_baseline_star_border_24)
                        val badge:BadgeDrawable = tab.orCreateBadge
                        badge.backgroundColor = ContextCompat.getColor(applicationContext, R.color.red)
                        badge.number = 10
                        badge.isVisible = true
                    }
                    3 -> {
                        tab.text = "Compartir"
                        tab.setIcon(R.drawable.ic_baseline_share_24)
                        val badge:BadgeDrawable = tab.orCreateBadge
                        badge.backgroundColor = ContextCompat.getColor(applicationContext, R.color.red)
                        badge.isVisible = true
                    }
                }
            })
        tabLayoutMediator.attach()
    }
}
