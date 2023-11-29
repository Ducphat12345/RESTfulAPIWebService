package com.poly.controller;

import com.poly.entity.Category;
import com.poly.service.CategoryService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categories")
public class CategoryController {
    CategoryService categoryService = new CategoryService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategoryByID(@PathParam("id") int id){
        return categoryService.getCategoryByID(id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addCategory(Category category){
        return categoryService.addCategory(category) ? "add success!" : "add fail!";
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateCategory(Category category){
        return categoryService.updateCategory(category) ? "update success!" : "update fail!";
    }
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteCategory(@PathParam("id") int id){
        return categoryService.deleteCategory(id) ? "delete success!" : "delete fail!";
    }
}
