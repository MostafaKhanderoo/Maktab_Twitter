package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

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
    private long tweetId;


}
