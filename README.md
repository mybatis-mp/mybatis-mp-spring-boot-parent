# mybatis-mp-spring-boot-parent

## 介绍
mybatis-mp springboot启动器，基于mybatis-spring-boot-starter改动，改动很小，只是替换成mybatis-mp的配置类

# 快速开始

## 1. 基于spring-boot开发 (已引入spring、springboot 基本依赖，创建SpringApplication.run即可启动)

### 1.1 springboot2 maven 集成

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>cn.mybatis-mp</groupId>
            <artifactId>mybatis-mp-spring-boot-parent</artifactId>
            <version>1.5.9-rc6</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

<dependencies>
    <dependency>
        <groupId>cn.mybatis-mp</groupId>
        <artifactId>mybatis-mp-spring-boot-starter</artifactId>
    </dependency>
</dependencies>
```

### 1.2 springboot3 maven 集成

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>cn.mybatis-mp</groupId>
            <artifactId>mybatis-mp-spring-boot-parent</artifactId>
            <version>1.5.9-rc6-spring-boot3</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

<dependencies>
    <dependency>
        <groupId>cn.mybatis-mp</groupId>
        <artifactId>mybatis-mp-spring-boot-starter</artifactId>
    </dependency>
</dependencies>
```

#### 1.3 数据源 配置

配置spring boot配置文件

```yaml
spring.datasource.url=jdbc:mysql://localhost/test
spring.datasource.username=dbuser
spring.datasource.password=dbpass
```

或者 自己实例一个 DataSource 也可以

```java

@Configuration(proxyBeanMethods = false)
public class DatasourceConfig {

    @Bean
    public DataSource getDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setName("test_db")
                .setType(EmbeddedDatabaseType.H2)
                .addScript("schema.sql")
                .build();
    }
}

```

### 其他配置(可不配置)

#### 数据库命名规则配置(可不配置，在项目启动时配置)

```java

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        MybatisMpConfig.setTableUnderline(true); //数据库表是否下划线规则 默认 true
        MybatisMpConfig.setColumnUnderline(true); ///数据库列是否下划线规则 默认 true
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

#### 数据库类型配置(可不配置，默认MYSQL)

```yaml
mybatis:
  configuration:
    databaseId: MYSQL
```

> 更多数据库支持，请查看类：db.sql.api.DbType

> 启动springboot即可，非常简单

### 一切都就绪，启动即可

> 1.添加此依赖，无需再添加mybatis依赖

> 2.包含 mybatis、mybatis-spring、 mybatis-spring-boot-starter 所有功能（支持原有mybatis的所有功能）

> 3.更多mybatis 配置参数，参考 https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/zh/index.html

> 4.参考示例：https://gitee.com/mybatis-mp/mybatis-mp/tree/master/mybatis-mp-spring-boot-demo

> 5.更多 mybatis 用法，参考：
> mybatis：https://mybatis.org/mybatis-3/zh/index.html
>
> mybatis spring: https://mybatis.org/spring/zh/index.html

> 6.更多mybatis-mp 用法，参考作者编写的test case:(包含各种简单，复杂的CRUD操作案例)
>
> https://gitee.com/mybatis-mp/mybatis-mp/tree/master/mybatis-mp-core/src/test/java/com/mybatis/mp/core/test/testCase
