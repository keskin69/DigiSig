package yellowzebra.booking;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class Utils {

	public static HttpResponse postJSON(String json) {
		HttpResponse response = null;
		HttpClient httpClient = HttpClientBuilder.create().build();
		try {
			HttpPost post = new HttpPost(Config.APIBASE);
			StringEntity postingString = new StringEntity(json);

			post.setEntity(postingString);
			post.setHeader("Content-type", "application/json");
			response = httpClient.execute(post);
			
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(response.getStatusLine().getReasonPhrase());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return response;
	}

	public static Object readObject() {
		Object obj = null;
		try {
			FileInputStream fin = new FileInputStream("C:\\Mustafa\\workspace\\DigiSig\\bookings.ser");
			ObjectInputStream ois = new ObjectInputStream(fin);
			try {
				obj = ois.readObject();
				ois.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}
}
