package me.elmajni.commonapi

class GetAllRadarsQuery();
data class GetRadarById(
    val radarId:String,
);

class GetOverSpeedsQuery();

class SubscribeToEventsQuery();
class GetAllOverSpeedsQuery();
class GetAllOverSpeedsByRegistrationNumberQuery(
    val registrationNumber : String,
);

//**********************IMMATRICULATION********************************//


class GetAllVehiclesQuery();
class GetAllOwners();
class GetVehicleByRegistrationNumber(
    val registrationNumber : String,
);

class GetAllContraventions(
    val page : Int,
    val size : Int
);
class GetContraventionsByNationalCardNumber(
    val nationalCardNumber : String,
    val page : Int,
    val size : Int
);
