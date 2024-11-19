package entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LikeTweet {

    private long userId;
    private long tweetId;
    private LikeDislike likeDislike;
}
