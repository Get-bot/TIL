package ch17.sec04.exam04;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class StreamExample {
  public static void main(String[] args) throws URISyntaxException, IOException {
    Path path = Paths.get(Objects.requireNonNull(StreamExample.class.getResource("data.txt")).toURI());
    System.out.println(path);
    Stream<String> stream = Files.lines(path, Charset.defaultCharset());
    stream.forEach(System.out::println);
    stream.close();
  }
}
