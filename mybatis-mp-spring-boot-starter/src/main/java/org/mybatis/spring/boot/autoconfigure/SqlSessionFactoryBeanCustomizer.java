/*
 *  Copyright (c) 2024-2025, Ai东 (abc-127@live.cn).
 *
 *  Licensed under the Apache License, Version 2.0 (the "License").
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and limitations under the License.
 *
 */
package org.mybatis.spring.boot.autoconfigure;

import org.mybatis.spring.SqlSessionFactoryBean;

/**
 * Callback interface that can be customized a {@link SqlSessionFactoryBean} object generated on auto-configuration.
 *
 * @author Kazuki Shimizu
 * @since 2.2.2
 */
@FunctionalInterface
public interface SqlSessionFactoryBeanCustomizer {

    /**
     * Customize the given a {@link SqlSessionFactoryBean} object.
     *
     * @param factoryBean the factory bean object to customize
     */
    void customize(SqlSessionFactoryBean factoryBean);

}
