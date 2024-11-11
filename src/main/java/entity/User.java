package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String accountName;
    private String email;
    private String username;
    private String password;
    private String bio;
    private LocalDate createDate;
    private int tweetId;


}
