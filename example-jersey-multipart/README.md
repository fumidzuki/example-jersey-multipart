# example-simple-jersey

## Overview

Jersey を Gradle だけで実行するためのシンプルなサンプルプロジェクトです。
リソースクラスにアクセスすることで、次の形式のレスポンスの取得を確認することもできます。

* XML（Extensible Markup Language）
* JSON（JavaScript Object Notation）

## Requirement

* Java Development Kit（JDK）：11+

## Install

```sh
$ git clone https://github.com/fumidzuki/example-simple-jersey.git
```

## Usage

### 起動方法

次のコマンドで起動することができます。

```sh
$ cd example-simple-jersey
$ gradlew appRun
```

起動するServletコンテナは Jetty になります。
別のServletコンテナを指定することもできます。

#### Tomcat

```sh
$ cd example-simple-jersey
$ gradlew tomcatRun
```

### Jetty

```sh
$ cd example-simple-jersey
$ gradlew jettyRun
```

### リソースクラス

各リソースクラスのアクセス方法は次のようになります。

### XML形式

XML形式のレスポンスを取得するためのアクセス方法は、次のようになります。

```http
http://localhost:8080/example-simple-jersey/xml
```

取得したレスポンス情報は、次のようになります。

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<customer>
  <age>20</age>
  <name>山田太郎</name>
</customer>
```

### JSON形式

JSON形式のレスポンスを取得するためのアクセス方法は、次のようになります。

```http
http://localhost:8080/example-simple-jersey/json
```

取得したレスポンス情報は、次のようになります。

```json
{"name":"山田太郎","age":20}
```

## Note

ビルドスクリプトに、それぞれの形式を取得するためのライブラリを指定しています。

### XML形式

* javax.xml.bind:jaxb-api
* org.glassfish.jaxb:jaxb-runtime

XML形式のレスポンスを作成するために必要なライブラリです。
このライブラリが存在しないと、レスポンス情報を取得する時に次のエラーが発生します。

```java
MessageBodyWriter not found for media type=application/xml
```

### JSON形式

* org.glassfish.jersey.media:jersey-media-json-jackson

JSON形式のレスポンスを作成するために必要なライブラリです。
このライブラリが存在しないと、レスポンス情報を取得する時に次のエラーが発生します。

```java
MessageBodyWriter not found for media type=application/json
```

## Licence

[MIT](https://github.com/fumidzuki/example-simple-jersey/blob/master/LICENSE)

## Author

[fumidzuki](https://fumidzuki.com)