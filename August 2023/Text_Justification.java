class Solution {
     public static void processLineWithKWords(List<String> currLine, int currWidth, int maxWidth, List<String> result) {
        int whiteSpaces = maxWidth - currWidth;
        int evenSpaces = whiteSpaces / (currLine.size() - 1);
        int unevenSpaces = whiteSpaces % (currLine.size() - 1);
        
        int word = 0;
        
        //Distribute spaces evenly
        while(word < currLine.size() - 1) {
            int spaces = 0;
            while(spaces < evenSpaces) {
                currLine.set(word, currLine.get(word)+" ");
                spaces += 1;
            }
            word += 1;
        }

        //left must have extra spaces
        word = 0;
        while(unevenSpaces > 0) {
            currLine.set(word, currLine.get(word) + " ");
            word += 1;
            unevenSpaces -= 1;
        }

        String tempRes = "";
        for(int k = 0; k < currLine.size(); k++) {
            if(k == 0) {
                tempRes += currLine.get(k);
            } else {
                tempRes = tempRes + " " + currLine.get(k);
            }
        }
        
        result.add(tempRes);
    }
    
    public static void processLineWithOneWord(List<String> currLine, int currWidth, int maxWidth, List<String> result) {
        int whiteSpaces = maxWidth - currWidth;
        String tempRes = currLine.get(0);
        while(whiteSpaces > 0) {
            tempRes += " ";
            whiteSpaces -= 1;
        }
        result.add(tempRes);
    }
    
    public static void processLastLine(List<String> currLine, int currWidth, int maxWidth, List<String> result) {
        int whiteSpaces = maxWidth - currWidth;
        String tempRes = currLine.get(0);
        
        if(currLine.size() > 1) {
            for(int i = 1; i < currLine.size(); i++) {
                tempRes += " "+currLine.get(i);
            }
        }
            
        while(whiteSpaces > 0) {
            tempRes += " ";
            whiteSpaces -= 1;
        }
        
        result.add(tempRes);
    }
    
    
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currLine = new ArrayList<>();
        int currWidth = 0;
        for(int i = 0; i < words.length; i++) {
            
            //calculate currWidth and see if this line can accomodate currWord
            int value = currLine.size() == 0 ? words[i].length() : (currWidth + words[i].length() + 1);
            
            if(value <= maxWidth) {
                currLine.add(words[i]);
                currWidth = value;
            } else {
                
                if(currLine.size() > 1) {
                    processLineWithKWords(currLine, currWidth, maxWidth, result);
                } else {
                    processLineWithOneWord(currLine, currWidth, maxWidth, result);
                }
                
                currLine = new ArrayList<>();
                currLine.add(words[i]);
                currWidth = words[i].length();             
            }
        }
        
        processLastLine(currLine, currWidth, maxWidth, result);
        
        return result;
    }
}