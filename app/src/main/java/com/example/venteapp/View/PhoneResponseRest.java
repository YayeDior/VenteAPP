package com.example.venteapp.View;

import com.example.venteapp.Model.Phone;

import java.util.List;

public class PhoneResponseRest {
    private List<Phone> PhoneItemList;

    public List<Phone>getPhoneItemList () {
        return PhoneItemList;
    }

    public void setPhoneItemList( Phone PhoneItemList) {
        this.PhoneItemList = (List <Phone>) PhoneItemList;
    }
}
