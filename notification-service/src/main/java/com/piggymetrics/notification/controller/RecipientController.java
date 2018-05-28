package com.piggymetrics.notification.controller;

import java.security.Principal;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.piggymetrics.notification.domain.Recipient;
import com.piggymetrics.notification.service.RecipientService;

@ApplicationPath("/recipients")
public class RecipientController extends Application {

    @Inject
    private RecipientService recipientService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Path("/current")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object getCurrentNotificationsSettings(final Principal principal) {
        return recipientService.findByAccountName(principal.getName());
    }

    @Path("/current2")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object getCurrentNotificationsSettings() {
        return "Hi from notification!";
    }

    @Path("/current")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object saveCurrentNotificationsSettings(final Principal principal, @Valid final Recipient recipient) {
        return recipientService.save(principal.getName(), recipient);
    }
}
