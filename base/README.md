注意点：
1. pom.xml中依赖spring-boot-starter-parent，其又依赖于spring-boot-dependencies，此中包含了所有的版本依赖和版本号。
   如果需要改变版本号可以通过,如下方式修改
<properties>
    <java.version>11</java.version>
</properties>
2. 从pom.xml中的spring-boot-starter-web进入，找到其依赖spring-boot-starter，其中有个重要依赖spring-boot-autoconfigure。
   所有的自动装配都是从此包而来。

3. @Component
   @ConfigurationProperties(prefix = "student")
   
4. 