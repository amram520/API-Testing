package e2e.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateUserResponse {
    private String createdAt;
    private String name;
    private String id;
    private String job;
}
