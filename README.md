<div align="center">
    <h1> DexKit </h1>

[![license](https://img.shields.io/github/license/LuckyPray/DexKit.svg)](https://www.gnu.org/licenses/lgpl-3.0.html)
[![Maven Central](https://img.shields.io/maven-central/v/org.luckypray/dexkit.svg?label=Maven%20Central)](https://central.sonatype.com/search?q=dexkit&namespace=org.luckypray)

English | [简体中文](https://github.com/LuckyPray/DexKit/blob/master/README_zh.md)

</div>

A high-performance runtime parsing library for dex implemented in C++, used for lookup of obfuscated classes,
methods, or properties.

---

# Welcome to DexKit 2.0

> Special Note:
> - The current version is actively under development, and there may be instability and missing features.
> - Due to a project rewrite, comprehensive testing and validation haven't been performed, leading to potential issues.
> - If you need a stable version, please use version [1.1.8](https://github.com/LuckyPray/DexKit/tree/1.1.x).

## Supported APIs

Basic Features:

- [x] Multi-condition class search
- [x] Multi-condition method search
- [x] Multi-condition field search
- [x] Access annotations of classes/methods/properties/parameters

⭐️ Distinctive Features (Recommended):

- [x] Batch search of classes using strings
- [x] Batch search of methods using strings

> Note: Optimizations have been implemented for string search scenarios, significantly enhancing 
> search speed. Increasing query groups will not lead to a linear increase in time consumption.

### Dependencies

Add `dexkit` dependency in `build.gradle`. 

```gradle
repositories {
    mavenCentral()
}
dependencies {
    implementation 'org.luckypray:dexkit:<version>'
}
```

> **Note**
> ArtifactId of DexKit `2.0.0-alpha` is `dexkit`.

DexKit current version: [![Maven Central](https://img.shields.io/maven-central/v/org.luckypray/dexkit.svg?label=Maven%20Central)](https://central.sonatype.com/search?q=dexkit&namespace=org.luckypray)

## Usage Example

Here's a simple usage example.

Suppose this class is what we want to obtain, with most of its names obfuscated and changing in each version.

> Sample app:


```java
package org.luckypray.dexkit.demo;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.h;
import java.util.Random;
import org.luckypray.dexkit.demo.annotations.Router;

@Router(path = "/play")
public class PlayActivity extends AppCompatActivity {
    private final String a = "PlayActivity";
    private TextView b;
    private Handler c;

    public void d(View view) {
        Handler handler;
        int i;
        Log.d("PlayActivity", "onClick: rollButton");
        if (new Random().nextFloat() < 0.987f) {
            handler = this.c;
            i = 0;
        } else {
            handler = this.c;
            i = 114514;
        }
        handler.sendEmptyMessage(i);
    }

    public void e(boolean z) {
        int i;
        if (!z) {
            i = g.a();
        } else {
            i = 6;
        }
        String a = h.a("You rolled a ", i);
        this.b.setText(a);
        Log.d("PlayActivity", "rollDice: " + a);
    }

    protected void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        setContentView(0x7f0b001d);
        Log.d("PlayActivity", "onCreate");
        HandlerThread handlerThread = new HandlerThread("PlayActivity");
        handlerThread.start();
        this.c = new e(this, handlerThread.getLooper());
        this.b = (TextView) findViewById(0x7f080134);
        ((Button) findViewById(0x7f08013a)).setOnClickListener(new b(this));
    }
}
```

At this point, to obtain this class, you can use the following code:

> This is just an example, in actual usage, there's no need for such an extensive set of matching 
> conditions. Choose and use as needed to avoid unnecessary complexity in matching due to an 
> excessive number of conditions.

<details><summary>Java Example</summary>
<p>

```java
public class MainHook implements IXposedHookLoadPackage {
    
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        String packageName = loadPackageParam.packageName;
        String apkPath = loadPackageParam.appInfo.sourceDir;
        if (!packageName.equals("org.luckypray.dexkit.demo")) {
            return;
        }
        // need minSdkVersion >= 23
        System.loadLibrary("dexkit");
        try (DexKitBridge bridge = DexKitBridge.create(apkPath)) {
            bridge.findClass(FindClass.create()
                    // Search within the specified package name range
                    .searchPackages("org.luckypray.dexkit.demo")
                    // Exclude the specified package name range
                    .excludePackages("org.luckypray.dexkit.demo.annotations")
                    .matcher(ClassMatcher.create()
                            // ClassMatcher for class matching
                            .className("org.luckypray.dexkit.demo.PlayActivity")
                            // FieldsMatcher for matching properties within the class
                            .fields(FieldsMatcher.create()
                                    // Add a matcher for properties
                                    .add(FieldMatcher.create()
                                            .modifiers(Modifier.PRIVATE | Modifier.STATIC | Modifier.FINAL)
                                            .type("java.lang.String")
                                            .name("TAG")
                                    )
                                    .addForType("android.widget.TextView")
                                    .addForType("android.os.Handler")
                                    // Specify the number of properties in the class
                                    .count(3)
                            )
                            // MethodsMatcher for matching methods within the class
                            .methods(MethodsMatcher.create()
                                    // Add a matcher for methods
                                    .methods(List.of(
                                            MethodMatcher.create()
                                                    .modifiers(Modifier.PROTECTED)
                                                    .name("onCreate")
                                                    .returnType("void")
                                                    .parameterTypes("android.os.Bundle")
                                                    .usingStrings("onCreate"),
                                            MethodMatcher.create()
                                                    .parameterTypes("android.view.View")
                                                    .usingNumbers(
                                                            List.of(
                                                                    createInt(114514),
                                                                    createFloat(0.987f)
                                                            )
                                                    ),
                                            MethodMatcher.create()
                                                    .modifiers(Modifier.PUBLIC)
                                                    .parameterTypes("boolean")
                                    ))
                                    // Specify the number of methods in the class, a minimum of 4, and a maximum of 10
                                    .range(1, 10)
                            )
                            // AnnotationsMatcher for matching interfaces within the class
                            .annotations(AnnotationsMatcher.create()
                                    .add(AnnotationMatcher.create()
                                            .typeName("org.luckypray.dexkit.demo.annotations.Router")
                                            .addElement(
                                                    AnnotationElementMatcher.create()
                                                            .name("path")
                                                            .matcher(createString("/play"))
                                            )
                                    )
                            )
                            // Strings used by all methods in the class
                            .usingStrings("PlayActivity", "onClick", "onCreate")
                    )
            ).forEach(classData -> {
                // Print the found class: org.luckypray.dexkit.demo.PlayActivity
                System.out.println(classData.getClassName());
                // Get the corresponding class instance
                Class<?> clazz = classData.getInstance(loadPackageParam.classLoader);
            });
        }
    }
}
```

</p></details>

<details open><summary>Kotlin Example</summary>
<p>

```kotlin
class MainHook : IXposedHookLoadPackage {
    
    override fun handleLoadPackage(loadPackageParam: LoadPackageParam) {
        val packageName = loadPackageParam.packageName
        val apkPath = loadPackageParam.appInfo.sourceDir
        if (packageName != "org.luckypray.dexkit.demo") {
            return
        }
        // need minSdkVersion >= 23
        System.loadLibrary("dexkit")
        DexKitBridge.create(apkPath)?.use { bridge ->
            bridge.findClass {
                // Search within the specified package name range
                searchPackages = listOf("org.luckypray.dexkit.demo")
                // Exclude the specified package name range
                excludePackages = listOf("org.luckypray.dexkit.demo.annotations")
                // ClassMatcher for class matching
                matcher {
                    className = "org.luckypray.dexkit.demo.PlayActivity"
                    // FieldsMatcher for matching properties within the class
                    fields {
                        // Add a matcher for properties
                        add {
                            modifiers = Modifier.PRIVATE or Modifier.STATIC or Modifier.FINAL
                            type = "java.lang.String"
                            name = "TAG"
                        }
                        addForType("android.widget.TextView")
                        addForType("android.os.Handler")
                        // Specify the number of properties in the class
                        count = 3
                    }
                    // MethodsMatcher for matching methods within the class
                    methods {
                        // Add a matcher for methods
                        add {
                            modifiers = Modifier.PROTECTED
                            name = "onCreate"
                            returnType = "void"
                            parameterTypes = listOf("android.os.Bundle")
                            usingStrings = listOf("onCreate")
                        }
                        add {
                            parameterTypes = listOf("android.view.View")
                            usingNumbers {
                                addInt(114514)
                                addFloat(0.987f)
                            }
                        }
                        add {
                            modifiers = Modifier.PUBLIC
                            parameterTypes = listOf("boolean")
                        }
                        // Specify the number of methods in the class, a minimum of 4, and a maximum of 10
                        range = 1..10
                    }
                    // AnnotationsMatcher for matching interfaces within the class
                    annotations {
                        add {
                            typeName = "org.luckypray.dexkit.demo.annotations.Router"
                            elements {
                                add {
                                    name = "path"
                                    matcher {
                                        stringValue("/play")
                                    }
                                }
                            }
                        }
                    }
                    // Strings used by all methods in the class
                    usingStrings = listOf("PlayActivity", "onClick", "onCreate")
                }
            }.forEach {
                // Print the found class: org.luckypray.dexkit.demo.PlayActivity
                println(it.className)
                // Get the corresponding class instance
                val clazz = it.getInstance(loadPackageParam.classLoader)
            }
        }
    }
}
```

</p></details>

### Documentation

- [Click here]() Documentation is currently being written and might take some time.
- [DexKit API KDoc]() Documentation is currently being written and might take some time.

## Third-Party Open Source References

- [slicer](https://cs.android.com/android/platform/superproject/+/master:tools/dexter/slicer/export/slicer/)
- [ThreadPool](https://github.com/progschj/ThreadPool)
- [parallel-hashmap](https://github.com/greg7mdp/parallel-hashmap)

## License

[LGPL-3.0](https://www.gnu.org/licenses/lgpl-3.0.html) © LuckyPray
