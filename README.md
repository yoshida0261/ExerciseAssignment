# ExerciseAssignmen

#usage

- ss -s date event
- ss -f start end

#実装方針
オブジェクト指向としてdaoなどのデザインパターンを意識し
モジュール間の結合を疎とする。
利用できるOSSは使用する。
予約検索のアルゴリズムは二分検索を使用する。

#実行方法
usage参照

#環境構築
Java 1.8 + Intellij + OSS（下記 OSS参照）

##仕様
- 日時と予定を検索する
- 日時　
  - YYYYMMDDhhmm
  - 文字列
- 予定
  -　256文字
- 設定
  - 日時、予定
- 検索
  - 始点、終点を入力
  - 始点から終点までの予定を一覧で出力(json)

## OSS

###導入手順
以下のサイトからjarをDLし、intellijの設定をする。
  
- common cli
    - http://commons.apache.org/proper/commons-cli/download_cli.cgi
- Jackson
    - http://wiki.fasterxml.com/JacksonDownload
        - jackson-annotations-2.8.0
        - jackson-core-2.8.1
        - jackson-databind-2.8.5
- JUnit
    - http://search.maven.org/#search|gav|1|g:"junit" AND a:"junit"
- SQLite
    -
