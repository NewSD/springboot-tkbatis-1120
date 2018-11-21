package com.niu.query;

import com.niu.entity.UserInfo;
import com.niu.mybatis.AbstractQuery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * Created by ami on 2018/11/19.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoQuery extends AbstractQuery<UserInfo> {
    private Integer id;
    private Integer startId;
    private Integer endId;
    private List<Integer> ids;

    private String username;
    private List<String> usernames;

    private String password;


    @Override
    protected void addCondition(Example.Criteria criteria) {
        if (null != id) {
            criteria.andEqualTo(UserInfo.column.id, id);
        }
        if (null != startId && null != endId) {
            criteria.andBetween(UserInfo.column.id, startId, endId);
        }
        if (CollectionUtils.isNotEmpty(ids)) {
            criteria.andIn(UserInfo.column.id, ids);
        }
        if (StringUtils.isNotBlank(username)) {
            criteria.andLike(UserInfo.column.username, '%' + username + '%');
        }
        if (CollectionUtils.isNotEmpty(usernames)) {
            criteria.andIn(UserInfo.column.username, usernames);
        }
        if (StringUtils.isNotBlank(password)) {
            criteria.andLike(UserInfo.column.password, '%' + password + '%');
        }


    }
}
