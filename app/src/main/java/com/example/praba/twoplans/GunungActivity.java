package com.example.praba.twoplans;

import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

public class GunungActivity extends AppCompatActivity {
    RecyclerView list;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler1);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer1);
        mToogle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list = (RecyclerView) findViewById(R.id.sub_list);
        list.setLayoutManager(new LinearLayoutManager(this));
        SubAdapterGunung adapter = new SubAdapterGunung(GunungActivity.this);
        list.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToogle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item){
//        int id = item.getItemId();
//
//        switch (id){
//            case (R.id.navigation1):
//                Toast.makeText(this, "This is beranda",Toast.LENGTH_SHORT).show();
//                break;
//            case (R.id.navigation2):
//                Toast.makeText(this, "This is Profil",Toast.LENGTH_SHORT).show();
//                break;
//            case (R.id.navigation3):
//                Toast.makeText(this, "This is Daftar",Toast.LENGTH_SHORT).show();
//                break;
//            case (R.id.navigation4):
//                Toast.makeText(this, "This is Setting",Toast.LENGTH_SHORT).show();
//                break;
//            case (R.id.navigation5):
//                Toast.makeText(this, "This is About",Toast.LENGTH_SHORT).show();
//                break;
//            default:
//                break;
//
//        }
//
//        return false;
//    }
}
