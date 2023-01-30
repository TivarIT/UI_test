package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtil {
    private static final Random RANDOM = new Random();
    private static final int NUMBER_OF_LETTERS_ALPHABET = 26;
    private static final int ASCII_CODE_OF_A = 97;
    private static final int NUMBER_OF_DIGITS_IN_PASSWORD = 4;
    private static final int RANDOM_NUMBER_GENERATION_RANGE = 9;
    private static final int MAX_RANGE_OF_EMAIL_INDEX = 10;
    private static final int NUMBER_OF_CAPITAL_LETTERS_IN_PASSWORD = 3;
    private static final int NUMBER_OF_LOWERCASE_LETTERS_IN_PASSWORD = 2;

    public static String getEmail(String email) {
        return email.substring(0, email.indexOf('@'));
    }

    public static String getMailDomain(String email){
        String domain = getAllDomain(email);
        return domain.substring(0, domain.indexOf("."));
    }

    public static String getDomain(String email){
        String domain = getAllDomain(email);
        return domain.substring(domain.indexOf("."));
    }

    public static List<String> getDomains(String email){
        List<String> domains = new ArrayList<>();
        domains.add(getMailDomain(email));
        domains.add(getDomain(email));
        return domains;
    }

    private static String getAllDomain(String email) {
        return email.substring(email.indexOf('@') + 1);
    }

    public static int getRandomNumber(int min, int max){
        int diff = max - min;
        return RANDOM.nextInt(diff + 1) + min;
    }

    public static String generatePassword(String email) {
        StringBuilder dataForPassword = new StringBuilder();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < NUMBER_OF_DIGITS_IN_PASSWORD; i++) {
            dataForPassword.append(RANDOM.nextInt(RANDOM_NUMBER_GENERATION_RANGE));
        }

        for (int i = 0; i < NUMBER_OF_LOWERCASE_LETTERS_IN_PASSWORD; i++) {
            dataForPassword.append((char) (RANDOM.nextInt(NUMBER_OF_LETTERS_ALPHABET) + ASCII_CODE_OF_A));
        }

        for (int i = 0; i < NUMBER_OF_CAPITAL_LETTERS_IN_PASSWORD; i++) {
            dataForPassword.append(String.valueOf((char) (RANDOM.nextInt(NUMBER_OF_LETTERS_ALPHABET) + ASCII_CODE_OF_A)).toUpperCase());
        }

        dataForPassword.append(email.charAt(getRandomNumber(0,MAX_RANGE_OF_EMAIL_INDEX)));

        int randomSymbol;
        int passwordLength = dataForPassword.length();

        for (int i = 0; i < passwordLength; i++) {
            randomSymbol = RANDOM.nextInt(dataForPassword.length());
            password.append(dataForPassword.charAt(randomSymbol));
            dataForPassword.deleteCharAt(randomSymbol);
        }
        return password.toString();
    }
}
