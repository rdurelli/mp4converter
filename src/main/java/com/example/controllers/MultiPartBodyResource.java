package com.example.controllers;


import com.example.MyEntity;
import com.example.exceptions.StorageException;
import com.example.models.MultiPartBody;
import com.example.models.Payload;
import com.example.models.Status;
import com.example.services.PayloadService;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/v1/convert")
public class MultiPartBodyResource {

    @Inject
    Logger logger;

    @Inject
    PayloadService payloadService;

    @POST
    @Transactional
    @RolesAllowed({"manager"})
    public void convertMp4ToMp3(@Valid @MultipartForm MultiPartBody data) throws StorageException {
        logger.info("Starting converting mp4 to mp3 " + data);
        var payloadToPersist = Payload.multiPartToPayload(data);

        payloadToPersist.setStatus(Status.converting);
        payloadToPersist.persist();
        payloadService.sendObjectToStorage(payloadToPersist, data.getFile());
        logger.info("Payload created " + payloadToPersist);
    }

    @GET
    public List<Payload> getAllPayload() {
        logger.info("Getting all payload ");
        return Payload.listAll();
    }

    @POST()
    @Path("/teste")
    @Consumes(MediaType.APPLICATION_JSON)
    public void testeJson(MyEntity my) {
        logger.info("teste " + my);
    }

}
