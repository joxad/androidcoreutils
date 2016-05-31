# Android project Template
This library is to use to quick start a new Android project that can handle :
 
 - Dagger 2
 - Retrofit 2
 - MVVM/ Databinding
 - Reactive
 - Somme Databases 

There is also some utily gradle tasks in order to manage the versioning, and to rename your .apk.

# How to Install

You will need Java 8 and at least version 1.5.1 of AndroidStudio

In the file local.properties, you will need to add the location of your java 8 installation, in order
to make retrolambda working

local.properties

```groovy
jdk.dir=/usr/lib/jvm/java-8-openjdk-amd64
sdk.dir=/home/josh/Documents/dev/android-sdk
keystore.file = keystore.jks
file.password = password
keystore.alias = alias
keystore.password = password

```
# Goals

The main goal is to start faster new projects with a lot of the common libs integrated from the start.



# Major libs used

- DataBinding 
In order to test MVVM on Android
- Dagger 2
- Rx 
- Realm (it seems it is a new DB that is going better, so need to test that)
- Retrofit

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