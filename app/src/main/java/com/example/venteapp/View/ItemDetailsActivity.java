package com.example.venteapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.venteapp.R;

public class ItemDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_item_details);
        ImageView icon =findViewById(R.id.icon_detail);
        TextView textView =findViewById(R.id.detail_text);
        TextView storage =findViewById(R.id.Phone_storage);
        TextView color =findViewById(R.id.Phone_color);
        Bundle bundle=this.getIntent().getExtras();
        int pic=bundle.getInt("image");

        Intent intent = getIntent();
        String value = intent.getStringExtra("itemName");
        String value1 = intent.getStringExtra("itemStorage");
        String value2 = intent.getStringExtra("itemColor");

        icon.setImageResource(pic);
        textView.setText(value);
        storage.setText(value1);
        color.setText(value2);

    }

}
