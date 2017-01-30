package com.example.ravi.datecal.service;

import android.content.Context;

public class Util {
        public ServiceOperations getBaseClassService(Context ctx, String url){
            return new RetroHelper().getAdapter(ctx,url).create(ServiceOperations.class);
        }
}