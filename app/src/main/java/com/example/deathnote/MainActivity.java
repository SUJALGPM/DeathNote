package com.example.deathnote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar  toolbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerlayout1);
        navigationView = findViewById(R.id.naviView1);
        toolbar = findViewById(R.id.toolbar1);

        //Step1
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //By default this fragment will load.
        loadFragment(new WelcomeFragment());

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id  = item.getItemId();

                if(id==R.id.Home){
                    loadFragment(new WelcomeFragment());
                }else if(id==R.id.addcourse){
                    loadFragment(new AddCourseFragment());
                    Toast.makeText(MainActivity.this, "Course", Toast.LENGTH_SHORT).show();
                }else if(id==R.id.viewcourse){
                    loadFragment(new ViewFragment());
                    Toast.makeText(MainActivity.this, "View Courses", Toast.LENGTH_SHORT).show();
                }else if(id==R.id.about){
                    loadFragment(new AboutFragment());
                    Toast.makeText(MainActivity.this, "About page", Toast.LENGTH_SHORT).show();
                }else{
                    loadFragment(new ContactFragment());
                    Toast.makeText(MainActivity.this, "Contact page", Toast.LENGTH_SHORT).show();
                }


                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.container,fragment);
        ft.commit();
    }
}