package com.pro.commons.events.model.user;

import com.pro.commons.events.model.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record UserVerifiedEvent(

        UUID eventId,
        Instant occurredAt,

        UUID userUuid,
        String countryIsoCode,
        String currencyCode

) implements DomainEvent {

    public static UserVerifiedEvent of(UUID userUuid, String countryIsoCode, String currencyCode) {
        return new UserVerifiedEvent(
                UUID.randomUUID(),
                Instant.now(),
                userUuid,
                countryIsoCode,
                currencyCode
        );
    }

}
