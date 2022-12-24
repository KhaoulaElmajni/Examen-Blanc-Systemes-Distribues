package me.elmajni.commonapi

import java.lang.RuntimeException

abstract class VehicleOverSpeedingTicketException(message : String)
    : RuntimeException(message);
class VehicleOwnerAlreadyAffctedException(message : String) :
    VehicleOverSpeedingTicketException(message);