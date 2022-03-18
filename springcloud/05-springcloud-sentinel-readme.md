现在用过来最顺畅的当属这个版本关系
我的nacos用的是1.4.3版的所以带来了很多的冲突，如指定的nacos端口配置未生效
各种奇怪的小小问题都是版本的兼容性问题，包括sentinel解析fegin带来的报错，等等

## 然后吧，我发现nacos用127.0.0.1做集群的地址时会出现一些不可抗拒的错误,改成对应的IP地址就ok了

## 下列是报错信息
```aidl
2022-03-18 19:10:12.651 ERROR [main :c.a.n.c.naming] [NA] failed to request
com.alibaba.nacos.api.exception.NacosException: <html><body><h1>Whitelabel Error Page</h1><p>This application has no explicit mapping for /error, so you are seeing this as a fallback.</p><div id='created'>Fri Mar 18 19:10:12 CST 2022</div><div>There was an unexpected error (type=Bad Request, status=400).</div><div>receive invalid redirect request from peer 127.0.0.1</div></body></html>
	at com.alibaba.nacos.client.naming.net.NamingProxy.callServer(NamingProxy.java:615) [nacos-client-1.4.2.jar:na]
	at com.alibaba.nacos.client.naming.net.NamingProxy.reqApi(NamingProxy.java:526) [nacos-client-1.4.2.jar:na]
	at com.alibaba.nacos.client.naming.net.NamingProxy.reqApi(NamingProxy.java:498) [nacos-client-1.4.2.jar:na]
	at com.alibaba.nacos.client.naming.net.NamingProxy.reqApi(NamingProxy.java:493) [nacos-client-1.4.2.jar:na]
	at com.alibaba.nacos.client.naming.net.NamingProxy.registerService(NamingProxy.java:246) [nacos-client-1.4.2.jar:na]
	at com.alibaba.nacos.client.naming.NacosNamingService.registerInstance(NacosNamingService.java:212) [nacos-client-1.4.2.jar:na]
	at com.alibaba.cloud.nacos.registry.NacosServiceRegistry.register(NacosServiceRegistry.java:74) [spring-cloud-starter-alibaba-nacos-discovery-2.2.6.RELEASE.jar:2.2.6.RELEASE]
	at org.springframework.cloud.client.serviceregistry.AbstractAutoServiceRegistration.register(AbstractAutoServiceRegistration.java:239) [spring-cloud-commons-2.2.6.RELEASE.jar:2.2.6.RELEASE]
	at com.alibaba.cloud.nacos.registry.NacosAutoServiceRegistration.register(NacosAutoServiceRegistration.java:78) [spring-cloud-starter-alibaba-nacos-discovery-2.2.6.RELEASE.jar:2.2.6.RELEASE]
	at org.springframework.cloud.client.serviceregistry.AbstractAutoServiceRegistration.start(AbstractAutoServiceRegistration.java:138) [spring-cloud-commons-2.2.6.RELEASE.jar:2.2.6.RELEASE]
	at org.springframework.cloud.client.serviceregistry.AbstractAutoServiceRegistration.bind(AbstractAutoServiceRegistration.java:101) [spring-cloud-commons-2.2.6.RELEASE.jar:2.2.6.RELEASE]
	at org.springframework.cloud.client.serviceregistry.AbstractAutoServiceRegistration.onApplicationEvent(AbstractAutoServiceRegistration.java:88) [spring-cloud-commons-2.2.6.RELEASE.jar:2.2.6.RELEASE]
	at org.springframework.cloud.client.serviceregistry.AbstractAutoServiceRegistration.onApplicationEvent(AbstractAutoServiceRegistration.java:47) [spring-cloud-commons-2.2.6.RELEASE.jar:2.2.6.RELEASE]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.doInvokeListener(SimpleApplicationEventMulticaster.java:172) [spring-context-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.invokeListener(SimpleApplicationEventMulticaster.java:165) [spring-context-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:139) [spring-context-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.publishEvent(AbstractApplicationContext.java:404) [spring-context-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.publishEvent(AbstractApplicationContext.java:361) [spring-context-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.boot.web.servlet.context.WebServerStartStopLifecycle.start(WebServerStartStopLifecycle.java:46) [spring-boot-2.3.2.RELEASE.jar:2.3.2.RELEASE]
	at org.springframework.context.support.DefaultLifecycleProcessor.doStart(DefaultLifecycleProcessor.java:182) [spring-context-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.context.support.DefaultLifecycleProcessor.access$200(DefaultLifecycleProcessor.java:53) [spring-context-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.context.support.DefaultLifecycleProcessor$LifecycleGroup.start(DefaultLifecycleProcessor.java:360) [spring-context-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.context.support.DefaultLifecycleProcessor.startBeans(DefaultLifecycleProcessor.java:158) [spring-context-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.context.support.DefaultLifecycleProcessor.onRefresh(DefaultLifecycleProcessor.java:122) [spring-context-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.finishRefresh(AbstractApplicationContext.java:895) [spring-context-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:554) [spring-context-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:143) [spring-boot-2.3.2.RELEASE.jar:2.3.2.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:758) [spring-boot-2.3.2.RELEASE.jar:2.3.2.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:750) [spring-boot-2.3.2.RELEASE.jar:2.3.2.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:397) [spring-boot-2.3.2.RELEASE.jar:2.3.2.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:315) [spring-boot-2.3.2.RELEASE.jar:2.3.2.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1237) [spring-boot-2.3.2.RELEASE.jar:2.3.2.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1226) [spring-boot-2.3.2.RELEASE.jar:2.3.2.RELEASE]
	at com.who.springcloud.Application.main(Application.java:13) [classes/:na]
```



参考这个文档：https://github.com/alibaba/spring-cloud-alibaba/wiki
可知相对应的版本关系，减少冲突