package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:local.properties")
public interface LocalConfig extends Config {

    String device();
    @Key("os_version")
    String osVersion();

    String platformName();
    String appPackage();
    String appActivity();
    String url();
}
