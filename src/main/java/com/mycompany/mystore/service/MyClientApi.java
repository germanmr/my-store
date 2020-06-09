package com.mycompany.mystore.service;

import com.mycompany.mystore.dto.ClientDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import javax.annotation.Nonnull;

public interface MyClientApi {

    @GET("client/{id}")
    Call<ClientDto> get(@Nonnull @Path("id") Long id);

}