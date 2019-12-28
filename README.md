# seata-demo
seata研究案例


项目结构
>* 模拟一个创建订单的流程，包括库存，账号余额，积分
>* springcloud + feign + consul
>* seata-demo.sql 是项目运行需要的数据库表结构的脚本


模块说明
>* web 是一个请求入口，处理用户请求，在这里面实现对其他服务的调用，模拟分布式事务的场景
>* order 是订单服务，包括创建订单，订单查询
>* storage 是库存服务，实现对sku库存的操作
>* account 是账户服务，实现对用户下单后积分的处理
>* common 是一个依赖的模块，不是启动项，seata 的配置文件放在这里面


