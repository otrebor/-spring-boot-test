package com.example.gae.materials.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gae.api.materials.controller.MaterialsApi;
import com.example.gae.api.materials.model.Material;
import com.example.gae.common.services.GetTranslatedTextService;
import com.example.gae.framework.utilities.GlobalConstants;

import jakarta.validation.Valid;
import lombok.Getter;

@RestController
@RequestMapping(GlobalConstants.MATERIALS_API_CONTEXT_PATH)
public class MaterialsApiController implements MaterialsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MaterialsApiController.class);

    @Getter private GetTranslatedTextService getTranslatedTextService;

    public MaterialsApiController(final GetTranslatedTextService getTranslatedTextServiceIn) {
        this.getTranslatedTextService = getTranslatedTextServiceIn;
    }

    @Override 
    public final ResponseEntity<List<Material>> materialsGet(
        final @Valid @RequestParam(value = "limit", required = false) Integer limit,
        final @Valid @RequestParam(value = "offset", required = false) Integer offset
    ) {
        List<Material> list = new ArrayList<Material>();

        LOGGER.info("Materials Get invoked");
        // The proxy has a problem with final, i use the getter to bypass it
        LOGGER.info(this.getGetTranslatedTextService().invoke("test"));

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
