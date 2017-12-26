package com.gemidroid.java_lib;

import java.util.ArrayList;
import java.util.List;

public class JavaClass {

    List<String> JokesList = new ArrayList<>();


    public List<String> GetAllJokes() {

        if (JokesList.isEmpty()) {

            JokesList.add("1- Chuck Norris uses ribbed condoms inside out, so he gets the pleasure.");

            JokesList.add("2- MacGyver can build an airplane out of gum and paper clips. Chuck Norris can kill him and take it.");

            JokesList.add("3- Chuck Norris doesn't read books. He stares them down until he gets the information he wants.");

            JokesList.add("4- If you ask Chuck Norris what time it is, he always answers &quot;Two seconds till&quot;. After you ask &quot;Two seconds to what?&quot;, he roundhouse kicks you in the face.");

            JokesList.add("5- Chuck Norris lost his virginity before his dad did.");

            JokesList.add("6- Since 1940, the year Chuck Norris was born, roundhouse kick related deaths have increased 13,000 percent.");

            JokesList.add("7- Chuck Norris sheds his skin twice a year.");

            JokesList.add("8- Chuck Norris once challenged Lance Armstrong in a &quot;Who has more testicles?&quot; contest. Chuck Norris won by 5.");

            JokesList.add("9- There are no steroids in baseball. Just players Chuck Norris has breathed on.");

            JokesList.add("10- When Chuck Norris goes to donate blood, he declines the syringe, and instead requests a hand gun and a bucket.");
        }
        return JokesList;

    }


}
