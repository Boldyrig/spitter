package controller;

import com.gmail.fuskerr63.controller.HomeController;
import com.gmail.fuskerr63.domain.Spitter;
import com.gmail.fuskerr63.service.ISpitterService;
import com.gmail.fuskerr63.service.SpitterService;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;
import static com.gmail.fuskerr63.controller.HomeController.DEFAULT_SPITTERS_PER_PAGE;
import static org.mockito.Mockito.*;

public class HomeControllerTest {
    @Test
    public void shouldDisplayRecentSpitters() {
        List<Spitter> spitters = asList(
                new Spitter(0, "name1", "message1", "tag1"),
                new Spitter(1, "name2", "message2", "tag2"),
                new Spitter(2, "name3", "message3", "tag3"),
                new Spitter(3, "name4", "message4", "tag4")
        );

        ISpitterService spitterService = mock(SpitterService.class);

        when(spitterService.getRecentSpitters(DEFAULT_SPITTERS_PER_PAGE))
                .thenReturn(spitters);

        HomeController homeController = new HomeController(spitterService);
        HashMap<String, Object> model = new HashMap<>();

        String viewName = homeController.showHomePage(model);

        assertEquals(viewName, "home");

        assertSame(spitters, model.get("spitters"));
        verify(spitterService).getRecentSpitters(DEFAULT_SPITTERS_PER_PAGE);
    }
}
