import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class MarkdownParseTest {
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
}