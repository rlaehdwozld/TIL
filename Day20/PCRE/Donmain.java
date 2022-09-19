package PCRE;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Donmain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String domain = "^((http|https)://)?(www.)?([a-zA-Z0-9]+)\\.[a-z]+([a-zA-z0-9.?#]+)?";
        String user = sc.nextLine();

        boolean regex = Pattern.matches(domain, user);
        System.out.println(regex);
    }
}

//^((http|https)://)?(www.)?([a-zA-Z0-9]+)\\.[a-z]+([a-zA-z0-9.?#]+)?
//((http|https)://)? : http or https 이후 :// 가 붙는지를 0번 또는 1차례 발생 확인
//(www.)? : www. 이 0번 또는 1차례 발생 확인
//[a-zA-Z0-9]+\\ : 영문/영대문자/숫자가 무조건 있는지, "_"를 제외하여 영숫자가 아닌 문자열들과 일치시키기
//.[a-z]+([a-zA-z0-9.?#]+)? : . 이후에 소문자가 한번이상 반복하고 영문/영대문자/숫자가 무조건 있는지 이후 종료