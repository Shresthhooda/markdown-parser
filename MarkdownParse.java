//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            if (closeBracket + 1 == markdown.indexOf("]", closeBracket + 1)){
                int closeParen = markdown.indexOf(")", closeBracket);
                currentIndex = closeParen + 1;
                continue;
            }
            if (markdown.indexOf(" ",closeBracket) < markdown.indexOf("(", closeBracket) && markdown.indexOf(" ",closeBracket) != -1){
                // System.out.println("hi");
                int closeParen = markdown.indexOf(")", closeBracket);
                currentIndex = closeParen + 1;
                continue;
            }

            int openParen = markdown.indexOf("(", closeBracket);
            if (openParen + 1 == markdown.indexOf("(", openParen + 1)){
                int closeParen = markdown.indexOf(")", closeBracket);
                currentIndex = closeParen + 1;
                continue;
            }
            int closeParen = markdown.indexOf(")", openParen);
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }
       
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
       
    }
}
