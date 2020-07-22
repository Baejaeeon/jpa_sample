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
package com.osc.sample.service;

import com.osc.sample.domain.City;
import com.osc.sample.dto.CityDto;

import java.util.List;
import java.util.Optional;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jaeeon Bae
 * @version 1.0
 */
public interface CityService {

    List<City> getCities();

    CityDto getCity(Long id);

    CityDto createCity(CityDto cityDto);

    CityDto modifyCity(Long id, CityDto cityDto);

    CityDto removeCity(Long id);
}
//end of CityService.java