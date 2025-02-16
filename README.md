# TProxy

[![Maven Central Version](https://img.shields.io/maven-central/v/one.tranic/t-proxy)](https://central.sonatype.com/artifact/one.tranic/t-proxy)
[![javadoc](https://javadoc.io/badge2/one.tranic/t-proxy/javadoc.svg)](https://javadoc.io/doc/one.tranic/t-proxy)

TProxy is used to quickly read proxy information from system settings and environment variables.

No need to install TLIB Base, need Java 17.

## Install
Please use shadow to remap TProxy to your own path to avoid conflicts with other libraries/plugins using TProxy.

`maven`

```xml
<dependency>
    <groupId>one.tranic</groupId>
    <artifactId>t-proxy</artifactId>
    <version>[VERSION]</version>
</dependency>
```

`Gradle (Groovy)`
```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'one.tranic:t-proxy:[VERSION]'
}
```

`Gradle (Kotlin DSL)`
```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("one.tranic:t-proxy:[VERSION]")
}
```