package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tweet {
    private int id;
    private String content;
    private String retweet;

}
