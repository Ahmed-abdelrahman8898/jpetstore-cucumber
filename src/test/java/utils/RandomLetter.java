package utils;

import java.util.Random;

public class RandomLetter {

	public static String getRandomLetters(int length) {
        
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        
        StringBuilder randomString = new StringBuilder(length);
        
        
        Random random = new Random();
        
        
        for (int i = 0; i < length; i++) {
            
            int randomIndex = random.nextInt(CHARACTERS.length());
            
            
            randomString.append(CHARACTERS.charAt(randomIndex));
        }
        
        
        return randomString.toString();
    }
	public static String getRandomNumbers(int length) {
        final String DIGITS = "0123456789";
        StringBuilder randomNumberString = new StringBuilder(length);
        Random random = new Random();
        
        for (int i = 0; i < length; i++) {
            
            int randomIndex = random.nextInt(DIGITS.length());
            
            
            randomNumberString.append(DIGITS.charAt(randomIndex));
        }
        
        return randomNumberString.toString();
    }
	public static int getRandomNumberInRange(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Maximum value (" + max + ") must be greater than or equal to the minimum value (" + min + ").");
        }
        
        
        int rangeSize = max - min + 1;
        
        
        Random random = new Random();
        
       
        return random.nextInt(rangeSize) + min;
    }
}
