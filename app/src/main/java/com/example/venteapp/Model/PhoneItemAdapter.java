package com.example.venteapp.Model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.venteapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhoneItemAdapter extends RecyclerView.Adapter<PhoneItemAdapter.ViewHolder>  {

    //fields
    public Context context;
    public List<Phone> PhoneItemList;
    public LayoutInflater inflater;
    Bundle bundle=new Bundle();

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView itemNameView;
        public TextView itemPriceView;
        public ImageView itemIconView;
        public TextView itemStorageView;
        public TextView itemColorView;
        RelativeLayout layout;


        public ViewHolder(View v) {
            super(v);
            layout = v.findViewById( R.id.shop_list);
            itemNameView = v.findViewById(R.id.item_name);
            itemPriceView = v.findViewById(R.id.item_price);
            itemIconView = v.findViewById(R.id.item_icon);
            itemStorageView = v.findViewById(R.id.item_storage);
            itemColorView = v.findViewById(R.id.item_color);
        }
    }

    public Phone getItem(int position) {
        return PhoneItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public int getItemCount() {
        return PhoneItemList.size();
    }

    public PhoneItemAdapter(Context context, List<Phone> PhoneItemList){
        this.PhoneItemList = PhoneItemList;
        this.context=context;
        this.inflater=LayoutInflater.from(context);
    }


    @Override
    public PhoneItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.adapter_item, parent,false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        //get item informations
        Phone currentItem = getItem(position);
        String tag =currentItem.getTag();
        final String itemStorage = currentItem.getStorage();
        final String itemName = currentItem.getName();
        final String itemColor = currentItem.getColor();
        final double itemPrice;
        itemPrice = currentItem.getPrice();

        //get icon view
        final String ressourceName = "item_" + tag + "_icon";
        final int resId=context.getResources().getIdentifier(ressourceName,"drawable",context.getPackageName());



        holder.itemIconView.setImageResource(resId);

        //get item name view
        holder.itemNameView.setText(itemName);

        //get item storage


        holder.itemStorageView.setText(itemStorage);

        //get item color view

        holder.itemColorView.setText(itemColor);

        //get item price view
        holder.itemPriceView.setText(itemPrice+"£");

        Picasso.with(context).load(currentItem.getImgUrl()).into(holder.itemIconView);


        };

    }

