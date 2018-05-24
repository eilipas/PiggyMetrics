package com.piggymetrics.account.controller;

import java.security.Principal;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import com.piggymetrics.account.domain.Account;
import com.piggymetrics.account.domain.User;
import com.piggymetrics.account.service.AccountService;

@ApplicationPath("/")
public class AccountController extends Application {

    @Inject
    private AccountService accountService;

    public AccountController() {
        System.out.println("gdgdfgdfgd");
    }

    // @PreAuthorize("#oauth2.hasScope('server') or #name.equals('demo')")
    @Path("/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccountByName(final String name) {
        System.out.println("cazz");
        System.out.println("cazz1");
        return accountService.findByName(name);
    }

    @GET
    @Path("/current")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getCurrentAccount(final Principal principal) {
        System.out.println("cazz5");
        return accountService.findByName(principal.getName());
    }

    @PUT
    @Path("/current")
    @Produces(MediaType.APPLICATION_JSON)
    public void saveCurrentAccount(final Principal principal, @Valid final Account account) {
        accountService.saveChanges(principal.getName(), account);
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Account createNewAccount(@Valid final User user) {
        return accountService.create(user);
    }
}
