Construct a Java program that takes a sentence from the user and finds the highest and smallest
length words in it.

  
import java.util.Scanner;
public class WordLengthFinder {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// ইউজার থেকে ইনপুট ননচ্ছি
System.out.print("Enter a sentence: ");
String sentence = scanner.nextLine();
// বােয থেকে শব্দ গু ক া আ াদা েরনি (space নদকে ভাগ েকর)
String[] words = sentence.split(" ");
// প্র েম শব্দ নদকেই শুরু েরনি
String smallest = words[0];
String largest = words[0];
// প্র নিটট শকব্দর ওপরু প চা াচ্ছি
for (String word : words) {
if (word.length() < smallest.length()) {
smallest = word;
}
if (word.length() > largest.length()) {
largest = word;
}
}
// ফ াফ থদখাচ্ছি
System.out.println(" Smallest word: " + smallest);
System.out.println(" Largest word: " + largest);
}
}
