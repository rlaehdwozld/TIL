# 2022.11.07 목요일

## Servlet

### 들여쓰기

```html
<c:forEach var="i" begin="1" end="${board.depth}" step="1">
  &nbsp;&nbsp;&nbsp;
</c:forEach>
```

### 페이징 처리

#### 1. 페이저로 클래스를 별도로 만들어서 관리

여러개 게시판 만들때 효율적으로 관리

```html

```

#### 2. list에 작성하면

ui적 측면에서 나은 결과물

### 엔터 처리 하는법

```jsp
			String content = board.getContent();
								if(content != null){
									content = content.replace("\n", "<br>");
								}
								out.print(content);
```

### 꼬리글 달기

```html
<form name="reply" action="board_replyok.jsp" method="POST">
  <!-- hidden 태그  값을 숨겨서 처리  -->
  <input type="hidden" name="idx" value="<%=idx%>" />
  <input type="hidden" name="userid" value="" /><!-- 추후 필요에 따라  -->
  <!-- hidden data -->
  <table width="80%" border="1">
    <tr>
      <th colspan="2">덧글 쓰기</th>
    </tr>
    <tr>
      <td align="left">
        작성자 : <input type="text" name="reply_writer" /><br />
        내&nbsp;&nbsp;용 :
        <textarea name="reply_content" rows="2" cols="50"></textarea>
      </td>
      <td align="left">
        비밀번호:
        <input type="password" name="reply_pwd" size="4" />
        <input type="button" value="등록" onclick="reply_check()" />
      </td>
    </tr>
  </table>
</form>
```

### 부족한 점

1. 뿌려지는 data jstl로 변환
2. 비동기처리
3.

### 파일 업로드, 다운로드

http://www.servlets.com/cos/ 에서 cos 파일 다운
