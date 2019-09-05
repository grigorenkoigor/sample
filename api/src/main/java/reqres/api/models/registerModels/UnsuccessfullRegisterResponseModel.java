package reqres.api.models.registerModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@Getter
@Setter
@Accessors(chain = true)
public class UnsuccessfullRegisterResponseModel{

	@JsonProperty("error")
	private String error;
}