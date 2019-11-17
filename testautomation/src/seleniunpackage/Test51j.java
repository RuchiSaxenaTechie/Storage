package seleniunpackage;

import java.util.HashMap;
import java.util.Map;

public class Test51j {

	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		// insert the data & store
		hm.put(102, "kalam");
		hm.put(101, "kohli");
		// get data from hashmap
		for (Map.Entry<Integer,String> e : hm.entrySet()) {
			System.out.print(e.getKey());
			System.out.println(" " + e.getValue());
		}
	}

}
