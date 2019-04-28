package com.alvin.framework.applet.template.message.template;

import java.io.Serializable;

/**
 * datetime 2019/4/24 15:46
 *
 * @author sin5
 */
public class TemplateKeyword implements Serializable {
    private static final long serialVersionUID = -3487952237668979296L;

    private String value;
    private String color;

    public TemplateKeyword() {
    }

    public TemplateKeyword(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
