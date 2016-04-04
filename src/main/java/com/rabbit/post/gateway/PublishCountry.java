package com.rabbit.post.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;


/**
 * SI Gateway Interface to manage publishing to RabbitMQ.
 */
@MessagingGateway(name = "country-code-publisher")
public interface PublishCountry {


    /**
     * Publish information to the SI gateway.
     * @param country to publish.
     */
    @Gateway(requestChannel = "post-country-code-channel")
    void publish(final Country country);

}
