package level1;

public class PrimeNum1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int numberOfPrime(int n) {
        int result = 0;
        for(int i=2; i<=n; i++){
        for(int j=2; j<=i; j++){
        if(j == i){
            ++result;
        } else if(i%j == 0){
            break;
        }
      }
    }

        return result;
    }
}
