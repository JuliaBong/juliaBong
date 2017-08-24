package newsAPI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;


public class nhnNews {

	static StringBuffer response;
	
    public String nhnNews_test(String keyword, String align, String display, String start) {
        String clientId = "xdJPuvMfIoDlZddUpS7f";	//애플리케이션 클라이언트 아이디값";
        String clientSecret = "I5bSxEAYrO";	//애플리케이션 클라이언트 시크릿값";
        System.out.println(keyword);
        try {
            String text = URLEncoder.encode(keyword, "UTF-8");
            
            String query = "query=" + text;
            String query2 = "&display=" + display;
            String query3 = "&sort=" + align;
            String query4 = "&start=" + start;
            
            String apiURL = "https://openapi.naver.com/v1/search/news.json?"+ query + query2 + query3 + query4; // json 결과
            //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
            
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
            }
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            return response.toString();
            
        } catch (Exception e) {
            System.out.println(e);
    		return null;
        }
    }
}