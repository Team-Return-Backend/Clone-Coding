package com.example.together.domain.donation.presentation;

import com.example.domain.donation.dto.QueryDonationListResponse;
import com.example.domain.donation.usecase.CreateDonationUseCase;
import com.example.domain.donation.usecase.DonateMoneyUseCase;
import com.example.domain.donation.usecase.QueryDonationListUseCase;
import com.example.domain.donation.usecase.QueryTagDonationListUseCase;
import com.example.together.domain.donation.presentation.dto.request.CreateDonationWebRequest;
import com.example.together.domain.donation.presentation.dto.request.DonateMoneyWebRequest;
import com.example.together.domain.donation.presentation.dto.request.QueryTagDonationWebRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/donation")
@RestController
public class DonationWebAdapter {

    private final CreateDonationUseCase createDonationUseCase;
    private final DonateMoneyUseCase donateMoneyUseCase;
    private final QueryDonationListUseCase queryDonationListUseCase;
    private final QueryTagDonationListUseCase queryTagDonationListUseCase;

    @PostMapping
    public void createDonation(@RequestBody @Valid CreateDonationWebRequest webRequest) {
        createDonationUseCase.execute(webRequest.toDomainRequest());
    }

    @PostMapping("/donate")
    public void donateMoney(@RequestBody @Valid DonateMoneyWebRequest webRequest) {
        donateMoneyUseCase.execute(webRequest.toDomainRequest());
    }

    @GetMapping
    public QueryDonationListResponse queryDonationList() {
        return queryDonationListUseCase.execute();
    }

    @GetMapping("/tag")
    public QueryDonationListResponse queryTagDonationList(QueryTagDonationWebRequest webRequest) {
        return queryTagDonationListUseCase.execute(webRequest.toDomainRequest());
    }

}
