package com.example.demo.behavorial.template;

public abstract class HtmlTemplate {

    public String render(){
        return head() + body() + footer();
    }

    public abstract String head();

    public abstract String body();

    public abstract String footer();
}
