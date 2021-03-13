
--同じテーブル名があっても複製できるよー
CREATE TABLE IF NOT EXISTS questions(
          id          int(6)        NOT NULL PRIMARY KEY
         ,question    varchar (255) NOT NULL
         ,choice_y    varchar (10)  NOT NULL
         ,choice_n    varchar (10)  NOT NULL
         ,answer      int(3)        NOT NULL
         ,answerRate   boolean      NOT NULL
);


