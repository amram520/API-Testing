package org.config;

import org.aeonbits.owner.Config;

@Config.Sources({"file:config.properties"})
public interface AutoConfig extends Config {

    @Key("base.url")
    @DefaultValue("http://localhost:8080/api/v3/")
    String baseUrl();

    @Key("api.key")
    String apiKey();

    @Key("book.base.url")
    @DefaultValue("https://restful-booker.herokuapp.com/")
    String bookBaseUrl();

    @Key("book.password")
    String bookPassword();

    @Key("student.base.url")
    String studentBaseUrl();

    @Key(("openProject.username"))
    String openProjectUsername();

    @Key("openProject.password")
    String openProjectPassword();

    @Key(("openProject.url"))
    String url();
}
