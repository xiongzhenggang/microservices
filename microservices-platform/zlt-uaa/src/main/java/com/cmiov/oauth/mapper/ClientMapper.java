package com.cmiov.oauth.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmiov.db.mapper.SuperMapper;
import com.cmiov.oauth.model.Client;
import org.apache.ibatis.annotations.Param;

/**
 * @autho
 */
public interface ClientMapper extends SuperMapper<Client> {
    List<Client> findList(Page<Client> page, @Param("params") Map<String, Object> params );
}
