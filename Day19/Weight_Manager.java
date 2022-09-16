package kr.or.data.object;



import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
 
public class Weight_Manager {
    public Scanner keyboard = new Scanner(System.in);
    public String str_name="기본값";
    public String str_weight="기본값";
    public String str_password="기본값";
    String[] txt_data=null;
    File f;
    File fd= new File("C://WeightMgData/"); //파일이 생성될곳
   
    public static void main(String[] args) {
    	Weight_Manager wm = new Weight_Manager();
        int choiceInt;
       
        while (true) {
 
            try {
                wm.showMenu();
                choiceInt = wm.keyboard.nextInt();
                wm.keyboard.nextLine(); //다음 입력을 위해 날림
                System.out.println();
 
                if (choiceInt < 1 || choiceInt > 5) // 주어진 메뉴의 범위를 벗어나면
                    throw new MenuChoiceException(choiceInt); // 정의해놓은 Exception발생
 
                switch (choiceInt) {
                case 1: wm.inputWeight();break;
                case 2: wm.searchWeight();break;
                case 3: wm.changeWeight();break;
                case 4: wm.changePassword();break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                    // System.exit(0);
                }// switch문 닫기
            } catch (MenuChoiceException e) {
                e.showWrongChoice();
                System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
                System.out.println();
           
            } catch(IOException e){
                System.out.println(e + "오류발생");
               
            } catch(Exception e){
                 String temp = wm.keyboard.nextLine();  //재입력을 위해 키보드로 입력받은 값을 문자로 다시 받음
                 System.out.println("입력하신 "+temp+"는 숫자가 아닙니다.");
                System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
                System.out.println();
            }// catch문닫기
 
        }// while문 닫기
    }
 
    //===========================================메뉴를 보여주는 메서드
 public void showMenu() {
       
        str_name="기본값";
        str_weight="기본값";
        str_password="기본값";
       
        System.out.println("\n다음 사항에 맞게 입력하여 주십시요");
        System.out.println("======> 몸무게 입력은  1번");
        System.out.println("======> 몸무게 검색은  2번");
        System.out.println("======> 몸무게 변경은  3번");
        System.out.println("======> 비밀번호변경은 4번");
        System.out.println("======> 프로그램종료는 5번");
        System.out.println("을 입력한후 Enter을 눌러주십시요");
        System.out.print("메뉴 선택 : ");
    }
    //==============================================================
 
    //===============================================//몸무게 입력하기
 public void inputWeight() throws IOException{
        boolean fileExist;
       
        System.out.println("이름을 입력하여 주십시요.");
        System.out.print("이름 : "); 
        this.str_name = keyboard.nextLine();
        System.out.println();//@@
       
        File f= new File("C://WeightMgData/"+this.str_name+".txt"); //기록할 파일객체 생성
        
        if( !f.exists()){      
       
            System.out.println("몸무게를 입력하여 주십시요.");
            System.out.print("몸무게 : ");
            this.str_weight = keyboard.nextLine();
            System.out.println();
            System.out.println("비밀번호를 입력하여 주십시요.");
            System.out.print("비밀번호 : ");
            this.str_password = keyboard.nextLine();
            System.out.println();
           
            showResult(); //입력한 값 보여주기
               
            //File fd= new File("C://WeightMgData/");
            //File f= new File("C://WeightMgData/"+this.str_name+".txt"); //파일생성
            if (!fd.exists()) fd.mkdir(); // C://WeightMgData/폴더 생성//@@
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.str_weight+":");  //생성한 파일에 쓰기
            bw.write(this.str_password);
           
            bw.close();
            System.out.println("___입력이 완료되어_..[ C://WeightMgData/"+this.str_name+".txt ]._가(이) 생성되었습니다.");
        }else{
            System.out.println("현재 ["+this.str_name+"] 사용자가 존재합니다.");
            System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
            System.out.println();
        }
           
    }//inputWeight닫기
    
    //===============================================//몸무게 검색하기
 public void searchWeight() throws IOException{
 
        boolean passcheck = fileCheck();
       
        if (passcheck) {
            System.out.println("*****************************************************************");
            System.out.println("\t\t" + this.str_name + "님의 몸무게는 "+ txt_data[0] + " kg 입니다.");
            System.out.println("*****************************************************************");
            System.out.println();
       
        } else {
                return;        
        }
        System.out.println();
    }//searchWeight() 닫기
   
    //===============================================//몸무게 변경하기
 public void changeWeight() throws IOException{
               
        boolean passcheck = fileCheck();       
       
        if (passcheck) {
            System.out.println("*****************************************************************");
            System.out.println("\t\t"+this.str_name+"님의 몸무게는 "+this.txt_data[0]+" kg 입니다.");
            System.out.println("*****************************************************************");
            System.out.println("\t\t변경할 몸무게를 입력하여 주십시요.");
            System.out.print("\t\t변경할 몸무게 : ");
            this.str_weight = keyboard.nextLine();
           
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            //int str_num = txt_data[1].length();
            //System.out.println(str_num);
            bw.write(this.str_weight+":");
            //bw.write(this.str_weight, 1, str_num-1);
            bw.write(this.str_password);
           
            bw.close();            
        }else{
            return;        
        }
       
        showResult();
       
    }//changeWeight() 닫기
   
    //===============================================//패스워드 변경하기   
  public void changePassword() throws IOException{
 
        boolean passcheck = fileCheck();       
       
        if (passcheck) {
            System.out.println("*****************************************************************");
            System.out.println("\t\t"+this.str_name+"님의 비밀번호는는 "+this.str_password+" 입니다.");
            System.out.println("*****************************************************************");
            System.out.println("\t\t변경할 패스워드를 입력하여 주십시요.");
            System.out.print("\t\t변경할 패스워드 : ");
            this.str_password = keyboard.nextLine();
           
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.str_weight+":");
            bw.write(this.str_password);
            bw.close();    
           
        }else{
            return;        
        }  
       
        showResult();
       
    }//changePassword()닫기
   
  public boolean fileCheck() throws IOException{  
        //검색, 몸무게 변경, 패스워드 변경시 입력받은 이름에 대한 파일존재여부체크 ,입력받은 패스워드에 대한 체크
        FileReader fr=null;
        BufferedReader br=null;
        String cmp_data;        //txt파일에서 한줄 읽어오기
        boolean boo = false;    //상태 체크
       
        System.out.println("검색할 이름을 입력하여 주십시요.");
        System.out.print("이름 : ");
        this.str_name = keyboard.nextLine();   
        System.out.println();
       
        f= new File(fd.getAbsolutePath()+"/"+this.str_name+".txt"); //입력받은이름으로 파일경로 생성
       
        if(f.exists()){ //파일이 존재하면//@@
            fr= new FileReader(f);  //파일 읽을 준비
            br= new BufferedReader(fr);
            cmp_data = br.readLine(); //읽어온 파일에서 한줄을 cmp_data에 저장한다.
            txt_data = cmp_data.split(":"); // ':' 로 쪼개 txt_data배열에 저장
            //System.out.println(txt_data.length); //txt_data배열 크기 보기
            br.close(); //닫기   
                       
           
           
            //int cnt = 2;  //비밀번호 체크를 3회만 한다.
            //while(cnt>0){
            for( int cnt = 3;cnt>0;cnt--){ 
               
                System.out.println("비밀번호를 입력하여 주십시요.");
                System.out.print("비밀번호 : ");
                this.str_password = keyboard.nextLine();
                System.out.println();
               
                if (txt_data[1].equals(this.str_password)) {
                    this.str_weight = txt_data[0];
                    boo =  true;
                    break;
                } else {
                   
                    if(cnt > 1) {
                    System.out.println("입력하신 비밀번호가 일치하지 않습니다.");
                    System.out.print((cnt-1) + "번의 기회가 남았습니다. 올바른 ");
                    }else{
 
                    System.out.println("입력하신 비밀번호가 일치하지 않습니다.");
                    System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
                    System.out.println("======================================");
                    System.out.println();
                   
                    }
 
                    /*System.out.print("비밀번호 : ");
                    this.str_password = keyboard.nextLine();
                    --cnt;*/
                }              
            }                              
        }else{//f.getName()
            System.out.println(str_name+"님 이(가) 존재하지 않습니다.");
            boo = false;
            }          
        return boo;
    }
   
           
 public void showResult(){   //입력받은 값을 보여주기
    System.out.println();
    System.out.println("*****************************************************************");
    System.out.println("\t이름 : "+this.str_name +", \t몸무게 : "+ this.str_weight + ",\t 비밀번호 : "+this.str_password);
    System.out.println("*****************************************************************");
    System.out.println();
}
   
   
   
}//WeightManagExam000 class닫기
 
 
 
class MenuChoiceException extends Exception { //잘못된 선택을 하게되면 생성될 Exception
    int wrongChoice; // 잘못된 입력값저장하기 위한 변수
 
    public MenuChoiceException(int choice) // 입력값을 받는 생성자
    {
        super("잘못된 선택이 이뤄졌습니다.");
        // Exception(String message)
        wrongChoice = choice; // 전달 받은 인자값을 전역변수 wrongChoice에 저장
    }
 
    public void showWrongChoice() {
        System.out.println(wrongChoice + "에 해당하는 선택은 존재하지 않습니다.");
    }
   
 
}// class MenuChoiceException 닫기