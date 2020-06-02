package com.mycompany.mystore.config;

import com.mycompany.mystore.service.EmployeeApiRetrofit;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class GlobalConfiguration implements WebMvcConfigurer {


    //    private static final String BASE_URL = "https://api.github.com/";
    private static final String BASE_URL = "http://dummy.restapiexample.com/api/";

    private static Retrofit.Builder builder
            = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static OkHttpClient.Builder httpClient
            = new OkHttpClient.Builder();

    @Bean
    EmployeeApiRetrofit provideEmployeeApi() {
        return retrofit.create(EmployeeApiRetrofit.class);
    }


}
