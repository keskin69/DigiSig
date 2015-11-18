package bookeo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Utils {
	public static void writeObject(Object obj) {

		ObjectOutputStream oos = null;
		try {
			FileOutputStream fout = new FileOutputStream("C:\\Mustafa\\workspace\\DigiSig\\bookings.ser");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Object readObject() {
		Object obj = null;
		try {
			FileInputStream fin = new FileInputStream("C:\\Mustafa\\workspace\\DigiSig\\bookings.ser");
			ObjectInputStream ois = new ObjectInputStream(fin);
			try {
				obj = ois.readObject();
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
