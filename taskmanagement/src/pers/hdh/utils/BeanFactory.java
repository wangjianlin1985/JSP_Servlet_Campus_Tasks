// 
// 
// 

package pers.hdh.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory
{
    public static Object getBean(final String name) {
        try {
            final Document doc = new SAXReader().read(BeanFactory.class.getClassLoader().getResourceAsStream("mybeans.xml"));
            final Element e = (Element)doc.selectSingleNode("//bean[@id='" + name + "']");
            final String value = e.attributeValue("class");
            return Class.forName(value).newInstance();
        }
        catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
