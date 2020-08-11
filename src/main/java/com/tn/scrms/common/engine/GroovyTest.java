package com.tn.scrms.common.engine;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.junit.Test;

/**
 * @Author: yangcs
 * @Date: 2020/8/11 8:43
 * @Description:
 */

public class GroovyTest {

    @Test
    public void testGroovyClassLoader() throws IllegalAccessException, InstantiationException {
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        String hello = "package com.szwn.util\n" + "\n" + "class GroovyHello {\n" + "    String sayHello(String name) {\n"
                + "        print 'GroovyHello call '\n" + "        name\n" + "    }\n" + "}";
        Class aClass = groovyClassLoader.parseClass(hello);
        GroovyObject object = (GroovyObject) aClass.newInstance();
        Object o = object.invokeMethod("sayHello", "zhangsan");
        System.out.println(o.toString());
    }
}
