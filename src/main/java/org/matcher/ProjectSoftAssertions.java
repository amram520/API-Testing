package org.matcher;

import org.assertj.core.api.SoftAssertions;
import org.example.Person;

public class ProjectSoftAssertions extends SoftAssertions {
    public PersonAssert assertThat(Person actual) {
        return proxy(PersonAssert.class, Person.class, actual);
    }

}
