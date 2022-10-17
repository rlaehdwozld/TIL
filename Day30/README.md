2022.10.11 화요일

## 트리거

TRIGGER의 사전적인 의미를 살펴보면 [ 방아쇠, 촉발시키다, 야기하다, 유발하다 ] 라고 나온다.

이러한 의미처럼 트리거(TRIGGER)란 DML(Data Manipulation Language) 작업 즉, [ INSERT, UPDATE, DELETE ] 작업이 일어날때 자동적으로 실행되는(유발되는, 촉발되는) 객체이다. (이와 같은 특징을 강조하여 DML TRIGGER 라고 부르기도 한다)   
<br>
트리거는 무결성 뿐만 아니라 다음과 같은 작업들에 널리 사용된다.

자동으로 파생된 열 값 생성

잘못된 트랜잭션 방지

복잡한 보안 권한 강제 수행

분산 데이터베이스 노드 상에서 참조 무결성 강제 수행

복잡한 업무 규칙 강제 적용

투명한 이벤트 로깅 제공

복잡한 감사 제공

동기 테이블 복제 유지관리

테이블 액세스 통계 수집

하나 주의할 점이 있는데, 트리거 내에서는 COMMIT과 ROLLBACK 문을 사용할 수 없다. 
 <br>
트리거의 종류 및 기본 형태  
트리거는 [ BEFORE, AFTER ] 그리고 [ STATEMENT, ROW ] 에 따라서 총 4가지의 종류로 나눌 수 있다.

BEFORE STATEMENT : SQL 구문이 실행되기 전에 그 문장에 대해 한 번 실행
<br>

BEFORE ROW : SQL 구문이 실행되기 전에(DML 작업을 수행 전에) 각 행(ROW)에 대해 한 번씩 실행
<br>

AFTER STATEMENT : SQL 구문이 실행된 후에 그 문장에 대해 한 번 실행
<br>

AFTER ROW : SQL 구문이 실행된 후에(DML 작업을 수행한 후에) 각 행(ROW)에 대해 한 번씩 실행

STATEMENT는 DML로 테이블에 여러 행에 대한 데이터가 변경되더라도 오로지 DML 작업에 대한 트리거를 한 번만 실행한다는 것이다.  
 <br>
트리거의 기본 형태 및 구조는 다음과 같다.

```sql
CREATE [ OR REPLACE ] TRIGGER 트리거명        [ BEFORE | AFTER ]        이벤트1 [ OR 이벤트2 [ OR 이벤트3 ] ] ON 테이블명   -- 장착되는 테이블        [ FOR EACH ROW [WHEN TRIGGER 조건] ]               [ DECLARE ]        -- 선언 구문        (...)BEGIN        -- 실행 구문        (...)END;
```

```sql
트리거 사용 예
AFTER STATEMENT TRIGGER
먼저 예제를 위한 테이블을 만들도록 한다.
 
CREATE TABLE TBL_TEST1( ID        NUMBER, NAME   VARCHAR2(30), TEL       VARCHAR2(60), CONSTRAINT TEST1_ID_PK PRIMARY KEY(ID));--==>> Table TBL_TEST1이(가) 생성되었습니다.CREATE TABLE TBL_EVENTLOG( MEMO    VARCHAR2(200), ILJA        DATE DEFAULT SYSDATE);--==>> Table TBL_EVENTLOG이(가) 생성되었습니다.

```

이제 TBL_TEST1 테이블에 데이터를 INSERT, UPDATE, DELETE 할때 작업 내용 로그 데이터로 TBL_EVENTLOG에 자동으로 추가하는 기능을 하는 트리거 TBL_EVENTLOG를 만들어 보자.

```sql
CREATE OR REPLACE TRIGGER TRG_EVENTLOG             AFTER             INSERT OR UPDATE OR DELETE ON TBL_TEST1             -- (FOR EACH ROW... 생략시 기본으로 STATEMENT로 사용)BEGIN       -- 이벤트 종류 구분 (조건문을 통한 분기)       IF (INSERTING)           THEN INSERT INTO TBL_EVENTLOG(MEMO)                   VALUES( 'INSERT 쿼리가 실행되었습니다.' );       ELSIF (UPDATING)           THEN INSERT INTO TBL_EVENTLOG(MEMO)                   VALUES( 'UPDATE 쿼리가 실행되었습니다.' );       ELSIF (DELETING)           THEN INSERT INTO TBL_EVENTLOG(MEMO)                   VALUES( 'UPDATE 쿼리가 실행되었습니다.' );       END IF;       -- COMMIT;       --> 트리거 내에서는 COMMIT / ROLLBACK 사용 불가END;--==>> Trigger TRG_EVENTLOG이(가) 컴파일되었습니다.
```

이제 TBL_TEST1에 데이터를 추가하거나 갱신하거나 삭제하는 쿼리문을 실행하게 되면 쿼리문이 실행된 이후 TRG_EVENTLOG 트리거가 자동으로 실행되면서 TBL_EVENTLOG에 로그 메시지를 기록할 것이다.

BEFORE STATEMENT TRIGGER  
앞서 만든 테이블 TBL_TEST1에 데이터를 INSERT, UPDATE, DELETE 하는 작업을 업무시간(8시 ~ 18시)에만 가능하도록 제한하는 트리거를 만들어보자.

```sql
CREATE OR REPLACE TRIGGER TRG_TEST1_DML               BEFORE             INSERT OR UPDATE OR DELETE ON TBL_TEST1BEGIN    IF ( TO_NUMBER( TO_CHAR( SYSDATE, 'HH24' ) ) < 8         OR TO_NUMBER ( TO_CHAR( SYSDATE, 'HH24') ) > 17 )        THEN RAISE_APPLICATION_ERROR(-20003, '작업은 08:00 ~ 18:00 까지만 가능합니다.');    END IF;END;--==>> Trigger TRG_TEST1_DML이(가) 컴파일되었습니다.
```

이제 TRG_TEST_DML 트리거로 인해 업무시간 이외에 데이터를 추가, 변경, 삭제시 이 작업을 수행하기 전에 오류 메시지가 뜨게 된다.

BEFORE ROW TRIGGER  
이번에는 참조 관계가 설정된 데이터(자식) 삭제를 먼저 수행하는 트리거를 만들어 보도록 하겠다. 역시 테이블을 먼저 만들어 준다.

```sql
CREATE TABLE TBL_TEST2( CODE      NUMBER, NAME      VARCHAR2(40), CONSTRAINT TEST2_CODE_PK PRIMARY KEY(CODE));--==>> Table TBL_TEST2이(가) 생성되었습니다.CREATE TABLE TBL_TEST3( SID       NUMBER, CODE    NUMBER, SU        NUMBER, CONSTRAINT TEST3_SID_PK PRIMARY KEY(SID), CONSTRAINT TEST3_CODE_FK FOREIGN KEY(CODE)                    REFERENCES TBL_TEST2(CODE));--==>> Table TBL_TEST3이(가) 생성되었습니다.
```

외래키인 TBL_TEST3.CODE가 기본키 TBL_TEST2.CODE를 참조하고 있는 구조이다. 때문에 TBL_TEST3에서 참조하고 있는 모든 CODE를 참조하는 데이터가 지워지지 않는다면 TBL_TEST2에 있는 데이터는 지울 수 없다.

이러한 제약을 미리 해결하여 TBL_TEST2의 데이터를 지울 수 있도록 해주는 트리거를 만들면 다음과 같다.

```sql
CREATE OR REPLACE TRIGGER TRG_TEST2_DELETE             BEFORE             DELETE ON TBL_TEST2             FOR EACH ROWBEGIN    DELETE    FROM TBL_TEST3    WHERE CODE = :OLD.CODE;END;--==>> Trigger TRG_TEST2_DELETE이(가) 컴파일되었습니다.
```

TRG_TEST2_DELETE를 통해 부모 테이블의 데이터를 지우기에 앞서 부모 테이블의 CODE를 참조하고 있는 자식 테이블의 데이터를 먼저 지워준다.

여기서 [ :OLD ] 는 UPDATE 또는 DELETE를 수행하는 엔터티를 만들어 관계로 연결해야 한다.
<br><br>

### 도메인(Domain)

속성이 가질수 있는 범위를 뜻한다.

예를 들어 급여 속성은 숫자만 들어가야 하고 0에서 10000 미만으로 정의되면 급여에는 문자가 입력될 수 없으며

음수와 10000을 초과한 수는 입력되지 못한다.

좀더 상세히 정의하면, 엔터티 내에서 속성에 대한 데이터 타입과 크기 그리고 제약사항을 지정하는 것이다.

- 속성 명명(Naming)

  업무에 사용되는 이름을 부여한다.

  서술식으로 정의하지 않는다.

  전체 데이터모델에서 유일성을 유지하는게 좋다.

### 식별자

1. 식별자 ( Identifiers )
   여러개의 속성 중 엔터티를 대표 할 수 있는 속성

2. 주식별자(기본 키) 5가지 특징  
   유일성 - 주식별자는 모든 인스턴스를 유일하게 구분가능하다.  
   최소성 - 주식별자를 구성하는 속성 수는 1개여야한다. ex) 학번 속성으로 구분가능한데 학번과 번호를 섞어서 구성 X  
   불변성 - 주식별자는 자주 변경되지 않아야한다.  
   존재성 - 주식별자는 항상 데이터 값이 있어야한다.  
   대표성 - 주식별자는 엔터티를 대표 할 수 있어야한다.
