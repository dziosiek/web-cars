package com.studies.application.controller;

import com.studies.application.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarsApplicationController {
    @Autowired
    CarService carService;
    @GetMapping(path = "/index")
    public String index(Model model) {
        carService.initDB();
        model.addAttribute("brands",carService.getCarBrands());
        return "index";
    }

    //Nieużywana metoda zastąpiona przez JSP
    @GetMapping(path = "/carlist-not-used")
    public String carList(@RequestParam(name = "typeOfCar") String typeOfCar,
                          @RequestParam(name = "carBrand") String carBrand,
                          @RequestParam(name = "yearOfProduction") String yearOfProduction,
                          @RequestParam(name = "fuelConsumption") String fuelConsumption) {



        return "carlist";
    }
}