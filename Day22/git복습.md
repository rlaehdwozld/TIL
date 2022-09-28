# Git

## git intit- 저장소 만들기

로컬 Git 저장소를 설정합니다.
작업

1. sample 디렉토리 생성
2. red, orange 파일 추가
3. sample 디렉토리를 로컬 저장소로 설정

```bash
mkdir sample
cd sample
touch red orange
echo "빨강" >> red
echo "주황" >> orange
git init
```

결과

```bash
    Initialized empty Git repository in /Users/cs.kim/Workspace/github.com/subicura/sample/.git/
```

- sample 디렉토리에 Git 저장소 생성
- 디렉토리 하위에 .git 디렉토리 생성 - Git과 관련된 정보 저장
- 쉘 프롬프트가 ➜ sample에서 ➜ sample git:(main) ✗로 변경

## git status- 현재 상태 확인

현재 작업 중인 파일의 상태를 확인합니다.

작업

상태 확인

실습

```bash
    git status # gst
```

결과

```bash

    On branch main

    No commits yet

    Untracked files:
    (use "git add <file>..." to include in what will be committed)
        orange
        red

    nothing added to commit but untracked files present (use "git add" to track)
```

- 현재 브랜치(main)와 커밋 상태, 작업 중인 파일의 상태 확인
- untracked files(추적하지 않는 파일)이 존재하는 것을 확인

## git add - 현재 상태 추적

파일의 변경사항을 인덱스index에 추가합니다. Git은 커밋하기 전, 인덱스에 먼저 커밋할 파일을 추가합니다.

-A 옵션을 이용하여 전체 파일(orange, red)을 인덱스에 추가
상태 확인  
실습

```bash
git add -A # gaa
git status # gst
```

결과

```bash
On branch main

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
	new file:   orange
	new file:   red
```

untracked files에 있던 orange와 red의 상태가 변경된 것을 확인

## git commit - 현재 상태 저장

인덱스에 추가된 변경 사항을 이력에 추가합니다.

### 1. -m 옵션을 이용하여 첫 번째 이력에 대한 메시지 작성

실습

```bash
git commit -m "v1 commit" # gc -m "v1 commit"
```

결과

```bash
[main (root-commit) 25354ae] v1 commit
 2 files changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 orange
 create mode 100644 red
```

https://subicura.com/git/guide/basic.html#git-reset-%E1%84%8B%E1%85%B5%E1%84%8C%E1%85%A5%E1%86%AB-%E1%84%89%E1%85%A1%E1%86%BC%E1%84%90%E1%85%A2%E1%84%85%E1%85%A9-%E1%84%8B%E1%85%B5%E1%84%85%E1%85%A7%E1%86%A8-%E1%84%8C%E1%85%A6%E1%84%80%E1%85%A5
