CREATE TABLE question_answer (
  questionnumber VARCHAR2(2) PRIMARY KEY NOT NULL,
  question VARCHAR2(200),
  choice1 VARCHAR2(50),
  choice2 VARCHAR2(50),
  choice3 VARCHAR2(50),
  choice4 VARCHAR2(50),
  answer  number(1),
  answerall VARCHAR2(20)
);

INSERT INTO question_answer
VALUES ( '1',
          '통신을 위한 프로그램을 생성하여 포트를 할당하고, 클라이언트의 통신 요청 시 클라이언트와 연결하는 내·외부 송·수신 연계기술은?',
          'DB링크 기술',
          '소켓 기술',
          '스크럼 기술',
          '프로토타입 기술', 2, '22334');

INSERT INTO question_answer
VALUES ('2',
          '객체지향 개념에서 연관된 데이터와 함수를 함께 묶어 외부와 경계를 만들고 필요한 인터페이스만을 밖으로 드러내는 과정은?',
          '메시지(Message)',
          '캡슐화(Encapsulation)',
          '다형성(Polymorphism)	',
          '상속(Inheritance)', 2, '');

INSERT INTO question_answer
VALUES ('3',
          'GoF(Gangs of Four) 디자인 패턴의 생성패턴에 속하지 않는 것은?',
          '추상 팩토리(Abstract Factory)',
          '빌더(Builder)',
          '어댑터(Adapter)',
          '싱글턴(Singleton)', 3, '');
          
INSERT INTO question_answer
VALUES ('4',
          '응용프로그램의 프로시저를 사용하여 원격 프로시저를 로컬 프로시저처럼 호출하는 방식의 미들웨어는?',
          'WAS(Web Application Server)',
          'MOM(Message Oriented Middleware)',
          'RPC(Remote Procedure Call)',
          'ORB(Object Request Broker)', 3, '');
          
          
INSERT INTO question_answer
VALUES ('5',
          '현행 시스템 분석에서 고려하지 않아도 되는 항목은?',
          'DBMS 분석		',
          '네트워크 분석',
          '운영체제 분석',
          '인적 자원 분석', 4, '');



SELECT *
FROM question_answer;


COMMIT;
