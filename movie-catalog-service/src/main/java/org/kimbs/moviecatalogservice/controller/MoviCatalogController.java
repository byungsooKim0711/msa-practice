package org.kimbs.moviecatalogservice.controller;

import java.util.Collections;
import java.util.List;

import org.kimbs.moviecatalogservice.models.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class MoviCatalogController {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable(name = "userId") String userId) {
        return Collections.singletonList(
            new CatalogItem("Transformers", "Test", 4)
        );
    }
}