package ws;
import java.util.*;
import entities.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.sun.jersey.api.client.*;
@Path("artist")
public class ArtistRestFul {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findAll/{country}")
	public List<Artist> findAll(@PathParam("country") String strCountry){
		List<Artist> result = new ArrayList<Artist>();
		try {
			Client client = Client.create();

			WebResource webResource = client
					.resource("http://ws.audioscrobbler.com/2.0/?method=geo.gettopartists&country="+strCountry+"&api_key=a2c9bdcbe5800c3e41d7943c00d7f9f9&format=json");

			ClientResponse response = webResource.accept("application/json")
					.get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(output);
			JSONObject json1 = (JSONObject)json.get("topartists");
			JSONArray arr = (JSONArray)json1.get("artist");
			for(Object jsnObj:arr){

				JSONObject jsonObjTemp = (JSONObject)jsnObj;
				JSONArray jsonArray = (JSONArray)jsonObjTemp.get("image");
				JSONObject pathurl = (JSONObject)jsonArray.get(0);
				String path = (String)pathurl.get("#text");
				Artist artist = new Artist(jsonObjTemp.get("name").toString(),jsonObjTemp.get("listeners").toString(),
						jsonObjTemp.get("mbid").toString(),jsonObjTemp.get("url").toString(),path);
				result.add(artist);
			}

		}	
		catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findArtistTracks/{track}")
	public List<Track> listArtistTracks(@PathParam("track") String strTrack){
			List<Track> result = new ArrayList<Track>();
	try {
		Client client = Client.create();

		WebResource webResource = client
				.resource("http://ws.audioscrobbler.com/2.0/?method=artist.gettoptracks&artist="+strTrack+"&api_key=a2c9bdcbe5800c3e41d7943c00d7f9f9&format=json");

		ClientResponse response = webResource.accept("application/json")
				.get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		String output = response.getEntity(String.class);

		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(output);
		JSONObject json1 = (JSONObject)json.get("toptracks");
		JSONArray arr = (JSONArray)json1.get("track");
		for(Object jsnObj:arr){

			JSONObject jsonObjTemp = (JSONObject)jsnObj;
			JSONArray jsonArray = (JSONArray)jsonObjTemp.get("image");
			JSONObject pathurl = (JSONObject)jsonArray.get(0);
			String path = (String)pathurl.get("#text");

			Track track = new Track(jsonObjTemp.get("name").toString(),jsonObjTemp.get("playcount").toString(),
					jsonObjTemp.get("listeners").toString(),jsonObjTemp.get("url").toString(),jsonObjTemp.get("streamable").toString(),path);
			result.add(track);
		}

	}	
	catch (Exception e) {
		e.printStackTrace();
	}

	return result;
	}	
}
