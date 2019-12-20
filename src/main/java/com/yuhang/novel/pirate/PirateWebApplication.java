package com.yuhang.novel.pirate;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@MapperScan("com.yuhang.novel.pirate.dto.mapper")
public class PirateWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PirateWebApplication.class, args);
    }


    /**
     * 这段代码是为了解决，上传文件大于10M出现连接重置的问题。此异常内容 GlobalException 也捕获不到。
     * @return
     */
    @Bean
    public TomcatServletWebServerFactory tomcatEmbedded() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
                //-1 means unlimited
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });
        return tomcat;
    }

    /**
     * 配置跨域问题
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        // 允许cookies跨域
        config.setAllowCredentials(true);
        // 允许向该服务器提交请求的URI，*表示全部允许。。这里尽量限制来源域，比如http://xxxx:8080
        // ,以降低安全风险。。
        config.addAllowedOrigin("http://localhost:8081");
        config.addAllowedOrigin("http://www.suibiankanshu.com:8090");
        config.addAllowedOrigin("http://suibiankanshu.com:8090");
        config.addAllowedOrigin("http://localhost:63344");
        config.addAllowedOrigin("http://www.suibiankanshu.com:8088");
        config.addAllowedOrigin("http://www.suibiankanshu.com");
        // 允许访问的头信息,*表示全部
        config.addAllowedHeader("*");
        // 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
        config.setMaxAge(18000L);
        // 允许提交请求的方法，*表示全部允许，也可以单独设置GET、PUT等
        config.addAllowedMethod("GET");

        /*
         * config.addAllowedMethod("HEAD"); config.addAllowedMethod("GET");//
         * 允许Get的请求方法 config.addAllowedMethod("PUT");
         * config.addAllowedMethod("POST"); config.addAllowedMethod("DELETE");
         * config.addAllowedMethod("PATCH");
         */
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
