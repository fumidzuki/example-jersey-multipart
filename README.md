# example-jersey-multipart

## Overview

Jerseyでファイルアップロードするためのサンプルプロジェクトです。

## Requirement

* Java Development Kit（JDK）：11+

## Install

```sh
$ git clone https://github.com/fumidzuki/example-jersey-multipart.git
```

## Usage

### 起動方法

次のコマンドでサーバを起動します。

```sh
$ cd example-jersey-multipart
$ gradlew appRun
```

次のファイルをブラウザで表示してファイルアップロードをします。

```txt
/src/main/resources/static/upload.html
```

ファイルアップロードが正常に成功するとファイル名のレスポンス情報を取得することができます。

## Licence

[MIT](https://github.com/fumidzuki/example-simple-jersey/blob/master/LICENSE)

## Author

[fumidzuki](https://fumidzuki.com)
