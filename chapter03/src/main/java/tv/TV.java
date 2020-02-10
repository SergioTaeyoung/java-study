package tv;

public class TV {

	private int channel = 7;
	private int volume = 20;
	private boolean power = false;
	
		
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;		
	}
	
	public void channel(int channel) {
		if(channel > 1 && channel<=255)
			this.channel = channel;
		else
			System.out.println("채널을 다시 입력하세요");
	}
	
	public void channel(boolean up) {
		if(channel >= 1 && channel<255) {
			if(up)
				this.channel = channel + 1;
			else
				this.channel = channel - 1;				
		}else if(channel==255){
			if(up)
				this.channel = 1;
			
		}else if(channel==1) {
			if(up=false)
				this.channel = 255;
		}			
		
		//channel(channel + (up ? 1 : -1 );
	}
	
	public void volume(int volume) {
		if(volume >= 1 && volume<=255)
			this.volume = volume;
		else
			System.out.println("볼륨을 다시 입력하세요");
	}
	
	public void volume(boolean up) {
		if(volume >= 1 && volume<255) {
			if(up)
				this.volume = volume + 1;
			else
				this.volume = volume - 1;				
		}else if(volume==255){
			if(up)
				System.out.println("더이상 높일 수 없습니다.");
			
		}else if(channel==1) {
			if(up=false)
				System.out.println("더이상 내릴수 없습니다.");
		}			
	}
	
	
	public void power(boolean on) {
		this.power = on;
	}
	
	public void status() {
		System.out.println("TV[channel=" + channel + ", volume=" + volume + ", power=" + power + "]");
	}
	
}
