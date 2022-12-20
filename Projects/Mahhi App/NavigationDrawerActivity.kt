package com.example.milkonmobile

import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.example.milkonmobile.databinding.ActivityNavigationDrawerBinding
import java.util.ArrayList

class NavigationDrawerActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNavigationDrawerBinding
    lateinit var toolbar: Toolbar
    lateinit var slider: SliderLayout
    lateinit var recycler: RecyclerView
    lateinit var list: MutableList<Model>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        toolbar.setTitle("Home")


        slider=findViewById(R.id.slider)

        var map=HashMap<String,Int>()
        map.put("A", R.drawable.a)
        map.put("B",R.drawable.b)
        map.put("C",R.drawable.c)
        map.put("D",R.drawable.d)
        map.put("E",R.drawable.e)
        map.put("F",R.drawable.f)
        map.put("G",R.drawable.g)
        map.put("H",R.drawable.h)


        for (name in map.keys)
        {
            var textslider= TextSliderView(this)
            textslider.image(map.get(name)!!)
            slider.addSlider(textslider)
        }

        recycler=findViewById(R.id.recycler)
        list= ArrayList()


        var layout:RecyclerView.LayoutManager= GridLayoutManager(this,2)
        recycler.layoutManager=layout


        list.add(Model("SUPER GOLD 500 ml",R.drawable.milk,"Rs. 33.0","Subscribe @ ₹33.0","-","0","+","ADD"))
        list.add(Model("SUPER GOLD 500 ml",R.drawable.ghee,"Rs. 33.0","Subscribe @ ₹33.0","-","0","+","ADD"))
        list.add(Model("SUPER GOLD 500 ml",R.drawable.milk,"Rs. 33.0","Subscribe @ ₹33.0","-","0","+","ADD"))
        list.add(Model("SUPER GOLD 500 ml",R.drawable.ghee,"Rs. 33.0","Subscribe @ ₹33.0","-","0","+","ADD"))

        var adapter=MyAdapter(applicationContext,list)
        recycler.adapter=adapter


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_navigation_drawer)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_MyProfile, R.id.nav_MyCart
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_navigation_drawer)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}