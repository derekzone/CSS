# CSS
## content sell system
============================

网易校招新人培训平台作业，java开发工程师版。</br>
网易云课堂java开发工程师(Web方向)微专业作业
## 技术选型
#### 依赖及版本信息可在pom.xml查看
- Spring boot
- MySql
- Mybatis
- Druid
- Redis 用作缓存，缓存了Content和httpsession，使用Spring-cache注解
- FreeMarker

## 运行步骤
1. 修改`application.yml`中数据库、redis的配置
2. 初始化数据库(sql文件在resource-sql目录下)
3. mvn clean compile
4. mvn spring-boot:run

## 工程结构
### 配置文件
* `application.yml`中包含主要配置参数
* `com.derek.config`中有Druid、Mybatis、Redis、Spring MVC等配置

### ORM
* mapper在`com.derek.model.mapper`包中，使用注解实现
* 数据库字段对应的bean由maven插件`mybatis-generator-maven-plugin`自动生成，相关配置在`mybatis=generator.xml`中
## 异常处理
* `com.derek.exception`包中定义了异常
* 在`GlobalExceptionHandler`中有统一的异常处理


