/*
 * Copyright 2003,2004 The Apache Software Foundation.
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
package org.apache.axis.description;

import javax.xml.namespace.QName;

import org.apache.axis.AbstractTestCase;
import org.apache.axis.engine.EngineRegistry;
import org.apache.axis.impl.description.FlowImpl;
import org.apache.axis.impl.description.ParameterImpl;
import org.apache.axis.impl.description.SimpleAxisOperationImpl;
import org.apache.axis.impl.description.SimpleAxisServiceImpl;
import org.apache.axis.impl.engine.EngineRegistryImpl;

/**
 * @author Srinath Perera(hemapani@opensource.lk)
 */
public class RegistryTest extends AbstractTestCase{
    private EngineRegistry reg;
    public RegistryTest(String testName) {
        super(testName);
    }
    
    

    public void testRegistry() throws Exception {
        AxisGlobal ag = new AxisGlobal();
        reg = new EngineRegistryImpl(ag);
        
        QName moduleName = new QName("module1");
        AxisModule modlue = new AxisModule(moduleName);
        reg.addMdoule(modlue);
        
        QName serviceName = new QName("service");
        AxisService service = new SimpleAxisServiceImpl(serviceName);
        reg.addService(service);       
        
        assertSame(modlue,reg.getModule(moduleName));
        assertSame(service,reg.getService(serviceName));
        assertSame(ag,reg.getGlobal());
 
    }
    public void testHandlerMedatata(){
        HandlerMetaData hmd = new HandlerMetaData();
        testParameteInClude(hmd);
    }

    public void testService(){
        AxisService service = new SimpleAxisServiceImpl(new QName("Service1"));
        testParameteInClude(service);
        testFlowIncludeTest(service);
    }    
    
    public void testModule(){
        AxisModule module = new AxisModule(new QName("module1"));
        testParameteInClude(module);
        testFlowIncludeTest(module);
    }    

    public void testOpeartion(){
        AxisOperation op = new SimpleAxisOperationImpl(new QName("op"));
        testParameteInClude(op);
    }    


    public void testParameteInClude(ParameterInclude parmInclude){
        String key = "value1";
        Parameter p = new ParameterImpl(key,"value2");
        parmInclude.addParameter(p);
        assertEquals(p,parmInclude.getParameter(key));
    }
    
    public void testFlowIncludeTest(FlowInclude flowInclude){
        Flow flow1 = new FlowImpl();
        Flow flow2 = new FlowImpl();
        Flow flow3 = new FlowImpl();
        
        flowInclude.setInFlow(flow1);
        flowInclude.setFaultFlow(flow2);
        flowInclude.setOutFlow(flow3);
        assertSame(flow1,flowInclude.getInFlow());
        assertSame(flow2,flowInclude.getFaultFlow());
        assertSame(flow3,flowInclude.getOutFlow());
    }
    
}