package com.pluralsight.bookstore.rest;

import com.pluralsight.bookstore.model.Book;
import com.pluralsight.bookstore.repository.BookRepository;

import javax.inject.Inject;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/books")
public class BookEndpoint {

    @Inject
    private BookRepository repository;

    @GET
    @Path("/{id: [0-9]*}")
    @Produces(APPLICATION_JSON)
    public Response getBook(@PathParam("id") @Min(1) Long id) {
        Book book = repository.find(id);
        if (book == null)
            return Response.noContent().build();
        return Response.ok(book).build();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public Response createBook(Book book, @Context UriInfo uriInfo) {
        System.out.println("createbook...");
        book = repository.create(book);
        System.out.println("book.."+book);
        URI createdURI = uriInfo.getBaseUriBuilder().path(book.getId().toString()).build();
        return Response.created(createdURI).build();
    }

    @DELETE
    @Path("/{id: [0-9]*}")
    public Response deleteBook(@PathParam("id") @Min(1) Long id) {
        repository.delete(id);
        return Response.noContent().build();
    }

    @GET
    @Produces(APPLICATION_JSON)
    public Response getBooks() {
        List<Book> books = repository.findAll();
        System.out.println("books: "+books.size());
        if (books.size() == 0)
            return Response.noContent().build();
        return Response.ok(books).build();
    }

    @GET
    @Path("/count")
    public Response countBooks() {
        System.out.println("count........ ");
        Long count = repository.countAll();
        if (count == 0)
            return Response.noContent().build();
        return Response.ok(count).build();
    }





}
