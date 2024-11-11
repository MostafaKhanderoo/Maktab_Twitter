package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tweet {
    private long tweetId;
    private String content;
    private List<Tag> tags;
    private long userId;


}
