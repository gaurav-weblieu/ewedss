package com.eweding.eweds.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.eweding.eweds.Activity.City_Select;
import com.eweding.eweds.Activity.Vender_Category;
import com.eweding.eweds.Adapter.CatergoryAdapter;
import com.eweding.eweds.Adapter.OurTipsAdapter;
import com.eweding.eweds.Adapter.PopularListAdapter;
import com.eweding.eweds.Adapter.SliderAdapterExample;
import com.eweding.eweds.Adapter.WeddingPlanAdapter;
import com.eweding.eweds.DataBindingModel.MainCategory;
import com.eweding.eweds.Interface.Last_cate_Interface;
import com.eweding.eweds.Pojo.ServiceListPojo;
import com.eweding.eweds.Pojo.SliderItem;
import com.eweding.eweds.R;
import com.eweding.eweds.ViewModel.ServiceViewModel;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements Last_cate_Interface {

    RecyclerView recycleView_category,recycleView_pre_wedding,recycleView_vender_bride,recycleView_vender_groom,
            recycleView_popular_features,recycleView_our_tips;

    LinearLayout line_van,line_city;

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    CardView cardView_main_cat;
    private SliderView sliderView;
    private SliderAdapterExample sliderAdapter;
    private ArrayList<Integer> arrayList_banner= new ArrayList<Integer>();
    private ServiceViewModel model;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);


        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        drawerLayout = view.findViewById(R.id.my_drawer_layout);
        sliderView = view.findViewById(R.id.imageSlider);
        NavigationView navigationView = view.findViewById(R.id.navigation_main);
       // navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar,
                R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        arrayList_banner.add(R.drawable.bannertwo);
        arrayList_banner.add(R.drawable.banner_two);
        arrayList_banner.add(R.drawable.banner_three);
        arrayList_banner.add(R.drawable.banner_one);

        recycleView_category=view.findViewById(R.id.recycleView_category);
        recycleView_pre_wedding=view.findViewById(R.id.recycleView_pre_wedding);
        recycleView_vender_bride=view.findViewById(R.id.recycleView_vender_bride);
        recycleView_vender_groom=view.findViewById(R.id.recycleView_vender_groom);
        recycleView_popular_features=view.findViewById(R.id.recycleView_popular_features);
        recycleView_our_tips=view.findViewById(R.id.recycleView_our_tips);
        line_van=view.findViewById(R.id.line_van);
        line_city=view.findViewById(R.id.line_city);
        cardView_main_cat=view.findViewById(R.id.cardView_main_cat);


        CatergoryAdapter adapter = new CatergoryAdapter(getActivity(),HomeFragment.this);
        recycleView_category.setHasFixedSize(true);
        recycleView_category.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recycleView_category.setAdapter(adapter);

        recycleView_vender_bride.setHasFixedSize(true);
        recycleView_vender_bride.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recycleView_vender_bride.setAdapter(adapter);

        recycleView_vender_groom.setHasFixedSize(true);
        recycleView_vender_groom.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recycleView_vender_groom.setAdapter(adapter);

        WeddingPlanAdapter adapter1 = new WeddingPlanAdapter(getActivity());
        recycleView_pre_wedding.setHasFixedSize(true);
        recycleView_pre_wedding.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recycleView_pre_wedding.setAdapter(adapter1);

        PopularListAdapter popularListAdapter = new PopularListAdapter(getActivity());
        recycleView_popular_features.setHasFixedSize(true);
        recycleView_popular_features.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recycleView_popular_features.setAdapter(popularListAdapter);


        OurTipsAdapter ourTipsAdapter = new OurTipsAdapter(getActivity());
        recycleView_our_tips.setHasFixedSize(true);
        recycleView_our_tips.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recycleView_our_tips.setAdapter(ourTipsAdapter);


        line_van.setOnClickListener(v -> startActivity(new Intent(getActivity(), Vender_Category.class)));


        sliderAdapter = new SliderAdapterExample(getActivity());
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();


        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
            }
        });

        List<SliderItem> sliderItemList = new ArrayList<>();
        //dummy data

        for (int i = 0; i < arrayList_banner.size(); i++) {
            SliderItem sliderItem = new SliderItem();
            sliderItem.setImageUrl(arrayList_banner.get(i));
            sliderItemList.add(sliderItem);
        }

        sliderAdapter.renewItems(sliderItemList);

        model = new ViewModelProvider(getActivity()).get(ServiceViewModel.class);
        model.getAllService(25).observe(getActivity(), new Observer<List<ServiceListPojo>>() {
            @Override
            public void onChanged(List<ServiceListPojo> address_lists) {
                if (address_lists!=null){

                }else {
                    Toast.makeText(getActivity(), "null data main", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }


    public void all_vender(View view) {
        startActivity(new Intent(getActivity(), Vender_Category.class));
    }

    public void city(View view) {
        startActivity(new Intent(getActivity(), City_Select.class));

    }

    @Override
    public void lastCat() {
        cardView_main_cat.setCardElevation(0);
    }

    @Override
    public void notLastCat() {
        cardView_main_cat.setCardElevation(12);

    }
}