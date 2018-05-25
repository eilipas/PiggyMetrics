package com.piggymetrics.notification.controller;

import com.piggymetrics.notification.domain.Recipient;
import com.piggymetrics.notification.service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.security.Principal;

@ApplicationPath("/recipients")
public class RecipientController {

	@Inject
	private RecipientService recipientService;

	@Path("/current")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getCurrentNotificationsSettings(Principal principal) {
		return recipientService.findByAccountName(principal.getName());
	}

	@Path("/current")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object saveCurrentNotificationsSettings(Principal principal, @Valid @RequestBody Recipient recipient) {
		return recipientService.save(principal.getName(), recipient);
	}
}
