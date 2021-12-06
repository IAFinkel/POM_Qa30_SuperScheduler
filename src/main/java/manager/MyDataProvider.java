package manager;

import models.Auth;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]>loginDtoPos(){

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Auth.builder()
                .email("your2@gmail.com")
                .password("Yy123456$")
                .build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>loginDtoNeg(){

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Auth.builder()
                .email("your2gmail.com")
                .password("Yy123456$")
                .build()});

        return list.iterator();
    }


}
