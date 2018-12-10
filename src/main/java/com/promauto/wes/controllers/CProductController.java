package com.promauto.wes.controllers;

import com.promauto.wes.exceptions.CProductNotFoundException;
import com.promauto.wes.models.CProduct;
import com.promauto.wes.services.CProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@Api(tags = "Products", description = "Products API")
public class CProductController {
    private final CProductService productService;

    public CProductController(CProductService service) {
        this.productService = service;
    }


    @GetMapping(value = "/{name}")
    @ApiOperation(value = "Find product",notes = "Find the product by Name")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Products found"),
            @ApiResponse(code = 404,message = "Products not found"),
    })
    public ResponseEntity<CProduct> findByName(@PathVariable("name") String name) throws CProductNotFoundException {
        return ResponseEntity.ok(this.productService.findByName(name));
    }


    @GetMapping
    @ApiOperation(value = "List products",notes = "List all products")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Products found"),
            @ApiResponse(code = 404,message = "Products not found")
    })
    public ResponseEntity<List<CProduct>> findAll(){
        return ResponseEntity.ok(this.productService.findAll());
    }



}
