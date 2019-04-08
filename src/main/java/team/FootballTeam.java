package team;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.InvalidJsonException;
import com.jayway.jsonpath.JsonPath;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;



public class FootballTeam {
    public static void main(String[] args) throws InvalidJsonException, IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/football_club.json");
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(fis, "UTF-8");
         ArrayList<Map<String,String>> clubsFoundDate = JsonPath.read(document, "$.football_club[*]");

        Collections.sort(clubsFoundDate, new Comparator<Map<String, String>>() {
            public int compare(Map<String, String> o1, Map<String, String> o2) {
                int compare = o1.get("founded").compareTo(o2.get("founded"));
                if(compare == 0){
                    compare = o1.get("city").compareTo(o2.get("city"));
                    if(compare == 0){
                        compare = o1.get("coach_name").compareTo(o2.get("coach_name"));
                    }
                }
                return compare;
            }
        });

        for (Map<String,String> e: clubsFoundDate
             ) {
            System.out.println(e);
        }
    }
}
