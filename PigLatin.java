
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

        for (String word : words) {
            System.out.println(word);
        
        System.out.println("-----------------------------------");

        String newString = "";
        // If a word starts with a vowel add the word "way" at the end of the word
        if (isVowel(input.charAt(0))) {
            System.out.println(input + "way");
            System.out.println("-----------------------------------");
        }

        // If a word starts with a consonant and a vowel, put the first letter of the word at the end of the word and add "ay"
        else if (isVowel(input.charAt(1))) {
            char firstLetter = input.charAt(0);
            firstLetter = Character.toLowerCase(firstLetter);
            for (int i = 1; i <= input.length()-1; i++) {
                newString = newString + input.charAt(i);
            }
            newString = newString + firstLetter + "ay";
            System.out.println(newString);
            System.out.println("-----------------------------------");
        }

        // If a word starts with two consonants move the two consonants to the end of the word and add "ay"
        else{
            char firstLetter = input.charAt(0);
            char secondLetter = input.charAt(1);
            firstLetter = Character.toLowerCase(firstLetter);
            for (int i = 2; i <= input.length()-1; i++) {
                newString = newString + input.charAt(i);
            }
            newString = newString + firstLetter + secondLetter + "ay";
            System.out.println(newString);
            System.out.println("-----------------------------------");
        }
        }
    }


    // Check for vowel
    static boolean isVowel(char c) {
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }


}