package no.fint.provider.adapter.sse;

import lombok.extern.slf4j.Slf4j;
import no.fint.event.model.Event;
import no.fint.provider.profilbilde.service.EventHandlerService;
import no.fint.sse.AbstractEventListener;
import org.glassfish.jersey.media.sse.InboundEvent;

/**
 * Event listener for the for the SSE client. When an inbound event is received the {@link #onEvent(InboundEvent)} method
 * calls {@link EventHandlerService} service.
 */
@Slf4j
public class FintEventListener extends AbstractEventListener {

    private EventHandlerService eventHandler;

    public FintEventListener(EventHandlerService eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public void onEvent(Event event) {
        log.info("Processing event: {}", event);
        log.trace("Event data: {}", event.getData());
        eventHandler.handleEvent(event);
    }
}
