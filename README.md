
# 工程约定

##  1. 包名规范

包的前缀规则为:
```
com.qingguatang.transcript
```


### com.qingguatang.transcript.api
存放对外的http层接口
### com.qingguatang.transcript.control
存放API的实现类

### com.qingguatang.transcript.exception
存放业务异常

### com.qingguatang.transcript.model
存放业务模型

### com.qingguatang.transcript.util
存放业务工具类

### com.qingguatang.transcript.service
存放业务的service

### com.qingguatang.transcript.service.impl
存放service的实现类

### com.qingguatang.transcript.dao
存放数据库访问的接口

### com.qingguatang.transcript.dataobject
存放数据库层的模型


## 2. 工程规范
每一个业务，包含三个子工程

### api
提供api、service、model、exception等没有具体业务实现的声明，方便其他业务依赖该jar包

### dao
提供数据库层的接口和实现

### service
提供业务的实现层，所以control、impl等都在这个库里。 service工程会依赖api、dao两个工程，应用则依赖service工程

## 3. 单元测试
核心逻辑需要覆盖到，外部没办法完成的，可以暂时不处理


## 4. 数据库代码生成
默认添加了mybatis的generate实现，可以通过dao工程的` MybatisGenerateRun ` 这个类运行，生成dao、dataobject、xml。

需要注意的是 手工修改下`dao.properties`文件，改成你需要的表名，另外，不支持重复生成，所以只解决第一次初始化的问题

生成完后，需要再dao接口类上，手工添加 `@Mapper`,并完善注释
