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
package com.osc.sample.service.impl;

import com.osc.sample.domain.City;
import com.osc.sample.dto.CityDto;
import com.osc.sample.exception.SampleException;
import com.osc.sample.repository.CityRepository;
import com.osc.sample.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jaeeon Bae
 * @version 1.0
 */
@Service
@Transactional
public class CityServiceImpl implements CityService {

    private static final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getCities() {
        return cityRepository.findAll();
    }

    @Override
    public CityDto getCity(Long id) {
        City city = cityRepository.findById(id).orElse(null);
        return new CityDto(city.getId(), city.getCountry(), city.getMap(), city.getName(), city.getState());
    }

    @Override
    @Transactional
    public CityDto createCity(CityDto cityDto) {
        City newCity = new City(cityDto.getCountry(), cityDto.getMap(), cityDto.getName(), cityDto.getState());
        cityRepository.save(newCity);

        return cityDto;
    }

    @Override
    @Transactional
    public CityDto modifyCity(Long id, CityDto cityDto) {
        City city = cityRepository.findById(id).orElse(null);
        city.setCountry(cityDto.getCountry());
        city.setMap(cityDto.getMap());
        city.setName(cityDto.getName());
        city.setState(cityDto.getState());

        return cityDto;
    }

    @Override
    @Transactional
    public CityDto removeCity(Long id) {
        CityDto cityDto = null;
        try {
            City city = cityRepository.findById(id).orElse(null);

            if (!StringUtils.isEmpty(city.getHotels())) {
                throw new SampleException("hotels in that city still exists.");
            }

            cityDto = new CityDto(city.getId(), city.getCountry(), city.getMap(), city.getName(), city.getState());
            cityRepository.delete(city);
        } catch (Exception e) {
            logger.error("Unhandled exception occurred while delete a city.", e);
        }

        return cityDto;
    }

}
//end of CityServiceImpl.java