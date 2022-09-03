package com.example.shoppingapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    lateinit var image1:ImageView
    lateinit var text1:TextView
    lateinit var image2:ImageView
    lateinit var text2:TextView
    lateinit var image3:ImageView
    lateinit var text3:TextView
    lateinit var image4:ImageView
    lateinit var text4:TextView
    lateinit var image5:ImageView
    lateinit var text5:TextView
    lateinit var image6:ImageView
    lateinit var text6:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        image1=findViewById(R.id.img1)
        text1=findViewById(R.id.txt1)
        image2=findViewById(R.id.img2)
        text2=findViewById(R.id.txt2)
        image3=findViewById(R.id.img3)
        text3=findViewById(R.id.txt3)
        image4=findViewById(R.id.img4)
        text4=findViewById(R.id.txt4)
        image5=findViewById(R.id.img5)
        text5=findViewById(R.id.txt5)
        image6=findViewById(R.id.img6)
        text6=findViewById(R.id.txt6)

        text1.setOnClickListener {
            var call="8888888888"
            var i=Intent(Intent.ACTION_CALL)
            i.setData(Uri.parse("tel:"+call))
            startActivity(i)
        }
        image2.setOnClickListener {
            var url="https://www.flipkart.com/eyebogler-striped-men-polo-neck-white-blue-yellow-t-shirt/p/itm5e2f30fc1f038?pid=TSHGA4MH4JYR6YAK&lid=LSTTSHGA4MH4JYR6YAK73IUIW&marketplace=FLIPKART&store=clo%2Fash%2Fank%2Fedy&srno=b_1_7&otracker=browse&fm=organic&iid=191da47d-38b5-4dd5-a0fb-c7b0b4acd9a7.TSHGA4MH4JYR6YAK.SEARCH&ppt=browse&ppn=browse"
            var j=Intent(Intent.ACTION_VIEW)
            j.setData(Uri.parse(url))
            startActivity(j)

        }
        text2.setOnClickListener {
            Toast.makeText(applicationContext,"Price is 314 rupees",Toast.LENGTH_LONG).show()
        }
        image3.setOnClickListener {
            var url="https://www.flipkart.com/dennis-lingo-men-solid-casual-green-shirt/p/itmf8h3yjdjtqjgm?pid=SHTF8GZVQCHHUQKQ&lid=LSTSHTF8GZVQCHHUQKQFBBEWU&marketplace=FLIPKART&store=clo%2Fash%2Faxc%2Fmmk&srno=b_1_5&otracker=browse&fm=organic&iid=b2de6eb5-57f9-4c0b-9d60-c1908d1f8e7b.SHTF8GZVQCHHUQKQ.SEARCH&ppt=browse&ppn=browse&ssid=0tqkiweif40000001662190904438"
            var j=Intent(Intent.ACTION_VIEW)
            j.setData(Uri.parse(url))
            startActivity(j)
        }
        text3.setOnClickListener {
            Toast.makeText(applicationContext,"Price is 499 rupees",Toast.LENGTH_LONG).show()
        }
      image4.setOnClickListener {
          var url="https://www.purelylush.com/blue-batik-print-cotton-kurti-with-chevron-pants/?v=c86ee0d9d7ed"
          var j=Intent(Intent.ACTION_VIEW)
          j.setData(Uri.parse(url))
          startActivity(j)
      }
        text4.setOnClickListener {
            Toast.makeText(applicationContext,"Price is 1499 rupees",Toast.LENGTH_LONG).show()
        }
        image5.setOnClickListener {
            var url="https://www.flipkart.com/marclex-magnet-wrist-watch-women-ladies-watches-girls-style-womens-trending-stylish-analog/p/itmdd9da5bb43f55?pid=WATG2TZQSGMRZ6UA&lid=LSTWATG2TZQSGMRZ6UAEVJOZZ&marketplace=FLIPKART&fm=neo%2Fmerchandising&iid=M_346f093e-73f8-4639-9379-f14cb3aa23b6_15_IEL7PUWY95U8_MC.WATG2TZQSGMRZ6UA&ppt=browse&ppn=browse&ssid=qz9023iucg0000001662191649484&otracker=clp_pmu_v2_Under%2B%25E2%2582%25B9999_1_15.productCard.PMU_V2_Marclex%2Bmagnet%2Bwrist%2Bwatch%2Bfor%2Bwomen%2Bladies%2Bwatches%2Bgirls%2Bstyle%2Bwomens%2Btrending%2Bstylish%2BAnalog%2BWatch%2B%2B-%2BFor%2BWomen_womens-watches-store_WATG2TZQSGMRZ6UA_neo%2Fmerchandising_0&otracker1=clp_pmu_v2_PINNED_neo%2Fmerchandising_Under%2B%25E2%2582%25B9999_LIST_productCard_cc_1_NA_view-all&cid=WATG2TZQSGMRZ6UA"
            var j=Intent(Intent.ACTION_VIEW)
            j.setData(Uri.parse(url))
            startActivity(j)
        }
        text5.setOnClickListener {
            Toast.makeText(applicationContext,"Price is 265 rupees",Toast.LENGTH_LONG).show()
        }
        image6.setOnClickListener {
            var url="https://www.flipkart.com/nh2-women-green-flats/p/itm6538afa3c00b2?pid=SNDFYJYYWS3ANVSY&lid=LSTSNDFYJYYWS3ANVSYGZN3KR&marketplace=FLIPKART&store=osp%2Fiko%2F9d5&srno=b_1_7&otracker=nmenu_sub_Women_0_Flats&fm=Search&iid=20626e2b-edd3-4192-996d-e115550d5b1b.SNDFYJYYWS3ANVSY.SEARCH&ppt=browse&ppn=browse&ssid=o6j8xvzccw0000001662191800051"
            var j=Intent(Intent.ACTION_VIEW)
            j.setData(Uri.parse(url))
            startActivity(j)
        }
        text6.setOnClickListener {
            Toast.makeText(applicationContext,"Price is 299 rupees",Toast.LENGTH_LONG).show()
        }
    }
}