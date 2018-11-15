import java.net.URL;

class practice {
	
	public static void main(String[] args) throws Exception {
		
		URL url = new URL("http://www.codechobo.com:80/sample/hello.html?referer=codechobo#index1");
		
		System.out.println(url.getAuthority());
		System.out.println(url.getHost());
		System.out.println(url.getFile());
		System.out.println(url.getPort());
		System.out.println(url.getProtocol());
	}
}
