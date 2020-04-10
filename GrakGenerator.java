import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class GrakGenerator {
    static Random randomGenerator = new Random();

    public static void main(String args[]) {
        int size = 0;

        size = randomGenerator.nextInt(100) + 1;
        System.out.println(size);
        // System.out.println(size);
        // System.out.println(hundred);

        if (size > 0 && size <= 70) {
            size = 2;
        } else if (size >= 71 && size <= 80) {
            size = 3;
        } else if (size >= 81 && size <= 90) {
            size = 4;
        } else if (size >= 91 && size <= 99) {
            size = 5;
        } else
            size = randomGenerator.nextInt(13) + 8;

        String grak = randomLetter();
        for (int i = 0; i < size; i++) {
            char lastLetter = grak.charAt(grak.length() - 1);
            if (lastLetter == 'a' || lastLetter == 'e' || lastLetter == 'i' || lastLetter == 'o' || lastLetter == 'u') {
                System.out.println(lastLetter); // aggiunge lettera a caso tranne l'ultima inserita
                grak = grak.concat(randomLetterBut(lastLetter));
            } else {
                if (grak.length() > 1) {
                    char secondLast = grak.charAt(grak.length() - 2);
                    if (secondLast == 'a' || secondLast == 'e' || secondLast == 'i' || secondLast == 'o'
                            || secondLast == 'u') {
                        grak = grak.concat(randomLetterBut(lastLetter)); // randomLetter() modificato in
                                                                         // randomLetterBut(lastLetter)
                    } else {
                        grak = grak.concat(randomVocals());

                    }

                } else {
                    grak = grak.concat(randomLetter());
                }

            }
        }
        grak = grak.concat("ak");
        System.out.println(grak);
    }

    private static String randomLetter() {
        String[] alfabeth = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
                "s", "t", "u", "v", "w", "x", "y", "z" };
        int wordIndex = randomGenerator.nextInt(alfabeth.length);
        return alfabeth[wordIndex];

    }

    private static String randomVocals() {
        String[] vocals = { "a", "e", "i", "o", "u" };
        int vocalIndex = randomGenerator.nextInt(vocals.length);
        return vocals[vocalIndex];
    }

    private static String randomConsonants() {
        String[] consonants = { "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v",
                "w", "x", "y", "z" };
        int consIndex = randomGenerator.nextInt(consonants.length);
        return consonants[consIndex];
    }

    private static String randomLetterBut(char a) {
        String[] alfabeth = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
                "s", "t", "u", "v", "w", "x", "y", "z" };

        List<String> alphabethBut = new ArrayList<String>(Arrays.asList(alfabeth));
        alphabethBut.remove(Character.toString(a));
        System.out.println(alphabethBut);
        int wordIndex = randomGenerator.nextInt(alphabethBut.size());
        return alphabethBut.get(wordIndex);
    }
}