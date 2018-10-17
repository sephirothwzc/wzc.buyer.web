package wzc.buyer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动类
 * @author 吴占超
 * @date 2018/10/16 5:17 PM
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class RestfulapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulapiApplication.class, args);
    }
}
