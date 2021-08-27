package acme.framework.utilities;

import java.util.Arrays;
import java.util.List;

import acme.framework.entities.CustomisationParameter;

public class SpamDetect {
	
	private SpamDetect() {
		
	}
	
	public static boolean isSpamText(final String textToCheck, final CustomisationParameter params) {
        boolean result = false;
        Double numSpWordsInText = 0.;
        final Integer numOfWords = textToCheck.split(" ").length;

        final String spamWords = params.getSpamWords();
        final String[] spamWordsArray = spamWords.split(",");
        final List<String> spamWordsList = Arrays.asList(spamWordsArray);

        for (final String sw : spamWordsList) {
            numSpWordsInText = numSpWordsInText + SpamDetect.timesAppearSpamWord(textToCheck.toLowerCase(), sw.toLowerCase(), 0.0);
            final Double percentage = numSpWordsInText / numOfWords * 100;

            if (percentage > params.getThreshold()) {
                result = true;
                break;
            }

        }

        return result;
    }

	private static double timesAppearSpamWord(final String textToCheck, final String spamWord, Double numSpWord) {
	        if (textToCheck.contains(spamWord)) {
	            final Integer index = textToCheck.indexOf(spamWord) + spamWord.length();
	            numSpWord++;
	            
	            return SpamDetect.timesAppearSpamWord(textToCheck.substring(index).trim(), spamWord, numSpWord);
	        }
	
	        return numSpWord;
	    }
	
}
