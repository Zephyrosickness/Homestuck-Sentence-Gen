import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        boolean currentProgramStatus;
        System.out.println("in early dev rn. things may be unpolished or buggy.\n(to exit the current sentence, type \"EXIT\".)\n");

        do{
            boolean currentSentenceGo = true;
            String sentence = InputHelper.getString("Enter your sentence");

            do {
                System.out.println("\n[CURRENT SENTENCE]: " + sentence);

                final String toReplace = getInput("\nEnter the character you want to replace.");

                String replaceWith = "";
                if(!toReplace.equals("EXIT")){replaceWith = getInput("\nEnter the character you will replace it with.");}

                if(toReplace.equals("EXIT")||replaceWith.equals("EXIT")) {currentSentenceGo = false;}

                sentence = replaceChars(sentence, toReplace, replaceWith);

            }while(currentSentenceGo);

            currentProgramStatus = InputHelper.getYN("\nDo you want to do another sentence?");
        }while(currentProgramStatus);

    }

    private static String getInput(String message){
        final Scanner scan = new Scanner(System.in);
        String input;
        boolean go = true;
        do {
            System.out.println(message);
            input = scan.nextLine();
            if (input.length() != 1){
                if(input.equals("EXIT")){break;}
                System.out.println("sorry. must be one character. try again");
            }else{go = false;}
        }while(go);

        return input;
    }

    private static String replaceChars(String sentence, String toReplace, String replaceWith){
        final char[] sentenceDeconstructed = sentence.toCharArray();
        for(int i = 0; i<sentenceDeconstructed.length;i++){ //use normal for loop instead of enchanced forloop here bc u need the index anyway
            String currentChar = String.valueOf(sentenceDeconstructed[i]);

            if(currentChar.equalsIgnoreCase(toReplace)){sentenceDeconstructed[i] = replaceWith.charAt(0);}

        }
        StringBuilder sentenceReconstructed = new StringBuilder();
        for(char i:sentenceDeconstructed){sentenceReconstructed.append(i);}

        return String.valueOf(sentenceReconstructed);
    }
}
