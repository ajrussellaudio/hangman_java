import java.util.ArrayList;

public class Word {
  private String word;
  private StringBuilder hiddenWord;

  public Word(String word){
    this.word = word;
  }

  public String hide(){
    hiddenWord = new StringBuilder();
    for(char character : this.word.toCharArray()){
      hiddenWord.append("*");
    }
    return hiddenWord.toString();
  }

  public boolean contains(char letter) {
    return this.word.indexOf(letter) >= 0;
  }

  public int positionOf(char letter) {
    return this.word.indexOf(letter);
  }

  public String showLetters(ArrayList<Character> guesses) {
    StringBuilder revealedWord = new StringBuilder();
    for( char letter : this.word.toCharArray() ) {
      if(guesses.contains(letter)) {
        revealedWord.append(letter);
      } else {
        revealedWord.append("*");
      }
    }
    return revealedWord.toString();
  }

  public String show() {
    return this.word;
  }


}