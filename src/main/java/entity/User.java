package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.ObjectStreamClass;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long userId;
    private String accountName;
    private String email;
    private String username;
    private String password;
    private String bio;
    private Date createDate;
//    private List<LikeTweet> likeTweet;



}
