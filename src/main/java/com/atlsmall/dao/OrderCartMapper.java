package com.atlsmall.dao;

import com.atlsmall.entity.OrderCart;
import com.atlsmall.entity.OrderCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderCartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_CART
     *
     * @mbggenerated
     */
    int countByExample(OrderCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_CART
     *
     * @mbggenerated
     */
    int deleteByExample(OrderCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_CART
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long ocNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_CART
     *
     * @mbggenerated
     */
    int insert(OrderCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_CART
     *
     * @mbggenerated
     */
    int insertSelective(OrderCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_CART
     *
     * @mbggenerated
     */
    List<OrderCart> selectByExample(OrderCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_CART
     *
     * @mbggenerated
     */
    OrderCart selectByPrimaryKey(Long ocNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_CART
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") OrderCart record, @Param("example") OrderCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_CART
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") OrderCart record, @Param("example") OrderCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_CART
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OrderCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_CART
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OrderCart record);
}