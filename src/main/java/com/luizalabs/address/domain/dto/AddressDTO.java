package com.luizalabs.address.domain.dto;

import com.luizalabs.address.domain.Address;
import com.luizalabs.address.domain.City;
import com.luizalabs.address.domain.State;

public class AddressDTO {

    private Integer id;
    private String road;
    private String district;
    private String cep;
    private City city;


    public AddressDTO(){

    }

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.road = address.getRoad();
        this.district = address.getDistrict();
        this.cep = address.getCep();
        this.city = address.getCity();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
