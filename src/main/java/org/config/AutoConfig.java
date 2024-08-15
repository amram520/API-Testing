package org.config;

import org.aeonbits.owner.Config;

@Config.Sources({"file:config.properties"})
public interface AutoConfig extends Config {

    @Key("base.url")
    @DefaultValue("http://localhost:8080/api/v3/")
    String baseUrl();

    @Key("api.key")
    String apiKey();

}
