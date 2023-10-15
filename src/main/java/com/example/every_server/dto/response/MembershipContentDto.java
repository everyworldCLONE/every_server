package com.example.every_server.dto.response;

import com.example.every_server.entity.Membership;
import com.example.every_server.global.common.Convert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MembershipContentDto {
    private List<String> title;
    private List<String> img;
    private List<String> content;

    public static MembershipContentDto from(Membership membership) {
        return MembershipContentDto.builder()
                .title(Convert.ToList(membership.getTitle()))
                .content(Convert.ToList(membership.getContent()))
                .img(Convert.ToList(membership.getImg()))
                .build();
    }
}
