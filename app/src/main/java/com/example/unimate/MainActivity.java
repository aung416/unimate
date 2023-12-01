package com.example.unimate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
  Toolbar toolbar;
  DrawerLayout drawerLayout;
  NavigationView navigationView;
  ActionBarDrawerToggle toggle;

  RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] categories_names= {"Attendence","CGPA Calulator","Career Path","Routine"};
        int[] imgs = {R.drawable.attendence,R.drawable.attendence,R.drawable.attendence,R.drawable.attendence};
        recyclerView = findViewById(R.id.recyleview);

        MyAdapter myAdapter = new MyAdapter(categories_names, imgs);
        GridLayoutManager layoutManager= new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);



         toolbar = findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);

         drawerLayout = findViewById(R.id.drawer_lyt);
         navigationView = findViewById(R.id.nav_view);

           toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
           drawerLayout.addDrawerListener(toggle );
           toggle.syncState();

           navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
               @Override
               public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                   int id = item.getItemId();
                   if(id == R.id.home)
                   {
                        drawerLayout.closeDrawer(GravityCompat.START);
                       Intent intent = new Intent(getApplicationContext(), Attendence.class);
                       startActivity(intent);
                   }

                   return true;
               }
           });



    }
}