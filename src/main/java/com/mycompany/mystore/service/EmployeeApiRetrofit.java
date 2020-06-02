package com.mycompany.mystore.service;

import com.mycompany.mystore.dto.StatusDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface EmployeeApiRetrofit {

    @GET("/employee")
    Call<List<StatusDto>> get(@Path("id") String id);

}