package servlets;

import javax.sound.sampled.*;

public class mysound {

	public static float SAMPLE_RATE = 8000f;

	public static void tone(double hz) throws LineUnavailableException {
		tone(hz, 10);
	}

	public static void tone(double hz, double msecs) throws LineUnavailableException {
		tone(hz, msecs);
	}

	public static void tone(double d, int msecs, double vol) throws LineUnavailableException {
		byte[] buf = new byte[1];
		AudioFormat af = new AudioFormat(SAMPLE_RATE, // sampleRate
				8, // sampleSizeInBits
				1, // channels
				true, // signed
				false); // bigEndian
		SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
		sdl.open(af);
		sdl.start();
		for (int i = 1; i < msecs * 800; i++) {
			double angle = i / (SAMPLE_RATE / d) * 2.0 * Math.PI;
			buf[0] = (byte) (Math.sin(angle) * 127.0 * vol);
			sdl.write(buf, 0,1);
		}
		sdl.drain();
		sdl.stop();
		sdl.close();
	}

	public void sound1(){
		for (int i = 200; i < 600; i +=60) {
			try {
				mysound.tone(i,1,50000-i);
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void sound2(){
		for (int i = 200; i < 600; i += 60) {
			try {
				mysound.tone(i,1,50000-i);
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void sound3(){
		for (int i = 200; i < 600; i += 60) {
			try {
				mysound.tone(i,1,50000-i);
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws Exception {
		mysound mys = new mysound();
		mys.sound1();
		mys.sound2();
		mys.sound3();
	
		// mysound.tone(440,100);
//		for (int i = 200; i < 500; i += 60) {
//			mysound.tone(i,1,50000-i);
//			//mysound.tone(i+70);
//		//	mysound.tone(i+70+99);
//		}
		// Thread.sleep(10);
		// mysound.tone(196,10);
		// // Thread.sleep(10);
		// mysound.tone(130,10);
		// // Thread.sleep(30);
		// mysound.tone(196,10);
		// // Thread.sleep(10);
		// mysound.tone(130,10);
		// // Thread.sleep(10);
		// mysound.tone(196,50);

	}
}
