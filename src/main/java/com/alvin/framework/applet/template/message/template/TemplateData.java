package com.alvin.framework.applet.template.message.template;

import java.io.Serializable;

/**
 * datetime 2019/4/24 15:45
 *
 * @author sin5
 */
public class TemplateData implements Serializable {
    private static final long serialVersionUID = 1355849912166860454L;

    private TemplateKeyword keyword1;
    private TemplateKeyword keyword2;
    private TemplateKeyword keyword3;
    private TemplateKeyword keyword4;
    private TemplateKeyword keyword5;
    private TemplateKeyword keyword6;

    public TemplateData() {
    }

    public TemplateKeyword getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(TemplateKeyword keyword1) {
        this.keyword1 = keyword1;
    }

    public TemplateKeyword getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(TemplateKeyword keyword2) {
        this.keyword2 = keyword2;
    }

    public TemplateKeyword getKeyword3() {
        return keyword3;
    }

    public void setKeyword3(TemplateKeyword keyword3) {
        this.keyword3 = keyword3;
    }

    public TemplateKeyword getKeyword4() {
        return keyword4;
    }

    public void setKeyword4(TemplateKeyword keyword4) {
        this.keyword4 = keyword4;
    }

    public TemplateKeyword getKeyword5() {
        return keyword5;
    }

    public void setKeyword5(TemplateKeyword keyword5) {
        this.keyword5 = keyword5;
    }

    public TemplateKeyword getKeyword6() {
        return keyword6;
    }

    public void setKeyword6(TemplateKeyword keyword6) {
        this.keyword6 = keyword6;
    }

}
