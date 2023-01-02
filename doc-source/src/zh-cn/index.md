---
home: true
title: 首页
actions:
- text: 快速上手
  link: /zh-cn/guide/getting-started
  type: primary
- text: 项目简介
  link: /zh-cn/guide/home
  type: secondary
features:
- title: 简单易用
  details: 不需要学习任何字节码以及实现，遵循"IDE 的所见即所得"接口设计原则，即：依赖 IDE 提示， 可不需要文档就能迅速上手
- title: 高效
  details: 使用 C++ 实现，且默认启用多线程懒加载资源，尽最大可能使用算法优化性能损耗，速度是同类型工具的十倍甚至上百倍
- title: 跨平台
  details: 能够在多种平台使用，例如在 Windows、Linux 或者 MacOS 中进行测试，测试完成后再将逻辑移入 Android 平台
footer: LGPL-3.0 License | Copyright © 2022 LuckyPray
---

### 极致体验，拒绝繁琐

#### 样例 APP 代码

> 假设这是一个宿主 APP 的被混淆后的代码，我们需要对这个方法的 hook 进行动态适配，由于混淆的存在，可能每个版本方法名以及类名都会发生变化
```java
public class abc {
    
    public boolean cvc() {
        boolean b = false;
        // ...
        Log.d("VipCheckUtil", "info: xxxx");
        // ...
        return b;
    }
}
```

怎样简单快速的完成我们的需求？这时候我们的 `DexKit` 就派上用场了。

#### Hook 代码

> 通过创建 `DexKitBridge` 实例，我们可以对 APP 的 dex 进行特定的查找，但是切记实例化只需要进行一次，请自行存储，不要重复创建。
> 且在使用完毕后，需要调用 `DexKitBridge.close()` 方法，释放内存，否则会造成内存泄漏。

:::: code-group
::: code-group-item kotlin
```kotlin
@Throws(NoSuchMethodException::class)
fun vipHook() {
      val apkPath = hostApp.applicationInfo.sourceDir
      create(apkPath)?.use { bridge ->
          val deobfMap = mapOf(
              "VipCheckUtil_isVip" to setOf("VipCheckUtil", "userInfo:")
          )

          val resultMap = bridge.batchFindMethodsUsingStrings(map = deobfMap)
          val result = resultMap["VipCheckUtil_isVip"]!!
          assert(result.size == 1)

          val method: Method = methodDescriptor[0]
              .getMethodInstance(hostClassLoader)
          XposedBridge.hookMethod(method, XC_MethodReplacement.returnConstant(true))
      }
  }
```
:::
::: code-group-item java
```java
public void vipHook() throws NoSuchMethodException {
      String apkPath = HostInfo.getHostApp().getApplicationInfo().sourceDir;
      try (DexKitBridge bridge = DexKitBridge.create(apkPath)) {
          if (bridge == null) {
             return;
          }

          Map<String, List<String>> deobfMap = new HashMap<>();
          deobfMap.put("VipCheckUtil_isVip", List.of("VipCheckUtil", "userInfo:"));

          Map<String, List<DexMethodDescriptor>> resultMap = bridge.batchFindMethodsUsingStrings(
              deobfMap,
              true,
              null
          );

          List<DexMethodDescriptor> result = Objects.requireNonNull(resultMap.get("VipCheckUtil_isVip"));
          assert result.size() == 1;
          
          DexMethodDescriptor descriptor = result.get(0);
          Method isVipMethod = descriptor.get(0)
              .getMethodInstance(HostInfo.getHostClassLoader());
          XposedBridge.hookMethod(isVipMethod, XC_MethodReplacement.returnConstant(true));
      }
  }
```
:::
::::

怎么样？是不是很简单！只需短短几行代码就完成了动态混淆的适配。