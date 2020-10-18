package lamaze.lucicrypt;

import java.lang.reflect.MalformedParametersException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Lucicrypt {

    public static String encrypt(String rawInput) {
        List<char[]> byteSequences = new ArrayList<>();

        final int inputLength = rawInput.length();
        final char[] characters = rawInput.toCharArray();
        int handled = 0;

        while(handled != inputLength) {
            char[] sequence = new char[9];

            char rbyte = (char) ThreadLocalRandom.current().nextInt(255);
            sequence[0] = rbyte;
            for(int i = 7; i >= 0; i--) {
                if(handled == inputLength) {
                    for(int j = i; j >= 0; j--) {
                        rbyte &= ~(1 << j);
                        sequence[j + 1] = (char) ThreadLocalRandom.current().nextInt(255);
                    }
                    sequence[0] = rbyte;
                    break;
                }
                char c;
                if((rbyte & (1 << i)) != 0) {
                    c = (char) (((byte) characters[handled]) + (i > 4 ? 5 : -5));
                    handled++;
                } else
                    c = (char) ThreadLocalRandom.current().nextInt(255);
                sequence[i + 1] = c;
            }
            byteSequences.add(sequence);
        }
        StringBuilder builder = new StringBuilder();
        for (char[] byteSequence : byteSequences)
            builder.append(byteSequence);
        return builder.toString();
    }

    public static String decrypted(String input) {
        int rots = (input.length() % 9);
        if(rots != 0)
            throw new MalformedParametersException("Input is supposed to be able to be modded by 9");

        StringBuilder output = new StringBuilder();

        for(int i = 0; i < input.length(); i+=9) {
            char[] sequence = input.substring(i, i + 9).toCharArray();
            char bufferbyte = sequence[0];

            for(int j = 7; j >= 0; j--) {
                if((bufferbyte & (1 << j)) != 0)
                    output.append((char) ((sequence[j + 1]) + (j > 4 ? -5 : 5)));
            }
        }
        return output.toString();
    }

}
