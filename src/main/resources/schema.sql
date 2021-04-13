
--USE `stressquestion`;

--同じテーブル名があっても複製できる
CREATE TABLE IF NOT EXISTS questions(
          id          int(6)        NOT NULL PRIMARY KEY
         ,question    varchar (255) NOT NULL
         ,choiceY    varchar (10)  NOT NULL
         ,choiceN    varchar (10)  NOT NULL
         ,answer      int(3)        NOT NULL
         ,answered     boolean      NOT NULL
         ,answerRate   boolean      NOT NULL
);

CREATE TABLE IF NOT EXISTS my_questions(
		  id          int(6)        NOT NULL PRIMARY KEY
         ,question    varchar (255) NOT NULL
         ,choiceY    varchar (10)  NOT NULL
         ,choiceN    varchar (10)  NOT NULL
         ,answer      int(3)        NOT NULL
         ,answered     boolean      NOT NULL
         ,answerRate   boolean      NOT NULL
);




