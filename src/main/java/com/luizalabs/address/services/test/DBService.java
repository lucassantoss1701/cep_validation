package com.luizalabs.address.services.test;

import com.luizalabs.address.domain.Address;
import com.luizalabs.address.domain.City;
import com.luizalabs.address.domain.State;
import com.luizalabs.address.repositories.AddressRepository;
import com.luizalabs.address.repositories.CityRepository;
import com.luizalabs.address.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    StateRepository stateRepository;

    public void instantitateDatabase(){
        State state = new State(null, "São Paulo");
        City city = new City(null, "Franca", state);
        Address address = new Address(null,"Rua Magalu", "LuizaLabs", "13167777", city);

        stateRepository.save(state);
        cityRepository.save(city);
        addressRepository.save(address);


        State state2 = new State(null, "Rio de Janeiro");
        City city2 = new City(null, "Rio de Janeiro", state2);
        Address address2 = new Address(null,"Rua Santos ", "Ipanema", "15400000", city2);

        stateRepository.save(state2);
        cityRepository.save(city2);
        addressRepository.save(address2);
    }
}
