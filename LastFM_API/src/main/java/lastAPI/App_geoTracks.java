package lastAPI;

import java.util.HashMap;
import java.util.Map;

import lastAPI.calls.Geo_Tracks;
import models.geo.tracks.GeoGetTopTracks;
import models.geo.tracks.Track;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App_geoTracks {

	public static void main(String[] args) {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(Geo_Tracks.url_base)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		Map<String, String> options = new HashMap<String, String>();
		//method=geo.gettoptracks&
		//country=brazil&
		//limit=1&
		//api_key=68bcc9cffa6a90e346de31b396b1a163&
		//format=json
		options.put("method", "geo.gettoptracks");
		options.put("country", "brazil");
		options.put("api_key", "68bcc9cffa6a90e346de31b396b1a163");
		options.put("format", "json");
		options.put("limit", "4");
		
		Geo_Tracks geotracks = retrofit.create(Geo_Tracks.class);
		Call<GeoGetTopTracks> requestTracks = geotracks.geo_tracks(options);
		
		requestTracks.enqueue(new Callback<GeoGetTopTracks>() {
			
			public void onResponse(Call<GeoGetTopTracks> call, Response<GeoGetTopTracks> r) {
				if(!r.isSuccessful()) {
					System.out.println("Erro: "+r.code());
				}else {
					GeoGetTopTracks tracks = r.body();
					for(Track track : tracks.tracks.track) {
						System.out.println(track.name);
						System.out.println(track.artist.name);
					}
				}
				
			}
			
			public void onFailure(Call<GeoGetTopTracks> call, Throwable t) {
				// TODO Auto-generated method stub
				
			}
		});

	}

}
