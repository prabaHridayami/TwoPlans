package com.example.praba.twoplans;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class RecyclerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
        private static final String TAG = "RecyclerActivity";
    RecyclerView list;
//    private Toolbar toolbar;
//    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);
        Log.d(TAG, "onCreate: drawer_layout");

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToogle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list = (RecyclerView) findViewById(R.id.home_list);
        list.setLayoutManager(new LinearLayoutManager(this));
        HomeAdapter adapter = new HomeAdapter(RecyclerActivity.this);
        list.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToogle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case (R.id.navigation1):
                Toast.makeText(this, "This is Home",Toast.LENGTH_SHORT).show();
                break;
            case (R.id.navigation2):
                Toast.makeText(this, "This is Profil",Toast.LENGTH_SHORT).show();
                break;
            case (R.id.navigation3):
                Toast.makeText(this, "This is About",Toast.LENGTH_SHORT).show();
                break;
        }

        return false;
    }

}

