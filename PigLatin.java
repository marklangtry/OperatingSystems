
public class PigLatin {
    public static void main(String[] args) {
        // Awesome
        // Happy
        // Plan
        // pigLatin("Plan");
        pigLatin("Awesome Happy Plan");
    }
    
     
    static void pigLatin(String input) {

        String[] words = input.split("\\s+");
        String concatenatedOutput = "";

        for (String word : words) {
            // System.out.println("-----------------------------------");
            // System.out.println(word);
            // System.out.println("-----------------------------------");

            String newString = "";
            // If a word starts with a vowel add the word "way" at the end of the word
            if (isVowel(word.charAt(0))) {
                char firstLetter = word.charAt(0);
                firstLetter = Character.toLowerCase(firstLetter);
                for (int i = 1; i <= word.length()-1; i++) {
                    newString = newString + word.charAt(i);
                }
                newString = firstLetter + newString + "way";
                // System.out.println(newString);
                // System.out.println("-----------------------------------");
            }

            // If a word starts with a consonant and a vowel, put the first letter of the word at the end of the word and add "ay"
            else if (isVowel(word.charAt(1))) {
                char firstLetter = word.charAt(0);
                firstLetter = Character.toLowerCase(firstLetter);
                for (int i = 1; i <= word.length()-1; i++) {
                    newString = newString + word.charAt(i);
                }
                newString = newString + firstLetter + "ay";
                // System.out.println(newString);
                // System.out.println("-----------------------------------");
            }

            // If a word starts with two consonants move the two consonants to the end of the word and add "ay"
            else{
                char firstLetter = word.charAt(0);
                char secondLetter = word.charAt(1);
                firstLetter = Character.toLowerCase(firstLetter);
                for (int i = 2; i <= word.length()-1; i++) {
                    newString = newString + word.charAt(i);
                }
                newString = newString + firstLetter + secondLetter + "ay";
                // System.out.println(newString);
                // System.out.println("-----------------------------------");
            }
            concatenatedOutput += newString + " ";
        }
        System.out.println(concatenatedOutput);
    }


    // Check for vowel
    static boolean isVowel(char c) {
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }


}