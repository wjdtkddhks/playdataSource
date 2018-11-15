import java.util.ArrayList;
import java.util.StringTokenizer;

public class Dart {

	public static void main(String[] args) {
		String a = "1s2d*3t";

		System.out.println("result : " + result(a));

	}
	
	public static int result(String dart) {
		int res = 0;
		StringTokenizer stn = new StringTokenizer(dart, "s,d,t", true);
		ArrayList<String> tokenList = new ArrayList<String>();
		
		while(stn.hasMoreTokens()) {
			String token = stn.nextToken();
				if(token.length() == 3) {
					if(token.charAt(0) == '#' || token.charAt(0) == '*') {
						tokenList.add(Character.toString(token.charAt(0)));
						tokenList.add("10");
					}
				}else if(token.length() == 2) {
					if(token.charAt(0) == '#' || token.charAt(0) == '*') {
						tokenList.add(Character.toString(token.charAt(0)));
						tokenList.add(Character.toString(token.charAt(1)));
					}else {
						tokenList.add("10");
					}
				}else if(token.length() == 1) {
						tokenList.add(token);
				}
		}
		
		if(tokenList.size() == 6) {
			for(int i=0; i<tokenList.size();) {
				res += sdtCheck(tokenList.get(i), tokenList.get(i+1));
				i = i+2;
			}	
			return res;
		}
		
		for(int i=tokenList.size()-1; i>=0; i--) {
			if(tokenList.get(i).equals("s") || tokenList.get(i).equals("d") || tokenList.get(i).equals("t")){
				if(i != tokenList.size()-1) {
				if(tokenList.get(i+1).equals("#") || tokenList.get(i+1).equals("*")) {
					res += sharpCheck(tokenList.get(i-1), tokenList.get(i), tokenList.get(i+1));
					if(tokenList.get(i-2).equals("#") || tokenList.get(i-2).equals("*")) {
						res += sharpCheck(tokenList.get(i-4), tokenList.get(i-3), tokenList.get(i-2), tokenList.get(i+1));
						if(tokenList.get(i-5).equals("#") || tokenList.get(i-5).equals("*")) {
							res += sharpCheck(tokenList.get(i-7), tokenList.get(i-6), tokenList.get(i-5), tokenList.get(i-2));
							return res;
						}else {
							res += sdtCheck(tokenList.get(i-6), tokenList.get(i-5));
							return res;
						}
					}else {
						if(tokenList.get(i+1).equals("*")) {
							res += sharpCheck(tokenList.get(i-3), tokenList.get(i-2), tokenList.get(i+1));
							if(tokenList.get(i-4).equals("#") || tokenList.get(i-4).equals("*")) {
								res+= sharpCheck(tokenList.get(i-6), tokenList.get(i-5), tokenList.get(i-4));
								return res;
							}else {
								res += sdtCheck(tokenList.get(i-5),tokenList.get(i-4));
								return res;
							}
						}else {
							res += sdtCheck(tokenList.get(i-3), tokenList.get(i-2));
							if(tokenList.get(i-4).equals("#") || tokenList.get(i-4).equals("*")) {
								res+= sharpCheck(tokenList.get(i-6), tokenList.get(i-5), tokenList.get(i-4));
								return res;
							}else {
								res += sdtCheck(tokenList.get(i-5),tokenList.get(i-4));
								return res;
							}
						}
					}
				}else {
					res += sdtCheck(tokenList.get(i-1), tokenList.get(i));
					if(tokenList.get(i-2).equals("#") || tokenList.get(i-2).equals("*")) {
						res+= sharpCheck(tokenList.get(i-4), tokenList.get(i-3), tokenList.get(i-2));
						if(tokenList.get(i-5).equals("#") || tokenList.get(i-5).equals("*")) {
							res+= sharpCheck(tokenList.get(i-7), tokenList.get(i-6), tokenList.get(i-5), tokenList.get(i-2));
							return res;
						}else {
							if(tokenList.get(i-2).equals("*")) {
								res+= sharpCheck(tokenList.get(i-6), tokenList.get(i-5), tokenList.get(i-2));
								return res;
							}else {
								res+= sdtCheck(tokenList.get(i-6), tokenList.get(i-5));
								return res;
							}
						}
					}else {
						res+= sdtCheck(tokenList.get(i-3), tokenList.get(i-2));
						if(tokenList.get(i-4).equals("#") || tokenList.get(i-4).equals("*")) {
							res += sharpCheck(tokenList.get(i-6), tokenList.get(i-5), tokenList.get(i-4));
							return res;
						}else {
							res += sdtCheck(tokenList.get(i-5), tokenList.get(i-4));
							return res;
						}
					}
				}
				}else {
					res += sdtCheck(tokenList.get(i-1), tokenList.get(i));
					if(tokenList.get(i-2).equals("#") || tokenList.get(i-2).equals("*")) {
						res+= sharpCheck(tokenList.get(i-4), tokenList.get(i-3), tokenList.get(i-2));
						if(tokenList.get(i-5).equals("#") || tokenList.get(i-5).equals("*")) {
							res+= sharpCheck(tokenList.get(i-7), tokenList.get(i-6), tokenList.get(i-5), tokenList.get(i-2));
							return res;
						}else {
							if(tokenList.get(i-2).equals("*")) {
								res+= sharpCheck(tokenList.get(i-6), tokenList.get(i-5), tokenList.get(i-2));
								return res;
							}else {
								res+= sdtCheck(tokenList.get(i-6), tokenList.get(i-5));
								return res;
							}
						}
					}else {
						res+= sdtCheck(tokenList.get(i-3), tokenList.get(i-2));
						if(tokenList.get(i-4).equals("#") || tokenList.get(i-4).equals("*")) {
							res += sharpCheck(tokenList.get(i-6), tokenList.get(i-5), tokenList.get(i-4));
							return res;
						}else {
							res += sdtCheck(tokenList.get(i-5), tokenList.get(i-4));
							return res;
						}
					}
				}
			}
		}	
		
		return res;
	}
	
	public static int sdtCheck(String num, String up) {
		int res = 0;
		if(up.equals("s")) {
			res += Integer.parseInt(num);
		}else if(up.equals("d")) {
			res += Math.pow(Integer.parseInt(num), 2);
		}else if(up.equals("t")) {
			res += Math.pow(Integer.parseInt(num), 3);
		}
		
		return res;
	}
	
	public static int sharpCheck(String num, String up, String bonus) {
		int res = 0;
		if(bonus.equals("*")) {
			res += sdtCheck(num, up)*2;			
		}else if(bonus.equals("#")) {
			res += sdtCheck(num, up)*(-1);
		}
		
		return res;
	}
	
	public static int sharpCheck(String num, String up, String bonus, String bbs) {
		int res = 0;
		if(bbs.equals("*")) {
			if(bonus.equals("*")) {
				res += sdtCheck(num, up)*2*2;
			}else {
				res += sdtCheck(num, up)*2*(-1);
			}			
		}else if(bbs.equals("#")) {
			if(bonus.equals("*")) {
				res += sdtCheck(num, up)*2*(-1);
			}else {
				res += sdtCheck(num, up)*(-1)*(-1);
			}
		}
		
		return res;
	}

}
