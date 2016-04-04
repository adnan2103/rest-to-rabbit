package com.rabbit.post.controller;


import com.rabbit.post.gateway.Country;
import com.rabbit.post.gateway.PublishCountry;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CountryController {

    @Autowired
    private PublishCountry publishCountry;

    /**
     * Handles POST action to Create Country.
     *
     * @param country    Model
     * @return the created country as response.
     */
    @RequestMapping(
            value = "/api/v1/country",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    @ResponseBody
    public ResponseEntity createCountry(
            @RequestBody final Country country
    ) {
        System.out.println("Posting Counyty to Rabbit : " + country.getCountryId());
        publishCountry.publish(country);

        return new ResponseEntity<>(
                country,
                HttpStatus.CREATED
        );
    }

    /**
     * Handles POST action to Create Country.
     *
     * @return the created country as response.
     */
    @RequestMapping(
            value = "/api/v1/country",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    @ResponseBody
    public ResponseEntity getCountry() {

        Country country = new Country();
        country.setCountryId(12345678);

        return new ResponseEntity<>(
                country,
                HttpStatus.CREATED
        );
    }
}
