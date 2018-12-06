package com.promauto.wes.resources;

import com.promauto.wes.exceptions.CModuleNotFoundException;
import com.promauto.wes.models.CModule;
import com.promauto.wes.services.CModuleService;
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
@RequestMapping("/modules")
@Api(tags = "Modules", description = "Modules API")
public class CModulesResource {
    private final CModuleService moduleService;

    public CModulesResource(CModuleService service) {
        this.moduleService = service;
    }

    @GetMapping(value = "/{name}")
    @ApiOperation(value = "Find module",notes = "Find the module by Name")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Modules found"),
            @ApiResponse(code = 404,message = "Modules not found"),
    })
    public ResponseEntity<CModule> findOne(@PathVariable("name") String name) throws CModuleNotFoundException {
        return ResponseEntity.ok(this.moduleService.findOne(name));
    }


    @GetMapping
    @ApiOperation(value = "List modules",notes = "List all modules")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Modules found"),
            @ApiResponse(code = 404,message = "Modules not found")
    })
    public ResponseEntity<List<CModule>> findAll(){
        return ResponseEntity.ok(this.moduleService.findAll());
    }


}
