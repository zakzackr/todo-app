# 🗒️Todoアプリ
# 🖊️概要
日々のTodoタスクを管理することができるTodoアプリ
<br>

# ✨Demo
![todo](https://github.com/zakzackr/todo-app/assets/100734822/a228274e-fc61-401d-aad0-d44b986059f0)
<br>

# 📍 URL
http://todo-app-1.s3-website-ap-northeast-1.amazonaws.com
<br>   

# 💾 技術スタック
| Category | Tech Stack |
| ---- | ---- |
| Frontend | JavaScript, React.js |
| Backend | Java, Spring Boot |
| Database | MySQL |
| Infrastructure | AWS (Elastic Beanstalk, S3, RDS) |
| Others | Git, GitHub |
<br>

# 📝 説明
Todoアプリを使用することで、タスクの追加・削除・更新などを行うことができます。
<br>    

### 主な操作：
* 新規ユーザー登録（Register）：名前・ユーザー名・メールアドレス・パスワードを入力し、新規ユーザー登録
* ログイン（Login）：ユーザー名またはメールアドレス、パスワードを使用してログイン
* タスクの追加（Add task）：新タスクの追加
* タスクの編集（Update）：既存タスクの更新
* タスクの削除（Delete）：既存タスクの削除
* タスクの完了（Complete）：既存タスクの完了
* タスクの未完了（In-Complete）：既存タスクの未完了

*通常のユーザーは、User権限を付与さるため、Update機能を使用することができません。
<br>

# 📈 作成の経緯
* Webアプリの認証の仕組みを理解する
* 認証（authentication）と認可（authorization）の違いを理解する
* Spring Securityにるログイン、ユーザー登録機能の実装を行う
<br>    

# 💻 学んだこと
* Webアプリの認証・認可の仕組み（ログイン後の一連の流れ）
* ロールベースアクセス制御（ROLE_ADMIN, ROLE_USER）
* JWTを使用したトークンベースの認証方法
* Spring Securityによる認可・認証の実装方法
* ベーシック認証の脆弱性
<br>    

# 🌈 こだわりポイント
* ユーザー名またはメールアドレスのどちらかでログインができること
* 機能拡張によりマルチユーザーに対応できるようにしたこと
<br>    

# 🔜 今後の計画
- [x] マルチユーザーに対応（機能拡張済み）    
- [x] 新規ユーザー登録時にユーザーにメールを送信する機能の追加（機能拡張済み）    
- [ ] UIの向上
