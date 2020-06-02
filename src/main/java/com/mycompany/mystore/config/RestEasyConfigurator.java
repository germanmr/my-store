package com.mycompany.mystore.config;

import com.mycompany.mystore.service.ClientApi;
import com.mycompany.mystore.service.EmployeeApi;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient4Engine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.core.UriBuilder;

@Configuration
public class RestEasyConfigurator {

    final String path = "http://dummy.restapiexample.com/api/v1";

    //    @Bean
    public void restEasyService() {

//        String transformerImdbId = "tt0418279";
//        Movie transformerMovie = new Movie("tt0418279", "Transformer 2");
//        final String path = "http://localhost:8080/my-client/";
//        final String path = "http://localhost:8080/my-client/";
        //http://dummy.restapiexample.com/api/v1/employee/1


        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(UriBuilder.fromPath(path));
        ClientApi clientApi = target.proxy(ClientApi.class);

// POST
//        Response moviesResponse = proxy.addMovie(transformerMovie);
//        System.out.println("HTTP code: " + moviesResponse.getStatus());
//        moviesResponse.close();

// GET
//        Movie movies = proxy.movieByImdbId(transformerImdbId);
        Long clientId = 1L;
        clientApi.get(clientId);

// PUT
//        transformerMovie.setTitle("Transformer 4");
//        moviesResponse = proxy.updateMovie(transformerMovie);
//        moviesResponse.close();
//
//// DELETE
//        moviesResponse = proxy.deleteMovie(batmanMovie.getImdbId());
//        moviesResponse.close();
    }

    @Bean
    public EmployeeApi employeeApi() {

//        final String path = "http://localhost:8080/my-client/";

        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        cm.setMaxTotal(200); // Increase max total connection to 200
        cm.setDefaultMaxPerRoute(20); // Increase default max connection per route to 20
        ApacheHttpClient4Engine engine = new ApacheHttpClient4Engine(httpClient);

        ResteasyClient client = new ResteasyClientBuilder().httpEngine(engine).build();
        ResteasyWebTarget target = client.target(UriBuilder.fromPath(path));
        return target.proxy(EmployeeApi.class);

    }

}
