import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class MarkdownParseTest {
    public static void main(String[] args) {
        
    }
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    
    @Test
    public void getLinksEquals() throws Exception{
        ArrayList<String> toReturn = new ArrayList<String>();
        toReturn.add("https://something.com");
        toReturn.add("some-thing.html");
        System.out.println(toReturn);
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(toReturn, links);
    }

    @Test
    public void getLinksEquals2() throws Exception{
        ArrayList<String> toReturn = new ArrayList<String>();
        toReturn.add("https://google.com");
        toReturn.add("some-thing.html");
        toReturn.add("https://www.youtube.com/watch?v=k67e-Icw4ug&ab_channel=CS50");
        toReturn.add("many-things.html");
        toReturn.add("https://games.com");
        System.out.println(toReturn);
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(toReturn, links);
    }

    @Test
    public void getLinksEquals3() throws Exception{
        ArrayList<String> toReturn = new ArrayList<String>();
        toReturn.add("https://google.com");
        toReturn.add("some-thing.html");
        toReturn.add("https://www.youtube.com/watch?v=k67e-Icw4ug&ab_channel=CS50");
        toReturn.add("many-things.html");
        toReturn.add("https://yahoo.org");
        System.out.println(toReturn);
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(toReturn, links);
    }

    @Test
    public void getLinksEquals4() throws Exception{
        ArrayList<String> toReturn = new ArrayList<String>();
        toReturn.add("https://google.com");
        toReturn.add("some-thing.html");
        toReturn.add("https://www.youtube.com/watch?v=k67e-Icw4ug&ab_channel=CS50");
        toReturn.add("many-things.html");
        toReturn.add("https://games.com");
        System.out.println(toReturn);
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(toReturn, links);
    }
    @Test
    public void getLinksEquals5() throws Exception{
        ArrayList<String> toReturn = new ArrayList<String>();
        toReturn.add("https://google.com");
        toReturn.add("some-thing.html");
        toReturn.add("https://www.youtube.com/watch?v=k67e-Icw4ug&ab_channel=CS50");
        toReturn.add("many-things.html");
        toReturn.add("https://games.com");
        System.out.println(toReturn);
        Path fileName = Path.of("test-file5.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(toReturn, links);
    }
}
