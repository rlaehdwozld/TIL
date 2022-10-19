# 2022.09.28 수요일 못먹어도 고!

GRANT "CONNECT" TO "KOSA" WITH ADMIN OPTION;  
GRANT "RESOURCE" TO "KOSA" WITH ADMIN OPTION;  
ALTER USER "KOSA" DEFAULT ROLE "CONNECT","RESOURCE";

CREATE TABLE EMP  
(EMPNO number not null,  
ENAME VARCHAR2(10),  
JOB VARCHAR2(9),  
MGR number ,  
HIREDATE date,  
SAL number ,  
COMM number ,  
DEPTNO number );

INSERT INTO EMP VALUES  
(7369,'SMITH','CLERK',7902,'1980-12-17',800,null,20);  
INSERT INTO EMP VALUES  
(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);  
INSERT INTO EMP VALUES  
(7521,'WARD','SALESMAN',7698,'1981-02-22',12 50,200,30);  
INSERT INTO EMP VALUES  
(7566,'JONES','MANAGER',7839,'1981-04-02',2975,30,20);  
INSERT INTO EMP VALUES  
(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,300,30);
INSERT INTO EMP VALUES  
(7698,'BLAKE','MANAGER',7839,'1981-04-01',2850,null,30);  
INSERT INTO EMP VALUES  
(7782,'CLARK','MANAGER',7839,'1981-06-01',2450,null,10);  
INSERT INTO EMP VALUES  
(7788,'SCOTT','ANALYST',7566,'1982-10-09',3000,null,20);  
INSERT INTO EMP VALUES  
(7839,'KING','PRESIDENT',null,'1981-11-17',5000,3500,10);  
INSERT INTO EMP VALUES  
(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);  
INSERT INTO EMP VALUES  
(7876,'ADAMS','CLERK',7788,'1983-01-12',1100,null,20);  
INSERT INTO EMP VALUES  
(7900,'JAMES','CLERK',7698,'1981-10-03',950,null,30);  
INSERT INTO EMP VALUES  
(7902,'FORD','ANALYST',7566,'1981-10-3',3000,null,20);  
INSERT INTO EMP VALUES  
(7934,'MILLER','CLERK',7782,'1982-01-23',1300,null,10);

COMMIT;

CREATE TABLE DEPT  
(DEPTNO number,  
DNAME VARCHAR2(14),  
LOC VARCHAR2(13) );

INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');  
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');  
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');  
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');

COMMIT;

CREATE TABLE SALGRADE  
( GRADE number,  
LOSAL number,  
HISAL number );

INSERT INTO SALGRADE VALUES (1,700,1200);  
INSERT INTO SALGRADE VALUES (2,1201,1400);  
INSERT INTO SALGRADE VALUES (3,1401,2000);  
INSERT INTO SALGRADE VALUES (4,2001,3000);  
INSERT INTO SALGRADE VALUES (5,3001,9999);
COMMIT;

select _ from emp;  
select _ from dept;  
select \* from salgrade;

show user;  
--비교연산자  
--< > <=  
--주의  
--java 같다 (==) 할당(=) , javascript(==,===)  
--oracle. 같다 (=) 같지않다(!=)

--논리연산자  
--AND, OR, NOT

select \*  
from emp  
where sal >=2000;

--사번이 7788번인 사원의 사번, 이름, 직종 입사일을 출력하세요

select empno, ename,job,hiredate --3  
from emp --1  
where EMPNO = 7788; --2

--개발자 : CRUD >> create db에서는 (insert), read(select),update, delete  
--db 작업 : read (select) 70%

--관리자 : 백업과 복원, 장애(네트워크, 성능) 관리 , 보안 ( 사용자 권한, 암호화)  
--튜닝 (쿼리튜닝, 하드웨어) >> 문장 튜닝 >>시간을줄이는 작업  
--설계(모델러) : 설계(요구사항정의, 분석) :erd  
--사원의 이름이 King 인 사원의 사번, 이름, 급여 정보를 출력하세요  
select empno,ename,job,sal  
from emp  
where ename='KING';  
--오라클은 엄격하게대소문자를 구별하기 때문에 king이라고 하면 안나온다.  
/_ AND OR  
00 0 0  
01 0 1  
10 0 1  
11 1 1  
_/
--급여가 2000달러 이상이면서 직종이 매니저인 사원의 모든 정보를 출력하세요  
select \*  
from emp  
where sal>=2000 AND job='mANAGER';

--급여가 2000달러 초과이면서 직종이 매니저인 사원의 모든 정보를 출력하세요  
select \*  
from emp  
where sal>2000 AND job='mANAGER';

--오라클 날짜 (DB서버의 날짜)  
--오라클 날짜(sysdate)  
select sysdate from dual;  
--22/09/27

select \* from nls_session_parameters;--시스템 테이블  
--현재 접속한 사용자(session) 가지는 환경정보  
--NLS_TIME_FORMAT HH24:MI:SSXFF

--일반적으로 2022-09-27  
alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';  
select sysdate from dual; --2022-09-27 09:52:35  
--오라클 접속 끊고 다시 sysdate하면 위오 같은 형식이 유지 되지 않는다.  
-- 변경정보는 현재 오라클 서버에 접속한 오라클 사용자의 환경정보만 변경된다.  
--접속을 끊엇다가 다시 연결하면 원래상태로 복원되어 있다. (RR-MM-DD)  
select hiredate from emp;  
--1980-12-17 00:00:00

select \*  
from emp  
where hiredate='1980-12-17';

select _  
from emp  
where hiredate='1980/12/17';--//인정  
--문자와 날짜 조회는 양족에 작은 따음표를 붙이고 출력하면된다.  
/_  
모든 시스템 날짜 필수 구성  
게시판  
설계  
글쓴이, 제목, 내용, 조회수,작성날짜  
insert into board(writer, title, content, hit, regdate)  
 values \*('홍기롱'.'처음방가', '졸립다',0,sysdate)

regdate : 컬럽의 데이터는 서버의 시간(DB서버)  
--Tip) ms-sql : select getdate()  
 mysql : curdate(), curtime(), now(), sysdate()

_/  
select _  
from emp  
where hiredate='1980-12-17';

select \*  
from emp  
where hiredate='1980/12/17';--//인정

select \*  
from emp  
where hiredate='80/12/17';--//인정안된다. 현재 포맷이(yyyy-mm-dd)로 바꿔놔서 안된다.

--사원의 급여가 2000달러 이상이고 4000이하인 모든 사원의 정보를 출력하세요  
select _  
from emp  
where sal>=2000 and sal<4000;  
--이쿼리 마음에 드나?? NO!! sal이 두번나오기 떄문에 반복되는 것을 없애자  
select _  
from emp  
where sal >= 2000 and sal<=4000;  
--연산자 : 컬럼명 between A and B

select \*  
from emp  
where sal between 2000 and 4000;

select \*  
from emp  
where sal > 2000 and sal<4000;  
--초과 미만은 안된다

--부서번호가 10번 또는 20번 또는 30번인 사원의 사번, 이름, 급여,부서번호를 출력하세요  
select \*  
from emp  
where deptno =10 or deptno=20 or deptno =30;  
--연산자(IN 연산자)

select \*  
from emp  
where deptno in(10,20,30 ); --풀어쓰면 deptno =10 or deptno=20 or deptno =30;

--부서번호가 10번 또는 20번이 아닌 사원의 사번, 이름, 급여,부서번호를 출력하세요  
select \*  
from emp  
where deptno !=10 AND deptno!=20;--두자기 조건을 모두 만족하는 애들은 30번인 애들

--In 부정  
select \*  
from emp  
where deptno not in(10,20);-- deptno !=10 and deptno !=20;  
--not in은 부정의 and이다.

--POINT : null >> 오라클 값이없다 >> 필요악  
--자바에서 클래스랑 비슷한 개념  
create table member(  
userid VARCHAR2(20) not null,--null을 허용하지 않겠다.(필수 입력)  
name varchar2(20) not null,--나는 클라이언트로 부터 이름을 필수 입력 받겠다.  
hobby varchar2(50)-- default null허용 : 선택적 입력사항  
);

select \* from member;

insert into member(userid, hobby) values('hong','농구');
--ORA-01400: cannot insert NULL into ("KOSA"."MEMBER"."NAME")
insert into member(userid, name) values('hong','홍길동');

SELECT  
 \*  
FROM member;  
--hobby >> null

-- 간단하게  
--DB 서버마다 설정  
--DML (데이터 조작어) : insert, update, delete  
-- 오라클 실제 반영을 위해서 개발자에게 : commit, rollback 강제  
-- MS-sql , mysql default commit  
commit ;--명령 (insert, update, delete) 실제 반영

--수당 (Comm)을 받지 않는 모든 사원의 정보를 출력하세요  
--0도 데이터(받는 조건)  
select comm from emp;

select \*  
from emp  
where comm = null;  
--이런 문법은 존재하지 않는다.  
-- null의 비교는 (is null, is not null)암기...

select \*  
from emp  
where comm is null;

-- 수당 받는 사원들  
select \*  
from emp  
where comm is not null;

--사원 테이블에서 사번, 이름, 급여, 수당, 총급여를 출력하세요  
-- 초급려 정의( 급여 + 수당)  
SELECT  
 empno,ename,sal,comm,(sal+comm) as "총급여"  
FROM emp;  
--총급여에 null이 나온다....

/\*  
null이라는 놈

1. null과의 모든 연산의 결과는 null이다 ex) 100+null=null, 100-null=null
2. 위 문제를 해결하기 위해서 함수 >>nvl(), nvl2()>>암기  
   ex) nvl(컬럼명, 대체값) >> 치환  
   Tip)Ms-sql> null>convert()  
    mysql > null>IFNULL()>>SELECT IFNULL(NULL,111);  
    암기해야한다.  
   \*/  
   SELECT empno,ename,sal,comm,sal+nvl(comm,0) as "총급여"  
   FROM emp;

select 1000+null from dual;

- dual;

select comm, nvl(comm,111111) from emp;

select nvl(null,'hello world')from dual;

--사원의 급여가1000이상이고 수당을 받디 않는 사원의 사번, 이름, 직종, 급여, 수당을 출력하세요  
select empno, ename,job,sal,comm  
from emp  
where sal>=1000 and comm is null;

--DQL(DATA QEURY LANGUAGE) : select  
--DDL(DATA DEFINITION LANGAUGE) : create, alter, drop(Table 생성, 수정, 삭제) commit 과 rollback 은 의미가 없다..  
--DML(DATA MANIPULATION LANGUAGE) : insert ,update, delete(반드시 commit, rollback )

--java : class Board{private int boardno}  
--DB : create table Board(boardno number)

create table Board(  
boardid number not null, --숫자이면서 필수입력  
title varchar2(50) not null, --글제목(한글 25자, 영문자50자), 필수입력  
content varchar2(2000) not null, --글내용 (한글 1000자 영문자 2000자) 필수입력  
hp varchar2(20)--default null허용 (선택사항)  
);  
desc board;  
SELECT  
 \*  
FROM board;  
insert into board(boardid, title, content)  
values(100,'오라클','실수했네');-- 핸드폰 번호 null허용하니깐 가능

SELECT  
 _  
FROM board;  
--데이터 잘못 넣었네  
rollback;  
--insert전으로 돌아갔다  
SELECT  
 _  
FROM board;  
commit;

insert into board(boardid, title, content)  
values(100,'오라클','실수했네');-- 핸드폰 번호 null허용하니깐 가능  
commit;

/\*
commit or rollback  
insert ....1  
insert.....2

commit..... 1,2 모두 commit된다.  
insert...3  
rollback...  
\*/  
select boardid, title, content, nvl(hp,'emp ty') as HP  
from board;  
--문자열 검색  
--주소검색 : 검색어 : 역삼 ->역삼이라는 단어가 들어가있는 모든 주소가 출력  
--Like 패턴검색

--Like(문자열 채턴 검색 연산자)

--like 연산자(와일드 카드 문자 : 1.% (모든 것), \_(한문자) 결합 패턴을 생성 일치...  
--검색이 한정적 >> java와 동일한 정규 표현식을 오라클 적용)

SELECT  
 \*  
FROM emp  
where ename like'%A%';--ename 컬럼에 A가 들어가 있으면 다 뽑아라

SELECT \*  
FROM emp  
where ename like'%a%';--대소문자는 엄격하게 구문한다.

SELECT  
 \*  
FROM emp  
where ename like'%A%';--A로 시작하고 뒤에는 어떤 것이 와도 상관 없다.  
--like '김%' 김씨 성 다 찾아라!

SELECT  
 \*  
FROM emp  
where ename like'%E';

--주소 검색  
--select _ from zip where like '%역삼%'  
--select _ from mmber where name liek '이%'

SELECT  
 \*  
FROM emp  
where ename like '%LL%';

SELECT  
 \*  
FROM emp  
where ename like '%A%A%';--ADAMS ABABA AAAAAA

SELECT  
 \*  
FROM emp  
where ename like '\_A%';-- A가 두번째 오는 글자를 찾아라 첫글자는 어떤 것이 와도 상관 없다.( A의 위치값)  
--WARD  
--MARTIN  
--JAMES

--과제 regexp_like 연산자 (정규식)  
select \* from emp where regexp_like(ename,'[A-C]');  
--regexp_like 사용 정규표현 검색 5개 대상 EMP

--데이터 정렬하기  
--order by 컬럼명 : 문자, 숫자, 날짜 정렬  
--오름차순 : asc : 낮은 순 : default  
--내림차순 : desc : 높은 순  
--비용 (cost)많이드는 작업

select \* from emp  
order by sal;--default asc

select \* from emp  
order by sal desc;

--입사일이 가장 늦은 순으로 정렬해서 사번, 이름 , 급여ㅡ 입사일을 출력하세요  
--가장 최근에 입사한 순으로  
select

- from emp  
  order by hiredate desc;

select empno, ename

- from emp  
  order by ename asc;

/_
select 절 3  
from 절 1  
where절 2  
order by 절 4  
_/

select empno, ename, sal, job, hiredate  
from emp  
where job ='MANAGER'  
order by hiredate desc;

select job, deptno  
from emp  
order by job asc, deptno desc;  
--order by 컬럼명 asc , 컬럼명 asc.....  
--게시판 ... 답변 게시판

--연산자  
--합집합(union) : 테이블과 테이블의 데이터를 합치는 것  
--합집합(union all) : 중복값 허용

create table uta(name varchar2(20));

insert into uta(name) values('AAA');  
insert into uta(name) values('BBB');  
insert into uta(name) values('CCC');  
insert into uta(name) values('DDD');  
COMMIT ;

create table ut(name varchar2(20));

insert into ut(name) values('AAA');  
insert into ut(name) values('BBB');  
insert into ut(name) values('CCC');  
COMMIT ;

select _ from ut  
union  
select _ from uta;

select _ from ut  
union all  
select _ from uta;  
--ut집에 uta 가족들이 놀러간 것

--union  
--1. 대응되는 컬럼의 타입이 동일  
select empno, ename from emp--숫자, 문자열  
union  
select dname, deptno from dept;--문자열, 숫자  
--ORA-01790: expression must have same datatype as corresponding expression

---

--초보개발자가 의무적으로 해야하는 코드( 단일 테이블 select)

select empno, ename from emp--숫자, 문자열  
union  
select deptno, dname from dept;--숫자, 문자열  
--문자열은 문자열끼지 숫자는 숫자끼리

--2. 대응되는 컬럼의 갯수가 동일해야한다.  
--필요악 : null 컬럼을 대체  
select empno, ename,job,sal from emp  
union  
select deptno, dname ,loc from dept  
--ORA-01789: query block has incorrect number of result columns  
--컬럼의 갯수가 다르다. 하지만 null이 컬럼을 대체 할 수 있다.\  
select empno, ename,job,sal from emp  
union  
select deptno, dname ,loc, null from dept

/\*1.2.2 단일 행 함수의 종류

1. 문자형 함수 : 문자를 입력 받고 문자와 숫자 값 모두를 RETURN 할 수 있다.
2. 숫자형 함수 : 숫자를 입력 받고 숫자를 RETURN 한다.
3. 날짜형 함수 : 날짜형에 대해 수행하고 숫자를 RETURN 하는 MONTHS_BETWEEN 함수를  
   제외하고 모두 날짜 데이터형의 값을 RETURN 한다.
4. 변환형 함수 : 어떤 데이터형의 값을 다른 데이터형으로 변환한다.
5. 일반적인 함수 : NVL, DECODE\*/

--문자열 함수  
select initcap ('the super man') from dual;--The Supr Man

select lower('AAA'),upper('aaa') from dual;

select ename, lower(ename) as "ename" from emp;

select \* from emp where lower(ename) ='king';

select length('abcd') from dual;--문자열의 갯수4  
select length ('홍길동') from dual;--3개  
select length (' 홍길동') from dual;--9개 공백도 문자다.

select concat ('a','b') from dual;  
--select concat ('a','b','c') from dual;  
select 'a'||'b'||'c' from dual;--결합 연산자가 훨씬 유연하다.

select ename||' '||job from emp;--유연한 표현 가능  
select concat(ename,job) from emp;

--java : substring  
--oracle : substr

select substr('ABCDE',2,3) from dual;--0부터 세지 않고 두번째 부터 하나 둘 셋 이렇게 해서 BCD가 나옴  
select substr('ABCDE',1,1) from dual;--A  
select substr('ABCDE',3,1) from dual;--C

select substr('asdjasdljadklajsdlkasdjlkadljdl',3) from dual;--시작 값만 준거임 3번째 부터 쭉~~  
select substr('ABCDE',-2,1) from dual;--D  
select substr('ABCDE',-2,2) from dual;--DE

--사원 테이블에서 ename 컬럼의 데이터에 대해서 첫글자는 소문자로 나머지 글자는 대문자로 출력하되 하나의 컬럼으로 만들어 출력하시고 컬럼의 별칭은 fullname이라고 하고  
--첫글자와 나머지 문자 사이에는 공백 하나를 넣으세요  
-->SMITH>>s MITH...  
select lower(substr(ename,1,1)) ||' '|| upper(substr(ename,2)) as fullname from emp;

select lpad('ABC',10,'\*') from dual;--**\*\*\***ABC

select lpad('ABC',10,'%') from dual;--%%%%%%%ABC

--사용자의 비번 : homg 1007 or k1234  
-- 화면 : 앞 두글자 >> ho**\*\***  
-- >> k1*\*\*  
select rpad(substr('hong1007',1,2),length('hong1007'),'*') from dual;  
select rpad(substr('k1234',1,2),length('k1234'),'\*') from dual;

--emp 테이블 ename 컬럼의 데이터를 출력하는데  
--첫글자만 출력하고 나머지는 _로 출력하자  
select rpad(substr(ename,1,1),length(ename),'_')as 보안 from emp;  
create table member2(  
id number,  
jumin varchar2(14)  
);  
insert into member2(id, jumin) values(100,'123456-1234567');  
insert into member2(id, jumin) values(200,'234567-1234567');  
commit;
select \*from member2;

--출력결과
--100: 123456-**\*\*\***
--200: 234566-**\*\*\***
--가명칭은 "juminnumber
select id||':'||rpad(substr(jumin,1,7),length(jumin),'\*') as juminnumber
from member2;

--rtrim 함수
--오른쪽 문자 지워라
select rtrim('MILLER','ER')from dual;--MILL

--ltrim 함수
--왼쪽 문자 지워라
select ltrim('MILLLLLLLLLLER','MIL')from dual;--ER

--공백제거
select '>' || rtrim('MILLER ',' ')||'<'from dual;
-->MILLER<
select '>' || ltrim(' MILLER',' ')||'<'from dual;

--치환함수
select ename, replace(ename,'A','와우') from emp;

---

--숫자 함수
--round (반올림 함수)
-- trunc(절사함수)
--mod() 나머지를 구하는 함수

-- -3 -2 -1 0(정수) 1 2 3  
select round(12.345,0) as "r" from dual;--정수부만 남겨라--12  
select round(12.567,0) as "r" from dual;--정수부만 남겨라--13

select round(12.345,1) as "r" from dual;--12.3  
select round(12.567,1) as "r" from dual;--12.6

select round(12.345,-1) as "r" from dual;--10;  
select round(15.345,-1) as "r" from dual;--20;  
select round(15.345,-2) as "r" from dual;--0;

select round(12.345,1) as "r" from dual;--12.3

-- -3 -2 -1 0(정수) 1 2 3  
select trunc(12.345,0) as "t" from dual;--정수부만 남겨라--12  
select trunc(12.567,0) as "t" from dual;--정수부만 남겨라--13

select trunc(12.345,1) as "t" from dual;--12.3  
select trunc(12.567,1) as "t" from dual;--12.6

select trunc(12.345,-1) as "t" from dual;--10;  
select trunc(15.345,-1) as "t" from dual;--20;  
select trunc(15.345,-2) as "t" from dual;--0;

select trunc(12.345,1) as "t" from dual;--12.3

--나머지  
select 12/10 from dual;--1.2

select mod(12,10) from dual;--2

select mod(0,0) from dual;--0

---

--날짜 함수  
select sysdate from dual;
--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

--point (날짜 연산)  
--1. Date + Number>> Date  
--2. Date - Number>> Date  
--3. Date - Date >> Number(일수)

select sysdate + 100 from dual;--2023-01-05 16:04:24  
select '2022-02-27' + 1000 from dual;

select hiredate from emp;  
select months_between('2019-09-27','2022-09-27')from dual;  
select months_between('2022-09-27','2019-09-27')from dual;  
select months_between(sysdate,'2010-09-27') from dual;--144

select '2022-01-01'+100 from dual;  
--point 변환함수 to_date()  
--날짜 형식의 문자를 날짜로 바꿀 수 있다!  
select to_date('2022-02-27') + 1000 from dual;

--사원테이블에서 사원들의 입사일에서 현재날짜가지의 근속월수를 구하세요  
--사원 이름 , 입사일,근속월수 출력  
--단 근속 월수는 정수부분만 출력 ( 반올림하지마세요)  
desc emp;  
select ename,hiredate, trunc(months_between(sysdate, hiredate),0)as "근속월수" from emp;
=--1. 사원 테이블에서 사원들의 입사일에서 현재 날짜까지의 근속월수를 구하세요  
--사원 이름, 입사일, 근속월수 출렷  
-- 단 근속월수는 정수부분만 출력(반올림하지 마세요)

--2. 한달이 31일 이라는 기준에서 근속월수를 구하세요
--(반올림하지마세요) (함수 사용(X) >> 날짜 - 날짜 >> 150일)요)  
select ename,hiredate,trunc((sysdate-hiredate)/31,0) as "근속월수" from emp;

---

## --함수(문자, 숫자, 날짜)까지

--변환함수 todaypoint  
--oracle 데이처 : 문자열 , 숫자, 날짜  
--to_char():숫자 ->문자(100000->$100,000)>>format 출력 형식 정의  
-- 날짜 ->문자('2022-09-29'-> 2022년 09월 29일)  
--자바의 printf, simpldateformat처럼  
--to_date : 문자-> 날짜  
select to_date('2022-02-27') + 1000 from dual;

--to_number() : 문자 -> 숫자 >> 자동형변환  
--select '100' + 100 from dual;  
--select to_number('100') + 100 from dual;

--1.  
select '1'+1 from dual;--'1'문자 ->숫자(형변환)  
--원칙적인방법  
select to_number('1') +1 from dual;

--2  
select sysdate, to_char(sysdate,'YYYY') ||'년'as "YYYY"  
to_char(sysdate,'YYYY') as "YYYY"  
to_char(sysdate,'MM') as "MM"  
to_char(sysdate,'DD') as "DD"
to_char(sysdate,'DAY') as "DAY"  
to_char(sysdate,'DY') as "DY"  
from dual;

--입사일이 12월인 사원의 사번, 이름, 입사일, 입사년도, 입사월을 출력하세요  
select empno, ename, hiredate,to_char(hiredate,'YYYY')as YYYY  
,to_char(hiredate,'MM') as MM from emp  
where to_char(hiredate,'MM')='12';

select to*char(hiredate,'YYYY MM DD')from emp;  
--to_char() : 날짜 *> 형식문자변환  
--오라클.pdf 68page표 참조

--t0_char : 숫자-> 형식문자 변환  
--오라클.pdf 71page 표참조  
-- 1000000-> $10,000,000  
select '>'|| to_char(12345,'9999999999') ||'<'from dual ;
select '>'|| ltrim(to_char(12345,'9999999999')) ||'<'from dual;  
select '>', to_char(sal,'$999,999')from emp;

select sal, to_char(sal,'$999,999')from emp;

---

show user;

## HR.sql

show user;  
--user가 hr입니다.  
select \* from employees;  
select sysdate from dual;  
alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

select  
last*name || first_name as fullname,  
to_char(hire_date,'YYYY-MM-DD') as "입사일",  
to_char(salary * 12) as "연봉",  
to*char((salary * 12) \* 1.1, '999,999,999') as "인상급여"  
from employees  
where to_char(hire_date, 'YYYY') >= '2005'  
order by 연봉 desc;  
--order by 절은 select 다음에 실행 >> select 된 결과 컬럼값을 사용가능하다( 가명칭)

--총정리  
--문자함수, 숫자함수, 날짜함수  
--변환함수(to\_...)(to_char())

--내일은  
-- 일반함수(nvl, nvl2....)  
--집계함수(avg(), sum(), min() , max())  
--page(55~1)

---

--함수끝

select  
last*name || first_name as fullname,  
to_char(hire_date,'YYYY-MM-DD') as "입사일",  
to_char(salary * 12) as "연봉",  
to*char((salary * 12) \* 1.1, '999,999,999') as "인상급여"  
from employees  
where to_char(hire_date, 'YYYY') >= '2005'  
order by 연봉 desc;  
--order by 절은 select 다음에 실행 >> select 된 결과 컬럼값을 사용가능하다( 가명칭)

--총정리  
--문자함수, 숫자함수, 날짜함수  
--변환함수(to\_...)(to_char())

--내일은  
-- 일반함수(nvl, nvl2....)  
--집계함수(avg(), sum(), min() , max())  
--page(55~1)

---
