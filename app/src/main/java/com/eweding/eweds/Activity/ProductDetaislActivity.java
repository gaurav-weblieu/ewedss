package com.eweding.eweds.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.eweding.eweds.Adapter.CatergoryAllListAdapter;
import com.eweding.eweds.Adapter.OurTipsAdapter;
import com.eweding.eweds.Adapter.ReviewAdapter;
import com.eweding.eweds.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class ProductDetaislActivity extends AppCompatActivity {

    RecyclerView recycleView_our_tips,recycleView_review,recycleView_similar_vender;
    //private LinearLayout linear_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detaisl);


        recycleView_our_tips=findViewById(R.id.recycleView_our_tips);
        recycleView_review=findViewById(R.id.recycleView_review);
        recycleView_similar_vender=findViewById(R.id.recycleView_similar_vender);
        //linear_layout=findViewById(R.id.line1);


        OurTipsAdapter ourTipsAdapter = new OurTipsAdapter(this);
        recycleView_our_tips.setHasFixedSize(true);
        recycleView_our_tips.setLayoutManager(new GridLayoutManager(this,2));
        recycleView_our_tips.setAdapter(ourTipsAdapter);

        ReviewAdapter reviewAdapter = new ReviewAdapter(this);
        recycleView_review.setHasFixedSize(true);
        recycleView_review.setLayoutManager(new LinearLayoutManager(this));
        recycleView_review.setAdapter(reviewAdapter);

        CatergoryAllListAdapter adapter = new CatergoryAllListAdapter(this);
        recycleView_similar_vender.setHasFixedSize(true);
        recycleView_similar_vender.setLayoutManager(new LinearLayoutManager(this));
        recycleView_similar_vender.setAdapter(adapter);

    }

    public void send(View view) {
        startActivity(new Intent(this,SendMessage.class));
    }

    public void see_all_elbum(View view) {
        startActivity(new Intent(this,Albmus_Activity.class));

    }


    private void showBottomSheetDialog() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.price_info_bottom_view);

        bottomSheetDialog.show();
    }

    public void see_price(View view) {
        showBottomSheetDialog();
    }

    public void finish(View view) {
        Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down);
        //linear_layout.startAnimation(slide_down);
        finish();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    public void call(View view) {
        Intent intentDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "123456789"));
        startActivity(intentDial);
    }

    private void setupWindowAnimations() {
        Slide slide = new Slide();
        slide.setDuration(1000);
        getWindow().setReturnTransition(slide);
    }
}