package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class ExeTimeAspect2 {
	
	// execution(수식어패턴? 리턴타입패턴 클래스이름패턴? 메서드이름패턴(파라미터패턴))
	// 수식어패턴은 상당부분 생략 가능 ex) public protected
	// * 모든 값, .. 0개이상
	
	@Pointcut("execution(public * chap07..*(..))")
	private void publicTarget() {
		
	}
	
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.nanoTime();
		try {
			Object result = joinPoint.proceed(); 
			return result;
		} finally {
			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature(); //호출된 메서드의 정보 리턴
			System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n",
					joinPoint.getTarget().getClass().getSimpleName(), // ProceedingJoinPoint.getTarget 대상객체를 구한다.
					sig.getName(), Arrays.toString(joinPoint.getArgs()), (finish-start));
		}
	}
		
	// org.asjectj.lang.Signature 인터페이스
	//	String getName - 메서드 이름 리턴
	//	String toLongString - 메서드 완전하게 문장으로(메서트 리턴타입, 파라미터 모두 표시)
	//	String toShortString - 메서드 축약해서 문장으로(메서드 이름만)

}
