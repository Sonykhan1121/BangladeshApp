package com.example.bangladesh

import android.content.Intent
import android.os.Bundle
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.webkit.WebChromeClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bangladesh.databinding.ActivityDetailedBinding


class DetailedActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Scroll to top when the layout is ready
        binding.scrolviewId.getViewTreeObserver().addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                // Scroll to the top
                binding.scrolviewId.scrollTo(0, 0)

                // Remove the listener to avoid redundant calls
                binding.scrolviewId.getViewTreeObserver().removeOnGlobalLayoutListener(this)
            }
        })

        val title_name  = intent.getStringExtra("selectedItem")
        val bdname = intent.getStringExtra("banglaname")
        binding.divisionNameId.text = title_name+" ("+bdname+")"

        Toast.makeText(this, "this is "+title_name, Toast.LENGTH_SHORT).show()
        loadImages(title_name)
        loadVideos(title_name)

        binding.ig1Id.setOnClickListener {
            openDisplayImageActivity(binding.ig1Id.tag as Int,title_name)
        }

        binding.ig2Id.setOnClickListener {
            openDisplayImageActivity(binding.ig2Id.tag as Int,title_name)
        }

        binding.ig3Id.setOnClickListener {
            openDisplayImageActivity(binding.ig3Id.tag as Int,title_name)
        }


    }

    private fun openDisplayImageActivity(imageId: Int, titleName: String?) {
            val intent = Intent(this,ShowPictureActivity::class.java)
        intent.putExtra("imageId",imageId)
        intent.putExtra("title",titleName)
        startActivity(intent)
    }


    private fun loadImages(selectedItem: String?) {

        if(selectedItem=="Barishal")
        {

            binding.ig1Id.setImageResource(R.drawable.br2)
            binding.ig1Id.tag = R.drawable.br2
            binding.ig2Id.setImageResource(R.drawable.br3)
            binding.ig2Id.tag = R.drawable.br3

            binding.ig3Id.setImageResource(R.drawable.br1)
            binding.ig3Id.tag = R.drawable.br1

        }
        else if(selectedItem=="Chattogram")
        {
            binding.ig1Id.setImageResource(R.drawable.ct1)
            binding.ig1Id.tag = R.drawable.ct1

            binding.ig2Id.setImageResource(R.drawable.ct2)
            binding.ig2Id.tag = R.drawable.ct2

            binding.ig3Id.setImageResource(R.drawable.ct3)
            binding.ig3Id.tag = R.drawable.ct3
        }else if(selectedItem=="Dhaka")
        {
            binding.ig1Id.setImageResource(R.drawable.dk1)
            binding.ig1Id.tag = R.drawable.dk1

            binding.ig2Id.setImageResource(R.drawable.dk2)
            binding.ig2Id.tag = R.drawable.dk2

            binding.ig3Id.setImageResource(R.drawable.dk3)
            binding.ig3Id.tag = R.drawable.dk3
        }
        else if(selectedItem=="Khulna")
        {
            binding.ig1Id.setImageResource(R.drawable.kl1)
            binding.ig1Id.tag = R.drawable.kl1

            binding.ig2Id.setImageResource(R.drawable.kl2)
            binding.ig2Id.tag = R.drawable.kl2

            binding.ig3Id.setImageResource(R.drawable.kl3)
            binding.ig3Id.tag = R.drawable.kl3
        }
        else if(selectedItem=="Rajshahi")
        {
            binding.ig1Id.setImageResource(R.drawable.rj2)
            binding.ig1Id.tag = R.drawable.rj2

            binding.ig2Id.setImageResource(R.drawable.rj3)
            binding.ig2Id.tag = R.drawable.rj3

            binding.ig3Id.setImageResource(R.drawable.rj1)
            binding.ig3Id.tag = R.drawable.rj1
        }
        else if(selectedItem=="Rangpur")
        {
            binding.ig1Id.setImageResource(R.drawable.rg1)
            binding.ig1Id.tag = R.drawable.rg1

            binding.ig2Id.setImageResource(R.drawable.rg2)
            binding.ig2Id.tag = R.drawable.rg2

            binding.ig3Id.setImageResource(R.drawable.rg3)
            binding.ig3Id.tag = R.drawable.rg3
        }
        else if(selectedItem=="Sylhet")
        {
            binding.ig1Id.setImageResource(R.drawable.sl1)
            binding.ig1Id.tag = R.drawable.sl1

            binding.ig2Id.setImageResource(R.drawable.sl2)
            binding.ig2Id.tag = R.drawable.sl2

            binding.ig3Id.setImageResource(R.drawable.sl3)
            binding.ig3Id.tag = R.drawable.sl3

        }
        else if(selectedItem=="Mymensingh")
        {
            binding.ig1Id.setImageResource(R.drawable.mg2)
            binding.ig1Id.tag = R.drawable.mg2

            binding.ig2Id.setImageResource(R.drawable.ms1)
            binding.ig2Id.tag = R.drawable.ms1

            binding.ig3Id.setImageResource(R.drawable.ms2)
            binding.ig3Id.tag = R.drawable.ms2
        }
    }
    private fun loadVideos(selectedItem: String?) {
        //id's are
        //       binding.historyVideoId
        //        binding.placeId
        //        binding.foodId

        if(selectedItem.equals("Barishal"))
        {
            val video1 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/xMRJ8Nv-7Xs?si=MIJnA4M1XxkWLZAD\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.historyVideoId.loadData(video1,"text/html","utf-8")
            binding.historyVideoId.settings.javaScriptEnabled = true
            binding.historyVideoId.webChromeClient = WebChromeClient()

            val video2 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/d70rN_HCvwA?si=wgNDVvQjo2e0IrDx\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.popularVideoId.loadData(video2,"text/html","utf-8")
            binding.popularVideoId.settings.javaScriptEnabled = true
            binding.popularVideoId.webChromeClient = WebChromeClient()

            val video3 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/kLcSTdb0R_g?si=h5PnvOa6z2gxF9km\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.foodVideoId.loadData(video3,"text/html","utf-8")
            binding.foodVideoId.settings.javaScriptEnabled = true
            binding.foodVideoId.webChromeClient = WebChromeClient()

        }
        else if(selectedItem=="Chattogram")
        {
            val video1 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/3LJAxFKoa6o?si=TBpDPOcz3Bx2S-D_\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.historyVideoId.loadData(video1,"text/html","utf-8")
            binding.historyVideoId.settings.javaScriptEnabled = true
            binding.historyVideoId.webChromeClient = WebChromeClient()

            val video2 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eoBH6wv8yAA?si=foYnz8Yhn-jElq8e\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.popularVideoId.loadData(video2,"text/html","utf-8")
            binding.popularVideoId.settings.javaScriptEnabled = true
            binding.popularVideoId.webChromeClient = WebChromeClient()

            val video3 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/nUmDXpJaKrs?si=OIb5SuaioqL516l-\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.foodVideoId.loadData(video3,"text/html","utf-8")
            binding.foodVideoId.settings.javaScriptEnabled = true
            binding.foodVideoId.webChromeClient = WebChromeClient()

        }else if(selectedItem=="Dhaka")
        {
            val video1 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/4SbFWt-ioxM?si=PLmUyIOqd8TgDiAX\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.historyVideoId.loadData(video1,"text/html","utf-8")
            binding.historyVideoId.settings.javaScriptEnabled = true
            binding.historyVideoId.webChromeClient = WebChromeClient()

            val video2 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/oHB1NTpGxj8?si=fLywfNf8uWd58vdF\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.popularVideoId.loadData(video2,"text/html","utf-8")
            binding.popularVideoId.settings.javaScriptEnabled = true
            binding.popularVideoId.webChromeClient = WebChromeClient()

            val video3 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/SoIXM8HA2Io?si=ugSV55sN7gWWJvog\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.foodVideoId.loadData(video3,"text/html","utf-8")
            binding.foodVideoId.settings.javaScriptEnabled = true
            binding.foodVideoId.webChromeClient = WebChromeClient()
        }
        else if(selectedItem=="Khulna")
        {
            val video1 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/k7iFMGTl6dA?si=hUMqpSUYAGe4KsfH\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.historyVideoId.loadData(video1,"text/html","utf-8")
            binding.historyVideoId.settings.javaScriptEnabled = true
            binding.historyVideoId.webChromeClient = WebChromeClient()

            val video2 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/SYp_eOiSHDk?si=9-kqR6mOAzarSC99\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.popularVideoId.loadData(video2,"text/html","utf-8")
            binding.popularVideoId.settings.javaScriptEnabled = true
            binding.popularVideoId.webChromeClient = WebChromeClient()

            val video3 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/M5Lg7sIzrCA?si=4GeORChIo098Oi-h\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.foodVideoId.loadData(video3,"text/html","utf-8")
            binding.foodVideoId.settings.javaScriptEnabled = true
            binding.foodVideoId.webChromeClient = WebChromeClient()
        }
        else if(selectedItem=="Rajshahi")
        {
            val video1 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/DnSmHJIbf6k?si=nnW_ou4pUbCh9CJS\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.historyVideoId.loadData(video1,"text/html","utf-8")
            binding.historyVideoId.settings.javaScriptEnabled = true
            binding.historyVideoId.webChromeClient = WebChromeClient()

            val video2 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/rvPY0Sm40iI?si=3eLxNWMUnllnaCPO\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.popularVideoId.loadData(video2,"text/html","utf-8")
            binding.popularVideoId.settings.javaScriptEnabled = true
            binding.popularVideoId.webChromeClient = WebChromeClient()

            val video3 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/fvdzGUt5pIE?si=54DPak86sVuLJo70\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.foodVideoId.loadData(video3,"text/html","utf-8")
            binding.foodVideoId.settings.javaScriptEnabled = true
            binding.foodVideoId.webChromeClient = WebChromeClient()
        }
        else if(selectedItem=="Rangpur")
        {
            val video1 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/o2Y3uZJe60I?si=Vmt8_poKurdkvFBC\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.historyVideoId.loadData(video1,"text/html","utf-8")
            binding.historyVideoId.settings.javaScriptEnabled = true
            binding.historyVideoId.webChromeClient = WebChromeClient()

            val video2 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/A1xdA1Om6JM?si=Pw8HoxMv9OTjORGh\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.popularVideoId.loadData(video2,"text/html","utf-8")
            binding.popularVideoId.settings.javaScriptEnabled = true
            binding.popularVideoId.webChromeClient = WebChromeClient()

            val video3 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/s9ehh4kb5iI?si=J136iIEV7fcylQPC\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.foodVideoId.loadData(video3,"text/html","utf-8")
            binding.foodVideoId.settings.javaScriptEnabled = true
            binding.foodVideoId.webChromeClient = WebChromeClient()
        }
        else if(selectedItem=="Sylhet")
        {
            val video1 ="<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/dXwX0bxL0Ww?si=2JOpEWmk1mzzb95_\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.historyVideoId.loadData(video1,"text/html","utf-8")
            binding.historyVideoId.settings.javaScriptEnabled = true
            binding.historyVideoId.webChromeClient = WebChromeClient()

            val video2 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/EKpR32hQA3w?si=iiDzIPaSMkLtBbPE\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.popularVideoId.loadData(video2,"text/html","utf-8")
            binding.popularVideoId.settings.javaScriptEnabled = true
            binding.popularVideoId.webChromeClient = WebChromeClient()

            val video3 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/pzGCYvTgB9g?si=xA2ntzxALD5QEH3W\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.foodVideoId.loadData(video3,"text/html","utf-8")
            binding.foodVideoId.settings.javaScriptEnabled = true
            binding.foodVideoId.webChromeClient = WebChromeClient()

        }
        else if(selectedItem=="Mymensingh")
        {
            val video1 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/-Wy1ODH871M?si=HKyfWhDqRo9rBUlc\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.historyVideoId.loadData(video1,"text/html","utf-8")
            binding.historyVideoId.settings.javaScriptEnabled = true
            binding.historyVideoId.webChromeClient = WebChromeClient()

            val video2 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/noDxGsP3E4g?si=9z7waZvdvieHlZ-R\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.popularVideoId.loadData(video2,"text/html","utf-8")
            binding.popularVideoId.settings.javaScriptEnabled = true
            binding.popularVideoId.webChromeClient = WebChromeClient()

            val video3  ="<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/P1SJbZVzsiE?si=xfqYIt52HT2ro8kK\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            binding.foodVideoId.loadData(video3,"text/html","utf-8")
            binding.foodVideoId.settings.javaScriptEnabled = true
            binding.foodVideoId.webChromeClient = WebChromeClient()
        }
    }
}