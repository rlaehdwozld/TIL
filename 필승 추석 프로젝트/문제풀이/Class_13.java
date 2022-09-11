package q8;

class MyTv2 {
	private boolean isPowerOn;
	private int channel;
	private int volume;
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	private int prevChannel;
	
	public void setVolume(int volume) {
		if (volume > MAX_VOLUME || volume < MIN_VOLUME)
			return;
		this.volume = volume;
	}

	public int getVolume() {
		return volume;
	}

	public void setChannel(int channel) {
		if (channel > MAX_CHANNEL || channel < MIN_CHANNEL)
			return;
		this.channel = channel;
	}

	public int getChannel() {
		return channel;
	}
	public void gotoPrevChannel() {
		
	}
}

public class Class_13 {
public static void main(String args[]) {
MyTv2 t = new MyTv2();
t.setChannel(10);
System.out.println("CH:"+t.getChannel());
t.setVolume(20);
System.out.println("VOL:"+t.getVolume());
}
}
