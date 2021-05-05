package dataModel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
@Getter
@Setter
@ToString
public class PetPojo
{
    private String id;
    private String name;
    private HashMap <String,String> category;
    private ArrayList<String> photoUrls;
    private HashMap <String,String> tag;
    private ArrayList<HashMap <String,String>> tags;
    private String status;
}
