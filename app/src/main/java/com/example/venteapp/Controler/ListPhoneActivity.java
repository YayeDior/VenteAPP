package com.example.venteapp.Controler;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.venteapp.Model.Phone;
import com.example.venteapp.Model.PhoneItemAdapter;
import com.example.venteapp.R;
import com.example.venteapp.View.ItemDetailsPhone;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.venteapp.Model.Phone.getName;
import static com.example.venteapp.Model.Phone.getStorage;


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

        PhoneApiRest PhoneApiRest = retrofit.create( PhoneApiRest.class );
        Call<List<Phone>> call = PhoneApiRest.getListPhone();
        call.enqueue( new Callback<List<Phone>>() {
            @Override
            public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
                int resId = 0;


                Bundle bundle = null;

                Context context = null;



                showList(response.body(), null, null, resId );

            }

            @Override
            public void onFailure(Call<List<Phone>> call, Throwable t) {

            }
        } );
    }

    //get list view
    private void showList ( final List <Phone> listToDisplay, final Context context, final Bundle bundle, final int resId ){
        shopListView = findViewById( R.id.shop_list );
        layoutManager = new LinearLayoutManager( this );
        shopListView.setLayoutManager( layoutManager );
        mAdapter = new PhoneItemAdapter( this, listToDisplay );
        shopListView.setAdapter( mAdapter );

        shopListView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemDetailsPhone.class);
                intent.putExtra("itemName",getName());
                intent.putExtra("itemStorage",getStorage());
                intent.putExtra("itemColor",Phone.getColor());
                bundle.putInt("image",resId);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        } );


    }


}