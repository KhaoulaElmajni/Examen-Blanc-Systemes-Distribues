package me.elmajni.radardevices.model;

import lombok.Data;

@Data
public class ChangeRadarStatusRequest {
    private String radarId;
    private String radarStatus;
}
