package Airlines.Pojos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Airline {
	
	private int id;
	private String name;
	private String country;
	private String logo;
	private String slogan;
	private String headquoters;
	private String website;
	private String established;

	
}
