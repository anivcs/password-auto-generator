import java.util.Random;

public class PasswordGenerator {
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_-+=~`[]{}|\\:;\"'<>,.?/";

    public static void main(String[] args) {
        int length = 10; // Change the desired password length as per your requirement

        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        // Ensure that the password contains at least one character from each category
        sb.append(getRandomCharacter(LOWERCASE_LETTERS, random));
        sb.append(getRandomCharacter(UPPERCASE_LETTERS, random));
        sb.append(getRandomCharacter(NUMBERS, random));
        sb.append(getRandomCharacter(SPECIAL_CHARACTERS, random));

        // Generate remaining characters randomly
        for (int i = 4; i < length; i++) {
            String characterSet = getRandomCharacterSet(random);
            sb.append(getRandomCharacter(characterSet, random));
        }

        // Shuffle the generated password
        String password = sb.toString();
        char[] passwordArray = password.toCharArray();
        for (int i = passwordArray.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[j];
            passwordArray[j] = temp;
        }

        return new String(passwordArray);
    }

    private static char getRandomCharacter(String characterSet, Random random) {
        int randomIndex = random.nextInt(characterSet.length());
        return characterSet.charAt(randomIndex);
    }

    private static String getRandomCharacterSet(Random random) {
        int randomIndex = random.nextInt(4);
        switch (randomIndex) {
            case 0:
                return LOWERCASE_LETTERS;
            case 1:
                return UPPERCASE_LETTERS;
            case 2:
                return NUMBERS;
            case 3:
                return SPECIAL_CHARACTERS;
            default:
                return LOWERCASE_LETTERS;
        }
    }
}
