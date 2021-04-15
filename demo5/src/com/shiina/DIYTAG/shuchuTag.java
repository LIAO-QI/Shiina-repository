package com.shiina.DIYTAG;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class shuchuTag extends SimpleTagSupport {
    private Object value;

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().print(value);
        System.out.println(value);
    }
}
