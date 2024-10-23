package kr.co.ckdgns.tmdb.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class TmdbService {
	private final String apiKey = "7fac3654ac1cb2c02d565db3f351b84b";
    private final String tmdbUrl = "https://api.themoviedb.org/3/movie/";

    public String getMovieDetails(int movieId) throws IOException {
        String url = tmdbUrl + movieId + "?api_key=" + apiKey;

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        CloseableHttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        client.close();

        return result; // JSON 형태로 영화 데이터 반환
    }
}
