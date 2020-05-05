package com.shiina.DIYTAG;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Calendar;

public class CopyrightTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().write("<div style='height:20px;position:absolute;bottom:5px;left:50%;transform:translateX(-50%);'>");
        getJspContext().getOut().write("Copyright© 2000-" + Calendar.getInstance().get(Calendar.YEAR) + " Shiina");
        getJspContext().getOut().write("</div>");
    }
}
