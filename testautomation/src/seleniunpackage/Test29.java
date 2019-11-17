
package seleniunpackage;

import java.util.Scanner;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Test29 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your text");
		String x = s.nextLine();
		VoiceManager vm=VoiceManager.getInstance();
		Voice v=vm.getVoice("kevin");
		v.allocate();
		v.speak(x);
		s.close();
		

	}

}
