package com.mycompany.mystore.service;

import com.mycompany.mystore.dto.ClientDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/client")
public interface ClientApi {

    @GET
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    ClientDto get(@PathParam("id") Long clientId);

//    @POST
//    @Path("/addmovie")
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    Response addMovie(Movie movie);
//
//    @PUT
//    @Path("/updatemovie")
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    Response updateMovie(Movie movie);
//
//    @DELETE
//    @Path("/deletemovie")
//    Response deleteMovie(@QueryParam("imdbId") String imdbId);
}