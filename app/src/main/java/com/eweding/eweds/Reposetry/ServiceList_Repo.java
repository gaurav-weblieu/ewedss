package com.eweding.eweds.Reposetry;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.eweding.eweds.Pojo.ServiceListPojo;
import com.eweding.eweds.Pojo.ServiceModels;
import com.eweding.eweds.api_service.RetrofitServicesHandler;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceList_Repo {


    public MutableLiveData<List<ServiceListPojo>> Service_list;

    public MutableLiveData<List<ServiceListPojo>> getService_list(Integer id){

       Log.d("check","data"+id);

        Service_list = new MutableLiveData<>();

        Call<ServiceModels> myProductsCall = RetrofitServicesHandler
                .getInstance()
                .getApi()
                .getServices("");


        myProductsCall.enqueue(new Callback<ServiceModels>() {
            @Override
            public void onResponse(Call<ServiceModels> call, Response<ServiceModels> response) {
                if (response.body() != null) {
                    ServiceModels serviceModels = response.body();
                    if (!serviceModels.getService_list().isEmpty()) {

                        Service_list.postValue(serviceModels.getService_list());


                        Log.d("tag","Goog");


                    } else if (serviceModels.getService_list().isEmpty()) {
                        // Toast.makeText(Address_Activity.this, "empty", Toast.LENGTH_SHORT).show();

                        Service_list=null;
                        Log.d("tag","empty");



                    }
                } else if (response.body() == null) {
                    //  Toast.makeText(Address_Activity.this, "null", Toast.LENGTH_SHORT).show();

                    Log.d("tag","null");



                }
            }

            @Override
            public void onFailure(Call<ServiceModels> call, Throwable t) {


                Log.d("tag",t.toString());


            }
        });

        return Service_list;
    }

}
