package Tests;


import org.example.Person;
import org.testng.annotations.Test;

import org.matcher.ProjectSoftAssertions;

import static org.matcher.ProjectAssertions.assertThat;


public class TestCustomAssertion {

    @Test
    public void testPersonAssertion(){
        Person person = new Person("Itai Agmon", 11);
        assertThat(person)
                .hasFullName("Itai Foo")
                .isAdult();
    }


    @Test
    public void testPersonSoftlyAssertion(){
        Person person = new Person("Itai Agmon", 11);
        ProjectSoftAssertions softly = new ProjectSoftAssertions();
        softly.assertThat(person)
                .hasFullName("Itai Foo")
                .isAdult();
        softly.assertAll();
    }

}
