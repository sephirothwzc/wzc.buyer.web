package wzc.buyer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import wzc.buyer.interceptor.ModuleApiWebInterceptorHandler;

/**
 * 2.0之后注册拦截器
 * @author 吴占超
 * @date 2018/10/21 2:17 PM
 */
@Configuration
public class RestfulApiConfig implements WebMvcConfigurer {

    @Bean
    ModuleApiWebInterceptorHandler moduleApiWebInterceptorHandler() {
        return new ModuleApiWebInterceptorHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(moduleApiWebInterceptorHandler());
    }
}
