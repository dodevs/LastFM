package lastAPI;

import java.util.HashMap;
import java.util.Map;

import lastAPI.calls.Track_Search;
import lastAPI.calls.Track_Similar;
import models.track.similar.SimilarTracks;
import models.track.similar.Track;
import models.track.similar.TrackGetSimilar;
import okio.Options;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App_Similar {
	public static void main(String[] args) {
		// Constroi o objeto
		Retrofit retrofit = new Retrofit.Builder().baseUrl(Track_Similar.url_base)// Olha na interface
				.addConverterFactory(GsonConverterFactory.create())// Método de "conversão" do JSON para uma classe
				.build();
		
		Map<String, String> options = new HashMap<String, String>(); //Cria um hashmap para as query's
		options.put("method","track.getSimilar");
		options.put("artist", "Projota");
		options.put("track", "Mulher");
		options.put("api_key", "68bcc9cffa6a90e346de31b396b1a163");
		options.put("format", "json");
		options.put("limit", "4");
		
		Track_Similar similar = retrofit.create(Track_Similar.class);
		Call<TrackGetSimilar> requestSimilar = similar.track_similar(options);
		
		requestSimilar.enqueue(new Callback<TrackGetSimilar>() {

			public void onFailure(Call<TrackGetSimilar> call, Throwable t) {
				System.out.println("erro "+t.getMessage());	
			}

			public void onResponse(Call<TrackGetSimilar> call, Response<TrackGetSimilar> r) {
				if(!r.isSuccessful()) {
					System.out.println("Erro: "+r.code());
				}
				else {
					TrackGetSimilar similar = r.body();
					
					for(Track track : similar.similartracks.track) {
						System.out.println(track.name);
						System.out.println(track.artist);
						System.out.println("");
					}
					
				}
			}
			
		});
		
	}
}
