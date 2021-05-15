package com.luizalabs.address.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luizalabs.address.domain.Address;
import com.luizalabs.address.domain.City;
import com.luizalabs.address.domain.State;
import com.luizalabs.address.repositories.AddressRepository;
import com.luizalabs.address.repositories.CityRepository;
import com.luizalabs.address.repositories.StateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressControllerTest {

    private final ObjectMapper jsonMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void should_address_by_cep() throws Exception {
        State state = new State(null, "São Paulo");
        City city = new City(null, "Artur Nogueira", state);
        Address address = new Address(null, "Rua Albertino Stocco", "Coração Criança", "13167616", city);

        stateRepository.save(state);
        cityRepository.save(city);
        addressRepository.save(address);

        mockMvc.perform(get("/address/ceps/13167616")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.road", is("Rua Albertino Stocco")))
                .andExpect(jsonPath("$.district", is("Coração Criança")))
                .andExpect(jsonPath("$.cep", is("13167616")))
                .andExpect(jsonPath("$.city.name", is("Artur Nogueira")))
                .andExpect(jsonPath("$.city.state.name", is("São Paulo")));
    }


    @Test
    void should_address_by_cep_passing_cep_invalid_but_similar() throws Exception {
        State state = new State(null, "São Paulo");
        City city = new City(null, "Artur Nogueira", state);
        Address address = new Address(null, "Rua Albertino Stocco", "Coração Criança", "13168000", city);

        stateRepository.save(state);
        cityRepository.save(city);
        addressRepository.save(address);

        mockMvc.perform(get("/address/ceps/13167616")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.road", is("Rua Albertino Stocco")))
                .andExpect(jsonPath("$.district", is("Coração Criança")))
                .andExpect(jsonPath("$.cep", is("13160000")))
                .andExpect(jsonPath("$.city.name", is("Artur Nogueira")))
                .andExpect(jsonPath("$.city.state.name", is("São Paulo")));
    }


    @Test
    void should_address_by_cep_passing_cep_invalid() throws Exception {
        State state = new State(null, "São Paulo");
        City city = new City(null, "Artur Nogueira", state);
        Address address = new Address(null, "Rua Albertino Stocco", "Coração Criança", "13160000", city);

        stateRepository.save(state);
        cityRepository.save(city);
        addressRepository.save(address);

        mockMvc.perform(get("/address/ceps/18167845")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.msg", is("CEP Inválido!")));
    }
}
