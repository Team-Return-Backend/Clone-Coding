package com.example.together.domain.like;

import com.example.domain.auth.dto.TokenResponse;
import com.example.domain.like.usecase.LikeUseCase;
import com.example.together.domain.user.presentation.dto.request.LoginWebRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
