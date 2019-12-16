package com.example.venteapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.venteapp.Model.Phone;
import com.example.venteapp.R;

public class ItemDetailsPhone extends AppCompatActivity {

    public class ItemDetailsActivity extends AppCompatActivity {


        @Override
        protected void onCreate ( Bundle savedInstanceState ) {
            super.onCreate( savedInstanceState );

            setContentView( R.layout.phone_item_details );
            ImageView icon = findViewById( R.id.icon_detail );
            TextView textView = findViewById( R.id.detail_text );
            TextView description = findViewById( R.id.Phone_description );

            Intent intent = getIntent();
            String value = intent.getStringExtra( "itemName" );
            String value1 = intent.getStringExtra( "itemStorage" );
           String Value2=intent.getStringExtra("itemColor");

            textView.setText( value );
            description.setText( value1 );

        }

    }
}