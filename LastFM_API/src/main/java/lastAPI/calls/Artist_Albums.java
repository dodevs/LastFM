package lastAPI.calls;

import java.util.Map;

import models.artist.albums.Album;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface Artist_Albums {
	String url_base = "http://ws.audioscrobbler.com/2.0/?"; //Url principal da api
	@GET(url_base)
	Call<Album> artist_albums(@QueryMap Map<String, String> options);
}
