## 2022.10.17 화요일

### node

- DOM객체 자원...
- 모든 자원에 대한 사용이 가능하다.
- DOM script는 계층 트리 형태이다. (node 개념 접근 : 부모, 자식, 형제 개념 )

```js
let menode;
menode = document.getElementById("me");
menode.style.backgroundColor = "gold";
let parentnode = menode.parentNode; //body
parentnode.style.backgroundColor = "pink";
let grandenode = parentnode.parentNode; //html grandenode.style.backgroundColor="red"; let my =
console.log(my);
console.log(my.firstChild);
let my = document.getElementById("mychild");
console.log(my);
console.log(my.firstChild.nodeName); //LI
console.log(my.firstChild.innerText); //LI>AA
//innerHTML, innerTEXT>> value가 없는 친구 >>p,div,li,span...
//BB라는Text값을 가지고 오고 싶다.
console.log(my.firstChild.nextSibling.innerText); //BB

console.log(my.childNodes);
//질문 : my.childNodes return type>> Array^^
//[<li>AA</li>][<li>BB</li>][<li>CC</li>]
console.log(my.childNodes[0]);
console.log(my.childNodes.length);
```

<hr>

### for문 in, of

두가지 방법이 있다.  
for …in 반복문  
for in 반복문은 객체의 속성들을 반복하여 작업을 수행할 수 있습니다. 모든 객체에서 사용이 가능합니다. for in 구문은 객체의 key 값에 접근할 수 있지만, value 값에 접근하는 방법은 제공하지 않습니다. 자바스크립트에서 객체 속성들은 내부적으로 사용하는 숨겨진 속성들을 가지고 있습니다. 그 중 하나가 [[Enumerable]]이며, for in 구문은 이 값이 true로 셋팅되어 속성들만 반복할 수 있습니다. 이러한 속성들을 열거형 속성이라고 부르며, 객체의 모든 내장 메서드를 비롯해 각종 내장 프로퍼티 같은 비열거형 속성은 반복되지 않습니다.

```js
let text = "";
for (let index in cars) {
  text += cars[index] + "<br>";
}
```

for …of 반복문  
for of 반복문은 ES6에 추가된 새로운 컬렉션 전용 반복 구문입니다. for of 구문을 사용하기 위해선 컬렉션 객체가 [Symbol.iterator] 속성을 가지고 있어야만 합니다(직접 명시 가능).

```js
let text = "";
for (let x of cars) {
  text += x + "<br>";
}
```

for in 반복문과 for of 반복문의 차이점  
for in 반복문 : 객체의 모든 열거 가능한 속성에 대해 반복  
for of 반복문 : [Symbol.iterator] 속성을 가지는 컬렉션 전용

<hr>

### 함수의 호출 타이밍

- 함수를 호출할때 document.getElementById("mybtn").onclick=diplayDate();
  이 함수가 (괄호)가 있으면 버튼을 클릭하지 않았음에도 불구하고 실행되는데
  그럴때는 (괄호)를 빼면 onclick시에 실행되게 할 수 있다.
- 스크립트 블럭이 위에 있으면 실행순서때문에 함수의 실행이 안될 수도 있다.

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <script>
      function displayDate() {
        console.log("call");
        document.getElementById("demo").innerHTML = new Date();
      }
      //[1]test
      //script 블럭
      //document.getElementById("mybtn").onclick=diplayDate();
      // 이코드가 문제가 생기는 이유 스크립트는 라인단위로 실행되는데
      //실행순서때문에 ....body 안에 요소가 메모리에 없기때문에
      window.onload = function () {
        console.log("load.....");
        //document.getElementById("mybtn").onclick=diplayDate(); 괄호가 없어야 바로 호출이 안된다.
        document.getElementById("mybtn").onclick = diplayDate;
      };
    </script>
  </head>
  <body>
    <button id="mybtn">111</button>
    <br />
    <button id="mybtn2" onclick="displayDate()">222</button>
    <br />
    <p id="demo"></p>
  </body>
  <script>
    //[2]test
    //document.getElementById("mybtn").onclick=diplayDate();
    //버튼을 클릭하기 전에 displayDate()호춣...
    //특급 주의사항...함수의 괄호()

    //document.getElementById("mybtn").onclick=diplayDate;
  </script>
</html>
```

### AddEventListener

element.addEventListener(event, function, useCapture);  
 element.removeEventListener("mousemove", myFunction);

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <script>
      /*
  element.addEventListener(event, function, useCapture);
첫 번째 매개변수는 이벤트 유형(예: " click" 또는 " mousedown" 또는 기타 HTML DOM 이벤트 )입니다.
두 번째 매개변수는 이벤트가 발생할 때 호출하려는 함수입니다.
element.removeEventListener("mousemove", myFunction);

   */
    </script>
  </head>

  <body>
    <button id="mybtn">클릭</button>
    <p id="demo"></p>
  </body>
  <script>
    //1. 하나의 요소는 여러개의 event를 가질 수 있다.
    //2. 이벤트가 더이상 필요하지 않다면 removeEventListener()제거가능 (단 addEvent 추가)

    document.getElementById("mybtn").addEventListener("click", displayText); //괄호 안씀
    //document.geElementById("mybtn").addEventListener(type,function(e){},capture)
    function displayText() {
      document.getElementById("demo").innerHTML = "hello world";
    }
  </script>
</html>
```

### AddEventListener 실습

버튼에 마우스가 올라갔을때 mousseover라는 글을 버튼에 추가시키고  
버튼에 마우스가 떨어졌을떄 mousseout라는 글을 버튼에 추가시키고  
버튼을 클릭했을때 click이라는 글을 버튼에 추가시키자.

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <button id="mybtn">클릭</button>
  </body>
  <script>
    let x = document.getElementById("mybtn");

    x.addEventListener("mouseover", myFunc);
    x.addEventListener("mouseout", myFunc2);
    x.addEventListener("click", myFunc3);

    function myFunc() {
      document.getElementById("mybtn").innerHTML += "Mouse Over<br>";
    }
    function myFunc2() {
      document.getElementById("mybtn").innerHTML += "Mouse Out<br>";
    }
    function myFunc3() {
      document.getElementById("mybtn").innerHTML += "Click<br>";
    }
  </script>
</html>
```

### addEventListener 문제

문제  
a click 이벤트 처리하시고  
[0] [1] [2] [3]  
images/1.jpg images/2.jpg...  
다음 링크를 클릭하면 다음 image를 보여주세요  
이번 링크를 클릭하면 이전 image를 보여주세요

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <script>
      window.onload = function () {
        let myphotos = [
          "images/1.jpg",
          "images/2.jpg",
          "images/3.jpg",
          "images/4.jpg",
        ];

        //문제
        //a click 이벤트 처리하시고
        //[0]             [1]           [2]            [3]
        //images/1.jpg  images/2.jpg...
        //다음 링크를 클릭하면 다음 image를 보여주세요
        //이번 링크를 클릭하면 이전 image를 보여주세요
        let index = 0; //글로벌로 한 이유 next하다가 이전으로 갔을때 그 값을 읽어 올 수 없기 떄문에
        console.log("index:" + index);

        document.getElementById("prv").addEventListener("click", function () {
          if (index == 0) {
            index = myphotos.length;
          }
          document.getElementById("imgs").src = myphotos[--index];
        });
        document.getElementById("next").addEventListener("click", function () {
          if (++index == myphotos.length) {
            //index가 4가 될 때 걸리면
            index = 0;
          }

          document.getElementById("imgs").src = myphotos[index];
        });
      };
    </script>
  </head>

  <body>
    <h3>DOM 슬라이드</h3>
    <img src="images/1.jpg" alt="이미지" id="imgs" width="200" height="200" />
    <hr />
    <a href="#" id="prv">이전</a>|| <a href="#" id="next">다음</a>
  </body>
</html>
```

###

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script type="text/javascript">
      /*  
	https://www.w3schools.com/jsref/dom_obj_event.asp
	>>JAVA
	try{
		 0/0 >> 예외가 발생 ...예외에 해당하는 객체가 자동 생성 div ..객체 자동 생성 (정보가 담겨요)
		 생성된 예외 객체의 주소를 e변수가 받는다 
	}catch(Exception e) 
	
	문제가 발생하면 자동 객체 생성 .... (문제에 정보가 담긴다 ) >> 그 객체를 가지고 >>......
	
	
	javascript >> 사건이 발생 (click , mouseover) >> 내부적으로 객체 하나 생성 >>
	Event 객체 >> 사건에 대한 정보 (누가 사건, 사건 주체 , 영향 .....)
	
	자동으로 생성된 Event 객체의 주소를 받아서 사용 ..POINT 
	
	window.event.메서드 ..제공
	window.event.속성   ..제공 
	
	KEY POINT : Event 객체 가 가지고 있는 메서드 , 속성 ....
	
	*/
      window.onload = function () {
        let btn = document.getElementById("mybtn");
        btn.onclick = function (e) {
          //e변수가 Event객체의 주소값을 받아요 .....
          console.log(e.type); //Event객체가 가지는 type 속성 >> 어떤 이벤트가 발생했는지 >> 종류
          console.log(e.target); //<span>눌러봐</span>
          console.log(e.currentTarget); //<button id="mybtn"><span>눌러봐</span></button
          console.log(e.x); //좌표값
          console.log(e.y);
        };

        let btn2 = document.getElementById("mybtn2");
        let handler = function (event) {
          //Event객체의 주소 전달 받아여
          switch (
            event.type //event.type
          ) {
            case "click":
              alert("클릭");
              break;
            case "mouseover":
              event.target.style.backgroundColor = "red"; //응용 ...
              break;
            case "mouseout":
              event.target.style.backgroundColor = "";
              break;
          }
        };

        btn2.onclick = handler; //함수의 주소
        btn2.onmouseover = handler; //함수의 주소
        btn2.onmouseout = handler; //함수의 주소

        /*
		btn2.onclick = function(e){}; //함수의 주소
		btn2.onmouseover = function(e){}; //함수의 주소
		btn2.onmouseout = function(e){}; //함수의 주소
		
		*/
      };
    </script>
  </head>
  <body>
    <button id="mybtn"><span>눌러봐</span></button>
    <br />
    <button id="mybtn2">눌러봐2</button>
  </body>
</html>
```

### 버블링, 캡쳐링

버블링(bubbling)의 원리는 간단합니다.

한 요소에 이벤트가 발생하면, 이 요소에 할당된 핸들러가 동작하고, 이어서 부모 요소의 핸들러가 동작합니다. 가장 최상단의 조상 요소를 만날 때까지 이 과정이 반복되면서 요소 각각에 할당된 핸들러가 동작합니다.

3개의 요소가 FORM > DIV > P 형태로 중첩된 구조를 살펴봅시다. 요소 각각에 핸들러가 할당되어 있습니다.
![버블링](https://joshua1988.github.io/images/posts/web/javascript/event/event-bubble.png)

캡처링은 버블링과는 반대로 최상위 태그에서 해당 태그를 찾아 내려간다.
![캡쳐링](https://joshua1988.github.io/images/posts/web/javascript/event/event-capture.png)

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script type="text/javascript">
      /*  
	https://www.w3schools.com/jsref/dom_obj_event.asp
	>>JAVA
	try{
		 0/0 >> 예외가 발생 ...예외에 해당하는 객체가 자동 생성 div ..객체 자동 생성 (정보가 담겨요)
		 생성된 예외 객체의 주소를 e변수가 받는다 
	}catch(Exception e) 
	
	문제가 발생하면 자동 객체 생성 .... (문제에 정보가 담긴다 ) >> 그 객체를 가지고 >>......
	
	
	javascript >> 사건이 발생 (click , mouseover) >> 내부적으로 객체 하나 생성 >>
	Event 객체 >> 사건에 대한 정보 (누가 사건, 사건 주체 , 영향 .....)
	
	자동으로 생성된 Event 객체의 주소를 받아서 사용 ..POINT 
	
	window.event.메서드 ..제공
	window.event.속성   ..제공 
	
	KEY POINT : Event 객체 가 가지고 있는 메서드 , 속성 ....
	
	*/
      window.onload = function () {
        let btn = document.getElementById("mybtn");
        btn.onclick = function (e) {
          //e변수가 Event객체의 주소값을 받아요 .....
          console.log(e.type); //Event객체가 가지는 type 속성 >> 어떤 이벤트가 발생했는지 >> 종류
          console.log(e.target); //<span>눌러봐</span>
          console.log(e.currentTarget); //<button id="mybtn"><span>눌러봐</span></button
          console.log(e.x); //좌표값
          console.log(e.y);
        };

        let btn2 = document.getElementById("mybtn2");
        let handler = function (event) {
          //Event객체의 주소 전달 받아여
          switch (
            event.type //event.type
          ) {
            case "click":
              alert("클릭");
              break;
            case "mouseover":
              event.target.style.backgroundColor = "red"; //응용 ...
              break;
            case "mouseout":
              event.target.style.backgroundColor = "";
              break;
          }
        };

        btn2.onclick = handler; //함수의 주소
        btn2.onmouseover = handler; //함수의 주소
        btn2.onmouseout = handler; //함수의 주소

        /*
		btn2.onclick = function(e){}; //함수의 주소
		btn2.onmouseover = function(e){}; //함수의 주소
		btn2.onmouseout = function(e){}; //함수의 주소
		
		*/
      };
    </script>
  </head>
  <body>
    <button id="mybtn"><span>눌러봐</span></button>
    <br />
    <button id="mybtn2">눌러봐2</button>
  </body>
</html>
```

### 버블링 전파 막기

버블링은 해당 타깃에서 document 객체를 만날 때까지 핸들러가 모두 호출되는데 코드를 작성하다보면 원하는 타깃에서만 이벤트를 발생하게 하고 싶을때가 있다.

그럴 때에는 event.stopPropagation() 을 사용하면 되는데 버블링의 경우에는 클릭한 타깃의 이벤트만 발생하고 상위 요소로 이벤트가 전파되는 것을 막을 수 있다.

버블링에서 작성된 코드에 event.stopPropagation() 을 추가하고 실행해보자.

```js
const clickEvent = (e) => {
  e.stopPropagation();
  console.log(e.currentTarget.className);
};
```

아까는 DIV3을 클릭했을 때 이벤트가 전파되어 DIV3, DIV2, DIV1 이 출력이 됐지만 이번에는 클릭한 타깃의 이벤트만 발생하는 것을 알 수 있다.

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script type="text/javascript">
      function checkTarget(event) {
        console.log(event.type); //click
      }

      function showmsg() {
        event.stopPropagation(); //이벤트의 전파를 막겠다
        console.log("Webisfree");
      }

      var doDep1 = function (event) {
        alert("Clicked dep1");
      };
      var doDep2 = function (event) {
        alert("Clicked dep2");
      };
      var doDep3 = function (event) {
        event.stopPropagation();
        alert("Clicked dep3");
      };
    </script>
    <style type="text/css">
      .dep1 {
        width: 200px;
        height: 200px;
        display: block;
        background-color: #dcdcdc;
      }
      .dep2 {
        width: 100px;
        height: 100px;
        display: block;
        margin: 3px auto;
        background-color: #ececec;
      }
      button {
        display: block;
        margin: 0 auto;
      }
    </style>
  </head>
  <body>
    <!--  
  event.target은 이벤트버블링의 가장 마지막에 위치한 최하위의 요소를 반환합니다. 
  즉 클릭된 요소를 기준으로 사용하는 경우 event.target을 사용합니다. 
  하지만 event.currentTarget의 경우 이벤트가 바인딩된 요소, 
  해당하는 요소를 반환합니다
  
  <div onclick="checkTarget();">
     <span>test</span>
  </div>
  
  function checkTarget(event) {
     var ele = event.currentTarget;
     console.log(ele);
  }
  event.target  //  클릭된 span 태그를 반환
  event.currentTarget  //  이벤트가 바인딩된 div 요소를 반환

  위 예제는 간단한 1 depth의 하위 구조를 가졌지만 복잡해지는 경우 
  event.target 만으로는 어떤 요소가 클릭되어 반환되어야하는지 그 결과가 달라질 수 있습니다. 
  이런 경우 event.currentTarget을 활용하는 것이 더욱 편리할 것입니다.
 -->
    <div onclick="showmsg()" style="background-color: red">
      <p onclick="showmsg()" style="background-color: yellow">Click Me!!</p>
    </div>

    <div class="dep1" onclick="doDep1(event);">
      dep1
      <div class="dep2" onclick="doDep2(event);">
        dep2
        <br />
        <br />
        <button onclick="doDep3(event);">dep3</button>
      </div>
    </div>
  </body>
</html>
```

### 이벤트 객체 활용 todolist 만들어보기

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      #add-btn {
        padding: 5px 10px;
        border: 0;
        background: #f80;
        color: white;
        border-radius: 5px;
      }

      ul {
        padding: 0;
        list-style-position: inside;
      }

      li {
        border-bottom: 1px solid #999;
        padding: 5px 0;
      }

      .active {
        background: #abc;
      }

      /* step3: 목록 클릭 스타일 */
    </style>
  </head>

  <body>
    <h1 id="title">할일 목록</h1>
    <button id="add-btn">목록 추가</button>
    <ul id="list">
      <li>제목 1</li>
      <li>제목 2</li>
      <li>제목 3</li>
      <li>제목 4</li>
    </ul>
  </body>
  <script>
    let title = document.getElementById("title");
    let list = document.getElementById("list");
    let li = document.getElementsByTagName("li");
    let addbtn = document.getElementById("add-btn");

    //TEST
    // console.log(title);
    // console.log(list);
    // console.log(li);
    // console.log(addbtn);

    function activeItem(event) {
      //이벤트 객체를 받아서
      console.log(event.target); //li
      console.log(event.currentTarget); //ul

      if (event.target.nodeName == "LI") {
        title.innerHTML = event.target.innerText;
      }
      //active가 다른데 가면 없애기위해서 꼼수를 써야한다.
      // 모든요소의 class를 제거하고 다시 추가하는 방법
      for (let i = 0; i < event.target.parentNode.children.length; i++) {
        event.target.parentNode.children[i].removeAttribute("class");
      }
      event.target.setAttribute("class", "active");
    }
    list.addEventListener("click", activeItem);

    //목록추가
    addbtn.addEventListener("click", function () {
      let txt = prompt("제목입력"); //window 객체가 가지는 내장함수
      if (txt != null) {
        list.innerHTML += "<li>" + txt + "</li>";
      }
    });
  </script>
</html>
```

### 이벤트 a태그 기능 막기

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <form action="Ex35.jsp" id="frm">
      <fieldset>
        <legend>주소록</legend>
        <textarea rows="10" cols="30" name="txt" id="txt"></textarea>
        <input type="submit" id="sub" value="전송하기" />
      </fieldset>
    </form>
  </body>
  <script type="text/javascript">
    let add = ["아무개", "email:i7027@naver.com"];

    let frm = document.getElementById("frm");

    function addr_Search(event) {
      console.log(event.type);

      let textarea = frm.txt;
      textarea.value = "이름/주소\n";
      textarea.value += add[0] + "," + add[1] + "\n";
    }

    //point
    frm.addEventListener("submit", function (event) {
      //<input type="submit"...action="Ex35.jsp" 전송기능을 가지고 있어요
      //원래 가지고 있는 기본 이베느트는 해제 하고 싶어요
      //<a->event 걸어서 링크로 빠져나가지 못하게 막는 것
      event.preventDefault();
      addr_Search(event);
    });
  </script>
</html>
```

```html

```

```html

```

```html

```
