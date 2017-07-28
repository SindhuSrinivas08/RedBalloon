package entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="track")
public class Track {
	private String name;
	private String playcount;
	private String listeners;
	private String url;
	private String streamable;
	private String imagePath;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlaycount() {
		return playcount;
	}
	public void setPlaycount(String playcount) {
		this.playcount = playcount;
	}
	public String getListeners() {
		return listeners;
	}
	public void setListeners(String listeners) {
		this.listeners = listeners;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getStreamable() {
		return streamable;
	}
	public void setStreamable(String streamable) {
		this.streamable = streamable;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Track(String name, String playcount, String listeners, String url, String streamable, String imagePath) {
		super();
		this.name = name;
		this.playcount = playcount;
		this.listeners = listeners;
		this.url = url;
		this.streamable = streamable;
		this.imagePath = imagePath;
	}
	public Track() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
