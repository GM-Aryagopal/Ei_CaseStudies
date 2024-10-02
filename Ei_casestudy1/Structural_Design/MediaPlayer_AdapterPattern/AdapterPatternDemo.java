import java.util.Scanner;

// Target interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Adaptee class for playing MP3 files
class MP3Player {
    public void playMP3(String fileName) {
        System.out.println("Playing MP3 file: " + fileName);
    }
}

// Adaptee class for playing WAV files
class WAVPlayer {
    public void playWAV(String fileName) {
        System.out.println("Playing WAV file: " + fileName);
    }
}

// Adapter class
class AudioPlayer implements MediaPlayer {
    private MP3Player mp3Player = new MP3Player();
    private WAVPlayer wavPlayer = new WAVPlayer();

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            mp3Player.playMP3(fileName);
        } else if (audioType.equalsIgnoreCase("wav")) {
            wavPlayer.playWAV(fileName);
        } else {
            System.out.println("Invalid media type. Supported types are: MP3, WAV.");
        }
    }
}

// Main class to demonstrate Adapter Pattern
public class AdapterPatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter audio type (mp3/wav) or 'exit' to quit: ");
        String audioType = scanner.nextLine();

        if (!audioType.equalsIgnoreCase("exit")) {
            System.out.print("Enter file name: ");
            String fileName = scanner.nextLine();

            AudioPlayer audioPlayer = new AudioPlayer();
            audioPlayer.play(audioType, fileName);
        } else {
            System.out.println("Exiting...");
        }

        scanner.close();
    }
}
