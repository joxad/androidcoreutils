# Android project Template

This project an android library that is to be used as a module of your Android project.

> Main architecture idea packages:

- app (your application)
- core (this module)
- data (that will your core module to make the retrofit management)


> Installation 

From Scratch 

1. Create your project in android studio
2. Make a git init
3. Clone this project

```
git submodule add https://github.com/joxad/androidcoreutils.git
```

4. Update your app build.gradle

```
compile project(path: ':androidcoreutils:core')
```

5. Update your settings.gradle

```
include ':app', ':androidcoreutils:core'
```

6. Update your project build.gradle

```groovy
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        jcenter()
        mavenCentral()
        maven { url "http://dl.bintray.com/joxad/maven" }

    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.3.1'
        classpath 'me.tatarka:gradle-retrolambda:3.6.1'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        jcenter()
        mavenCentral()
        maven { url "http://dl.bintray.com/joxad/maven" }

    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}



ext {
    androidCompileSdkVersion = 25
    androidBuildToolsVersion = '25.0.2'
    androidMinSdkVersion = 21
    androidTargetSdkVersion = 25
}

apply from: 'androidcoreutils/gradle/tasks/versioning.gradle'
apply from: 'androidcoreutils/gradle/tasks/imports.gradle'
apply plugin: 'me.tatarka.retrolambda'

```




> Gradle imports

In the folder /gradle/tasks, you will find a lot of usefull librairies.

For example You can then add it into your project with :

compile libs.rxPermissions

# Contributing 

Feel free to contribute to this project :) Pull request are welcome !

# Contact & Questions

If you have any questions, fell free to send me a mail.

#  License

The MIT License (MIT)

Copyright (c) 2016 Jocelyn David

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
