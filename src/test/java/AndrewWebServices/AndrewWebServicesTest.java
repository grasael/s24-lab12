package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class AndrewWebServicesTest {
    InMemoryDatabase database;
    RecSys recommender;
    PromoService promoServiceMock;
    AndrewWebServices andrewWebService;

    @Before
    public void setUp() {
        // You need to use some mock objects here
        database = new InMemoryDatabase(); // We probably don't want to access our real database...
        recommender = mock(RecSys.class);
        promoServiceMock = mock(PromoService.class);

        andrewWebService = new AndrewWebServices(database, recommender, promoServiceMock);
    }

    @Test
    public void testLogIn() {
        // This is taking way too long to test
        database.addAccount("Scotty", 17214);
        assertTrue(andrewWebService.logIn("Scotty", 17214));
    }

    @Test
    public void testGetRecommendation() {
        // This is taking way too long to test
        when(recommender.getRecommendation("Scotty")).thenReturn("Animal House");
        assertEquals("Animal House", andrewWebService.getRecommendation("Scotty"));
    }

    @Test
    public void testSendEmail() {
        // How should we test sendEmail() when it doesn't have a return value?
        // Hint: is there something from Mockito that seems useful here?
        promoServiceMock.mailTo("something");
        verify(promoServiceMock).mailTo("something");
    }

    @Test
    public void testNoSendEmail() {
        // How should we test that no email has been sent in certain situations (like right after logging in)?
        // Hint: is there something from Mockito that seems useful here?
        andrewWebService.logIn("Scotty", 17214);
        verify(promoServiceMock, never()).mailTo("Scotty@andrew.cmu.edu");
    }
}
