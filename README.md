# SimpleStressChecker  
# 超簡易版　心身　ストレスチェックアプリ！
ストレスチェックアプリケーション


## Ocerview
心身のストレスチェックを所要時間１分、全１０問で簡単にできるアプリケーション

厚生労働省のストレスチェックシートの
身体面、精神面、の項目を簡略化、参考にして作成。

## Description

[背景]

私が大学時代の研究課題としてストレスについて取り上げていたことや

* 毎年１回のストレスチェックシートの記入だけでは足りないのでは？
* もっと気軽にできないか？（厚生労働省のストレスチェックシートのチェック項目は５７項目あります。）
* 結局、チェックしたけど特に対策はしなかったなー

と思ったこと。

あと自分が働いていた職場でもシフト勤務のために心身ともにストレスがたまることが多くの方が体調を客観視することができず無理して体調を崩したり
する人が多かったということもありました。

根本的な解決とはならないが、まずは自分の体の状態に気がついてほしいという思いもあります。


疲労が溜まってしまうと対策する気も起きず、効果が低い簡単なストレス解消法などに走ってしまいがちだと考えました。


日頃のストレスや生活習慣の積み重ねが、後々、年を重ね、４０〜60代になったときにガンや高血圧、糖尿病などの生活習慣病になる確率を上げる原因になります。
私は家族や親戚が生活習慣病で苦しんでいるの目の当たりにしていることもあり、本人からの後悔したことなども聞いており身に染みてます。


病気になってから、健康が大事だと気がついたという人もいますが、気がついてからはもう遅いという人もいます。


なので日頃の健康管理は積み重ねが大事であり、まずは自分の体の状態に気がつくことが大事です。


ということで、気軽に週に１回くらいでいいので自分の体の調子について
質問形式で答えてく感じの、クイズ風ストレスチェックアプリを作ろうと思い作成しました。


[目的]

* 体調が悪いことによる機会損失を減らし、健康に楽しく過ごす手助けになってほしいため。
* とにかく気軽に自分の体調について気がつくきっかけになってほしいため。
* 間違ったストレス解消法を行ってしまい、なかなか疲れが取れない人と  
 仕事や生活で忙しすぎて自分の体調の良し悪しに気がつけない人に向けて日頃の健康の大切さを再認識してほしいため。

## Dependency

使用した技術

java11  
gradle  
SpringBoot 2.3.10     
Thymeleaf 3.0.12  
mybatis-spring-boot-starter-2.1.4   

AWS RDS
mysql (メイン）  
H2:database(テスト用)

HTML/CSS/JS  
bootstarap  
Thymeleaf 3.0.12.RELEASE   

junit  
mybatis-spring-boot-starter-test:2.1.3  
selenide:5.18.0  

AWS RDS
AWS EC2
AWS VPC

## Usage

* トップ画面から、チェックスタートボタンを押し質問画面に移ります。
* 質問に対して２択の、「そうだ」、「ちがう」のどちらかを答えてください。
* １０問全て答えたら、結果画面へ移ります。
* ストレス項目の回答数によって、診断結果が表示されます。
* ストレス対策へのアドバイスのボタンを押すとアドバイスページに移ります。
* 最初に戻るボタンを押すとトップ画面へ戻ります。

ストレス診断結果として
ストレス項目へ答えた数が

０〜２問 低ストレス傾向  
3〜6問 中ストレス傾向  
7〜10問 高ストレス傾向  

となります。


## Author
Ryuta Kuwamura

