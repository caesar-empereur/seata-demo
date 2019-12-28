# seata-demo
seata研究案例


### 项目结构
* 模拟一个创建订单的流程，包括库存，账号余额，积分
* springcloud + feign + consul
* seata-demo.sql 是项目运行需要的数据库表结构的脚本


### 模块说明
* web 是一个请求入口，处理用户请求，在这里面实现对其他服务的调用，模拟分布式事务的场景
* order 是订单服务，包括创建订单，订单查询
* storage 是库存服务，实现对sku库存的操作
* account 是账户服务，实现对用户下单后积分的处理
* common 是一个依赖的模块，不是启动项，seata 的配置文件放在这里面


### seata 官网文档里3个事务模式的个人理解
##### AT 模式
* 是指在 2 阶段提交模型中，会做一些**自动**处理
* 一阶段，业务数据与日志一起提交
* 二阶段提交，提交成功，回滚日志会**自动**删除
* 二阶段回滚，回滚日志，**自动**生成补偿操作以完成数据回滚

```
还长篇大论介绍了这个隔离级别，本地事务，全局事务的关联
写分离，提交本地事务之前必须获取全局锁，没有获得全局锁，本地事务不能提交
获取全局锁多次超时之后，必须回滚本地事务，释放本地事务锁
读分离，本地数据库的隔离级别是读提交，那全局事务是读未提交，如果全局事务需要读提交，需要自己实现
select for update, seata 检测到这个语法会处理
```

```
select for update 是处理读提交的一种方法，只有事务提交之后其他事务才能读
目的是为了在查库存与减库存之间还可以做一些操作逻辑，防止在中途被人修改了数据
```

##### TCC 模式
* TCC是服务化的两阶段编程模型，其Try、Confirm、Cancel 3个方法均由业务编码实现
* Try操作作为一阶段，负责资源的检查和预留
* Confirm操作作为二阶段提交操作，执行真正的业务
* Cancel是预留资源的取消
* 原本的一个接口，要改造为 3 个逻辑，Try-Confirm-Cancel
* 空回滚，悬挂，幂等都是需要考虑的
```
