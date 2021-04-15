package com.shiina.DIYTAG;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class xunhuanTag extends SimpleTagSupport {

    private Map items;
    private String key;
    private String value;

    // set方法由容器调用，这里是tomcat
    public void setItems(Map items) { this.items = items; }
    public void setKey(String key) { this.key = key; }
    public void setValue(String value) { this.value = value; }

    @Override
    public void doTag() throws JspException, IOException {
        for (Object k:items.keySet()){
            getJspContext().setAttribute(key,k);
            getJspContext().setAttribute(value,items.get(k));
            getJspBody().invoke(null);
        }
    }

}