package com.luizalabs.address.services.test;

import com.luizalabs.address.domain.Address;
import com.luizalabs.address.domain.City;
import com.luizalabs.address.domain.State;
import com.luizalabs.address.domain.User;
import com.luizalabs.address.repositories.AddressRepository;
import com.luizalabs.address.repositories.CityRepository;
import com.luizalabs.address.repositories.StateRepository;
import com.luizalabs.address.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private UserRepository userRepository;

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

        User user = new User("Lucas", "lucassantoss", "$2a$10$4xuWUlQV05DrcAsMD7Zji.3tfM9sX25hjs5JDX43q3ajmDbb2jMRy");

        userRepository.save(user);
    }
}
