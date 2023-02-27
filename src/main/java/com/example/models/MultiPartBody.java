package com.example.models;

import lombok.Data;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import java.io.File;

@Data
public class MultiPartBody {

    @FormParam("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    @NotNull(message = "File must be provided")
    private File file;

    @FormParam("userName")
    @PartType(MediaType.TEXT_PLAIN)
    @NotNull(message = "user name must be provided")
    private String userName;
    @FormParam("notificationType")
    @PartType(MediaType.TEXT_PLAIN)
    @NotNull(message = "Notification type name must be provided")
    private NotificationType notificationType;

    @FormParam("phone")
    @PartType(MediaType.TEXT_PLAIN)
    @NotNull(message = "Phone type name must be provided")
    private String phone;

    @FormParam("fileName")
    @PartType(MediaType.TEXT_PLAIN)
    @NotNull(message = "File name must be provided")
    private String fileName;

    @FormParam("email")
    @PartType(MediaType.TEXT_PLAIN)
    @Email(message = "Email must be a valid one")
    @NotNull(message = "Email must be provided")
    private String email;

}
