package by.bsac.webmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

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

    /**
     * Thymeleaf {@link org.thymeleaf.templateresolver.ITemplateResolver} implementation. Resolver configured
     * to get html template's from "src/main/resources/html" directory.
     * @return - configured {@link org.thymeleaf.templateresolver.ITemplateResolver} bean.
     */
    @Bean("TemplateResolver")
    @Order(1)
    public ITemplateResolver getClassLoaderTemplateResolver() {

        LOGGER.info(CREATION.startCreateBean(BeanDefinition.of(ClassLoaderTemplateResolver.class)));
        ClassLoaderTemplateResolver tr = new ClassLoaderTemplateResolver();

        tr.setPrefix("html/");
        tr.setSuffix(".html");

        tr.setCacheable(false);
        tr.setCharacterEncoding("UTF-8");
        tr.setTemplateMode(TemplateMode.HTML);

        LOGGER.info(CREATION.endCreateBean(BeanDefinition.of(ClassLoaderTemplateResolver.class)));
        return tr;
    }

    @Bean
    public ViewResolver getViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();

        resolver.setTemplateEngine(this.getSpringTemplateEngine());
        resolver.setOrder(1);

        return resolver;
    }

    @Bean
    public SpringTemplateEngine getSpringTemplateEngine() {

        LOGGER.info(CREATION.startCreateBean(BeanDefinition.of(SpringTemplateEngine.class)));
        SpringTemplateEngine engine = new SpringTemplateEngine();

        engine.setTemplateResolver(this.getClassLoaderTemplateResolver());
        engine.setEnableSpringELCompiler(true);

        LOGGER.info(CREATION.endCreateBean(BeanDefinition.of(SpringTemplateEngine.class)));
        return engine;
    }





}
