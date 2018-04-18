# 2018年 组件化开发项目

## 04月13日 项目初建
* 以“app”为空壳module
* library中收录着第三方module及基础module
* module中收录着项目的业务模块
* config.gradle中配置核心数据及模块开发的判断参数

## 04月18日 使用ARouter路由
* baselibrary中的配置
```
android {

    defaultConfig {
        ...

        //ARouter
        javaCompileOptions {
            annotationProcessorOptions {
                arguments = [ moduleName : project.getName() ]
            }
        }
    }

}

dependencies {
    ...

    //ARouter
    compile 'com.alibaba:arouter-api:1.2.1.1'
    annotationProcessor 'com.alibaba:arouter-compiler:1.1.2.1'
}
```
* login中的配置（使用ARouter的module中均如下配置）
```
android {

    defaultConfig {
        ...

        //ARouter
        javaCompileOptions {
            annotationProcessorOptions {
                arguments = [ moduleName : project.getName() ]
            }
        }
    }

}

dependencies {
    ...

    //ARouter(此时需要引入baselibrary)
    annotationProcessor 'com.alibaba:arouter-compiler:1.1.2.1'
    compile project(':library:baselibrary')

}
```