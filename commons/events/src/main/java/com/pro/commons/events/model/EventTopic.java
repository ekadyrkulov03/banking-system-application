package com.pro.commons.events.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EventTopic {

    // user-service
    USER_VERIFIED("user.verified");;

    private final String topicName;

}
