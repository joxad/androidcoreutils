# android-imports
List of imports used in several projects


In order to use it in your projects, just add imports.gradle in one of your folder.

Generally i put it in /gradle/tasks/

In your top build.gradle :

```groovy
apply from: 'gradle/tasks/imports.gradle'
```

Then in your project build.gradle, you can add the dependencies like this :

```groovy
    compile libs.stetho
    compile libs.stethoOkHttp
```

If you need to put transitive :

```groovy
  compile (libs.stetho) {
    transitive true
  }
```
