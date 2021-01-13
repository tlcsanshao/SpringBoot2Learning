### 主要测试了swagger2和knife4j的用法

#### 集成Swagger2
1. POM中加入swagger2和swagger-ui的依赖
2. @EnableSwagger2注解
3. 重要注解
```shell script
@Api：修饰整个类，描述Controller的作用
@ApiOperation：描述一个类的一个方法，或者说一个接口
@ApiParam：单个参数描述
@ApiModel：用对象来接收参数
@ApiModelProperty：用对象接收参数时，描述对象的一个字段

@ApiResponse：HTTP响应其中1个描述
@ApiResponses：HTTP响应整体描述
@ApiIgnore：使用该注解忽略这个API
@ApiError ：发生错误返回的信息
@ApiImplicitParam：一个请求参数
@ApiImplicitParams：多个请求参数
```
4. 访问地址：XXXX:XXXX/swagger-ui.html
5. 通过配置文件，可以做一些UI的信息修改


#### 集成Knife4j
1. pom文件中加入依赖
2. @EnableKnife4j注解
3. 访问地址：XXXX:XXXX/doc.html
