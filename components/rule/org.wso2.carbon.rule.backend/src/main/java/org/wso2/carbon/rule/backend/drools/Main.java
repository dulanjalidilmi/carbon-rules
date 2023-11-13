package org.wso2.carbon.rule.backend.drools;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Worldm,m!");
        KieServices ks = KieServices.Factory.get();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        KieContainer kcontainer = ks.getKieClasspathContainer();
        KieBase kbase = kcontainer.getKieBase();
        System.out.println("ksession created");
    }
}
