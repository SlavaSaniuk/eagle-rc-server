package by.bsac.webmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static by.bsac.core.logging.SpringCommonLogging.*;

@Configuration("WebmvcConfiguration")

@EnableWebMvc
public class WebmvcConfiguration implements WebMvcConfigurer {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(WebmvcConfiguration.class);

    //Constructor
    public WebmvcConfiguration() {
        LOGGER.info(INITIALIZATION.startInitializeConfiguration(WebmvcConfiguration.class));
    }



}
