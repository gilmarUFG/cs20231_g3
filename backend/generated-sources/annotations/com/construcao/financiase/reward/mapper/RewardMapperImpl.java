package com.construcao.financiase.reward.mapper;

import com.construcao.financiase.reward.dto.RewardDTO;
import com.construcao.financiase.reward.entity.Reward;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-16T21:31:54-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class RewardMapperImpl implements RewardMapper {

    @Override
    public Reward toModel(RewardDTO rewardDTO) {
        if ( rewardDTO == null ) {
            return null;
        }

        Reward reward = new Reward();

        reward.setDescription( rewardDTO.getDescription() );
        reward.setExpectedDeliveryDate( rewardDTO.getExpectedDeliveryDate() );
        reward.setMinValue( rewardDTO.getMinValue() );

        return reward;
    }

    @Override
    public RewardDTO toDTO(Reward reward) {
        if ( reward == null ) {
            return null;
        }

        RewardDTO rewardDTO = new RewardDTO();

        rewardDTO.setDescription( reward.getDescription() );
        rewardDTO.setMinValue( reward.getMinValue() );
        rewardDTO.setExpectedDeliveryDate( reward.getExpectedDeliveryDate() );

        return rewardDTO;
    }
}
