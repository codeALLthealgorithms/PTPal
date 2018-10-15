package com.example.shree.pt_pal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.widget.Toast;

public class Exercises extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(mToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        int id = item.getItemId();

        if( id == R.id.profile)
        {
            //Toast.makeText(this, "This is profile", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Exercises.this, Profile.class);
            startActivity(intent);
            return true;
        }
        if( id == R.id.therapy)
        {
            //Toast.makeText(this, "This is therapy", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Exercises.this, Therapy.class);
            startActivity(intent);
            return true;
        }
        if( id == R.id.log)
        {
            Toast.makeText(this, "This is logout", Toast.LENGTH_LONG).show();
            return true;
        }

        return false;
    }

}
