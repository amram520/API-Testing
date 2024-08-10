package org.matcher;

import org.assertj.core.api.Assertions;
import org.example.Person;

public class ProjectAssertions extends Assertions {
    public static PersonAssert assertThat(Person actual) {
        return new PersonAssert(actual);
    }

    // static factory methods of other assertion classes
}