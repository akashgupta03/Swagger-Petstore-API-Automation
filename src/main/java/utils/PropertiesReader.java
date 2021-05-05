package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class PropertiesReader {
    private Properties prop = new Properties();

    PropertiesReader() {
        String propertiesFilePath = "config.properties";
        InputStream inputStream;
        inputStream = getInputStream(propertiesFilePath);

        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InputStream getInputStream(String propertiesFilePath) {
        return this.getClass().getClassLoader().getResourceAsStream(propertiesFilePath);
    }

    String getBaseUri() {
        return prop.getProperty("BaseURi");
    }


    String getCreateMultipleUserEndPoint() {
        return prop.getProperty("createMultipleUserEndPoint");
    }

    String getUpdateUserDetailEndPoint() {
        return prop.getProperty("updateUserDetailEndPoint");
    }

    String getCreateMultiplePetEndPoint() {
        return prop.getProperty("createMultiplePetEndPoint");
    }

    String getUpdatePetStatusEndPoint() {
        return prop.getProperty("updatePetStatusEndPoint");
    }

    String getGetPetStatusEndPoint() {
        return prop.getProperty("getPetStatusEndPoint");
    }

}
