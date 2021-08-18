package com.example.demo.examples.accessImages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*我们需要一个虚拟的路径映射到我们服务器中图片的地址，这样我们就可以通过这个虚拟地址和我们的图片的文件名称来访问我们上传的图片了。

        这里通过实现WebMvcConfigurer接口，来达到我们自定义资源映射的目的。创建一个配置类CustomWebConfiguration，内容如下：*/
@Configuration
public class CustomWebConfiguration implements WebMvcConfigurer {

    // 注入我们配置文件中写好的图片保存路径
    @Value("${user.filepath}")
    private  String filepath;

    // 自定义资源映射
    // 访问图片示例：http://localhost:3000/api/images/图片名称.jpg
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/api/images/**")
                .addResourceLocations("file:"+filepath);
    }

}
