package Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class RootResponse {
    private int id;
    private String name;
    private String birth;
//    private String email;
//    private Guardian guardian;
}
