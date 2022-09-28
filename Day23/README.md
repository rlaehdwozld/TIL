# 2022.09.28 화요일 못먹어도 고!

## 데이터 타입

class member3{private int age;}  
--1건  
member3 m = new member3();  
m.setAge(100);

100건 데이터 넣어라  
List<memer3>mlist = new ArrayList<member3>();  
mlist.add(new member(100));  
mlist.add(new member(200));  
mlist.add(new member(300));  
mlist.add(new member(400));  
데이터 타입  
문자열 타입

char(10) >> 10byte >> 한글 5자 , 영문자 , 특수, 공백, 10자>> 고정길이 문자열

varchar2(10)>> 10byte >> 한글 5자 , 영문자 , 특수, 공백, 10자 >> 고정길이 문자열\

> > char(10) >> 'abc' >> 3byte >>[a][b][c][][][][][][][]>> 공간의 변화가 없어요  
> > varchar >> 'abc' >> 3byte >>[a][b][c].. >>데이터 크기만큼만 공간 확보(가변적이라는 말)

사람의 이름  
create table member(name char(30))  
create table member(name varchar2(30)) (이게 맞다)

성별 (남 또는 여)  
create table member(gender char(30)) (이게 맞다)  
create table member(gender varchar2(30))

약속  
 고정 길이 문자열 (남,여....대, 중, 소.... 주민번호) char()  
 가변길이 문자열(사람의 이름, 취미 주소) varchar2()

char() , varchar2() 고민 : 한글과 영어 혼합
varchar2(10)

unicode(2byte) : 한글, 영문자, 특수문자, 공백>> 2byte

nchar(20) >>
nvarchar2(20)
<br>
<br>

## 일반함수

일반 함수( 프로그램 성격이 강한 함수)  
sql문에는 if문없다. 변수 선언이 없다.  
PL-SQL은 프로그램적 성격이 강한 sql이다.  
nvl(), nvl2() : null처리하는 함수  
decode() >> java if문  
case() >> java switch문

오라클 sql(변수, 제너문 개념이 없다.)
