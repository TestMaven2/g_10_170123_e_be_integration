package de.telran.g_10_170123_e_be_integration.controller;

import de.telran.g_10_170123_e_be_integration.entity.Vacancies;
import de.telran.g_10_170123_e_be_integration.entity.VacancySimple;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {

    private RestTemplate template = new RestTemplate();
    private String url = "https://api.hh.ru/vacancies";

    @GetMapping
    public List<VacancySimple> getVacancies() {
        RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET, URI.create(url));
        ResponseEntity<Vacancies> response = template.exchange(request, Vacancies.class);
        return response.getBody().getItems().stream().limit(5).toList();
    }
}