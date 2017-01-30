package com.example.ravi.datecal.service;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ServiceOperations {

    @FormUrlEncoded
    @POST("doctorapp_services/bookAppointments")
    Call<Example> bookAppointment(@Field("doctor_id") String dId, @Field("patient_id") String patientId, @Field("schedule_time") String sId, @Field("schedule_date") String sDate);
}