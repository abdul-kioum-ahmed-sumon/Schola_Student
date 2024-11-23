package com.example.schola


import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.schola.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.schola.Fragments.ClassRoutineFragment
import com.example.schola.Fragments.HomeFragment
import com.example.schola.Fragments.MessageFragment
import com.example.schola.Fragments.ProfileFragment
import com.example.schola.Model.SubjectActivity
import com.example.schola.ClassTestListActivity
import com.example.scholateacher.Model.Teacher
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding : ActivityMainBinding
    lateinit var headerView: View
    var flag:Boolean = false

    lateinit var largeProfilePic : ImageView
    lateinit var name: TextView
    lateinit var designation: TextView
    lateinit var department: TextView

    lateinit var currentTeacher :Teacher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        headerView = binding.navView.getHeaderView(0)
        largeProfilePic = headerView.findViewById(R.id.largeProfilePic)
        name = headerView.findViewById(R.id.name)
        designation = headerView.findViewById(R.id.designation)
        department = headerView.findViewById(R.id.department)


        val btnSubjects: ImageButton = findViewById(R.id.btn_subjects)
        btnSubjects.setOnClickListener {
            val intent = Intent(this, SubjectActivity::class.java)
            startActivity(intent)
        }


        val btnClassTest: ImageButton = findViewById(R.id.btn_class_test)
        btnClassTest.setOnClickListener{
            val intent = Intent(this, ClassTestListActivity::class.java )
            startActivity(intent)
        }

        setUpForNavigationDrawer()
        setProfilePic()
        handleMenuIconClick()
        setupBottomNavigation()
        setFragment(HomeFragment())





    }



    private fun set2() {



    }

    private fun setupBottomNavigation() {
        val bottomNavigationView: BottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.setOnItemSelectedListener { item ->
            val selectedFragment: Fragment = when (item.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_profile -> ProfileFragment()
                R.id.nav_class_routine -> ClassRoutineFragment()
                R.id.nav_message -> MessageFragment()
                else -> HomeFragment()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame, selectedFragment)
                .commit()
            true
        }
    }

    private fun handleMenuIconClick() {
        binding.menuicon.setOnClickListener {
            if (!binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }    }

    private fun setUpForNavigationDrawer() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        binding.navView.setNavigationItemSelectedListener(this)
    }

    private fun setProfilePic() {
        Glide.with(this)
            .load(R.drawable.stuprofile)
            .apply(RequestOptions.circleCropTransform())
            .into(binding.profilePic)



        Glide.with(this)
            .load(R.drawable.stuprofile)
            .apply(RequestOptions.circleCropTransform())
            .into(largeProfilePic)


    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_faculty_members -> {



            }
            R.id.nav_advising_batch -> {


                //startActivity(Intent(this,AdvHomeActivity::class.java))


            }
            R.id.nav_academic_calendar -> {


            }
            R.id.nav_cgpa_calculator -> {


            }
            R.id.nav_settings -> {


            }
            R.id.nav_logout -> {



            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


    fun setFragment(fragment: Fragment){
        val fragmentManager : FragmentManager = supportFragmentManager
        val frammentTransition : FragmentTransaction = fragmentManager.beginTransaction()

        if(!flag){
            frammentTransition.add(R.id.frame,fragment)
            flag = true
        }
        else{
            frammentTransition.replace(R.id.frame,fragment)
        }
        frammentTransition.commit()
    }



}


