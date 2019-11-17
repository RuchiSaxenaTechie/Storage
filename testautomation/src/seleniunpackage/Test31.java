package seleniunpackage;

import java.util.Scanner;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Test31 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your text");
		String x = sc.nextLine();
		// Convert into voice
		System.setProperty("mbrola.base", "E:\\selenium\\Mbrola");
		VoiceManager vm = VoiceManager.getInstance();
		Voice v = vm.getVoice("mbrola_us1");
		v.allocate();
		v.speak(x);
		v.deallocate();
		sc.close();
		

	}

}
