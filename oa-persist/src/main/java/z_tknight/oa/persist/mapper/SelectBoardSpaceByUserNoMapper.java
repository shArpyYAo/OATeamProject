package z_tknight.oa.persist.mapper;

import java.util.List;

import z_tknight.oa.model.entity.TBoardSpace;

public interface SelectBoardSpaceByUserNoMapper {

	List<TBoardSpace> selectBoardSpaceByUserNo(Integer userNo);
}
