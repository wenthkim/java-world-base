> Kafka的常用参数配置

##### Broker参数
|参数|配置样例|描述|
|---|:---:|:---:|
|log.dirs|/data/kafka1,/data/kafka2|kafka数据存放的目录，可以配置多个，有条件每个目录可挂载到不同机器上，提高读写性能，实现故障转移。|
|zookeeper.connect|zk1:2181,zk2:2181,zk3:2181|zookeeper连接地址，当两套kafka集群连同一个zk集群时，假设kafka1,kafka2。如下配置zk1:2181,zk2:2181,zk3:2181/kafka1;zk1:2181,zk2:2181,zk3:2181/kafka2|
|advertised.listeners|PLAINTEXT://myhost:9092|暴露给外部的listeners,主要给外网使用，如果没有设置，会用listeners|
|listeners|PLAINTEXT://myhost:9092, PLAINTEXT://0.0.0.0:9092, TRACE://localhost:9093|通过什么协议进行连接，主要用作内网连接|
|host.name|myhost|ip或主机名，已过期，使用上面两个|
|port|9092|已过期，使用advertised.listeners或listerners|

##### Topic管理
|参数|配置样例|描述|
|---|:---:|:---:|
|auto.create.topic.enable|true/false|是否自动创建Topic,建议设置成false|
|unclean.leader.election.enable|true/false|是否允许Unclean Leader选举，多个副本中，是否允许数据落后太多的进行leader选举，建议设置成false|
|auto.leader.rebalance.enable|true/false|是否允许定期进行Leader选举，由于变换Leader成本高,建议设置成false|

##### 数据留存
|参数|配置样例|描述|
|---|:---:|:---:|
|log.retention.{hour\|minutes\|ms}|log.retention.hour=168|控制消息保存多久，优先级ms>minutes>hour|
|log.retention.bytes|-1|broker数据存放的总大小，默认-1，代表不限制。|
|message.max.bytes|1000012|一条消息的容量最大值，默认1M不到|

##### Topic级别参数(设置了会覆盖Broker设置的参数，不同Topic设置不一样的，更加灵活)
|参数|配置样例|描述|
|---|:---:|:---:|
|log.retention.{hour\|minutes\|ms}|log.retention.hour=168|控制消息保存多久，优先级ms>minutes>hour|
|log.retention.bytes|-1|broker数据存放的总大小，默认-1，代表不限制。|
|message.max.bytes|1000012|一条消息的容量最大值，默认1M不到|
> 创建Topic时指定参数 
```
 bin/kafka-configs.sh --zookeeperlocalhost:2181 --entity-type topics --entity-name transaction --alter --add-config max.message.bytes=10485760
```
> 使用kafka-configs修改
```
 bin/kafka-configs.sh --zookeeper localhost:2181 --entity-type topics --entity-name transaction --alter --add-config max.message.bytes=10485760
```

##### JVM参数 
|参数|配置样例|描述|
|---|:---:|:---:|
|KAFKA_HEAP_OPTS|--Xms6g  --Xmx6g|JVM堆的参数，ms堆的大小，mx堆的最大值|
|KAFKA_JVM_PERFORMANCE_OPTS|-XX:+UseG1GC -XX:MaxGCPauseMillis=20|指定GC参数|
>启动之前先设置JVM参数值
```
export KAFKA_HEAP_OPTS=--Xms6g  --Xmx6g
export KAFKA_JVM_PERFORMANCE_OPTS= -server -XX:+UseG1GC -XX:MaxGCPauseMillis=20 -XX:InitiatingHeapOccupancyPercent=35 -XX:+ExplicitGCInvokesConcurrent -Djava.awt.headless=true
bin/kafka-server-start.sh config/server.properties
```