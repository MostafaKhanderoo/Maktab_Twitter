package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReTweet extends Tweet{
    private boolean reTweet;
    private long reTweetId;

}
