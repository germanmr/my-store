package com.mycompany.mystore.service;

import com.mycompany.mystore.dto.StatusDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/employee")
public interface EmployeeApi {

    @GET
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    StatusDto get(@PathParam("id") Long id);

}