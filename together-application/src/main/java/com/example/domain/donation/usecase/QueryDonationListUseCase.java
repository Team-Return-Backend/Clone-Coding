package com.example.domain.donation.usecase;

import com.example.common.annotation.UseCase;
import com.example.domain.donation.dto.QueryDonationListResponse;
import com.example.domain.donation.spi.QueryDonationPort;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@UseCase
public class QueryDonationListUseCase {

    private final QueryDonationPort queryDonationPort;

    public QueryDonationListResponse execute() {

        return new QueryDonationListResponse(
                queryDonationPort.queryDonationList()
        );
    }
}
