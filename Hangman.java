import java.util.ArrayList;

public class Hangman {

  private Word word;
  private int lives;
  private ArrayList<Character> guesses;

  public Hangman(Word word) {
    this.word = word;
    this.lives = 6;
    this.guesses = new ArrayList<Character>();
  }

  public void guess(char letter) {
    if(!this.guesses.contains(letter)) this.guesses.add(letter);
    if(!this.word.contains(letter)) deductLife();
  }

  public String word() {
    return this.word.show();
  }

  public int lives() {
    return this.lives;
  }

  public ArrayList<Character> guesses() {
    return this.guesses;
  }

  public String reveal() {
    return this.word.showLetters(this.guesses);
  }

  public boolean isWin() {
    return this.reveal().indexOf('*') < 0;
  }

  public boolean isLose() {
    return this.lives() <= 0;
  }

  private void deductLife() {
    this.lives -= 1;
  }

}