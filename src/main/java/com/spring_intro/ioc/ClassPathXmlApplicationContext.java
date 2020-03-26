package com.spring_intro.ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

                // Set initial default values for the object
                Iterator<Element> beanIter = element.elementIterator();
                while (beanIter.hasNext()) {
                    Element prop = beanIter.next();
                    String name = prop.attributeValue("name");
                    String valueStr = prop.attributeValue("value");
                    String ref = prop.attributeValue("ref");

                    if (ref == null) {
                        String methodName = "set" + name.substring(0,1).toUpperCase() + name.substring(1);
                        Field field = classes.getDeclaredField(name);
                        Method method = classes.getDeclaredMethod(methodName, field.getType());

                        // change the type of value
                        Object value = null;
                        if (field.getType().getName() == "long") {
                            value = Long.parseLong(valueStr);
                        } else if (field.getType().getName() == "int") {
                            value = Integer.parseInt(valueStr);
                        } else if (field.getType().getName() == "java.lang.String") {
                            value = valueStr;
                        }
                        method.invoke(object, value);
                    }
                    ioc.put(id, object);
                }
            }

            // do direct injection
            Iterator<Element> iter2 = root.elementIterator();
            while (iter2.hasNext()) {
                Element element = iter2.next();
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                // Use Reflection Mechanism to create Object
                Class classes = Class.forName(className);
                // Get Constructor with no params
                Constructor constructor = classes.getConstructor();
                Object object = constructor.newInstance();

                // Set initial default values for the object
                Iterator<Element> beanIter = element.elementIterator();
                while (beanIter.hasNext()) {
                    Element prop = beanIter.next();
                    String name = prop.attributeValue("name");
                    String valueStr = prop.attributeValue("value");
                    String ref = prop.attributeValue("ref");

                    String methodName = "set" + name.substring(0,1).toUpperCase() + name.substring(1);
                    Field field = classes.getDeclaredField(name);
                    Method method = classes.getDeclaredMethod(methodName, field.getType());
                    Object value = null;

                    // change the type of value
                    if (field.getType().getName() == "long") {
                        value = Long.parseLong(valueStr);
                    } else if (field.getType().getName() == "int") {
                        value = Integer.parseInt(valueStr);
                    } else if (field.getType().getName() == "java.lang.String") {
                        value = valueStr;
                    } else if (field.getType().getName() == "com.spring_intro.entity.Address") {
                        value = ioc.get("address");
                    }
                    method.invoke(object, value);
                    ioc.put(id, object);
                }
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
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String id) {
        return ioc.get(id);
    }
}
