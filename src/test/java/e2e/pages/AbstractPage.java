package e2e.pages;

import e2e.TestCase;

public abstract class AbstractPage extends TestCase {

    public abstract  <T> T validateNavigation();

}
