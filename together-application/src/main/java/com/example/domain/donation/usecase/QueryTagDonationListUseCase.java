package com.example.domain.donation.usecase;

import com.example.common.annotation.UseCase;
import com.example.domain.donation.dto.QueryDonationListResponse;
import com.example.domain.donation.dto.QueryTagDonationRequest;
import com.example.domain.donation.model.DonationTag;
import com.example.domain.donation.spi.QueryDonationPort;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@UseCase
public class QueryTagDonationListUseCase {

    private final QueryDonationPort queryDonationPort;

    public QueryDonationListResponse execute(QueryTagDonationRequest request) {

        return new QueryDonationListResponse (
                queryDonationPort.queryDonationListByTag(request.getDonationTag())
        );
    }

}
