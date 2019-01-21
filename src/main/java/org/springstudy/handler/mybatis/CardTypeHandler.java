package org.springstudy.handler.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springstudy.enums.CardTypeEnum;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义转换类
 *
 * @author eric.mo
 */
public class CardTypeHandler extends BaseTypeHandler<CardTypeEnum> {

    @Override
    public CardTypeEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int i = rs.getInt(columnName);

        if (rs.wasNull()) {
            return null;
        } else {
            return CardTypeEnum.findByValue(i);
        }
    }

    @Override
    public CardTypeEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int i = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return CardTypeEnum.findByValue(i);
        }
    }

    @Override
    public CardTypeEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int i = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            return CardTypeEnum.findByValue(i);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, CardTypeEnum parameter, JdbcType jdbcType)
            throws SQLException {
        // baseTypeHandler已经帮我们做了parameter的null判断
        ps.setInt(i, parameter.getCode());
    }

}