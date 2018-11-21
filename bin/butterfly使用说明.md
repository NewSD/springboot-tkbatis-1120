##Butterfly RPC生成工具教程
###单独命令
	./butterfly --output <outputDir> --package   <packageName> --writer <SpringMVC|Retrofit> --input <inputDir> ```

###shell命令
     echo './butterfly server 生成server接口'
     echo './butterfly android 生成android接口'
     echo './butterfly ios 生成ios接口'
     echo './butterfly js 生成js枚举'

####常用注解
1. service 
   -  @uri("test") 接口的uri路径->/v1/test/接口名
   -  @uri(prefix="bapi",value="feedback") -> bapi/feedback/接口名?v=版本号
   -  @version(2) 接口版本号
   -  @ApiOperation 接口注释
   -  @ApiImplicitParam 接口参数注释
2. model
    - @NoBuilder 不生成Builder类

####支持数据类型
基本数据类型+List+Map+自定义Model
支持泛型生成

#####注释类型
类注释

```
/**
 *  订单
 * /
public class Deal{ }   	
```
   
//属性注释

```
例： int code //返回码
```


Service接口定义例子：

```
@uri(prefix="bapi",value="feedback")
service FeedbackService{
    @version(2)
	ReqResult commit(String content);
}
```

Model接口定义例子：

```
model ReqResult<T>{
	int code;
	String message;
	T data;
}
```

枚举定义例子：

```
enum Platfrom{
    ANDROID(1,"android");
    IOS(2,"ios");
    WP(3,"wp");
}
```
