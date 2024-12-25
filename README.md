# 🗒️ Todoアプリ
# 🖊️ 概要
日々のタスクを管理することができるTodoアプリ
<br>    

# ✨ Demo


https://github.com/zakzackr/todo-app/assets/100734822/6c6ae7cf-1671-4b8a-9d21-8cb88151d01c


<br>    

# 📍 URL
http://todo-app-1.s3-website-ap-northeast-1.amazonaws.com<br>    
(↑AWS無料枠超過のためElastic Beanstalk、RDS停止中。フロントエンドの操作は可能です。)
<br>    
<br>    

    
# 💾 技術スタック
| Category | Tech Stack |
| ---- | ---- |
| Frontend | JavaScript, React |
| Backend | Java, Spring Boot |
| Database | MySQL |
| Infrastructure | AWS (Elastic Beanstalk, S3, RDS) |
| Others | Git, GitHub |
<br>    

# 📊 ER図
<img width="770" alt="スクリーンショット 2024-11-18 15 42 14" src="https://github.com/user-attachments/assets/4ca21af2-a22a-4d34-a602-2f6025149701">


# 📝 説明
Todoアプリのタスクの追加・削除・更新などの機能を使用して、日々のタスクの管理を行うことができます。
<br>    

### 主な操作：
* 新規ユーザー登録（Register）：名前・ユーザー名・メールアドレス・パスワードを入力し、新規ユーザー登録
* ログイン（Login）：ユーザー名またはメールアドレス、パスワードを使用してログイン
* タスクの追加（Add task）：新タスクの追加
* タスクの編集（Update）：既存タスクの更新
* タスクの削除（Delete）：既存タスクの削除
* タスクの完了（Complete）：既存タスクを完了にする
* タスクの未完了（In-Complete）：既存タスクを未完了にする

*通常のユーザーはUser権限が付与さるため、Update機能を使用することができません。
<br>

# 📈 作成の経緯
* Webアプリの認証の仕組みを理解する
* 認証（authentication）と認可（authorization）の違いを理解する
* Spring Securityにるログイン、ユーザー登録機能の実装を行う
<br>    

# 💻 学んだこと
* Webアプリの認証・認可の仕組み（ログイン後の一連の流れ）
* JWTを使用したトークンベース認証
* ロールベースアクセス制御（ROLE_ADMIN, ROLE_USER）
* Spring Securityによる認証・認可機能の実装
* ベーシック認証の脆弱性
<br>    

# 🌈 こだわりポイント
* ユーザー名またはメールアドレスのどちらかでログインができること
* 機能拡張によりマルチユーザーに対応したこと <br>
    - Spring Securityによるログイン機能の導入　<br>
    - データベース設計を工夫し、todoテーブル内でユーザーIDを外部キーとして保持することで、ユーザーとtodoタスクを対応づけしています<br>
    - HTTPリクエストのURLにパスパラメータとしてユーザーIDとtodoIDを含めることで、バックエンド側で特定のユーザーの特定のタスクに対して処理を行うことができます<br>
<br>

> [!NOTE]
> 詳細は、[こちらのReadme](https://github.com/zakzackr/reminder-app)をご覧ください。　
<br>    

# 🔜 今後の計画
- [x] マルチユーザーに対応（✅ 機能拡張済み）    
- [x] 新規ユーザー登録時にユーザーにメールを送信する機能の追加（✅ 機能拡張済み）    
- [ ] UIの向上
