package com.promauto.wes.resources;

import com.promauto.wes.exceptions.CMainNotFoundException;
import com.promauto.wes.exceptions.CModuleNotFoundException;
import com.promauto.wes.models.CMain;
import com.promauto.wes.services.CMainService;
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
@RequestMapping("/main")
@Api(tags = "Main", description = "Main API")
public class CMainResources {
    private final CMainService mainService;

    public CMainResources(CMainService service) {
        this.mainService = service;
    }


    @GetMapping(value = "/{name}")
    @ApiOperation(value = "Find main",notes = "Find the main by Name")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Main found"),
            @ApiResponse(code = 404,message = "Main not found"),
    })
    public ResponseEntity<CMain> findOne(@PathVariable("name") String name) throws CMainNotFoundException, CModuleNotFoundException {
        return ResponseEntity.ok(this.mainService.findByName(name));
    }


    @GetMapping
    @ApiOperation(value = "List main",notes = "List all main")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Main found"),
            @ApiResponse(code = 404,message = "Main not found")
    })
    public ResponseEntity<List<CMain>> findAll(){
        return ResponseEntity.ok(this.mainService.findAll());
    }

}
