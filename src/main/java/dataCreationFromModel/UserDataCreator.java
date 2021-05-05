package dataCreationFromModel;

import dataModel.UserPojo;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class UserDataCreator
{
    public static UserPojo user;
    public static Faker fake = new Faker();

    public UserPojo DataForUSerCreation() {
        user = new UserPojo();
        user.setId(fake.number().randomDigitNotZero());
        user.setUsername(fake.name().username());
        user.setFirstName(fake.name().firstName());
        user.setLastName(fake.name().lastName());
        user.setEmail(fake.internet().emailAddress());
        user.setPassword(fake.internet().password());
        user.setPhone(fake.phoneNumber().phoneNumber());
        user.setUserStatus("1");
        return user;
    }
    public List<UserPojo> createUser(long numberOfUsers){

        List<UserPojo> userPojoList = new ArrayList<>();

        for(int count=0;count<numberOfUsers;count++){

            userPojoList.add(DataForUSerCreation());
        }

        return userPojoList;
    }
}
