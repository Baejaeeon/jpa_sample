/*
 * Copyright 2018 The Playce-WASUP Project.
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
 * Author			Date				Description
 * ---------------	----------------	------------
 * Sang-cheon Park	Dec 4, 2018		First Draft.
 */
package com.osc.sample.domain.naming;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * <pre>
 *
 * </pre>
 *
 * @author SangCheon Park
 * @version 1.0
 */
public class CustomPhysicalNamingStrategy implements PhysicalNamingStrategy {

    /**
     * To physical catalog name identifier.
     *
     * @param identifier the identifier
     * @param jdbcEnv    the jdbc env
     * @return the identifier
     */
    @Override
    public Identifier toPhysicalCatalogName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        return convertToSnakeCase(identifier);
    }

    /**
     * To physical column name identifier.
     *
     * @param identifier the identifier
     * @param jdbcEnv    the jdbc env
     * @return the identifier
     */
    @Override
    public Identifier toPhysicalColumnName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        return convertToSnakeCase(identifier);
    }

    /**
     * To physical schema name identifier.
     *
     * @param identifier the identifier
     * @param jdbcEnv    the jdbc env
     * @return the identifier
     */
    @Override
    public Identifier toPhysicalSchemaName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        return convertToSnakeCase(identifier);
    }

    /**
     * To physical sequence name identifier.
     *
     * @param identifier the identifier
     * @param jdbcEnv    the jdbc env
     * @return the identifier
     */
    @Override
    public Identifier toPhysicalSequenceName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        return convertToSnakeCase(identifier);
    }

    /**
     * To physical table name identifier.
     *
     * @param identifier the identifier
     * @param jdbcEnv    the jdbc env
     * @return the identifier
     */
    @Override
    public Identifier toPhysicalTableName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        return convertToSnakeCase(identifier);
    }

    /**
     * Convert to snake case identifier.
     *
     * @param identifier the identifier
     * @return the identifier
     */
    private Identifier convertToSnakeCase(final Identifier identifier) {
        if (identifier != null) {
            final String regex = "([a-z])([A-Z])";
            final String replacement = "$1_$2";
            final String newName = identifier.getText()
                    .replaceAll(regex, replacement)
                    .toLowerCase();

            return Identifier.toIdentifier(newName);
        } else {
            return identifier;
        }
    }
}