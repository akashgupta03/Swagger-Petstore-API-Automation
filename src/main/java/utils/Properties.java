package utils;

public class Properties {

    private static final PropertiesReader propertiesReader = new PropertiesReader();
    public static final String baseUri = propertiesReader.getBaseUri();
    public static final String createMultipleUserEndPoint = propertiesReader.getCreateMultipleUserEndPoint();
    public static final String updatePetStatusEndPoint = propertiesReader.getUpdatePetStatusEndPoint();
    public static final String updateUserDetailEndPoint = propertiesReader.getUpdateUserDetailEndPoint();
    public static final String getPetStatusEndPoint = propertiesReader.getGetPetStatusEndPoint();
    public static final String createMultiplePetEndPoint = propertiesReader.getCreateMultiplePetEndPoint();



}
