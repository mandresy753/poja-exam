package image.submisson.demo.endpoint.event.consumer.model;

import image.submisson.demo.PojaGenerated;
import image.submisson.demo.endpoint.event.model.PojaEvent;

@PojaGenerated
public record TypedEvent(String typeName, PojaEvent payload) {}
