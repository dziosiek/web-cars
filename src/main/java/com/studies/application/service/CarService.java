package com.studies.application.service;

import com.studies.application.jpa.entity.Car;
import com.studies.application.jpa.entity.CarBrand;
import com.studies.application.jpa.repository.CarBrandRepository;
import com.studies.application.jpa.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;
    @Autowired
    CarBrandRepository carBrandRepository;

    public CarService(CarRepository carRepository, CarBrandRepository carBrandRepository) {
        this.carRepository = carRepository;
        this.carBrandRepository = carBrandRepository;
    }

    public CarService() {
    }

    public void initDB(){
        //INIT CAR_BRAND
        Set<String> brandNames = new HashSet<String>(){{
            add("Nissan");
            add("Alfa Romeo");
            add("BMW");
        }};

        List<CarBrand> carBrands = brandNames.stream()
                .map(name -> {
                    CarBrand cb = new CarBrand();
                    cb.setName(name);
                    return cb;
                }).collect(Collectors.toList());


        carBrandRepository.saveAll(carBrands);

        //INIT CAR

        CarBrand nissanBrand = carBrandRepository.findAll()
                .stream()
                .filter(carBrand -> carBrand.getName().equals("Nissan"))
                .findAny()
                .orElseGet(null);
        if(nissanBrand!=null){
            Car nissanCar = new Car();
            nissanCar.setFuelUsage(7.0);
            nissanCar.setModel("370z");
            nissanCar.setCarBrand(nissanBrand);
            Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
            nissanCar.setYearOfProduction(date);
            carRepository.save(nissanCar);
        }
    }
    public List<String> getCarBrands(){
        return carBrandRepository.findAll().stream().map(CarBrand::getName).collect(Collectors.toList());
    }
}
