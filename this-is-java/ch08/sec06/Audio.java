package ch08.sec06;

import ch08.sec06.RemoteControl;

public class Audio implements ch08.sec06.RemoteControl {

    public int volume;

    @Override
    public void turnOn() {
        System.out.println("Audio를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("Audio를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if(volume > ch08.sec05.RemoteControl.MAX_VOLUME) {
            this.volume = ch08.sec05.RemoteControl.MAX_VOLUME;
        } else if(volume < ch08.sec05.RemoteControl.MIN_VOLUME) {
            this.volume = ch08.sec05.RemoteControl.MIN_VOLUME;
        } else {
            this.volume = volume;
        }

        System.out.println("현재 Audio 볼륨: " + this.volume);
    }

    //필드
    private int memoryVolume;

    //디폴드 메소드 재정의
    @Override
    public void setMute(boolean mute) {
        if(mute) {
            this.memoryVolume = this.volume;
            System.out.println("Audio를 무음 처리합니다.");
            setVolume(RemoteControl.MIN_VOLUME);
        } else {
            System.out.println("Audio를 무음 해제합니다.");
            setVolume(this.memoryVolume);
        }
    }
}
