package com.example.gae.materials.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gae.api.materials.controller.MaterialsApi;
import com.example.gae.api.materials.model.Material;
import com.example.gae.common.services.GetTranslatedTextService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/materials-api/v1")
public class MaterialsApiController implements MaterialsApi {
    
    private static Logger LOGGER = LoggerFactory.getLogger(MaterialsApiController.class);
    
    private final GetTranslatedTextService getTranslatedTextService;
    
    @Autowired
    public MaterialsApiController(GetTranslatedTextService getTranslatedTextService){
        this.getTranslatedTextService = getTranslatedTextService;
    }
    @Override 
    public ResponseEntity<List<Material>> materialsGet(
        @Parameter(name = "limit", description = "Limits the number of items on a page", in = ParameterIn.QUERY) @Valid @RequestParam(value = "limit", required = false) Integer limit,
        @Parameter(name = "offset", description = "Specifies the page number of the artists to be displayed", in = ParameterIn.QUERY) @Valid @RequestParam(value = "offset", required = false) Integer offset
    ){
        List<Material> list = new ArrayList<Material>();
        
        LOGGER.info("Materials Get invoked");
        LOGGER.info(getTranslatedTextService.invoke("test"));
        
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
