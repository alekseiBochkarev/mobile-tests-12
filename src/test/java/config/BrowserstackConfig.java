package config;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:browserstack.properties")
public interface BrowserstackConfig extends Config {
    @Key("browserstack.user")
    String user();
    @Key("browserstack.key")
    String key();

    String project();
    String build();
    String name();
    String app();
    String device();
    @Key("os_version")
    String osVersion();

    @Key("url")
    String url();
}
