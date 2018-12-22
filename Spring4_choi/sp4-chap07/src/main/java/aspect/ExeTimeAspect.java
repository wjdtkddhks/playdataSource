package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class ExeTimeAspect {
	
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.nanoTime();
		try {
			Object result = joinPoint.proceed(); // 대상객체의 메서드 호출할때 사용
			return result;
		} finally {
			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s.%s(%s) 실행시간 : %d ns\n",
										joinPoint.getTarget().getClass().getSimpleName(),
										sig.getName(), Arrays.toString(joinPoint.getArgs()), (finish-start));
		}
	}

}
