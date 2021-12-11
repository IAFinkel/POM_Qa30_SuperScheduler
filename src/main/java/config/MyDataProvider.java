package config;

import models.Auth;
import org.testng.annotations.DataProvider;

import java.io.*;
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
                .email("your2@gmail.com")
                .password("Yy123456")
                .build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginFromFilePos() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src\\test\\resources\\dataPos.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[] split = line.split(",");
            list.add(new Object[]{Auth.builder()
                    .email(split[0])
                    .password(split[1])
                    .build()});

            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginFromFileNeg() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src\\test\\resources\\dataNeg.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[] split = line.split(",");
            list.add(new Object[]{Auth.builder()
                    .email(split[0])
                    .password(split[1])
                    .build()});

            line = reader.readLine();
        }
        return list.iterator();
    }


}
