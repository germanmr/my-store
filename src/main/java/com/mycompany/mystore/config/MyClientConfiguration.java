package com.mycompany.mystore.config;

import com.mycompany.mystore.service.MyClientApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.Nonnull;

@Configuration
public class MyClientConfiguration implements WebMvcConfigurer {

    @Bean
    Retrofit provideRetrofit(@Nonnull @Value("${service.client.host}") String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();

    }

    @Bean
    MyClientApi provideClientApi(Retrofit retrofit) {
        return retrofit.create(MyClientApi.class);
    }


}
