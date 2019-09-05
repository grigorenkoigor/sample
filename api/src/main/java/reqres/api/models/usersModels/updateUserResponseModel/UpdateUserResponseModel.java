package reqres.api.models.usersModels.updateUserResponseModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@Getter
@Setter
@Accessors(chain = true)
public class UpdateUserResponseModel{

	@JsonProperty("name")
	private String name;

	@JsonProperty("job")
	private String job;

	@JsonProperty("updatedAt")
	private String updatedAt;
}