package me.elmajni.radarqueryservice.mappers;

import ma.enset.coreapi.*;
import me.elmajni.radarqueryservice.entities.OverSpeedDetection;
import me.elmajni.radarqueryservice.entities.Radar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RadarMappers {
    Radar from(RadarDTO radarDTO);
    RadarResponseDTO from(Radar radar);
    RadarOverSpeedsDTO fromRadar(Radar radar);
    OverSpeedDetection from(OverSpeedRequestDTO overSpeedRequestDTO);
    OverSpeedResponseDTO fromOS(OverSpeedDetection overSpeedRequest);
}
