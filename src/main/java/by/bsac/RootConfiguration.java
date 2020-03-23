package by.bsac;

import by.bsac.domain.DatasourcesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static by.bsac.core.logging.SpringCommonLogging.*;

@Configuration("RootConfiguration")
@Import(DatasourcesConfiguration.class)
public class RootConfiguration {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(RootConfiguration.class);

    //Constructor
    public RootConfiguration() {
        LOGGER.info(INITIALIZATION.startInitializeConfiguration(RootConfiguration.class));
    }

}
