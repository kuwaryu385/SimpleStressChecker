USE `stressquestion`;

DELETE FROM `questions`;

INSERT INTO `questions` (`id`, `question`, `choiceY`, `choiceN`, `answer`, `answered` ,`answerRate`)
VALUES
(1, 'どちらかというと自分は元気だと思うか？', 'そうだ', 'ちがう', 0, FALSE, FALSE),
(2, 'イライラすることは多いか？', 'そうだ', 'ちがう', 1, FALSE, FALSE),
(3, '朝起きたとき体に疲れが残っていることが多いか?', 'そうだ', 'ちがう', 1, FALSE, FALSE),
(4, '不安感や落ち着かない感じはあるか？', 'そうだ', 'ちがう', 1, FALSE, FALSE),
(5, '憂鬱さやもやもやする感じがあるか？', 'そうだ', 'ちがう', 1, FALSE, FALSE),
(6, '体の痛みやだるさはあるか？（首・肩・腰痛など）', 'そうだ', 'ちがう', 1, FALSE, FALSE),
(7, '頭痛がしたり、頭がぼーっとしている感じがするか？', 'そうだ', 'ちがう', 1, FALSE, FALSE),
(8, '目のつかれはあるか？', 'そうだ', 'ちがう', 1, FALSE, FALSE),
(9, 'お腹の調子は悪いか？（便秘や下痢などもあるか）', 'そうだ', 'ちがう', 1, FALSE, FALSE),
(10, 'なかなか寝付けなくなかったり、目覚めが悪いか？', 'そうだ', 'ちがう', 1, FALSE, FALSE);




