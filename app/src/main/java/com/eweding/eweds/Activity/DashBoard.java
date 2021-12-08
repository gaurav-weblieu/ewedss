package com.eweding.eweds.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.eweding.eweds.Adapter.CatergoryAdapter;
import com.eweding.eweds.Adapter.OurTipsAdapter;
import com.eweding.eweds.Adapter.PopularListAdapter;
import com.eweding.eweds.Adapter.WeddingPlanAdapter;
import com.eweding.eweds.Fragment.BlogFragment;
import com.eweding.eweds.Fragment.HomeFragment;
import com.eweding.eweds.Fragment.WeddingPlaning;
import com.eweding.eweds.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class DashBoard extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
   // CardView cardView_profile,cardView_service,cardView_business_list;
    public DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        bottomNavigation=findViewById(R.id.bottomNavigation);
       /* cardView_profile=findViewById(R.id.cardView_profile);
        cardView_service=findViewById(R.id.cardView_service);
        cardView_business_list=findViewById(R.id.cardView_business_list);
*/
        Toolbar toolbar = findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);

        drawerLayout =findViewById(R.id.my_drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_main);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.vender:
                        openFragment(new HomeFragment());
                        return true;
                    case R.id.plan:
                        openFragment(new WeddingPlaning());
                        return true;
                    case R.id.dress_plan:
                        openFragment(new WeddingPlaning());
                        return true;

                    case R.id.dress_song:
                        openFragment(new WeddingPlaning());
                        return true;

                    case R.id.dress_blog:
                        openFragment(new BlogFragment());
                        return true;
                }
                return false;
            }
        });

        /* cardView_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoard.this, LoginActivity.class));

            }
        });

        cardView_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoard.this, ServiceProvider.class));

            }
        });

        cardView_business_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoard.this, FreeListBusiness.class));

            }
        });*/

        openFragment(new HomeFragment( ));

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.user_login:
                        startActivity(new Intent(DashBoard.this, LoginActivity.class));
                        break;

                    case R.id.about_us:
                        startActivity(new Intent(DashBoard.this, AboutUs.class));
                        break;

                    case R.id.termCon:
                        startActivity(new Intent(DashBoard.this, TermAndConditions.class));
                        break;

                    case R.id.privacy:
                        startActivity(new Intent(DashBoard.this, PrivacyPolicy.class));
                        break;

                }
                return true;
            }
        });
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
       // transaction.addToBackStack(null);
        transaction.commit();
    }


    public void city(View view) {
        startActivity(new Intent(DashBoard.this,City_Select.class));
    }
}