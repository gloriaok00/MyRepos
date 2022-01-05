package com.example.demo.pingshi.siddhi;

import com.sitewhere.rest.model.device.event.DeviceEvent;
import com.sitewhere.rest.model.device.event.DeviceEventContext;
import lombok.Data;

/**
 * Event payload that has been enriched with extra device/assignment data that
 * may be useful in processing.
 */

@Data
public class EnrichedEventPayload {

    /**
     * Extra context
     */
    private DeviceEventContext eventContext;

    /**
     * Event
     */
    private DeviceEvent event;

}
