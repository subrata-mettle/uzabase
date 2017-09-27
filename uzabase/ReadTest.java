package uzabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.*;
import java.util.Map;
import java.util.HashMap;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import uzabase.Feed;
import uzabase.FeedMessage;
import uzabase.RSSFeedParser;

public class ReadTest {
    public static void main(String[] args) throws IOException {
        RSSFeedParser parser = new RSSFeedParser("http://tech.uzabase.com/rss");
        Feed feed = parser.readFeed();
		//long startTime = System.currentTimeMillis();
        System.out.println(feed);
      /*  for (FeedMessage message : feed.getMessages()) {
            System.out.println(message);

        }*/
		
		feed.getMessages().forEach(System.out::println);
		
		List<String> feedMsg = feed.getMessages().stream().map(FeedMessage::toString).collect(Collectors.toList());
		
		Files.write(Paths.get("OutPut.text"), (Iterable<String>)feedMsg::iterator);
		
        //long endTime   = System.currentTimeMillis();
		//long totalTime = endTime - startTime;
		//System.out.println(totalTime);
    }
}