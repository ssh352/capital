#### 启动方式


##### 下载npm包

```
(sudo) npm install 
```

##### 打包方式

修改/build/webpack.config.js的entry，选择你要打包的文件。

执行：

```
npm run build
```

##### 启动本地静态服务器

执行：

```
gulp connect
```

规定静态的服务器的域名为``dkf2e.tongbanjie.com``；配置host到127.0.0.1

所以需要再本地使用反向代理，绑定8892到80端口。