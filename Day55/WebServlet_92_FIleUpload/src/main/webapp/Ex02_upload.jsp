<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
cos.jar 에서 다중 파일 업로드를 지원하는 객체가 바로 >> MultipartRequest >> request 객체를 넘겨준다
***MultipartRequest 객체의 생성자**************************************************
MultipartRequest(
javax.servlet.http.HttpServletRequest request,
java.lang.String saveDirectory,
int maxPostSize,
java.lang.String encoding,
FileRenamePolicy policy)

request : MultipartRequest와 연결될 request객체를 의미한다.
saveDirectiory : 서버측에 파일이 실질적으로 저당될 경로를 의미한다.
maxPostSize : 한번에 업로드 할수있는 최대 파일 크기를 의미한다.
encoding : 파일의 이름 인코딩 방식을 의미한다.
policy : 파일이름 중복 처리를 위한 인자를 의미한다. 기본값 : 똑같은 파일 덮어쓰기

***MultipartRequest 객체의 메서드**************************************************
getParameterNames() : 폼에서 전송된 파라미터의 타임이 file이 아닌 이름들을 Enumeration 타입으로 리턴한다.
getParameterValues() : 폼에서 전송된 파라미터 값들을 배열로 받아온다.
getParameter() : Request객체에 있는 해당 파라미터의 값을 가져온다.
getFileNames() : 파일을 여러개 업로드 할 경우 타입이 file인 파라미터 이름들을 Enumeration 타입으로 리턴한다.
getFileSystemName() : 서버에 실제로 업로드 된 파일의 이름을 의미한다.
getOriginalFileName() : 클라이언트가 업로드 한 파일의 원본 이름을 의미한다.
getContentType() : 업로드 된 파일의 컨텐트 타입을 얻을때 사용한다.
getFile() : 서버에 업로드 된 파일 객체 자체를 반환하는 메소드이다.


가상경로(웹) : http://localhost:8090/WebServlet_93_FileUpload/upload/
물리적 경로(웹 서버 특정경로) :
1. D:\bit\WEBJSP\Labs\WebServlet_93_FileUpload\WebContent\upload
2. 이클립스 톰켓 내장 : 실 배포 경로
실제 파일 저장 경로(아래 있는 경로)
D:\bit\WEBJSP\Labs\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\WebServlet_93_FileUpload\upload
-->
<%
   //1. 서버 저장 경로 확보하기 (실제 배포된 경로 ...) or 절대경로 (D:\\Download)
   String uploadpath = application.getRealPath("upload");
   //System.out.println(uploadpath);
   
   //cos.jar파일이 제공하는 MultipartRequest 객체 사용
   
   //업로드한 파일에 대한 기본정보 세팅
   int size = 1024*1024*10; //10M (네이버 계산기) 10메가
   String name ="";
   String title="";
   String filename1="";
   String filename2="";
   String orifilename1="";
   String orifilename2="";
   
   MultipartRequest multi = new MultipartRequest(
         request, //클라이언트가 서버로 요청하면 자동 생성 되는 객체(정보)
         uploadpath, //실 저장할 경로 (배포경로)
         size,  //10M
         "UTF-8",
         new DefaultFileRenamePolicy() // 파일이름 중복되면 (upload > 1.jpg > 1.jpg 업로드 > 1_1.jpg)
   );
   
   //파일 업로드는 위 6줄로 끝입니다.
   //웹서버의 특정 폴더에 upload 폴더에 저장됩니다.
   //저장되는 배포경로는   
   //C:\KOSA_IT\Web(Back)\Labs\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\WebServlet_92_FileUpload
   
   //실제로 자료실 게시파능ㄹ 구현하기 위해서
   //파일은 서버의 특정 경로에 저장하고
   //파일에 대한 정보(파일 이름, 파일 사이즈 등은 데이터 베이스에 게시글과 같이 저장 되어야합니다.)
   
   //DB에 저장하기 위해서
   //작성자 , 제목 , 내용, 파일명 , 파일사이즈 >> MultipartRequest 객체가 가지고 있어요
   
   name = multi.getParameter("name");
   title = multi.getParameter("title");
   String hid = multi.getParameter("hid");
   
   System.out.println(name + "-" + title + "-" + hid);
   Enumeration filenames = multi.getFileNames();
   //while(filenames.hasMoreElements()){
   //   System.out.println(filenames.nextElement());
   //};
   
   //2개 업로드 전제로 
   //기존 upload폴더에 a.jpg
   
   //a.jpg 업로드
   //orifilename > a.jpg
   //filename     > a1.jpg
   
   String file2 = (String)filenames.nextElement();
   filename2 = multi.getFilesystemName(file2);
   orifilename2 = multi.getOriginalFileName(file2);
   
   String file1 = (String)filenames.nextElement();
   filename1 = multi.getFilesystemName(file1);
   orifilename1 = multi.getOriginalFileName(file1);
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록보기</title>
</head>
<body>
 <form action="Ex03_upload_detail.jsp" method="get" name="filelist">
            <input type="hidden" name="name" value="<%=name %>">
            <input type="hidden" name="title" value="<%=title %>">
            <input type="hidden" name="filename2" value="<%=filename2 %>">
            <input type="hidden" name="orifilename2" value="<%=orifilename2 %>">
            <input type="hidden" name="filename1" value="<%=filename1 %>">
            <input type="hidden" name="orifilename1" value="<%=orifilename1%>">
            <a href="#" onclick="javascript:filelist.submit()">상세보기</a>
         </form>
</body>
</html>