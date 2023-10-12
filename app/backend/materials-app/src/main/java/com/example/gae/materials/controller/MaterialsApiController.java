package com.example.gae.materials.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gae.api.materials.controller.MaterialsApi;
import com.example.gae.api.materials.model.Material;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/materials-api/v1")
public class MaterialsApiController implements MaterialsApi {
    
    @Override 
    public ResponseEntity<List<Material>> materialsGet(
        @Parameter(name = "limit", description = "Limits the number of items on a page", in = ParameterIn.QUERY) @Valid @RequestParam(value = "limit", required = false) Integer limit,
        @Parameter(name = "offset", description = "Specifies the page number of the artists to be displayed", in = ParameterIn.QUERY) @Valid @RequestParam(value = "offset", required = false) Integer offset
    ){
        List<Material> list = new ArrayList<Material>();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
