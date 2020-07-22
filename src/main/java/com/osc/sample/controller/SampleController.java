/*
 * Copyright 2020 The Sample-JPA Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Revision History
 * Author            Date                Description
 * ---------------  ----------------    ------------
 * Jaeeon Bae       7월 22, 2020            First Draft.
 */
package com.osc.sample.controller;

import com.osc.sample.domain.City;
import com.osc.sample.dto.CityDto;
import com.osc.sample.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jaeeon Bae
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api")
public class SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    private final CityService cityService;

    public SampleController(CityService cityService) {
        this.cityService = cityService;
    }

    /**
     * Gets list for Cities
     *
     * @return
     */
    @GetMapping(path = "/city")
    @ResponseBody
    public List<CityDto> cities() {
        List<City> cities = cityService.getCities();

        return cities.stream()
                .map(c -> new CityDto(c.getId(), c.getCountry(), c.getMap(), c.getName(), c.getState()))
                .collect(Collectors.toList());
    }

    /**
     * Gets City by city id
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/city/{id}")
    @ResponseBody
    public CityDto city(@PathVariable Long id) {
        return cityService.getCity(id);
    }

    /**
     * Create a City
     *
     * @param cityDto
     * @return
     */
    @PostMapping(path = "/city")
    @ResponseBody
    public CityDto createCity(@RequestBody CityDto cityDto) {
        return cityService.createCity(cityDto);
    }

    /**
     * Modify a City
     *
     * @param id
     * @param cityDto
     * @return
     */
    @PutMapping(path = "/city/{id}")
    @ResponseBody
    public CityDto modifyCity(@PathVariable Long id, @RequestBody CityDto cityDto) {
        return cityService.modifyCity(id, cityDto);
    }

    /**
     * Remove a City By city id
     *
     * @param id
     * @return
     */
    @DeleteMapping(path = "/city/{id}")
    @ResponseBody
    public CityDto removeCity(@PathVariable Long id) {
        return cityService.removeCity(id);
    }
}
//end of SampleController.java