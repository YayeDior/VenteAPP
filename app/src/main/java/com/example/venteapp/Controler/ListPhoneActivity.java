package com.example.venteapp.Controler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.venteapp.Controler.PhoneApiRest;
import com.example.venteapp.Model.PhoneItem;
import com.example.venteapp.Model.PhoneItemAdapter;
import com.example.venteapp.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListPhoneActivity extends AppCompatActivity  {
    private RecyclerView shopListView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_list_phone);

            // API Gson
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit;
        retrofit = new Retrofit.Builder()
                .baseUrl( "https://raw.githubusercontent.com/YayeDior/YayeDior/master/" )
                .addConverterFactory( GsonConverterFactory.create( gson ) )
                .build();

        PhoneApiRest carApiRest = retrofit.create( PhoneApiRest.class );
            Call<List<PhoneItem>> call = carApiRest.getListPhone();
            call.enqueue( new Callback<List<PhoneItem>>() {
                @Override
                public void onResponse(Call<List<PhoneItem>> call, Response<List<PhoneItem>> response) {
                    showList(response.body());

                }

                @Override
                public void onFailure(Call<List<PhoneItem>> call, Throwable t) {

                }
            } );
        }

        //get list view
        private void showList(final List<PhoneItem> listToDisplay){
            shopListView = findViewById( R.id.shop_list );
            layoutManager = new LinearLayoutManager( this );
            shopListView.setLayoutManager( layoutManager );
            mAdapter = new PhoneItemAdapter( this, listToDisplay );
            shopListView.setAdapter( mAdapter );

        }


    }


