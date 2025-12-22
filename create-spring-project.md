# Spring Bootプロジェクト作成ガイド

## 方法1: Web版Spring Initializr（最も簡単・確実）

1. ブラウザで https://start.spring.io を開く
2. 以下の設定を入力：
   - **Project**: Maven または Gradle
   - **Language**: Java
   - **Spring Boot**: 最新の安定版（例: 3.3.5）
   - **Project Metadata**:
     - Group: `com.example`
     - Artifact: `myproject`
     - Name: `myproject`
     - Description: プロジェクトの説明
     - Package name: `com.example.myproject`
     - Packaging: Jar
     - Java: 17 または 21（推奨）
3. **Dependencies**を選択（例）：
   - Spring Web
   - Spring Data JPA
   - PostgreSQL Driver
   - Spring Boot DevTools
4. **GENERATE**ボタンをクリック
5. ダウンロードしたZIPファイルを解凍
6. Cursorでフォルダを開く

## 方法2: コマンドライン（curl使用）

PowerShellで以下のコマンドを実行：

```powershell
# プロジェクトを生成（例）
Invoke-WebRequest -Uri "https://start.spring.io/starter.zip?type=maven-project&language=java&bootVersion=3.3.5&baseDir=myproject&groupId=com.example&artifactId=myproject&name=myproject&description=Demo%20project&packageName=com.example.myproject&packaging=jar&javaVersion=17&dependencies=web,data-jpa,postgresql,devtools" -OutFile "myproject.zip"

# ZIPを解凍
Expand-Archive -Path "myproject.zip" -DestinationPath "."
```

## 方法3: Spring CLI（事前インストールが必要）

Spring CLIをインストールしている場合：

```bash
spring init --dependencies=web,data-jpa,postgresql,devtools --build=maven --java-version=17 myproject
```

## 推奨方法

**方法1（Web版）が最も確実で簡単です。** 拡張機能が動作しない場合は、この方法を使用してください。



