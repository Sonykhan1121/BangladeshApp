package com.example.bangladesh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.bangladesh.databinding.ActivityShowPictureBinding

class ShowPictureActivity : AppCompatActivity() {
    private lateinit var binding:ActivityShowPictureBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowPictureBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val idofimage = intent.getIntExtra("imageId",0)

        if(idofimage!=0)
        {
            binding.showPictureId.setImageResource(idofimage)
            binding.textView3.setText(intent.getStringExtra("title"))
        }
        else{
            val title = intent.getStringExtra("selectedItem")
            val picture = intent.getStringExtra("picture")
            Glide.with(this)
                .load(picture)
                .into(binding.showPictureId)
            binding.textView3.setText(title)
        }



        




    }
}