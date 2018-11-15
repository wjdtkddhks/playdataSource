import java.util.Arrays;

public class NumberK {

	public static void main(String[] args) {
		int[] k = {1, 5, 2, 6, 3, 7, 4};
		int[][] g = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		System.out.println(Arrays.toString(solution(k,g)));
	}
	
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        System.out.println(commands.length);
        
        for(int i=0; i<commands.length; i++) {
        	int[] b = Arrays.copyOf(array, array.length);
        	int start = commands[i][0]-1;
        	int end = commands[i][1];
        	int get = commands[i][2];
        	
        	Arrays.sort(b, start, end);
        	int ans = b[start+get-1];

        	answer[i] = ans;
        }
        
        return answer;
    }

}
