package com.eweding.eweds.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.eweding.eweds.Adapter.CatergoryAllListAdapter;
import com.eweding.eweds.Adapter.VenderCatAdapter;
import com.eweding.eweds.R;

public class Vender_Category extends AppCompatActivity {

    RecyclerView recycleView_vender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R .layout.activity_vender_category);

        recycleView_vender=findViewById(R.id.recycleView_vender);


        VenderCatAdapter adapter = new VenderCatAdapter(this);
        recycleView_vender.setHasFixedSize(true);
        recycleView_vender.setLayoutManager(new LinearLayoutManager(this));
        recycleView_vender.setAdapter(adapter);




    }

    public void finish(View view) {
        finish();
    }
}