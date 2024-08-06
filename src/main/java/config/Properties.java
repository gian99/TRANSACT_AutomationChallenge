package config;

import org.aeonbits.owner.Accessible;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.ConfigCache;


@LoadPolicy(LoadType.MERGE)
@Sources("file:src/test/resources/config.properties")
public interface Properties extends Accessible{

    @Key("browser")
    String browser();
    @Key("url")
    String url();
    @Key("fullName")
    String fullName();
    @Key("email")
    String email();
    @Key("password")
    String password();
    @Key("telephone")
    String telephone();
    @Key("address")
    String address();
    @Key("city")
    String city();
    @Key("country")
    String country();
    @Key("province")
    String province();
    @Key("postcode")
    String postcode();
    @Key("baseURL")
    String baseURL();
    @Key("accessKey")
    String accessKey();
    static Properties getConfig(){return ConfigCache.getOrCreate(Properties.class);}
}
