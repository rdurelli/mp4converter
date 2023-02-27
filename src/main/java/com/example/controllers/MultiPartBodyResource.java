package com.example.controllers;


import com.example.MyEntity;
import com.example.models.MultiPartBody;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/convert")
public class MultiPartBodyResource {

    @Inject
    Logger logger;


    @POST
    public void convertMp4ToMp3(@Valid @MultipartForm MultiPartBody data) {
        logger.info("Starting converting mp4 to mp3 " + data);
        System.out.println(data);
    }

    @POST()
    @Path("/teste")
    @Consumes(MediaType.APPLICATION_JSON)
    public void testeJson(MyEntity my) {
        logger.info("teste " + my);
    }


}
