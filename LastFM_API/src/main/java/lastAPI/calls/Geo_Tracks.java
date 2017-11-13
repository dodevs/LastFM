package lastAPI.calls;

import java.util.Map;

import models.geo.tracks.GeoGetTopTracks;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface Geo_Tracks {
	String url_base = "http://ws.audioscrobbler.com/2.0/?"; //Url principal da api
	@GET(url_base)//Vai user o método GET nessa usrl
	Call<GeoGetTopTracks> geo_tracks(@QueryMap Map<String, String> options); //Passando esses parametros para a chamada
}
