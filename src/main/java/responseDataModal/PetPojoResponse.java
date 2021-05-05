package responseDataModal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PetPojoResponse {
    private String id;
    Category CategoryObject;
    private String name;
    ArrayList<Object> photoUrls = new ArrayList<Object>();
    ArrayList<Object> tags = new ArrayList<Object>();
    private String status;
}

@Getter
@Setter
@ToString
class Category {
    private float id;
    private String name;

}

