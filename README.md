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
* module间的路由跳转实现

1 `BaseApplication`中进行配置属性
```
    ARouter.openLog();//打开日志
            ARouter.openDebug();//打开debug调试
            ARouter.init(this);//初始化ARouter
```
2 在`ActivityIntentUtils`中设置跳转标识

3 路由跳转一般方法
```
    ARouter.getInstance()
            .build(ActivityIntentUtils.Login.FLAG_LOGIN)
            .navigation();
```
* config.gradle中配置Libraries

1 设置配置信息
```
ext {
    //android
    compileSdkVersion = 26
    buildToolsVersion = "27.0.3"

    //sdkSupport
    appcompatVersion = "26.1.0"
    constraintVersion = "1.0.2"

    sdkSupportDependencies = [
            appcompatV7 : "com.android.support:appcompat-v7:${appcompatVersion}",
            constraint  : "com.android.support.constraint:constraint-layout:${constraintVersion}"
    ]
}
```
2 关联文件
在根目录下的`build.gradle`中设置`apply from: "config.gradle"`

