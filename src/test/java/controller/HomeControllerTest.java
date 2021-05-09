package controller;

import com.gmail.fuskerr63.controller.HomeController;
import com.gmail.fuskerr63.domain.Message;
import com.gmail.fuskerr63.domain.Spitter;
import com.gmail.fuskerr63.service.IMessageService;
import com.gmail.fuskerr63.service.ISpitterService;
import com.gmail.fuskerr63.service.MessageService;
import com.gmail.fuskerr63.service.SpitterService;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;
import static com.gmail.fuskerr63.controller.HomeController.DEFAULT_SPITTERS_PER_PAGE;
import static org.mockito.Mockito.*;

public class HomeControllerTest {
    @Test
    public void shouldDisplayRecentSpitters() {
        List<Spitter> spitters = asList(
                new Spitter(0, "name1", "username1"),
                new Spitter(1, "name2", "username2"),
                new Spitter(2, "name3", "username3"),
                new Spitter(3, "name4", "username4")
        );

        List<Message> messages = asList(
                new Message(0, 2, "username", "text", "tag", new Date()),
                new Message(1, 0, "username", "text", "tag", new Date()),
                new Message(2, 1, "username", "text", "tag", new Date()),
                new Message(3, 3, "username", "text", "tag", new Date())
        );

        IMessageService messageService = mock(MessageService.class);

        when(messageService.getRecentMessages(DEFAULT_SPITTERS_PER_PAGE))
                .thenReturn(messages);

        HomeController homeController = new HomeController(messageService);
        HashMap<String, Object> model = new HashMap<>();

        String viewName = homeController.showHomePage(model);

        assertEquals(viewName, "home");

        assertSame(messages, model.get("messages"));
        verify(messageService).getRecentMessages(DEFAULT_SPITTERS_PER_PAGE);
    }
}
