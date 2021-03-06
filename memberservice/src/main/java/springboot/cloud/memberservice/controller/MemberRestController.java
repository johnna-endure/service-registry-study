package springboot.cloud.memberservice.controller;

import org.springframework.web.bind.annotation.*;
import springboot.cloud.memberservice.client.TeamDiscoveryClient;
import springboot.cloud.memberservice.controller.dto.MemberDto;
import springboot.cloud.memberservice.entity.Member;
import springboot.cloud.memberservice.repository.MemberRepository;

import java.util.NoSuchElementException;
import java.util.Objects;

import static java.util.Objects.nonNull;

@RestController
public class MemberRestController {

    private final MemberRepository memberRepository;
    private final TeamDiscoveryClient teamDiscoveryClient;

    public MemberRestController(MemberRepository memberRepository, TeamDiscoveryClient teamDiscoveryClient) {
        this.memberRepository = memberRepository;
        this.teamDiscoveryClient = teamDiscoveryClient;
    }

    @GetMapping("/members/{memberId}")
    public MemberDto getMember(@PathVariable("memberId") Long memberId) {
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new NoSuchElementException(memberId+"에 해당하는 회원이 없습니다."));

        MemberDto memberDto = new MemberDto(findMember);

        if(nonNull(findMember.getTeamId())) {
            memberDto.setTeam(teamDiscoveryClient.getTeam(findMember.getTeamId()));
        }
        return memberDto;
    }

    @PostMapping("/init")
    public void initData() {
        memberRepository.save(new Member("iu", 28, 1L));
        memberRepository.save(new Member("chungha", 25,2L));
    }
}
