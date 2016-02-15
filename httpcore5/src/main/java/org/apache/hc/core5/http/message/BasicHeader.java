/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package org.apache.hc.core5.http.message;

import java.io.Serializable;
import java.util.Objects;

import org.apache.hc.core5.annotation.Immutable;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.util.Args;

/**
 * Immutable {@link Header}.
 *
 * @since 4.0
 */
@Immutable
public class BasicHeader implements Header, Serializable {

    private static final long serialVersionUID = -5427236326487562174L;

    private final String name;
    private final String value;

    /**
     * Constructor with name and value
     *
     * @param name the header name
     * @param value the header value, taken as the value's {@link #toString()}.
     */
    public BasicHeader(final String name, final Object value) {
        super();
        this.name = Args.notNull(name, "Name");
        this.value = Objects.toString(value, null);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        final StringBuilder buf = new StringBuilder();
        buf.append(this.name).append(": ");
        if (this.value != null) {
            buf.append(this.value);
        }
        return buf.toString();
    }

}
