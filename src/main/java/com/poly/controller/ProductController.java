package com.poly.controller;

import com.poly.entity.Product;
import com.poly.service.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/products")
public class ProductController {
    ProductService productService = new ProductService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProductByID(@PathParam("id") int id){
        return productService.getProductByID(id);
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON})
    public String addProduct(Product product){
        return productService.addProduct(product) ? "add success!" : "add fail!";
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON})
    public String updateProduct(Product product){
        return productService.updateProduct(product) ? "update success!" : "update fail!";
    }
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteProduct(@PathParam("id") int id){
        return productService.deleteProduct(id) ? "delete success!" : "delete fail!";
    }
}
