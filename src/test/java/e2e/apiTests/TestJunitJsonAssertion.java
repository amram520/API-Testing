package e2e.apiTests;

import org.testng.annotations.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;


public class TestJunitJsonAssertion {

    @Test
    public void testJsonAssert() {
        String json = "{\"name\":\"John\", \"age\":30, \"car\":null}";
        assertThatJson(json).node("name").isEqualTo("Itai");
    }

}
