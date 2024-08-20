package e2e;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;
import org.testng.annotations.Listeners;

@Listeners(il.co.topq.difido.ReportManagerHook.class)
public abstract class TestCase {

    protected ReportDispatcher report = ReportManager.getInstance();



}
