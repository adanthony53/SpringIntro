package com.spring_intro.ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public class ClassPathXmlApplicationContext implements ApplicationContext {
    Map<String, Object> ioc = new HashMap<>();

    public ClassPathXmlApplicationContext(String path) {
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(path);
            Element root = document.getRootElement();
            Iterator<Element> iter = root.elementIterator();
            while (iter.hasNext()) {
                Element element = iter.next();
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                // Use Reflection Mechanism to create Object
                Class classes = Class.forName(className);
                // Get Constructor with no params
                Constructor constructor = classes.getConstructor();
                Object object = constructor.newInstance();
                ioc.put(id, object);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String id) {
        return ioc.get(id);
    }
}
