/*
 * Copyright 2001-2004 The Apache Software Foundation.
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
 */
package org.apache.wsdl;

public interface WSDLConstants {

    public static final String WSDL2_0_NAMESPACE =
        "http://www.w3.org/2004/03/wsdl";

    public static final String WSDL1_1_NAMESPACE =
        "http://schemas.xmlsoap.org/wsdl/";

    public static final String[] WSDL_NAMESPACES =
        { WSDL2_0_NAMESPACE, WSDL1_1_NAMESPACE };

	//TODO Verify weather the value is right with the spec.
	
    public static final String WSDL_MESSAGE_DIRECTION_IN = "in";
    
	//TODO Verify weather the value is right with the spec. 
    
    public static final String WSDL_MESSAGE_DIRECTION_OUT = "out";
}