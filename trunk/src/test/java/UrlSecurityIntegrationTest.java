import org.springframework.mock.web.MockFilterChain;
import org.springframework.security.AccessDeniedException;
import org.springframework.security.intercept.web.FilterSecurityInterceptor;
import org.springframework.security.ui.webapp.AuthenticationProcessingFilter;

/**
 * @author Saurabh Agrawal
 * @crated Feb 13, 2010
 */
public class UrlSecurityIntegrationTest extends AbstractIntegrationTestCase {


    private String filterProcessesUrl = "/pages/j_spring_security_check";


    public void testSucessfullAuthorize() throws Exception {

        request.setRequestURI(filterProcessesUrl);
        request.addParameter(AuthenticationProcessingFilter.SPRING_SECURITY_FORM_USERNAME_KEY, "Saurabh");
        request.addParameter(AuthenticationProcessingFilter.SPRING_SECURITY_FORM_PASSWORD_KEY, "1234");


        AuthenticationProcessingFilter authenticationProcessingFilter = (AuthenticationProcessingFilter) getApplicationContext().getBeansOfType(AuthenticationProcessingFilter.class).values().iterator().next();

        authenticationProcessingFilter.doFilter(request, response, filterChain);


        FilterSecurityInterceptor filterSecurityInterceptor = (FilterSecurityInterceptor) getApplicationContext().getBeansOfType(FilterSecurityInterceptor.class).values().iterator().next();


        request.setPathInfo("/page/home");

        filterSecurityInterceptor.doFilter(request, response, new MockFilterChain());

    }

    public void testUnAuthorize() throws Exception {

        request.setRequestURI(filterProcessesUrl);
        request.addParameter(AuthenticationProcessingFilter.SPRING_SECURITY_FORM_USERNAME_KEY, "un-authorize user");
        request.addParameter(AuthenticationProcessingFilter.SPRING_SECURITY_FORM_PASSWORD_KEY, "1234");


        AuthenticationProcessingFilter authenticationProcessingFilter = (AuthenticationProcessingFilter) getApplicationContext().getBeansOfType(AuthenticationProcessingFilter.class).values().iterator().next();

        authenticationProcessingFilter.doFilter(request, response, filterChain);


        FilterSecurityInterceptor filterSecurityInterceptor = (FilterSecurityInterceptor) getApplicationContext().getBeansOfType(FilterSecurityInterceptor.class).values().iterator().next();


        request.setPathInfo("/page/home");

        try {
            filterSecurityInterceptor.doFilter(request, response, new MockFilterChain());
            fail("must throw access defined");
        } catch (AccessDeniedException e) {
            //
        }

    }

}