package com.example.together.domain.donation.presentation;

import com.example.domain.donation.usecase.CreateDonationUseCase;
import com.example.domain.donation.usecase.DonateMoneyUseCase;
import com.example.together.domain.donation.presentation.dto.request.CreateDonationWebRequest;
import com.example.together.domain.donation.presentation.dto.request.DonateMoneyWebRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/donation")
@RestController
public class DonationWebAdapter {

    private final CreateDonationUseCase createDonationUseCase;
    private final DonateMoneyUseCase donateMoneyUseCase;

    @PostMapping
    public void createDonation(@RequestBody @Valid CreateDonationWebRequest webRequest) {
        createDonationUseCase.execute(webRequest.toDomainRequest());
    }

    @PostMapping("/donate")
    public void donateMoney(@RequestBody @Valid DonateMoneyWebRequest webRequest) {
        donateMoneyUseCase.execute(webRequest.toDomainRequest());
    }

}
