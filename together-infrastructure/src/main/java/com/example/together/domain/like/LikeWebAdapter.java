package com.example.together.domain.like;

import com.example.domain.like.usecase.LikeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/like")
@RestController
public class LikeWebAdapter {

    private final LikeUseCase likeUseCase;

    @PostMapping("/{donation-id}")
    public void like(@PathVariable("donation-id") Long donationId) {
        likeUseCase.execute(donationId);
    }

}
