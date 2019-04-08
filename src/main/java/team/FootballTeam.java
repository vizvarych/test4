package team;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.InvalidJsonException;
import com.jayway.jsonpath.JsonPath;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class FootballTeam {
    public static void main(String[] args) throws InvalidJsonException, IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/football_club.json");
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(fis, "UTF-8");
        ArrayList<String> clubsFoundDate = JsonPath.read(document, "$.football_club[*].founded");
        System.out.println(clubsFoundDate);
    }
}
