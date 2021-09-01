import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

// here it is not clear which type of http request is this so i am supposing it is get request

public class HttpUrl {

    // let user agent as Mozilla/5.0
	private static final String USER_AGENT = "Mozilla/5.0";

	private static final String GET_URL = "http://127.0.0.1:8999/test";

	private static final String GET_PARAMS = "value=p";

	public static void main(String[] args) throws IOException {
        try {
            sendGET();
        }catch (ConnectException ex){
            System.out.println("Connection refused!!!");
            return;
        }
		
		System.out.println("GET DONE");
	}

	private static void sendGET() throws IOException {
		URL obj = new URL(GET_URL);
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) obj.openConnection();
        }catch (ConnectException ex){
            return;
        }
		 
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);

        // For GET only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(GET_PARAMS.getBytes());
		os.flush();
		os.close();
		// For GET only - END

		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("GET request not worked");
		}

	}

}