package com.example.every_server.entity;

import com.example.every_server.dto.request.MembershipDto;
import com.example.every_server.global.common.Convert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Membership extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "membership_id", nullable = false)
    private Long membershipId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "img")
    private String img;

    public static Membership from (MembershipDto membershipDto){
        String title = Convert.ToJson(membershipDto.getTitle());
        String content = Convert.ToJson(membershipDto.getContent());
        String img = Convert.ToJson(membershipDto.getImg());

        Membership membership = Membership.builder().title(title).content(content).img(img).build();
        membership.language = membershipDto.getLanguage();

        return membership;
    }
}

