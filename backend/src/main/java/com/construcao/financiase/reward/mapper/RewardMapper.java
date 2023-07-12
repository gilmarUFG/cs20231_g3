package com.construcao.financiase.reward.mapper;

import com.construcao.financiase.reward.dto.RewardDTO;
import com.construcao.financiase.reward.entity.Reward;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RewardMapper {

    RewardMapper INSTANCE = Mappers.getMapper(RewardMapper.class);

    Reward toModel(RewardDTO rewardDTO);

    RewardDTO toDTO(Reward reward);

}
