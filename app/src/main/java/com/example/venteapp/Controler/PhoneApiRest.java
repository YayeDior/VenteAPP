package com.example.venteapp.Controler;


import com.example.venteapp.Model.Phone;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface PhoneApiRest {
    @GET("vente.json")
    Call<List<Phone>> getListPhone();
}
