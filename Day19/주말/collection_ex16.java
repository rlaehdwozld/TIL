package prac_1;

import java.util.HashMap;
import java.util.Set;

class QuizInfo{
	String question;
	String answer;
	String result;
	
	public QuizInfo(String question, String answer, String result) {
		super();
		this.question = question;
		this.answer = answer;
		this.result = result;
	}

	@Override
	public String toString() {
		return "QuizInfo [문제=" + question + ", 답안=" + answer + ", 결과=" + result + "]";
	}
}
public class collection_ex16 {
	public static void main(String[] args) {
		HashMap<String, String> quiz =new HashMap<String	, String	>();
		quiz.put("1+1", "2"	);
		quiz.put("1+2","3");
		quiz.put("1+3", "4");
		
		for(int i=0;i<quiz.size();i++) {
			Set set =quiz.keySet();
			Object[]obj = set.toArray();
			System.out.println("문제 : "+obj[i]);
		}
	}

}
