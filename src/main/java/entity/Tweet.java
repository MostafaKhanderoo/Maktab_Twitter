
package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tweet {
    private long tweetId;
    private String content;
    private Date createDate;
//    private List<Tag>tags;
    private long userId;
//    private List<Long> tags;
   // private boolean reTweet;
 //   private long lastTweetId;


}
