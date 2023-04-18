package com.xy.ssoserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface RoleMapper {
    List<String> getAuthoritiesByUsername(@Param("username") String username);
}
