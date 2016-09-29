package com.example;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class DemoForm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 2)
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
