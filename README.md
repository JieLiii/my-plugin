# my-plugin
IDEA插件开发
- Action ID: action 唯一 id，推荐 format: PluginName.ID
- Class Name: 要被创建的 action class 名称
- Name: menu item 的文本
- Description: action 描述，toolbar 上按钮的提示文本，可选
- Add to Group：选择新 action 要被添加到的 action group（Groups, Actions）以及相对其他 actions 的位置（Anchor）
- Keyboard Shortcuts：指定 action 的第一和第二快捷键
## 1. Components 类型
component类型 | 描述 | 需要实现的接口 | plugin.xml配置元素 | 对象获取方式
---|---|---|---|---
Application Component | 在IDEA启动时初始化，在IntelliJ IDEA程序中只有一个实例存在 | ApplicationComponent | <application-components> | Application实例的getComponent(Class)
Project Component | IDEA会为每一个Project实例创建project级别的Component | ProjectComponent | <project-components> | Project实例的getComponent(Class)
Module Component | IDEA会为已加载的Project中的每一个Module创建module级别的Component | ModuleComponent | <module-components> | Module实例的getComponent(Class)

## 2. 注册 Components
components 需要配置在 plugin.xml 中，并指定 interface 和 implementation，interface 类用于从其他组件中检索组件，implementation 类用于实例化组件。

```
<application-components>
    <component>
      <!-- 组件接口 -->
      <interface-class>service.DemoPluginRegistration</interface-class>
      <!-- 组件的实现类 -->
      <implementation-class>service.impl.DemoPluginRegistrationImpl</implementation-class>
    </component>
  </application-components>
```
## 3. Component 周期方法
- ### *ApplicationComponent 的生命周期方法：*

```
//构造方法
public constructor(){
}
//初始化
public void initComponent() {
}
//释放系统资源或执行其他清理
public void disposeComponent() {
}
```
- ### *ProjectComponent* 的生命周期方法：
```
//构造方法
public constructor(){
}
//通知一个project已经完成加载
public void projectOpened() {
}

public void projectClosed() {
}
//执行初始化操作以及与其他 components 的通信
public void initComponent() {
}
//释放系统资源或执行其他清理
public void disposeComponent() {
}
```
- ### *ModuleComponent* 的生命周期方法：

```
//构造方法
public constructor(){
}

//用于通知 module 已经被添加到 project 中
public void moduleAdded() {
}

//通知一个project已经完成加载
public void projectOpened() {
}

public void projectClosed() {
}
//执行初始化操作以及与其他 components 的通信
public void initComponent() {
}
//释放系统资源或执行其他清理
public void disposeComponent() {
}
```
