package kr.co.ckdgns.tmdb.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MovieService {

	private static final String TMDB_API_KEY = "7fac3654ac1cb2c02d565db3f351b84b";  // 발급받은 TMDB API 키
    private static final String TMDB_API_URL = "https://api.themoviedb.org/3/movie/popular";

    public Map<String, Object> getPopularMovies() {
        RestTemplate restTemplate = new RestTemplate();
        
        // API URL 구성
        String url = UriComponentsBuilder.fromHttpUrl(TMDB_API_URL)
                .queryParam("api_key", TMDB_API_KEY)
                .queryParam("language", "ko-KR")
                .queryParam("page", 1)
                .toUriString();

        // API 호출
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        return response; // TMDB API의 응답 데이터
    }
}
