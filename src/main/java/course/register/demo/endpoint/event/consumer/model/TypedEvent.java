package course.register.demo.endpoint.event.consumer.model;

import course.register.demo.PojaGenerated;
import course.register.demo.endpoint.event.model.PojaEvent;

@PojaGenerated
public record TypedEvent(String typeName, PojaEvent payload) {}
