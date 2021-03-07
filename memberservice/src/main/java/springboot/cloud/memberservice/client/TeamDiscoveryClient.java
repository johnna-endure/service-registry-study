package springboot.cloud.memberservice.client;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import springboot.cloud.memberservice.client.dto.TeamDto;

@Component
public class TeamDiscoveryClient {

    private final RestTemplate restTemplate;

    public TeamDiscoveryClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public TeamDto getTeam(Long teamId) {
        ResponseEntity<TeamDto> exchange = restTemplate.exchange(
                "http://team-service/teams/" + teamId,
                HttpMethod.GET,
                null,
                TeamDto.class);
        return exchange.getBody();
    }

}
