package reqres.api.models.registerModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class RegisterRequestModel {

    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    private String email;
}