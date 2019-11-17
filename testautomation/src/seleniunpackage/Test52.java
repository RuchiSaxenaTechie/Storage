package seleniunpackage;

import java.util.HashMap;
import java.util.Map;

public class Test52 {

	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		// to insret & store the data
		hm.put(101, "kalam");
		hm.put(102, "kohli");
		// change key
		hm.put(1001, hm.remove(101));
		// change value
		hm.replace(102, "virat kohli");
		for (Map.Entry<Integer, String> e : hm.entrySet()) {
			System.out.println(e.getKey());
			System.out.println("" + e.getValue());
		}

	}

}
