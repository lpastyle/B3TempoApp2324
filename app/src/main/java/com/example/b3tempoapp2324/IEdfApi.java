package com.example.b3tempoapp2324;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IEdfApi {

    // https://particulier.edf.fr/services/rest/referentiel/getNbTempoDays?TypeAlerte=TEMPO

    @GET("services/rest/referentiel/getNbTempoDays")
    Call<TempoDaysLeft> getTempoDaysLeft(@Query("TypeAlerte")String alertType);

    //https://particulier.edf.fr/services/rest/referentiel/searchTempoStore?dateRelevant=2024-02-20&TypeAlerte=TEMPO

    // https://particulier.edf.fr/services/rest/referentiel/historicTEMPOStore?dateBegin=2023&dateEnd=2024
}
