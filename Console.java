import java.util.Scanner;
import java.util.ArrayList;

public class Console {
  Scanner sc;
  Hangman game;

  public void start(){
    System.out.println("Please enter the word:");
    sc = new Scanner(System.in);
    String data = sc.nextLine();
    Word word = new Word(data);
    game = new Hangman(word);
    print(word.hide());
  }

  public void play() {
    if( game.isLose() ) {
      System.out.println("Bad luck! The word was \"" + game.word() + "\"");
      return;
    }
    if( game.isWin() ) {
      System.out.println("You win!");
      return;
    }
    System.out.println("Please enter a letter:");
    char data = sc.nextLine().charAt(0);
    game.guess(data);
    print( game.reveal() );
    play();
  }

  private void print(String string) {
    System.out.print("\033[H\033[2J");
    System.out.flush();
    System.out.println( game.guesses() );
    System.out.println( "" );
    System.out.println( draw( game.lives() ) );
    System.out.println( "" );
    System.out.println( string );
  }

  private String draw(int lives) {
    ArrayList<String> stages = new ArrayList<String>();
    stages.add(" (ö)\n-(!)-\n /'\\");
    stages.add(" (ö)\n-(!)-\n /");
    stages.add(" (ö)\n-(!)-\n");
    stages.add(" (ö)\n-(!)\n");
    stages.add(" (ö)\n (!)\n");
    stages.add(" (ö)\n\n");
    stages.add("\n\n");
    return stages.get(lives);
  }
}