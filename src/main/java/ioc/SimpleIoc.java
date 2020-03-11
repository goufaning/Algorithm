package ioc;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SimpleIoc {

    public SimpleIoc(String location) throws Exception {
        loadBeans(location);
    }

    private Map<String, Object> beanMap = new HashMap<>();

    public Object getBean(String name) {
        Object bean = beanMap.get(name);
        if (bean == null) {
            throw new IllegalArgumentException("there is no bean with name " + name);
        }
        return bean;
    }

    public void registerBean(String name, Object bean) {
        beanMap.put(name, bean);
    }

    public void loadBeans(String location) throws Exception {
        InputStream inputStream = new FileInputStream(location);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputStream);
        Element root = doc.getDocumentElement();
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                String id = element.getAttribute("id");
                String className = element.getAttribute("class");
                Class beanClass = null;
                try {
                    beanClass = Class.forName(className);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    return;
                }
                Object bean = beanClass.newInstance();

                NodeList propertyNodeList = element.getElementsByTagName("property");
                for (int j = 0; j < propertyNodeList.getLength(); j++) {
                    Node propertyNode = propertyNodeList.item(j);
                    if (propertyNode instanceof Element) {
                        Element property = (Element) propertyNode;
                        String name = property.getAttribute("name");
                        String value = property.getAttribute("value");
                        Field declareField = bean.getClass().getDeclaredField(name);
                        declareField.setAccessible(true);
                        if (value != null && value.length() > 0) {
                            declareField.set(bean, value);
                        } else {
                            String ref = property.getAttribute("ref");
                            if (ref == null || ref.length() <= 0) {
                                throw new IllegalArgumentException("ref config error");
                            }
                            declareField.set(bean, getBean(ref));
                        }
                    }
                }
                registerBean(id, bean);
            }
        }
    }
}
