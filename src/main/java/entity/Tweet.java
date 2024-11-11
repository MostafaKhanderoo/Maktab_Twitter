package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tweet {
    private int tweetId;
    private String content;
    private List<Tag> tags;


}
