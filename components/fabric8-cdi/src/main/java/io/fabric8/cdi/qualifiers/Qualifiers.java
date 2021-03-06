/*
 * Copyright 2005-2014 Red Hat, Inc.                                    
 *                                                                      
 * Red Hat licenses this file to you under the Apache License, version  
 * 2.0 (the "License"); you may not use this file except in compliance  
 * with the License.  You may obtain a copy of the License at           
 *                                                                      
 *    http://www.apache.org/licenses/LICENSE-2.0                        
 *                                                                      
 * Unless required by applicable law or agreed to in writing, software  
 * distributed under the License is distributed on an "AS IS" BASIS,    
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or      
 * implied.  See the License for the specific language governing        
 * permissions and limitations under the License.
 */

package io.fabric8.cdi.qualifiers;

import java.lang.annotation.Annotation;

public final class Qualifiers {
    
    private Qualifiers() {
        //Utility
    }
   
    public static Annotation[] create(String serviceId, String protocol) {
        if (serviceId == null) {
            throw new IllegalArgumentException("Service Id cannot be null.");
        } else if (protocol == null) {
            return new Annotation[]{new ServiceNameQualifier(serviceId)};
        } else {
            return new Annotation[]{new ServiceNameQualifier(serviceId), new ProtocolQualifier(protocol)};
        }
    }
}
