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
package com.osc.sample.exception;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jaeeon Bae
 * @version 1.0
 */
public class SampleException extends Exception {

    private static final long serialVersionUID = 4610406634943872782L;

    private Integer errorCode;

    /**
     * <pre>
     * Constructor of SampleException with message
     * </pre>
     */
    public SampleException() {
    }

    /**
     * <pre>
     * Constructor of SampleException with message
     * </pre>
     * @param message
     */
    public SampleException(String message) {
        super(message);
    }

    /**
     * <pre>
     * Constructor of SampleException with cause
     * </pre>
     * @param cause
     */
    public SampleException(Throwable cause) {
        super(cause);
    }

    /**
     * <pre>
     * Constructor of SampleException with errorCode & message
     * </pre>
     * @param errorCode
     * @param message
     */
    public SampleException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * <pre>
     * Constructor of SampleException with message and cause
     * </pre>
     * @param message
     * @param cause
     */
    public SampleException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the errorCode
     */
    public Integer getErrorCode() {
        return errorCode;
    }
}
//end of SampleException.java