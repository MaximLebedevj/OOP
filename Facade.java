package lecture5;

class Amplifier {
    int volume;
    public void on() {
        System.out.println("Amplifier is on");
    }
    
    public void off() {
        System.out.println("Amplifier is off");
    }
    
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Volume was set to " + volume);
    }
}

class CdPlayer {
    public void on() {
        System.out.println("CdPlayer is on");
    }
    
    public void off() {
        System.out.println("CdPlayer is off");
    }
    
    public void play() {
        System.out.println("CdPlayer is playing");
    }
    
    public void pause() {
        System.out.println("CdPlayer is paused");
    }
}

class DvdPlayer {
    int dvd;
    Amplifier amplifier;
    
    public DvdPlayer(Amplifier amplifier) {
        this.amplifier = amplifier;
    }
    
    public void on() {
        System.out.println("DvdPlayer is on");
    }
    
    public void off() {
        System.out.println("DvdPlayer is off");
    }
    
    public void play() {
        System.out.println("DvdPlayer is playing");
    }
    
    public void setDvd(int dvdNumber) {
        this.dvd = dvdNumber;
    }
    
    public void eject() {
        System.out.println("Dvd was ejected");
    }
    
    public void pause() {
        System.out.println("Dvd is paused");
    }
}

class PopcornPopper {
    public void on() {
        System.out.println("PopcornPopper is on");
        pop();
    }
    
    public void off() {
        System.out.println("PopcornPopper is off");
    }
    
    public void pop(){
        
    }
}

class Tuner {
    Amplifier amplifier;
    int fm, am, frq;
    
    public Tuner(Amplifier amplifier) {
        this.amplifier = amplifier;
    }
    
    public void on() {
        System.out.println("Tuner is on");
    }
    
    public void off() {
        System.out.println("Tuner is off");
    }
    
    public void setFm(int fm) {
        this.fm = fm;
    }
    
    public void setAm(int am) {
        this.am = am;
    }
    
    public void setFrequency(int frq) {
        this.frq = frq;
    }
}

class HomeTheaterFacade {
    Amplifier amplifier;
    CdPlayer cdPlayer;
    DvdPlayer dvdPlayer;
    PopcornPopper popcornPopper;
    Tuner tuner;
    
    public HomeTheaterFacade(Amplifier amplifier, CdPlayer cdPlayer, DvdPlayer dvdPlayer, PopcornPopper popcornPopper, Tuner tuner) {
        this.amplifier = amplifier;
        this.cdPlayer = cdPlayer;
        this.dvdPlayer = dvdPlayer;
        this.popcornPopper = popcornPopper;
        this.tuner = tuner;
    }
    
    public void watchMovie() {
        amplifier.on();
        cdPlayer.on();
        dvdPlayer.on();
        popcornPopper.on();
        tuner.on();
    }
}

