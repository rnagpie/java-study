package study.practice53;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class Practice53 {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1160100/service/GetCredCardCompInfoService/getCredCardCompGeneInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=0U1UI7eEPrMIfQ4IDDxpMfEleugBo9g2mcWANMn3WC7OdxPDjNJnMlJYw3r9s814X2Q0xiTOg2bkslDwgelSUQ%3D%3D"); /*Service Key - 실제 사용하시는 키로 변경하세요!*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수 (더 많은 데이터 확인을 위해 10으로 늘림)*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*결과형식(xml/json) - JSON으로 변경!*/
        urlBuilder.append("&" + URLEncoder.encode("title","UTF-8") + "=" + URLEncoder.encode("신용카드_일반현황_임직원현황", "UTF-8")); /*신용카드사 일반현황*/
        urlBuilder.append("&" + URLEncoder.encode("basYm","UTF-8") + "=" + URLEncoder.encode("201312", "UTF-8")); /*기준년월*/

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        // GET 요청 시에는 Content-type 헤더가 필수는 아니지만, 명시적으로 JSON을 원한다고 서버에 알릴 수 있습니다.
        // conn.setRequestProperty("Content-type", "application/json"); // 이 줄은 JSON을 원할 때 유지

        System.out.println("요청 URL: " + url.toString()); // 요청 URL 확인용
        System.out.println("Response code: " + conn.getResponseCode());

        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            // 성공 시, 응답 스트림을 읽습니다.
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8")); // 인코딩 지정
        } else {
            // 실패 시, 에러 스트림을 읽습니다.
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8")); // 인코딩 지정
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        // 최종 응답 내용을 콘솔에 출력
        System.out.println("==== API 응답 내용 ====");
        System.out.println(sb.toString());
    }
}