package Chapter15;

public class InvalidInputException extends Exception{
	
	InvalidInputException(){
		super("잘못된 입력입니다.");
	}
}
