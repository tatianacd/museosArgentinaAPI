package com.example.museosargentinaapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MuseoController {

    @GetMapping
    public List<Museo> listarMuseos(){

        RestTemplate apiMuseos = new RestTemplate();

        ListaMuseos listaMuseos = apiMuseos.getForObject("https://www.cultura.gob.ar/api/v2.0/museos/", ListaMuseos.class);

        return listaMuseos.getResults();
    }

    @GetMapping("nombres")
    public List<String> listarNombresMuseos(){
        RestTemplate apiMuseos = new RestTemplate();

        ListaMuseos listaMuseos = apiMuseos.getForObject("https://www.cultura.gob.ar/api/v2.0/museos/", ListaMuseos.class);

        return listaMuseos.getResults().stream().map(museo -> museo.getNombre()).toList();
    }

}
