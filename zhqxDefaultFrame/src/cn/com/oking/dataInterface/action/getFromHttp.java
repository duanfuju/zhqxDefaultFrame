package cn.com.oking.dataInterface.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class getFromHttp {
	public static String getResult(String url) throws ClientProtocolException,
			IOException {
		HttpGet getMethod = new HttpGet(url);
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse response;
		try {
			response = httpClient.execute(getMethod);
			String result = EntityUtils.toString(response.getEntity(), "utf-8");
			int code = response.getStatusLine().getStatusCode();
			if (code == 200) {
				return result;
			}
			return "";
		} finally {
			 getMethod.releaseConnection();
		}
	}

	public static String getResult(String url, String encode)
			throws ClientProtocolException, IOException {
		HttpGet getMethod = new HttpGet(url);
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse response;
		try {
			response = httpClient.execute(getMethod);
			String result = EntityUtils.toString(response.getEntity(), encode);
			int code = response.getStatusLine().getStatusCode();
			if (code == 200) {
				return result;
			}

			return "";
		} finally {
			getMethod.releaseConnection();
		}
	}

	public static String captureHtml(String url, String encode) {

		HttpURLConnection httpConn;
		try {
			httpConn = (HttpURLConnection) new URL(url).openConnection();

			InputStreamReader input;

			input = new InputStreamReader(httpConn.getInputStream(), encode);

			BufferedReader bufReader = new BufferedReader(input);
			String line = "";
			StringBuilder contentBuf = new StringBuilder();
			while ((line = bufReader.readLine()) != null) {
				contentBuf.append(line);
			}

			return contentBuf.toString();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String HtmlToTextGb2312(String inputString) {
		String htmlStr = inputString;
		String replace = "\n";
		String textStr = "";
		Pattern p_script;
		Matcher m_script;
		Pattern p_style;
		Matcher m_style;
		Pattern p_html;
		Matcher m_html;
		Pattern p_houhtml;
		Matcher m_houhtml;
		Pattern p_spe;
		Matcher m_spe;
		Pattern p_blank;
		Matcher m_blank;
		Pattern p_table;
		Matcher m_table;
		Pattern p_enter;
		Matcher m_enter;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
			String regEx_html = "<[^>]+>";
			String regEx_houhtml = "</[^>]+>";
			String regEx_spe = "\\&[^;]+;";
			String regEx_blank = " +";
			String regEx_table = "\t+";
			String regEx_enter = "\n+";

			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);

			htmlStr = m_script.replaceAll(replace);

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(replace);

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(replace);

			p_houhtml = Pattern
					.compile(regEx_houhtml, Pattern.CASE_INSENSITIVE);
			m_houhtml = p_houhtml.matcher(htmlStr);
			htmlStr = m_houhtml.replaceAll(replace);

			p_spe = Pattern.compile(regEx_spe, Pattern.CASE_INSENSITIVE);
			m_spe = p_spe.matcher(htmlStr);
			htmlStr = m_spe.replaceAll(replace);

			p_blank = Pattern.compile(regEx_blank, Pattern.CASE_INSENSITIVE);
			m_blank = p_blank.matcher(htmlStr);
			htmlStr = m_blank.replaceAll(replace);

			p_table = Pattern.compile(regEx_table, Pattern.CASE_INSENSITIVE);
			m_table = p_table.matcher(htmlStr);
			htmlStr = m_table.replaceAll(replace);

			p_enter = Pattern.compile(regEx_enter, Pattern.CASE_INSENSITIVE);
			m_enter = p_enter.matcher(htmlStr);
			htmlStr = m_enter.replaceAll(replace);

			textStr = htmlStr;

		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}

		return textStr;
	}

	public static void main(String[] s) {
		 
			try {
				String message = getResult("http://localhost:8080/test-jsp/test.jsp");
				//message = getFromHttp.HtmlToTextGb2312(message);

				System.out.println( message.trim());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
