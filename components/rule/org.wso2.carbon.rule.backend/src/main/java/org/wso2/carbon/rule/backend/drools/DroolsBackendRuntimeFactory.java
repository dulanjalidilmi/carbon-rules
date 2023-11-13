/*
 * Copyright 2004,2005 The Apache Software Foundation.
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

package org.wso2.carbon.rule.backend.drools;

//import org.drools.KnowledgeBase;
//import org.drools.KnowledgeBaseConfiguration;
//import org.drools.KnowledgeBaseFactory;
//import org.drools.builder.KnowledgeBuilder;
//import org.drools.builder.KnowledgeBuilderConfiguration;
//import org.drools.builder.KnowledgeBuilderFactory;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.wso2.carbon.rule.kernel.backend.RuleBackendRuntime;
import org.wso2.carbon.rule.kernel.backend.RuleBackendRuntimeFactory;

import java.util.Map;
import java.util.Properties;

public class DroolsBackendRuntimeFactory implements RuleBackendRuntimeFactory{

    public RuleBackendRuntime getRuleBackendRuntime(Map<String, String> properties,
                                                    ClassLoader classLoader){
        Properties knowledgeBaseProperties = new Properties();
        knowledgeBaseProperties.putAll(properties);
        ClassLoader existingClassLoader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(classLoader);


        KieServices kieServices = KieServices.Factory.get();
        try {
            KieContainer kieContainer = kieServices.getKieClasspathContainer();
        } catch (Exception e) {
            throw new RuntimeException("Error while creating KieContainer", e);
        }
        System.out.println("ss");
//        KieBaseConfiguration kbaseConf = kieServices.newKieBaseConfiguration( knowledgeBaseProperties, classLoader);
//        KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
//        KieBase kbase = kieContainer.newKieBase(kbaseConf);



//        Thread.currentThread().setContextClassLoader(classLoader);

//        KieServices ks = KieServices.Factory.get();
//        try {
//            KieContainer kcontainer = ks.getKieClasspathContainer(properties, classLoader);
//            KieBase kbase = kcontainer.getKieBase();
//            System.out.println("ksession created");
//        } catch (Exception e) {
//            System.out.println("ksession creation failed");
//            System.out.println(e.getCause());
////            throw new RuntimeException(e.getMessage());
//        } finally {
//            Thread.currentThread().setContextClassLoader(classLoader);
//        }
//
//        KieServices ks2 = KieServices.Factory.get();
//        try {
//            KieContainer kcontainer2 = ks2.getKieClasspathContainer();
//            KieBase kbase2 = kcontainer2.getKieBase();
//            System.out.println("ksession2 created");
//        } catch (Exception e) {
//            System.out.println("ksession2 creation failed");
//            System.out.println(e.getCause());
////            throw new RuntimeException(e.getMessage());
//        } finally {
//            Thread.currentThread().setContextClassLoader(existingClassLoader);
//        }

//        Thread.currentThread().setContextClassLoader(classLoader);

//        Properties knowledgeBaseProperties = new Properties();
//        knowledgeBaseProperties.putAll(properties);

//        KieContainer kcontainer = ks.getKieClasspathContainer();
//        KieBase kbase = kcontainer.getKieBase();

//        KnowledgeBaseConfiguration knowledgeBaseConfiguration
//                = KnowledgeBaseFactory.newKnowledgeBaseConfiguration(knowledgeBaseProperties, classLoader);
//
//        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase(
//                knowledgeBaseConfiguration);
//        KnowledgeBuilderConfiguration builderConfiguration
//                = KnowledgeBuilderFactory.newKnowledgeBuilderConfiguration();
//
//        KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder(
//                builderConfiguration);

        KieServices kieServicess = KieServices.Factory.get();
        KieContainer kieContainerr = kieServicess.getKieClasspathContainer();
        KieBase kieBasee = kieContainerr.getKieBase();

        Thread.currentThread().setContextClassLoader(existingClassLoader);
        
        return new DroolsBackendRuntime(kieBasee, kieServicess , classLoader);
//        return null;
    }
}
