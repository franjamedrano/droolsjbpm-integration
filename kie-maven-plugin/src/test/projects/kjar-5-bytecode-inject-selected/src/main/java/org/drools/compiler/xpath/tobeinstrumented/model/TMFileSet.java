/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.drools.compiler.xpath.tobeinstrumented.model;

import java.util.HashSet;
import java.util.Set;

public class TMFileSet {
    private final String name;
    private final Set<TMFile> members = new HashSet<TMFile>();

    public TMFileSet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<TMFile> getFiles() {
        return members;
    }
}
