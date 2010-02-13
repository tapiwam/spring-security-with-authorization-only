import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

/**
 * @author Saurabh Agrawal
 * @crated Feb 13, 2010
 */
public abstract class AbstractIntegrationTestCase extends AbstractDependencyInjectionSpringContextTests {


    protected MockHttpServletRequest request = new MockHttpServletRequest();
    protected MockHttpServletResponse response = new MockHttpServletResponse();
    protected MockFilterChain filterChain = new MockFilterChain();

    private static final String[] context = new String[]{
            "classpath*:/com/codersatwork/security/applicationContext-core-security.xml",
            "classpath*:/com/codersatwork/security/applicationContext-web-security.xml"};


    @Override
    protected String[] getConfigLocations() {
        return context;
    }


}
